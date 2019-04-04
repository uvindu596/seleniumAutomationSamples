package page.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class searchPageFactory {
	WebDriver driver;
	
	@FindBy(id= "tab-flight-tab-hp")
	WebElement flightTab;
  
	@FindBy(id = "flight-type-roundtrip-label-hp-flight")
	WebElement roundTrip;
	
	@FindBy(id="flight-type-multi-dest-label-hp-flight")
	WebElement multipleDestination;
	
	@FindBy(id="flight-origin-hp-flight") 
	WebElement originCity;
	
	@FindBy(id="flight-destination-hp-flight")
	WebElement destinationCity;
	
	@FindBy(id="flight-departing-single-hp-flight")
	WebElement depaturedate;
	
	@FindBy(id="flight-2-destination-hp-flight")
	WebElement returnDate;
	
	public searchPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickFlightTab() {
		flightTab.click();
	}
	
	public void clickRoundTrip() {
		roundTrip.click();
	}
	public void clickMultipleDestination () {
		multipleDestination.click();
	}
	public void setOriginCity(String origin) {
		originCity.sendKeys(origin);
	}
	
	public void setDestinationCity(String destination) {
		destinationCity.sendKeys(destination);
	}
}
