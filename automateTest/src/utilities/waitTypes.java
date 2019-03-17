package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class waitTypes {
	WebDriver driver;
	
	public waitTypes(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement waitForElement(By locator,int timeout) {
		WebElement element = null;
		
		try {
			System.out.println("waiting for max :: "+timeout+" seconds for element to be available");
			
			WebDriverWait wait = new WebDriverWait(driver,timeout);
			element =  wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			System.out.println("Element appeard on the web page !");
			
		} catch (Exception e) {
			System.out.println("Element not appeard on the web page!");
		}
		
    return element;
	}
	
	public void clickWhenReady(By locator,int timeout) {
		
		try {
			WebElement element = null;
			System.out.println("waiting for max :: "+timeout+" seconds for element to be available");
			
			WebDriverWait wait = new WebDriverWait(driver,timeout);
			element =  wait.until(
					ExpectedConditions.elementToBeClickable(locator));
			element.click();
			System.out.println("Element clicked on the web page !");
			
			
			
		} catch (Exception e) {
			System.out.println("Element not appeard on the web page!");
		}
	
	}
	
}
