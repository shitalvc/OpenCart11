package utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.CommonTcsBaseClass;

public class ExtentReportManagr implements ITestListener{
	public ExtentSparkReporter sparkReport;
	public ExtentReports extent ; //Creates/manages the overall report.
	public ExtentTest test; //ExtentTest is a class in ExtentReports that represents an individual test case in the 
	//report. It is used to log every 
	//step, status, screenshot, and exception for that specific test.
	
	String repName;
	
	public void onStart(ITestContext testContext)
	{
		String timeStamp = new SimpleDateFormat("yyyy.mm..dd.HH.mm.ss").format(new Date());
		repName = "Test-Report-" + timeStamp + ".html";
		sparkReport = new ExtentSparkReporter(".\\reports\\" + repName); //ExtentSparkReporter Generates attractive HTML reports.Shows Passed, Failed, Skipped test case
		sparkReport.config().setDocumentTitle("Ope cart Automation report"); //title of report
		sparkReport.config().setReportName("open cart testing"); //name of report
		sparkReport.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReport);
		extent.setSystemInfo("Application", "openCart");
		extent.setSystemInfo("Username", System.getProperty("user.name"));
		
		String browser = testContext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);
	}
		
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.log(Status.PASS, result.getName()+ "got pass successfully");
		
	}
	
	
	public void onTestFailure(ITestResult result)
		{
			test = extent.createTest(result.getTestClass().getName());
			test.log(Status.FAIL, result.getName() + "got failed");
			test.log(Status.INFO, result.getThrowable().getMessage());

			try {
				String imgPath = new CommonTcsBaseClass().captureScreenShort(result.getName());
				test.addScreenCaptureFromPath(imgPath);
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	public void onTestSkipped(ITestResult result)
	{
		test = extent.createTest(result.getTestClass().getName());
		test.log(Status.SKIP, result.getName() + "got skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());
	}
		
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}
		
		
	
	

}
