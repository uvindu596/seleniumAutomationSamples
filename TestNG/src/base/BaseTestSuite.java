package base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTestSuite {
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("\nBaseTestSuite -> before classs");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("\nBaseTestSuite -> after classs");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("\nBaseTestSuite -> before Test");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("\nBaseTestSuite -> after Test");
	}
	

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("\nBaseTestSuite -> before suite");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("\nBaseTestSuite -> after suite");
	}

}
