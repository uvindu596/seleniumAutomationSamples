package actionsClass;

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
import org.openqa.selenium.interactions.Actions;

public class mouseHoverActions {

	WebDriver driver;
	String baseUrl;
	JavascriptExecutor js;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "https://learn.letskodeit.com/p/practice";
		js = (JavascriptExecutor)driver;
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();	
	}
	
	@Test
	public void test() throws InterruptedException {
		
		driver.get(baseUrl);
		js.executeScript("window.scrollBy(0,700)");
		Thread.sleep(3000);
		
		WebElement mainElement = driver.findElement(By.id("mousehover"));
		Actions action = new Actions(driver);
		action.moveToElement(mainElement).perform();
		Thread.sleep(3000);
		
	    WebElement subelement = driver.findElement(By.xpath("//div[@class=\"mouse-hover-content\"]//a[text()='Reload']"));
	    action.moveToElement(subelement).click().perform();
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
