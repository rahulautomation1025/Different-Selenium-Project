package com.letskodeit.base;

import org.openqa.selenium.WebDriver;

public class BasePage extends CustomDriver {


    WebDriver driver;

    public BasePage(WebDriver driver){
        super(driver);

        this.driver=driver;
    }

    public boolean VerifyTitle(String expectedtitle){
        return driver.getTitle().equalsIgnoreCase(expectedtitle);

    }


}
