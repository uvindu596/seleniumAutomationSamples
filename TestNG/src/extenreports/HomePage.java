package extenreports;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HomePage {

	WebDriver driver = null;
	ExtentTest test;

	public HomePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	public void clickSignUpLink() {
		WebElement signupLink = driver.findElement(By.id("comp-iiqg1vggactionTitle"));
		signupLink.click();
		test.log(LogStatus.INFO, "Clicked on signup link");
	}

	public void clickLogInLink() {
		WebElement loginLink = driver.findElement(By.id("signUpDialogswitchDialogLink"));
		loginLink.click();
		test.log(LogStatus.INFO, "Clicked on login link");
	}

	public void Email(String email) {
		WebElement emailField = driver.findElement(By.xpath("//div[@id='memberLoginDialogemail']//input"));
		emailField.sendKeys(email);
		test.log(LogStatus.INFO, "Enter email");
	}

	public void Password(String password) {
		WebElement passwordField = driver.findElement(By.xpath("//div[@id='memberLoginDialogpassword']//input"));
		passwordField.sendKeys(password);
		test.log(LogStatus.INFO, "Enter password");
	}

	public void clickGoButton() {
		WebElement goButton = driver.findElement(By.id("memberLoginDialogokButton"));
		goButton.click();
		test.log(LogStatus.INFO, "Click go button");
	}

	public boolean isWelcomTextPresent() {
		WebElement welcomeText = null;

		try {
			// driver.findElement(By.id("p7kjtbalatabgcoloroverlay")).click();
			welcomeText = driver.findElement(By.id("comp-iiqg1vggactionTitle"));
			return true;
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
			return false;
		}

	}
	
	public void login(String email, String password) {
		clickSignUpLink();
		clickLogInLink();
		Email(email);
		Password(password);
		clickGoButton();
	}

}
