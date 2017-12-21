package com.test.UIAutomation.HomePage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.UIAutomtion.TestBase.TestBase;
import com.test.UIAutomtion.uIActions.HomePage;

public class TC_003_VerifyListeners extends TestBase {
	
	public static final Logger log=Logger.getLogger(TC_003_VerifyListeners.class.getName());
	
	HomePage homepage;
	
	
	@BeforeClass
	public void Setup() throws IOException{
		
		init();
		
	}

	@Test
	public void VerifyListeners()
	{
		log.info("Starting Testcase");
	homepage =new HomePage(driver);
	
	homepage.SiginintoApplication("rahgu@amdocs.com", "1234567");
	log.info("Passing Value");
	Assert.assertEquals(homepage.errormessage(), "Authentication failed.");
    log.info("Ending the Testcase");
		
	}
	/*@Test
	public void VerifyListeners2()
	{
		log.info("Starting Testcase");
	homepage =new HomePage(driver);
	
	homepage.SiginintoApplication("rahgu@vf.com", "fefefefe");
	log.info("Passing Value");
	Assert.assertEquals(homepage.errormessage(), "Authentication failed.");
    log.info("Ending the Testcase");
		
	}*/
	/*@AfterTest
	public void Close()
	{
		driver.close();
		
	}*/

}
