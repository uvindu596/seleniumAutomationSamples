package automateTest;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;

public class basicActions {
	WebDriver driver;
	String baseURL;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		driver = new ChromeDriver();
		baseURL = "https://learn.letskodeit.com/";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();	
	}

	
	@Test
	public void test() {
	
	driver.get(baseURL);
	driver.findElement(By.xpath("//a[contains(text(),\"Login\")]")).click();
	driver.findElement(By.id("user_email")).clear();
	driver.findElement(By.id("user_email")).sendKeys("test@email.com");
	driver.findElement(By.id("user_password")).sendKeys("test");
	driver.findElement(By.id("user_email")).clear();
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
