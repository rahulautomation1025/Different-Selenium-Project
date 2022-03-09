package com.letskodeit.pageclass;

import com.letskodeit.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class CategoryFilterPage extends BasePage {

    WebDriver driver;

    public CategoryFilterPage(WebDriver driver) {
        super(driver);
        this.driver = driver;

    }


    private String CATEGORY_DROPDOWN = "//select[@name='categories']";
    private String CATEGORY_OPTION = "//div[@id='course-list']/div";


    public ResultPage select(String CategoryName) {

        WebElement CatgoryDDL = driver.findElement(By.xpath(CATEGORY_DROPDOWN));
        Select select = new Select(CatgoryDDL);
        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement categoryOption = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//select[@name='categories']//option[1]")));
        select.selectByVisibleText(CategoryName);
        return new ResultPage(driver);

    }

    public int findCoursesCount(String CategoryName) throws InterruptedException {
        WebElement CatgoryDDL = driver.findElement(By.xpath(CATEGORY_DROPDOWN));
        Select select = new Select(CatgoryDDL);
        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement categoryOption = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//select[@name='categories']//option[1]")));
        select.selectByVisibleText(CategoryName);
        Thread.sleep(2000);
        List<WebElement> list = new ArrayList<>();
        list = driver.findElements(By.xpath(CATEGORY_OPTION));
        int count = list.size();

        return count;


    }

}
