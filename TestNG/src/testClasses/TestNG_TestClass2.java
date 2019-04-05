package testClasses;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestNG_TestClass2 {

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("\nTestNG_TestClass2 -> This runs before every method");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("\nTestNG_TestClass2 -> This runs after every method");
	}

	@BeforeClass
	public void beforeClass() {
		  System.out.println("\nTestNG_TestClass2 -> This runs once before class");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("\nTestNG_TestClass2 -> This runs once after class");
	}

	@Test
	public void testMethod1() {
		System.out.println("\nTestNG_TestClass2 -> Running Test ->TestNG_TestClass2 -> testMethod 1");
	}

	@Test
	public void testMethod2() {
		System.out.println("\\nRunning Test ->TestNG_TestClass2 -> testMethod 2");
	}

}
