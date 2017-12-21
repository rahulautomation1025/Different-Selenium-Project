package com.way2automation.twitter.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TwitLandingPage {
WebDriver driver;
	
	public TwitLandingPage(WebDriver driver){
		
		this.driver=driver;
	}
	
	@FindBy(xpath=".//*[@id='page-container']/div[1]/div[1]/div/div[3]/ul/li[1]/a/span[1]")
	WebElement tweet;
	
	@FindBy(xpath=".//*[@id='page-container']/div[1]/div[1]/div/div[3]/ul/li[2]/a/span[1]")
	WebElement following;
	
	@FindBy(xpath=".//*[@id='page-container']/div[1]/div[1]/div/div[2]/span")
	
	WebElement profile;
	
	public void gototweet(){
		
		tweet.click();
		
	}
	
public TwitMYProfile gotoprofile(){
		
		profile.click();
		
		return PageFactory.initElements(driver, TwitMYProfile.class);
		
	}
	
	public void gotofollowing(){
		
		
		following.click();
	}

}
