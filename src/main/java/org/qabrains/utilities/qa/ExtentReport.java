package org.qabrains.utilities.qa;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

	private static ExtentReports reports;

	public static ExtentReports getInstance() {
		if (reports == null) {
			ExtentSparkReporter spark = new ExtentSparkReporter("HTMLExtentReport/ExtentReport.html");
			spark.config().setDocumentTitle("QABrains Test case Report");
			spark.config().setReportName("QABrains Sites Test Case Report");
			reports = new ExtentReports();
			reports.attachReporter(spark);
			reports.setSystemInfo("Project Name", "Automation of QABranins");
			reports.setSystemInfo("Framework", "Selenium");
			reports.setSystemInfo("Team Name", "Software Tester");
		}
		return reports;
	}

}
