package testClasses;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestNG_Priority {

	@BeforeClass
	public void setUp() {
		System.out.println("\nTestNG_Priority ->  before class");
	}

	@AfterClass
	public void cleanUp() {
		System.out.println("\nTestNG_Priority ->  after class");
	}
	
	@Test(priority=2)
	public void testMethod1() {
		System.out.println("\nTestNG_Priority ->  testMethod1");
	}
	
	@Test(priority=1)
	public void testMethod2() {
		System.out.println("\nTestNG_Priority ->  testMethod2");	
	}
	
	@Test(priority=0)
	public void testMethod3() {
		System.out.println("\nTestNG_Priority ->  testMethod3");		
	}

}
