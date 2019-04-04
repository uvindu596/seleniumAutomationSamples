package pageObject;

import static org.junit.Assert.*;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import page.classes.*;

import page.classes.searchPageFactory;

public class findLinks {
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
		SerachPage.navigateToFlightTab(driver);
		
		List<WebElement> LinksList = clickableLinks(driver);
		for(WebElement link : LinksList) {
			String href = link.getAttribute("href");
			try {
				System.out.println("URL "+href+ "returned "+linkStatus(new URL(href)));
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
	
	public static List<WebElement> clickableLinks(WebDriver driver) {
		List<WebElement> linksToClick = new ArrayList<WebElement>();
		List<WebElement> elemets = driver.findElements(By.tagName("a"));
		elemets.addAll(driver.findElements(By.tagName("img")));
		
		for(WebElement e: elemets) {
			if(e.getAttribute("href") != null) {
				linksToClick.add(e);
			}
		}
		
		return linksToClick;
	}
	
	public static String linkStatus(URL url) {
		
		try {
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			http.connect();
			String responseMessage = http.getResponseMessage();
			http.disconnect();
			return responseMessage;
		}
		catch(Exception e) {
			return e.getMessage();
		}
	}
	
	@After
	public void tearDown() throws Exception {
	}

}
