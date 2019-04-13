package listenersPackage;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

public class CustomListerner2 implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// when test methos start
		System.out.println("onTestStart -> Test Name: "+result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// when test methos success
		System.out.println("onTestSuccess -> Test Name: "+result.getName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// when test methos failed
		System.out.println("onTestFailure -> Test Name: "+result.getName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// when test methos skipped	
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		//Before <test> tag of xml file
		System.out.println("onStart -> Test Name: "+context.getName());
		
		ITestNGMethod methods [] = context.getAllTestMethods();
		System.out.println("These methos will be executed in this test tag");
		for(ITestNGMethod method:methods) {
			System.out.println(method.getMethodName());
		}
		
	}

	@Override
	public void onFinish(ITestContext context) {
		//Before <test> tag of xml file
		System.out.println("onFinish -> Test Tag Name: "+context.getName());
	}



}
