package com.way2automation.twitter.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TwitMYProfile {
	
WebDriver driver;
	
	public TwitMYProfile(WebDriver driver){
		
		this.driver=driver;
	}
	
	
	@FindBy(xpath=".//*[@id='page-container']/div[3]/div/div[2]/div[2]/div/div[2]/div/div/ul/li[6]/div/button")
	
	WebElement Editprofile;
	
	public EditMyProfile EditProfile(){
		
		Editprofile.click();
		 return PageFactory.initElements(driver, EditMyProfile.class);
		 
		
	}
	

	
}
