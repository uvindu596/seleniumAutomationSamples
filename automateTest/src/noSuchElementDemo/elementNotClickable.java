package noSuchElementDemo;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class elementNotClickable {

	  WebDriver driver;
	    String baseUrl;
	    JavascriptExecutor js;
		
		@Before
		public void setUp() throws Exception {
			System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
			driver = new ChromeDriver();
			baseUrl = "https://freecrm.com/";
			js = (JavascriptExecutor) driver;
		
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		
		@Test
		public void test() throws InterruptedException {
			driver.get(baseUrl);
			Thread.sleep(2000);
			
			driver.findElement(By.name("username")).sendKeys("test");
			WebDriverWait wait = new WebDriverWait(driver,3);
			
			boolean invisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("preloader")));
			 if(invisible) {
				 WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
				 loginButton.click();
			 }
			 
			 //second way
			// WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
		   //js.executeScript("arguments[0].click();",loginButton);
			 
	}

	@After
	public void tearDown() throws Exception {
	}
}
