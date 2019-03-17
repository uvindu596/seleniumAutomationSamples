package automateTest;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testAutoComplete {
 
	WebDriver driver;
	String baseUrl;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "https://www.bbc.com/weather";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	
	}

	@Test
	public void test() throws InterruptedException {
		
		driver.get(baseUrl);
		String searchingText = "Colón, Panama";
		String partialText = "colo";
		
		WebElement text = driver.findElement(By.id("ls-c-search__input-label"));
		text.sendKeys(partialText);
		Thread.sleep(3000);
		
		WebElement element = driver.findElement(By.xpath("(//ul[@id=\"location-list\"])[1]"));  
		List<WebElement> results = element.findElements(By.tagName("a"));
		int size = results.size();
		Thread.sleep(2000);
		System.out.println(size);

		Thread.sleep(3000);
		for(WebElement result: results) {
			if (result.getText().equals(searchingText)) {
				result.click();
	     	}
		}		
		
	}
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
