package seleniumFrameworkProject.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsTest {
	public static ExtentReports er;
	public static ExtentReports reportMethod()
	{
		
		
		ExtentSparkReporter esr = new ExtentSparkReporter(System.getProperty("user.dir")+"\\target\\index.html");
		esr.config().setReportName("extent reports");
		esr.config().setDocumentTitle("Testing");
		er = new ExtentReports();
		er.attachReporter(esr);
		er.setSystemInfo("Local", "WindowsMachine");
		return er;
	}

}
