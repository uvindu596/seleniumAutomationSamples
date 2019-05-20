package automateTest;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigatingBetweenPages {

	WebDriver driver;
	String baseURL;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","chromeDriver/chromedriver.exe");
		driver = new ChromeDriver();
		baseURL = "https://learn.letskodeit.com/";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();	
	}

	@Test
	public void test() throws InterruptedException {
		driver.get(baseURL);
		
		//get title
	    String title =	driver.getTitle();
	    System.out.println("title of the page:"+title);
	    
	    //get current url
	    String currentUrl =  driver.getCurrentUrl();
	    System.out.println("current url is:"+currentUrl);
	    
	    
	    //navigate to another url
	    String urlToNavigate = "https://www.letskodeit.com/courses";
	    driver.navigate().to(urlToNavigate);
	    
	    currentUrl =  driver.getCurrentUrl();
	    System.out.println("navigation url is:"+currentUrl);
	    
	    // wait
	    Thread.sleep(2000);
	    
	    // navigate back
	    driver.navigate().back();
	    Thread.sleep(2000);
	    
	    currentUrl =  driver.getCurrentUrl();
	    System.out.println("current url is:"+currentUrl);
	    
	    // navigate forward
	    driver.navigate().forward();
	    
	    currentUrl =  driver.getCurrentUrl();
	    System.out.println("current url is:"+currentUrl);
	    
	    // navigate back
	    driver.navigate().back();
	    Thread.sleep(2000);
	    
	    currentUrl =  driver.getCurrentUrl();
	    System.out.println("navigated back! current url is:"+currentUrl);
	    
	    //refresh
	    driver.navigate().refresh();
	    System.out.println("Navigate Refresh");
	    
	    // refresh method 2
	    driver.get(currentUrl);
	    System.out.println("Navigate Refresh");
	    
	    //page source
	    String pageSource = driver.getPageSource();
	    System.out.println(pageSource);
	}

	
	@After
	public void tearDown() throws Exception {
	//	driver.quit();
	}

	
}
