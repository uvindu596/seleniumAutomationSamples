package extenreports;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {

	//extentReports method
	public static ExtentReports getInstance() {
		ExtentReports extent;
		String Path = "D:\\uvindu dev\\selenium\\reports\\report-demo2.html";
		extent = new ExtentReports(Path, false);
		return extent;
	}	
}
