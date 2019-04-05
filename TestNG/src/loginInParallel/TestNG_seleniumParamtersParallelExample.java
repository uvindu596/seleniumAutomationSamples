package loginInParallel;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;

public class TestNG_seleniumParamtersParallelExample {
 
	WebDriver driver;
	String baseUrl;

	@BeforeClass
	@Parameters({ "browser" })
	public void setUp(String browser) {

		baseUrl = "https://letskodeit.teachable.com/";

		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}
  
  @Test
  public void testLogin() throws InterruptedException {
	 WebElement loginLink = driver.findElement(By.xpath("//a[@href='/sign_in']"));
	 loginLink.click();
	 WebElement emailField = driver.findElement(By.id("user_email"));
	 emailField.sendKeys("test@email.com");
	 WebElement passwordField = driver.findElement(By.id("user_password"));
	 passwordField.sendKeys("test123");
	 WebElement loginButton = driver.findElement(By.name("commit"));
	 loginButton.click();
	 Thread.sleep(2000);
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
