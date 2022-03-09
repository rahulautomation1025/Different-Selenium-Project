package com.letskodeit.base;

import com.letskodeit.pageclass.*;
import com.letskodeit.utilities.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;


public class BaseTest {

   public WebDriver driver;
    protected LoginPage lg;
    protected NavigationPage nav;
    protected SearchBarPage sb;
    protected ResultPage rs;
    protected CategoryFilterPage category;

    @BeforeClass
    @Parameters({"browser"})
    public void commonSetUP(String browser){
        driver=WebDriverFactory.getInstance().getDriver(browser);
        driver.get(Constants.BASE_URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        nav = new NavigationPage(driver);
        lg=nav.openLoginPage();

    }

    @BeforeMethod
    public void methodSetUp() {
        CheckPoint.clearHashMap();
    }

    @AfterClass
    public void commonTearDown(){

        WebDriverFactory.getInstance().quitDriver();


    }


}
