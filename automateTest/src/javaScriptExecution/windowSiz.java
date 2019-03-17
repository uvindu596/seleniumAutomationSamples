package javaScriptExecution;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowSiz {

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
	    //navigation
		js.executeScript("window.location = 'https://learn.letskodeit.com/p/practice'");
		
		//size of window
		long height = (Long) js.executeScript("return window.innerHeight;");
		long width = (Long) js.executeScript("return window.innerWidth;");
		
		System.out.println("Height is : "+height);
		System.out.println("Width is : "+width);
	
	}
	
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

	

}
