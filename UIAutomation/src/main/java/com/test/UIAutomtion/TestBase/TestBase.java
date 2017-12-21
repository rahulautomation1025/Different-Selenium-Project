package com.test.UIAutomtion.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.test.UIAutomtion.CustomListener.WebEventListners;
import com.test.UIAutomtion.excelReader.Excel_Reader;

public class TestBase {
	Excel_Reader excel;
	
	public static final Logger log=Logger.getLogger(TestBase.class.getName());
	public static WebDriver driver;
	Properties OR;
	
	public static ExtentReports extent;
	public static ExtentTest test;
	
	
	public void loaddata() throws IOException{
		OR=new Properties();
		File file=new File("C://Webdriver//UIAutomation//src//main//java//com//test//UIAutomtion//config//config.properties");
		FileInputStream fs=new FileInputStream(file);
		OR.load(fs);
		
		
	}
	
	static {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		//extent = new ExtentReports(System.getProperty("user.dir") + "/src/main/java/com/test/automation/uiAutomation/report/test" + formater.format(calendar.getTime()) + ".html", false);
		extent =new ExtentReports("C://Webdriver//UIAutomation//src//main//java//com//test//UIAutomtion//Report//test" + formater.format(calendar.getTime()) + ".html",false);
	}
	
	public void init() throws IOException{
		loaddata();
	
		selectbrowser(OR.getProperty("browser"));
		geturl(OR.getProperty("url"));
		String log4jconfigpath="log4j.properties";
		PropertyConfigurator.configure(log4jconfigpath);
		
		
	}
	public void selectbrowser(String browser){
		
		if (browser.equalsIgnoreCase("chrome")){
			System.setProperty("Webdriver.chrome.driver","D:\\software\\Tools\\Drivers\\chromedriver.exe");
			log.info("Creating object of " +browser);
			driver=new ChromeDriver();
			EventFiringWebDriver dr=new EventFiringWebDriver(driver);
			WebEventListners eventlistner=new WebEventListners();
			dr.register(eventlistner);
			
		}
		
		else if(browser.equalsIgnoreCase("IE")){
			driver=new InternetExplorerDriver();
			
			EventFiringWebDriver dr=new EventFiringWebDriver(driver);
			WebEventListners eventlistners=new WebEventListners();
			dr.register(eventlistners);
		}
		
	}
	
	public void geturl(String url){
		log.info("Navigated to "+url);
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	public String[][] getData(String excelName, String sheetName) {

		String path = "C:/Webdriver/UIAutomation/src/main/java/com/test/UIAutomtion/data/"+excelName;
		excel = new Excel_Reader(path);
		String[][] data = excel.getDataFromSheet(sheetName, excelName);
		return data;
	}
	
	public void getScreenShot(String name) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

		//String methodName = result.getName();

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/src/main/java/com/test/UIAutomtion/screenshot/";
			File destFile = new File((String) reportDirectory + name + "-" + formater.format(calendar.getTime()) + ".png");

			FileUtils.copyFile(scrFile, destFile);

			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

		public void getresult(ITestResult result){
			
			if(result.getStatus()==ITestResult.SUCCESS){
				
				test.log(LogStatus.PASS, result.getName()+" test is pass");
			}
			
			else if(result.getStatus()==ITestResult.SKIP){
				
				test.log(LogStatus.SKIP, result.getName()+" test is skipped and skip reason is:-"+ result.getThrowable());
			}
		
			
			else if(result.getStatus()==ITestResult.FAILURE){
				test.log(LogStatus.ERROR, result.getName()+" test id failed" + result.getThrowable());
				
							}
			
			else if (result.getStatus()==result.STARTED){
				test.log(LogStatus.INFO, result.getName()+" test is started");
				
				
			}
			
		}
		
		@AfterMethod()
		public void afterMethod(ITestResult result) {
			getresult(result);
		}

		@BeforeMethod()
		public void beforeMethod(Method result) {
			test = extent.startTest(result.getName());
			test.log(LogStatus.INFO, result.getName() + " test Started");
		}

		@AfterClass(alwaysRun = true)
		public void endTest() {
			closeBrowser();
		}

		public void closeBrowser() {
			driver.quit();
			log.info("browser closed");
			extent.endTest(test);
			extent.flush();
		}
		
		
		
		
	
	
	

}
