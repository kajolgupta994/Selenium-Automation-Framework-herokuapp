package com.qa.herokuapp.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.pages.DynamicControlsPage;
import com.qa.herokuapp.pages.DynamicLoadingPage;
import com.qa.herokuapp.pages.HomePage;

public class DynamicLoadingTest extends TestBase {
	private DynamicLoadingPage dynamicLoadingPage;
	private HomePage homePage;

	@Test
	public void testDynamicLoading() {
		homePage = new HomePage(getDriver());
		dynamicLoadingPage = new DynamicLoadingPage(getDriver());
		SoftAssert softAssert = new SoftAssert(); // Initialize SoftAssert

		LOGGER.info("Navigating to Dynamic Loading Page");
		homePage.clickOnDynamicLoadingLinkText();
		LOGGER.info("Successfully navigated to Dynamic Loading");

		// **Click Example 1 link text**

		LOGGER.info("Click the Example 1 text");
		dynamicLoadingPage.exampleOneTest();
		LOGGER.info("Example 1 text is clicked...");
		LOGGER.info("Verifying the Example 1 message...");
		String exampleOneFinishMessage = dynamicLoadingPage.getFinishText();
		LOGGER.info("Actual finish message received: " + exampleOneFinishMessage);
		softAssert.assertTrue(exampleOneFinishMessage.contains("Hello World!"),
				"❌ Finish message mismatch! Expected: 'Hello World!' but found: " + exampleOneFinishMessage);

		driver.navigate().back();
		
		// Now click the Example 2 text
		LOGGER.info("Click the Example 2 text");
		dynamicLoadingPage.exampleTwoTest();
		LOGGER.info("Example 2 text is clicked...");
		LOGGER.info("Verifying the Example 2 message...");
		String exampleTwoFinishMessage = dynamicLoadingPage.getFinishText();
		LOGGER.info("Actual finish message received: " + exampleTwoFinishMessage);
		softAssert.assertTrue(exampleTwoFinishMessage.contains("Hello World!"),
				"❌ Finish message mismatch! Expected: 'Hello World!' but found: " + exampleTwoFinishMessage);

		softAssert.assertAll(); // Ensure all assertions are checked
	}
}
