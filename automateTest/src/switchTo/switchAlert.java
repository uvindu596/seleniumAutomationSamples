package switchTo;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class switchAlert {

	WebDriver driver;
	String baseUrl;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "https://learn.letskodeit.com/p/practice";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseUrl);
	
	}
	
	@Test
	public void test() throws InterruptedException {
	Thread.sleep(2000);	
	driver.findElement(By.id("name")).sendKeys("uvindu");
	driver.findElement(By.id("alertbtn")).click();
	Thread.sleep(3000);
	
	Alert alert = driver.switchTo().alert();
	alert.accept();
	}
	
	@Test
	public void test2() throws InterruptedException {
		Thread.sleep(2000);	
		driver.findElement(By.id("name")).sendKeys("uvindu");
		driver.findElement(By.id("confirmbtn")).click();
		Thread.sleep(3000);
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		//alert.dismiss();
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}


}
