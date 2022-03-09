package com.letskodeit.pageclass;

import com.letskodeit.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ResultPage extends BasePage {

    WebDriver driver;

    public ResultPage(WebDriver driver) {
        super(driver);

        this.driver = driver;

    }

    private String course_Field = "xpath=>//div[@id='course-list']";

    public int courseCount() {

        List<WebElement> courseList = getElementList(course_Field, "Field");
        return courseList.size();

    }

    public boolean verifySearchResult() {

        boolean result = false;
        if (courseCount() < 0) {

            return true;
        }

        return false;
    }


}
