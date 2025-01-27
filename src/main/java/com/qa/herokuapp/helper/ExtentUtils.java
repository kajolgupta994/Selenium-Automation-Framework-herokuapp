package com.qa.herokuapp.helper;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentUtils {
	protected static ExtentTest test;
	protected static ExtentReports extent;

	public static ExtentReports getExtentReports() {
		if (extent == null) {
			ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReports/TestReports.html");
			spark.config().setDocumentTitle("Automation Test Report");
			spark.config().setReportName("Test Execution Report");
			extent = new ExtentReports();
			extent.attachReporter(spark);
			extent.setSystemInfo("Environment", "QA");
			extent.setSystemInfo("Author", "Kajol");
		}
		return extent;
	}

}
