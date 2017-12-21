package com.framework;

import java.util.concurrent.TimeUnit;

import org.apache.bcel.classfile.Constant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.app.module.Sign_In;
import com.pack.page.Home_Page;
import com.utility.ExcelUtils;
import com.utility.*;

public class Main1 {

	
		private static WebDriver driver = null;
		 
		public static void main(String[] args) throws Exception {
 
        //This is to open the Excel file. Excel path, file name and the sheet name are parameters to this method
 
        ExcelUtils.setexcel(Constant + Constant.File_TestData,"Sheet1");
 
        driver = new FirefoxDriver();
 
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
 
        driver.get(Constant.URL);
 
        Sign_In.Execute(driver);
 
        System.out.println("Login Successfully, now it is the time to Log Off buddy.");
 
        Home_Page.lnk_LogOut(driver).click(); 
 
        driver.quit();

	}

}
