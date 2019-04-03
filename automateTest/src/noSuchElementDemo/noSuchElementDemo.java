package noSuchElementDemo;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class noSuchElementDemo {

	  WebDriver driver;
	  String baseUrl;
		
		@Before
		public void setUp() throws Exception {
			System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
			driver = new ChromeDriver();
			baseUrl = "https://learn.letskodeit.com/p/practice";
		
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		
		@Test
		public void test() throws InterruptedException {
			driver.get(baseUrl);
			Thread.sleep(2000);
			
			// 1. Timing Issues
			driver.findElement(By.xpath("//a[@href='/sign_in']")).click();
			
			WebDriverWait wait = new WebDriverWait(driver, 3);
			WebElement emailField = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.id("user_email")));
			emailField.sendKeys("testing");
			
		//	2. Elemet in iframe
		  driver.navigate().to(baseUrl);
		  Thread.sleep(2000);
		  
		  driver.switchTo().frame(0);
		  driver.findElement(By.id("search-courses")).sendKeys("java");
		  Thread.sleep(2000);
		  driver.switchTo().defaultContent();
		  
	}
	
	@After
	public void tearDown() throws Exception {
	}



}
