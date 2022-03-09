package com.letskodeit.pageclass;

import com.letskodeit.base.BasePage;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;

    }


    private String Email_Field = "xpath=>//form[@role='form']//input[@id='email']";
    private String Password_Field = "xpath=>//input[@id='password']";
    private String Login_Btn = "xpath=>//input[@value='Login']";


    public NavigationPage signIN(String email, String password) {
        sendData(Email_Field, email, "Email Field");
        sendData(Password_Field, password, "Password Field");
        elementClick(Login_Btn, "Login Button");
        return new NavigationPage(driver);


    }

}
