package browserprofiles;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

public class ProfilesDemo {

	public static void main(String[] args) {
		 WebDriver driver;
		 
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
		String baseURL = "https://www.google.com/";
		
		
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile fxProfile = profile.getProfile("automationprofile");
		
		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(fxProfile);
		
		driver = new FirefoxDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseURL);
		
		// C:\Users\ASUS\AppData\Local\Google\Chrome\User Data\Default\Extensions\aapocclcgogkmnckokdopfmhonfmgoek\0.10_0.crx
	}

}
