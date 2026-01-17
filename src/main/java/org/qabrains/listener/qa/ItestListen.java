package org.qabrains.listener.qa;

import org.apache.logging.log4j.Logger;
import org.qabrains.utilities.qa.ExtentReport;
import org.qabrains.utilities.qa.LogUtil;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ItestListen implements ITestListener {

	private static ExtentReports reports=ExtentReport.getInstance();
	public static ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();
	Logger log = LogUtil.getLogger(ItestListen.class);
	

	@Override
	public void onStart(ITestContext context) {
		ExtentTest test=reports.createTest("Test started " + context.getName());
		testThread.set(test);
        test.log(Status.INFO, "Test start  --------------- : " + context.getName());
          
	}

	@Override
	public void onTestStart(ITestResult result) {
   
		getTest().log(Status.INFO, "Test Case start." );
         
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		getTest().log(Status.PASS, "Test Case Sucessful.");
		log.info("Test case Passed.");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		getTest().log(Status.FAIL, "Test Case Failure.");
		log.error("Test case failed. Please refer screenshot.");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		getTest().log(Status.SKIP, "Test Case Skipped.");
		log.warn("Test case has been skipped.");
	}

	@Override
	public void onFinish(ITestContext context) {
		getTest().log(Status.INFO, "Test Finished --------------- " + context.getName());
		 reports.flush();
	}
	
	public ExtentTest getTest() {
		return testThread.get();
	}

}
