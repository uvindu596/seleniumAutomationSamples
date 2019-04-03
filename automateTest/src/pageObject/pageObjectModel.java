package pageObject;

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
import page.classes.SerachPage;

public class pageObjectModel {

	  WebDriver driver;
	  String baseUrl;
		
		@Before
		public void setUp() throws Exception {
			System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
			driver = new ChromeDriver();
			baseUrl = "https://www.expedia.com/";
		
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
	@Test
	public void test() throws InterruptedException {
		driver.get(baseUrl);
		SerachPage.fillOriginTextBox(driver, "New York");
		SerachPage.fillDestinationTextBox(driver, "Chikago");
		SerachPage.depatureDateTextBox(driver).sendKeys("05/12/2019");
		// Added a line to clear the return date text box
		// before entering the return date, because Expedia by default
		// enters the return date same as the departure date
		SerachPage.returnDateTextBox(driver).clear();
		SerachPage.returnDateTextBox(driver).sendKeys("05/20/2019");
		SerachPage.clickOnSearchButton(driver);
	}
	
	@After
	public void tearDown() throws Exception {
	}


}
