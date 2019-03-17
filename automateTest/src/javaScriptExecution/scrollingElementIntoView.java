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

public class scrollingElementIntoView {

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
	public void test() throws InterruptedException {
		driver.get(baseUrl);
		Thread.sleep(2000);
		
		//scrol down
		js.executeScript("window.scrollBy(0,1900);");
		Thread.sleep(2000);
		
		//scrol up
		js.executeScript("window.scrollBy(0,-1900);");
		Thread.sleep(2000);
		
		//scrol Element into view
		
		WebElement element = driver.findElement(By.id("mousehover"));
		js.executeScript("arguments[0].scrollIntoView(true);",element);
		Thread.sleep(2000);		
		
		js.executeScript("window.scrollBy(0,-190);");
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);	
		driver.quit();
	}
}
