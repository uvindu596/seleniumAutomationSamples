package fileUpload;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class FileUploadWindows {
 
	WebDriver driver;
	String baseUrl;
	
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
	  driver = new FirefoxDriver();
	  baseUrl = "https://www.gmail.com/";
	  
	        // Maximize the browser's window
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(baseUrl);
  }

  @Test
  public void fileUpload() throws InterruptedException, AWTException {
	  //login into gmail
	  WebElement email = driver.findElement(By.id("identifierId"));
	  email.sendKeys("autouvi8@gmail.com");
	  
	  driver.findElement(By.id("identifierNext")).click();
	  Thread.sleep(2000);
	  
	  WebElement password = driver.findElement(By.xpath("//div[@id=\"password\"]/div[1]/div/div[1]/input"));
	  password.sendKeys("Test@1234");
	  
	  driver.findElement(By.id("passwordNext")).click();
	  
	  
	  WebElement composeButton = driver.findElement(By.xpath("//div[@id=\":45\"]/div/div"));
	  composeButton.click();
	  
	  Thread.sleep(3000);
	  
	  //type sending email 
	  WebDriverWait wait = new WebDriverWait(driver, 3);
		WebElement composeTypeEmail = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@name='to']")));
		composeTypeEmail.sendKeys("uvindukavinda@gmail.com");
      //type subject
	  WebElement composeSubject = driver.findElement(By.xpath("//input[@name=\"subjectbox\"]"));
	  composeSubject.sendKeys("file upload");
	  
	  //select file to upload
	  StringSelection ss = new StringSelection("C:\\Users\\ASUS\\Desktop\\testfile.txt");
	  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	  
	  //click file input button
	  WebElement fileInput = driver.findElement(By.xpath("(//div[@class=\"wG J-Z-I\"])[1]"));
	  fileInput.click();
	  
	// Ctrl + v
	  Robot robot = new Robot();
	  robot.keyPress(KeyEvent.VK_CONTROL);
	  robot.keyPress(KeyEvent.VK_V);
	  robot.keyRelease(KeyEvent.VK_V);
	  
	  Thread.sleep(3000);
	 
	  robot.keyRelease(KeyEvent.VK_CONTROL);
	  robot.keyPress(KeyEvent.VK_ENTER);
	  robot.keyRelease(KeyEvent.VK_ENTER);
	  
	  Thread.sleep(3000);
	  
	  //click send button
	  driver.findElement(By.xpath("//div[text() = 'Send']")).click();
  }
  
  @AfterClass
  public void afterClass() throws InterruptedException {
	  Thread.sleep(2000);
	  driver.quit();
  }

}
