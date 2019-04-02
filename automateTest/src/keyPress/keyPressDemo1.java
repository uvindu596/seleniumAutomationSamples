package keyPress;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class keyPressDemo1 {

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
	driver.findElement(By.xpath("//a[contains(@href,'sign_in')]")).click();
	Thread.sleep(3000);
	
	driver.findElement(By.id("user_email")).sendKeys("uvindukavinda@gmail.com");
	driver.findElement(By.id("user_password")).sendKeys("uvindu");
	driver.findElement(By.name("commit")).sendKeys(Keys.ENTER);
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
