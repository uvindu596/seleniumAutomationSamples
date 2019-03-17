package waitTypes;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.waitTypes;

public class explicitWaitWithUtilityDemo {

	   WebDriver driver;
	   String baseUrl;
	   waitTypes wt; 
		
		@Before
		public void setUp() throws Exception {
	        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
	        driver = new ChromeDriver();
	        baseUrl = "https://learn.letskodeit.com/p/practice";
	        wt = new waitTypes(driver);
	        
	        driver.manage().window().maximize();    
		}

	@Test
	public void test() {
		driver.get(baseUrl);
		WebElement loginLink = driver.findElement(By.linkText("Login"));
		loginLink.click();
		
		
		WebElement emailField = wt.waitForElement(By.id("user_email"), 3);
		emailField.sendKeys("test");
		
		wt.clickWhenReady(By.name("commit"), 3);
		
	//	driver.findElement(By.id("user_email")).sendKeys("test");
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}


}
