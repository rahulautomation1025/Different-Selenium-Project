package com.test.way2automation.Registration;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.way2automation.PageActions.Registration;
import com.test.way2automation.TestBase.TestBase;

public class Tc_001_VerifyRegistration extends TestBase {
	
	Registration reg;
	
	@BeforeClass
	public void setup() throws IOException {
		
		init();
		
	}
	
	@Test
	public void VerifyRegistration(){
		reg =new Registration(driver);
		reg.verifyregistrationSignup("Testing","7757@gmail.com","Gurgaon","rrahul10","323232323");
		
	}
	
	@AfterTest
	public void close(){
		
		driver.close();
		
	}
	
	
	
	
	
	
	
	

}
