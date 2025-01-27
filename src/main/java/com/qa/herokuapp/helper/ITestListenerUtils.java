package com.qa.herokuapp.helper;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.qa.herokuapp.base.TestBase;

public class ITestListenerUtils implements ITestListener {
	protected static ExtentReports extent = ExtentUtils.getExtentReports();
	protected static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	@Override
	public void onTestStart(ITestResult result) {

		ExtentTest test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().pass("Test passes.");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Object currentClass = result.getInstance();
		WebDriver driver = ((TestBase) currentClass).getDriver();
		String screenshotPath = ScreenshotUtils.takeScreenshot(driver, result.getMethod().getMethodName());
		extentTest.get().fail(result.getThrowable()).addScreenCaptureFromPath(screenshotPath);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.get().skip("Test skipped.");
	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
