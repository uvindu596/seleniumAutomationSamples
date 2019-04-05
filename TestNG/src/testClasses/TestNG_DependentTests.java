package testClasses;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import appcode.SomeClassToTest;

public class TestNG_DependentTests {
 
	SomeClassToTest obj;
	
  @BeforeClass
  public void setUp() {
	  obj = new SomeClassToTest();
	  System.out.println("Before Class");
  }

  @AfterClass
  public void clearUp() {
	  System.out.println("after Class");
  }

  @Test(dependsOnMethods = {"testMethod2"},alwaysRun = true)
  public void testMethod1() {
	  System.out.println("Test method1");
  }
 
  @Test
  public void testMethod2() {
	  System.out.println("Test method2");
	  int result = obj.sumNumbers(1, 2);
	  Assert.assertEquals(result, 2);
  }
  
  @Test(dependsOnMethods = {"testMethod1"})
  public void testMethod3() {
	  System.out.println("Test method3");
  }
  
  @Test
  public void testMethod4() {
	  System.out.println("Test method4");
  }
}
