package testClasses;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestNG_EnableTimeout {

	@BeforeClass
	public void setUp() {
		System.out.println("Before Class");
	}

	@AfterClass
	public void cleanUp() {
		System.out.println("after Class");
	}

	@Test(enabled = false)
	public void testMethod1() {
		System.out.println("Test method1");
	}

	@Test(timeOut = 300)
	public void testMethod2() throws InterruptedException {
		System.out.println("Test method2");
		Thread.sleep(200);
	}

}
