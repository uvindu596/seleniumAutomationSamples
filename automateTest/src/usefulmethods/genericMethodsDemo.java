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
import usefulmethods.genericMethods;

public class genericMethodsDemo {
	    
	    WebDriver driver;
	    String baseUrl;
	    private  genericMethods gm;
		
		@Before
		public void setUp() throws Exception {
	        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
	        driver = new ChromeDriver();
	        baseUrl = "https://learn.letskodeit.com/p/practice";
	        gm = new genericMethods(driver);
	        
	        driver.manage().window().maximize();  
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        
		}

	@Test
	public void test() throws InterruptedException {
		
		driver.get(baseUrl);
		
		WebElement element = gm.getElement("name", "id");
		element.sendKeys("test");
		
		Thread.sleep(2000);
		WebElement alertBtnElement = gm.getElement("//input[@id=\"alertbtn\"]", "xpath");
		alertBtnElement.click();
		
		
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
