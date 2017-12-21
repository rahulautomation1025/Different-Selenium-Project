package com.app.module;

import org.openqa.selenium.WebDriver;

import com.pack.page.Home_Page;
import com.pack.page.LogIn_Page;
import com.utility.ExcelUtils;

public class Sign_In {
	
	public static void Execute(WebDriver driver) throws Exception{
		 
		//This is to get the values from Excel sheet, passing parameters (Row num &amp; Col num)to getCellData method

		String sUserName = ExcelUtils.getCellData(1, 1);

		String sPassword = ExcelUtils.getCellData(1, 2);

		Home_Page.lnk_MyAccount(driver).click();

		LogIn_Page.txtbx_UserName(driver).sendKeys(sUserName);

		LogIn_Page.txtbx_Password(driver).sendKeys(sPassword);

		LogIn_Page.btn_LogIn(driver).click();

    }

}
