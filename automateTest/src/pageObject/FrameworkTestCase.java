package pageObject;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import page.classes.searchPageFactory;

public class FrameworkTestCase {

	WebDriver driver;
	String baseUrl;
	searchPageFactory searchPage;
		
		@Before
		public void setUp() throws Exception {
			System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
			driver = new ChromeDriver();
			baseUrl = "https://www.expedia.com/";
			
			searchPage = new searchPageFactory(driver);
			
		    // maximize browser
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
	}

		@Test
		public void test() {
			driver.get(baseUrl);
			searchPage.clickFlightTab();
			searchPage.setOriginCity("New york");
			searchPage.setDestinationCity("Chicago");
		}
		
	@After
	public void tearDown() throws Exception {
	}

}
