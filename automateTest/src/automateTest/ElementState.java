package automateTest;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementState {
	
	WebDriver driver;
	String baseUrl;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "https://www.google.com/";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseUrl);
		
	}

	@Test
	public void test() {
		
		WebElement e1 = driver.findElement(By.name("q"));
		boolean isE1enabled = e1.isEnabled();
		
	 if(isE1enabled) {
		e1.sendKeys("letskodeit");
		System.out.println("e1 element is enabled!");
	}
	 else {
		 driver.navigate().refresh();
		 }
	 }
	
	@After
	public void tearDown() throws Exception {
	}


}
