package usefulmethods;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class getAttributeDemo {

	   WebDriver driver;
	    String baseUrl;
		
		@Before
		public void setUp() throws Exception {
	        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
	        driver = new ChromeDriver();
	        baseUrl = "https://learn.letskodeit.com/p/practice";
	        
	        driver.manage().window().maximize();  
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        
		}


	@Test
	public void test() {
		driver.get(baseUrl);
		
		WebElement element = driver.findElement(By.id("name"));
		
		String attributeValue =   element.getAttribute("class");
		String TypeattributeValue =   element.getAttribute("type");
		String PlaceHolderattributeValue =   element.getAttribute("placeholder");	
	
		System.out.println("value of  class attribute is: "+attributeValue);
		System.out.println("value of type attribute is: "+TypeattributeValue);
		System.out.println("value of placeholder attribute is: "+PlaceHolderattributeValue);
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}


}
