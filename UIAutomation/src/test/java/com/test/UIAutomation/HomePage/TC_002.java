package com.test.UIAutomation.HomePage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.UIAutomtion.TestBase.TestBase;
import com.test.UIAutomtion.uIActions.HomePage;

public class TC_002 extends TestBase {
	
	public static final Logger log=Logger.getLogger(TC_002.class.getName());
	HomePage homepage;
	
	/*String Emailaddress="3323@gmil.com";
	String  Loginpassword="gfgfgfg";
	*/
	@DataProvider(name="logindata")
	public String [][] getTestData(){
		String [][] testRecords=getData("TestData.xlsx", "Sheet1");
		return testRecords;
	}
	
	
	
	@BeforeClass
	public void Setup() throws IOException{
		
		init();
		
	}

	@Test(dataProvider="logindata")
	public void VerifyloginApplication(String Emailaddress, String Loginpassword, String runmode  )
	{
		if(runmode.equalsIgnoreCase("N")){
			
			throw new SkipException("Not able to run");
			
		}
		log.info("*********** Starting Execution of Testcase2 *************");
	homepage =new HomePage(driver);	
	homepage.SiginintoApplication(Emailaddress, Loginpassword);
	getScreenShot("VerifyloginApplicatio"+"_"+Emailaddress);
	log.info("*********** Finished Execution of Testcase2 *************");
		
	}
	/*@AfterTest
	public void Close()
	{
		driver.close();
		
	}*/

}
