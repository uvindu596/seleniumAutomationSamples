package testClasses;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestNG_Grouping {

	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		System.out.println("Before Class");
	}

	@Test(groups = {"cars","suv"})
	public void testBMWX6() {
		System.out.println("Running Test - BMWX6");
	}

	@Test(groups = {"cars","sedan"})
	public void testAudiA6() {
		System.out.println("Running Test - AudiA6");
	}

	@Test(groups = {"bikes"})
	public void testNinja() {
		System.out.println("Running Test - testNinja");
	}

	@Test(groups = {"bikes"})
	public void testHondaCBR() {
		System.out.println("Running Test - testHondaCBR");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		System.out.println("after Class");
	}
  
}
