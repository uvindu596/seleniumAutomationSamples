package browserprofiles;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsDemo {

	public static void main(String[] args) {
		
	String baseUrl = "http://www.google.com";
	WebDriver driver;
	System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
	
	ChromeOptions options = new ChromeOptions();
	options.addExtensions(new File("C:\\Users\\ASUS\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Extensions\\aapocclcgogkmnckokdopfmhonfmgoek\\0.10_0.crx"));
	
    driver = new ChromeDriver(options);
    driver.get(baseUrl);
	
	}

}
