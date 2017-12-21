package com.way2automation.twitter.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.way2automation.twit.config.Configuration;

public class TwitLoginpage {
	
	WebDriver driver;
	
	public TwitLoginpage(WebDriver driver){

      this.driver=driver;
	}
	
	@FindBy(xpath=Configuration.loginbutton)
	public WebElement loginbutton;
	
	@FindBy(xpath=Configuration.username)
	public WebElement username;
	
	@FindBy(xpath=Configuration.password)
	public WebElement password;
	
	@FindBy(xpath=Configuration.login)
	public WebElement login;
	
	public TwitLandingPage dologin(String myusername, String mypassword){
		
		loginbutton.click();
		username.sendKeys(myusername);
		password.sendKeys(mypassword);
		login.click();
		
		return PageFactory.initElements(driver,TwitLandingPage.class);
		
		
	}
	

}
