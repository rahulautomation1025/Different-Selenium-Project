package com.test.UIAutomtion.uIActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class HomePage {
	public static final Logger log=Logger.getLogger(HomePage.class.getName());
	WebDriver driver;
	
	@FindBy(xpath=".//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	WebElement Sigin;
	
	@FindBy(xpath=".//*[@id='email']")
	WebElement Emiladdress;
	
	@FindBy(xpath=".//*[@id='passwd']")
	WebElement loginPassword;
	
	@FindBy(xpath=".//*[@id='SubmitLogin']")
	WebElement Submit;
	
	@FindBy(xpath=".//*[@id='center_column']/div[1]/ol/li")
	WebElement ErrorMessage;
	
	public HomePage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	
	public void SiginintoApplication(String emailaddress,String password){
		log.info("Click on Signin button");
		Sigin.click();
		log.info("Entered Email Address");
		Emiladdress.sendKeys(emailaddress);
		log.info("Entered Password");
		loginPassword.sendKeys(password);
		log.info("Click on Submit Button");
		Submit.click();
		
		
	}
	
	public String errormessage(){
		
		return ErrorMessage.getText();
		
	}
	

}
