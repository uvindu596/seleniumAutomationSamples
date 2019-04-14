package extenreports;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginTest {
	
	private WebDriver driver;
	private String baseUrl;
	ExtentReports report;
	ExtentTest test;
	HomePage hp;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
		
		baseUrl = "http://www.letskodeit.com/";
		report = new ExtentFactory().getInstance();
		test = report.startTest("Verify welcome text");
		driver = new FirefoxDriver();
		hp = new HomePage(driver, test);
		test.log(LogStatus.INFO, "Browser started....");
		
		// Maximize the browser's window
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "Browser maximized");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
		test.log(LogStatus.INFO, "Web application opened");
	}
	
	@Test
	public void test1_validLoginTest() throws Exception {
		
	  // hp.clickSignUpLink();
		
	  //  hp.clickLogInLink();
		
	   // hp.Email("test@email.com");
	    
	  //  hp.Password("abcabc");
	    
	  //  hp.clickGoButton();
	
		hp.login("test@email.com", "abcabc");
		
		Thread.sleep(3000);
		
		boolean result = hp.isWelcomTextPresent();
		
		Assert.assertTrue(result);
		test.log(LogStatus.PASS, "Verified Welcome Text");
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
		report.endTest(test);
		report.flush();
	}
}