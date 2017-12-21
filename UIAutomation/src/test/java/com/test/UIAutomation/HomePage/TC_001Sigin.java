package com.test.UIAutomation.HomePage;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.UIAutomtion.TestBase.TestBase;
import com.test.UIAutomtion.uIActions.HomePage;

public class TC_001Sigin extends TestBase {
	public static final Logger log=Logger.getLogger(TC_001Sigin.class.getName());
	HomePage homepage;
	
	
	@BeforeClass
	public void Setup() throws IOException{
		
		init();
		
	}

	@Test
	public void VerifyloginApplication()
	{
		log.info("Starting Testcase");
	homepage =new HomePage(driver);
	
	homepage.SiginintoApplication("rahgu@amdocs.com", "1234567");
	log.info("Passing Value");
	Assert.assertEquals(homepage.errormessage(), "Authentication failed.");
		log.info("Ending the Testcase");
		
	}
	/*@AfterTest
	public void Close()
	{
		driver.close();
		
	}*/
}
