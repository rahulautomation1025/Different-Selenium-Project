package com.letskodeit.pageclass;

import com.letskodeit.base.BasePage;
import com.letskodeit.utilities.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationPage extends BasePage {
    WebDriver driver;

    public NavigationPage(WebDriver driver) {
        super(driver);

        this.driver = driver;

    }

    private String SignIn_Field = "xpath=>//a[normalize-space()='Sign In']";
    private String AllCourses_Field = "xpath=>//a[normalize-space()='ALL COURSES']";
    private String MyCourses_Field = "xpath=>//a[normalize-space()='MY COURSES']";
    private String Login_Image = "xpath=>//img[@class='zl-navbar-rhs-img ']";
    private String Dynamic_link = "xpath=>//*[@id='dropdownMenu1']/a";
    private String Logout_Field = "xpath=>//a[normalize-space()='Logout']";

    public LoginPage openLoginPage() {

        elementClick(SignIn_Field, "Sign In Field");
        return new LoginPage(driver);
    }

    public void click_AllCoursesTab() {

        elementClick(AllCourses_Field, "AllCourses Link");

    }

    public void click_MyCoursesTab() {
        elementClick(MyCourses_Field, "MyCourses Link");

    }

    public boolean isUserLoggedIn() {

        try {
            WebElement accountImage = getElement(Login_Image, "Login image");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }

    }

    public boolean verifyHeader() {

        WebElement val = getElement(AllCourses_Field, "All Courses");
        String text = val.getText();
        return Util.verifyTextContains(text, "ALL Courses");


    }

    public void logout() {

        elementClick(Dynamic_link, "Link");
        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement LogoutLink = waitForElementToBeClickable(Logout_Field, 10);
        elementClick(LogoutLink, "Logout Field");

    }


}
