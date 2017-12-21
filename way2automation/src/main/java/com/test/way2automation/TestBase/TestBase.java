package com.test.way2automation.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	
	Properties OR;
	
	  public static WebDriver driver;
	
	public void init() throws IOException{
		loaddata();
		selectBrowser(OR.getProperty("browser"));
		geturl(OR.getProperty("url"));
		//String log4jconfigpath="log4j.properties";
		//PropertyConfigurator.configure(log4jconfigpath);
		
		
	}
	
	public void loaddata() throws IOException{
		OR=new Properties();
		File file=new File("C://Webdriver//Way2Automation//src//main//java//com//test//way2automation//config//config.properties");
		FileInputStream fs=new FileInputStream(file);
		OR.load(fs);
	}
	public void selectBrowser(String browser) throws IOException{
		if (browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("Webdriver.chrome.driver","D:\\software\\Tools\\Drivers\\chromedriver.exe");
			//log.info("Creating object of " +browser);
			driver=new ChromeDriver();
		
		
		
	}
	}
	
	public void geturl(String url){
		//log.info("Navigated to "+url);
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	
	

}
