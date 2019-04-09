package testClasses;

import org.testng.annotations.Test;

import listenersPackage.CustomListerner1;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

@Listeners(CustomListerner1.class)
public class TestNG_ListenersTest1  {
 
  @BeforeClass
  public void setUp() {
	  System.out.println("Code in before class");
  }

  @AfterClass
  public void cleanUp() {
	  System.out.println("Code in after class");
  }

  @Test
  public void testMethod1() {
	  System.out.println("Code in testMethod1");
	  Assert.assertTrue(true);
  }
  
  @Test
  public void testMethod2() {
	  System.out.println("Code in testMethod2");
	  Assert.assertTrue(false);
  }
  
}
