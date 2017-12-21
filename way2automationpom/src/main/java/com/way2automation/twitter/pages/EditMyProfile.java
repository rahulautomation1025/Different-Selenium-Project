package com.way2automation.twitter.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditMyProfile {
	WebDriver driver;
	
public EditMyProfile(WebDriver driver){
		
		this.driver=driver;
		
		
	}
	
		@FindBy(xpath=".//*[@id='page-container']/div[3]/div/div[1]/div[2]/button")
		WebElement upload;

        @FindBy(xpath=".//*[@id='header-choose-existing']/div/div/label/input")
        WebElement uploadpic;
        
        @FindBy(xpath=".//*[@id='header_image_upload_dialog-dialog']/div[2]/div[2]/div/div/div/div[3]/button[1]")
        WebElement cancel;
        
       @FindBy(xpath=".//*[@id='page-container']/div[3]/div/div[2]/div[2]/div/div[2]/div/div/ul/li[6]/div/div/button[1]")
    		   WebElement cncl;

public void changepic(){
	
	upload.click();
	uploadpic.sendKeys("C:\\Users\\ACER\\Desktop\\DSC_2019.JPG");
	cancel.click();
	//cncl.click();
}
	
	

}
