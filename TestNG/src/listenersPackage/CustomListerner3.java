package listenersPackage;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class CustomListerner3 implements ISuiteListener{

	@Override
	public void onStart(ISuite suite) {
		// when <suite> tag starts
		System.out.println("onStart: before suite starts");
	}

	@Override
	public void onFinish(ISuite suite) {
		// when <suite> tag starts
	    System.out.println("onFinish: after suite completes");
		
	}

	
}
