package javaScriptExecution;

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

public class javaScriptExecution {

	WebDriver driver;
	String baseUrl;
	private JavascriptExecutor js;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "https://learn.letskodeit.com/p/practice";
		js = (JavascriptExecutor) driver;
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void test() {
		//driver.get(baseUrl);
		js.executeScript("window.location = 'https://learn.letskodeit.com/p/practice';");
		//WebElement textBox =driver.findElement(By.id("name"));
		//textBox.sendKeys("test");
		WebElement textBox =(WebElement) js.executeScript("return document.getElementById('name');");
		textBox.sendKeys("test");
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
