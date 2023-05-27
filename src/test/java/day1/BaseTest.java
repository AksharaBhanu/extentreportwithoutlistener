package day1;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseTest {
	public static ExtentReports extent;
	public ExtentTest eTest;
	
	@BeforeSuite
	public void initReport()
	{
		extent = new ExtentReports();
	    ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark/Spark.html");
	    extent.attachReporter(spark);
	}
	
	@BeforeMethod
	public void createTest(Method m)
	{
		eTest = extent.createTest(m.getName());
	}
	
	@AfterMethod
	public void endTest(ITestResult result)
	{	
		int status=result.getStatus();
		if(status!=1)
		{
			String failmsg=result.getThrowable().getMessage();
			eTest.fail(failmsg);
		}
	}
	
	@AfterSuite
	public void endReport()
	{
		extent.flush();
	}
}
