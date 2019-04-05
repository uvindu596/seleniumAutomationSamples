package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;
import appcode.*;

public class TestAnnotation {
	
  @Test
  public void testMethod1() {
	  System.out.println("Running Test --> testMethod1");
	  SomeClassToTest obj = new SomeClassToTest();
	  int result = obj.sumNumbers(1, 2);
	  
	  Assert.assertEquals(result, 3);
   }
  
  @Test
  public void testMethod2() {
	  System.out.println("Running Test --> testMethod2");
	  String expectedString = "Hello World";
	  SomeClassToTest obj = new SomeClassToTest();
	  String result = obj.addString("Hello", " World");
	  
	  Assert.assertEquals(result, expectedString);
   }
  
  @Test
  public void testMethod3() {
	  System.out.println("Running Test --> testMethod3");
	  int [] expectedArray = {1,2,3};
	  SomeClassToTest obj = new SomeClassToTest();
	
	  Assert.assertEquals(obj.getArray(),expectedArray);
   }
  
}
