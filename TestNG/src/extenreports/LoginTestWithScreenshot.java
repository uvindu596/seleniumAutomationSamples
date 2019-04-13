package extenreports;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.Screenshots;

public class LoginTestWithScreenshot {
	
	private WebDriver driver;
	private String baseUrl;
	ExtentReports report;
	ExtentTest test;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
		
		baseUrl = "http://www.letskodeit.com/";
		report = new ExtentReports("D:\\uvindu dev\\selenium\\reports\\logintestwithSS.html");
		test = report.startTest("Verify welcome text");
		driver = new FirefoxDriver();
		
		// Maximize the browser's window
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "Browser maximized");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
		test.log(LogStatus.INFO, "Web application opened");
	}
	
	@Test
	public void test1_validLoginTest() throws Exception {
		WebElement signupLink = driver.findElement(By.id("comp-iiqg1vggactionTitle"));
		signupLink.click();
		test.log(LogStatus.INFO, "Clicked on signup link");
		
		WebElement loginLink = driver.findElement(By.id("signUpDialogswitchDialogLink"));
		loginLink.click();
		test.log(LogStatus.INFO, "Clicked on login link");
		
		WebElement emailField = driver.findElement(By.xpath("//div[@id='memberLoginDialogemail']//input"));
		emailField.sendKeys("test@email.com");
		test.log(LogStatus.INFO, "Enter email");
		
		WebElement passwordField = driver.findElement(By.xpath("//div[@id='memberLoginDialogpassword']//input"));
		passwordField.sendKeys("abcabcQ");
		test.log(LogStatus.INFO, "Enter password");
		
		WebElement goButton = driver.findElement(By.id("memberLoginDialogokButton"));
		goButton.click();
		test.log(LogStatus.INFO, "Click go button");
		
		Thread.sleep(3000);
		
		WebElement welcomeText = null;
		
		try {
		   driver.findElement(By.id("p7kjtbalatabgcoloroverlay")).click();
			welcomeText = driver.findElement(By.id("comp-iiqg1vggactionTitle"));
		}
		catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
		Assert.assertTrue(welcomeText != null);
		test.log(LogStatus.PASS, "Verified Welcome Text");
	}
	
	@AfterMethod
	public void tearDown(ITestResult testResult) throws IOException {
		
		if(testResult.getStatus() == ITestResult.FAILURE) {
			String path = Screenshots.takeScreenshot(driver, testResult.getName());
			String imagePath = test.addScreenCapture(path);
			test.log(LogStatus.FAIL, "Verify Welcome Text Failed", imagePath);
		}
		driver.quit();
		report.endTest(test);
		report.flush();
	}
}