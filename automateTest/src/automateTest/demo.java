package automateTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class demo {
   public static void main(String[] args) {
	 WebDriver driver;
	 
	 System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
	 
	 driver = new FirefoxDriver();
	 
	 String baseURL = "https://www.youtube.com/";
	 driver.get(baseURL);
	 
	 driver.findElement(By.xpath("//input[@id=\"search\"]")).sendKeys("kalhari bandara");
	 driver.findElement(By.xpath("//button[@id=\"search-icon-legacy\"]")).click();
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 driver.findElement(By.linkText("Rajika & Kalhari videodisplay")).click();
  }
}
