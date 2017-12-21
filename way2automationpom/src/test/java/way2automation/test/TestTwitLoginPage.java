package way2automation.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.way2automation.twit.config.Configuration;
import com.way2automation.twitter.pages.EditMyProfile;
import com.way2automation.twitter.pages.TwitLandingPage;
import com.way2automation.twitter.pages.TwitLoginpage;
import com.way2automation.twitter.pages.TwitMYProfile;

public class TestTwitLoginPage {
	
	WebDriver driver;
	
	
	
	@BeforeMethod
	public void Openbrowser(){
		
		System.setProperty("Webdriver.chrome.driver","D:\\software\\Tools\\Drivers\\chromedriver.exe");
		//log.info("Creating object of " +browser);
		driver=new ChromeDriver();
		driver.get(Configuration.testsite);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	
	@Test
 public void login() throws InterruptedException{
		TwitLoginpage lp=PageFactory.initElements(driver, TwitLoginpage.class);
		
		TwitLandingPage landing=lp.dologin("rrahul1089", "9716942956@");
		TwitMYProfile profile= landing.gotoprofile();
		profile.EditProfile();
		Thread.sleep(3000);
		//editprofile.changepic();
		Thread.sleep(3000);
	}
	
	
	@AfterMethod
	public void Closebrowser(){
		driver.quit();
		
	}
	
	

}
