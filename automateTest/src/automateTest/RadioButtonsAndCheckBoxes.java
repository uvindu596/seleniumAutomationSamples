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

public class RadioButtonsAndCheckBoxes {
	
	WebDriver driver;
	String baseUrl;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "https://learn.letskodeit.com/p/practice";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseUrl);		
	}
	
	@Test
	public void test() throws InterruptedException {
		WebElement bmwRadioButton = driver.findElement(By.id("bmwradio"));
		bmwRadioButton.click();
		
		Thread.sleep(2000);
		WebElement benzRadioButton = driver.findElement(By.id("benzradio"));
		benzRadioButton.click();
		
		WebElement bmwCheckBox = driver.findElement(By.id("bmwcheck"));
		bmwCheckBox.click();
		
		Thread.sleep(2000);
		WebElement benzCheckBox = driver.findElement(By.id("benzcheck"));
		benzCheckBox.click();
		
		System.out.println("Bmw radio is selected? "+bmwRadioButton.isSelected());
		System.out.println("Benz radio is selected? "+benzRadioButton.isSelected());
		System.out.println("Bmw checkbox is selected? "+bmwCheckBox.isSelected());
		System.out.println("Benz checkbox is selected? "+benzCheckBox.isSelected());
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
	


}
