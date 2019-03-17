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
import org.openqa.selenium.support.ui.Select;

public class dropDownSelect {
    WebDriver driver;
    String baseUrl;
	
	@Before
	public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://learn.letskodeit.com/p/practice";
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        
	}

	@Test
	public void test() throws InterruptedException {
		driver.get(baseUrl);
		WebElement element = driver.findElement(By.id("carselect"));
		Select sel = new Select(element);
	
		Thread.sleep(2000);
		System.out.println("select benz by value");
		sel.selectByValue("benz");
		
		
		Thread.sleep(2000);
		System.out.println("select bmw by Index");
		sel.selectByIndex(0);
		
		Thread.sleep(2000);
		System.out.println("select honda by visible text");
		sel.selectByVisibleText("Honda");
		
		Thread.sleep(2000);
		System.out.println("print the list of all options");
	    List<WebElement> options = sel.getOptions();
	    int size = options.size();
	    
	    for(int i=0 ; i < size ; i++) {
	    	String optionName = options.get(i).getText();
	    	System.out.println(optionName);
	    }
	    
	}
	

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
