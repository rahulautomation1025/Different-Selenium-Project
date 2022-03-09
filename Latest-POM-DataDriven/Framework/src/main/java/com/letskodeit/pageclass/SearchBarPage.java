package com.letskodeit.pageclass;

import com.letskodeit.base.BasePage;
import org.openqa.selenium.WebDriver;

public class SearchBarPage extends BasePage {
    WebDriver driver;

    public SearchBarPage(WebDriver driver) {
        super(driver);

        this.driver = driver;
    }

    private String Search_Field = "xpath=>//input[@id='search']";
    private String Search_Course_Button = "xpath=>//i[@class='fa fa-search']";

    public ResultPage search_Courses(String coursesname) throws InterruptedException {

        sendData(Search_Field, coursesname, "Search field");
        elementClick(Search_Course_Button, "button");
        Thread.sleep(2000);
        return new ResultPage(driver);

    }


}
