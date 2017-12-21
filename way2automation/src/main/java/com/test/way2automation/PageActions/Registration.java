package com.test.way2automation.PageActions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registration {
	public WebDriver driver;
	
	
	@FindBy(xpath=".//*[@id='toggleNav']/li[6]/a")
	
	WebElement registration_link;
	
	@FindBy(xpath=".//form[@id='load_form']/fieldset/input[@name='name']")
	WebElement Name;
	
	@FindBy(xpath="//form[@id='load_form']/fieldset[2]/input[@name='phone']")
	WebElement Phone;
	
	@FindBy(xpath="//form[@id='load_form']/fieldset[3]/input[@name='email']")
	WebElement Email;
	
	@FindBy(xpath="//form[@id='load_form']/fieldset[5]/input[@name='city']")
	WebElement City;
	
	@FindBy(xpath="//form[@id='load_form']/fieldset[6]/input[@name='username']")
	WebElement Username;
	
	@FindBy(xpath="//form[@id='load_form']/fieldset[7]/input[@name='password']")
	WebElement Password;
		
	@FindBy(xpath="//form[@id='load_form']/input[@value='register']//../div/div[2]/input")
	WebElement Submtbtn;


public  Registration(WebDriver driver){
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
}

public void verifyregistrationSignup(String name, String email, String city,String username,String password ){
	
	registration_link.click();
	
	Set <String> windows=driver.getWindowHandles();
	Iterator<String> itr=windows.iterator();
	String parentwindow=itr.next();
	String childwindow=itr.next();
	driver.switchTo().window(childwindow);
	Name.sendKeys(name);
	Email.sendKeys(email);
	City.sendKeys(city);
	Username.sendKeys(username);
	Password.sendKeys(password);
	Submtbtn.click();
	
	
}








}
