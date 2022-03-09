package com.letskodeit.test;

import com.letskodeit.base.BaseTest;
import com.letskodeit.base.CheckPoint;
import com.letskodeit.utilities.Constants;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @BeforeClass
    public void setUP() {

    }

    @AfterMethod
    public void Logout() {
        System.out.println("****** After Method ******");
        if (nav.isUserLoggedIn()) {
            nav.logout();
            nav.openLoginPage();

        }

    }

    @Test
    public void verifyLoginStatus() {
        lg.signIN(Constants.DEFAULT_USERNAME, Constants.DEFAULT_PASSWORD);
        Boolean loggedIn = nav.isUserLoggedIn();
        //Assert.assertTrue(loggedIn);
        CheckPoint.mark("test-01", loggedIn, "login verification");
        Boolean header=nav.verifyHeader();
        //Assert.assertTrue(result);
        CheckPoint.markFinal("test-01", header, "Header verification");


    }

    @Test(enabled = false)
    public void InvalidLogin() {
        lg.signIN(Constants.DEFAULT_USERNAME, Constants.DEFAULT_PASSWORD);
        Assert.assertTrue(true);
        Boolean loggedIn = nav.verifyHeader();
        Assert.assertFalse(loggedIn);


    }

}
