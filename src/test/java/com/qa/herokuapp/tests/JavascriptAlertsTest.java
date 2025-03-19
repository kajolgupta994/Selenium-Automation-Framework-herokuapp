package com.qa.herokuapp.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.pages.HomePage;
import com.qa.herokuapp.pages.JavascriptAlertsPage;

public class JavascriptAlertsTest extends TestBase {
	private HomePage homePage;
	private JavascriptAlertsPage javascriptAlertsPage;

	@Test
	public void handleJQueryMenu() {
		homePage = new HomePage(getDriver());
		javascriptAlertsPage = new JavascriptAlertsPage(getDriver());

		LOGGER.info("Navigating to the JavaScript Alert page...");
		homePage.clickOnJavaScriptAlertsLinkText();

		LOGGER.info("Handling JavaScript Alerts...");

		boolean alertHandled = javascriptAlertsPage.handleJavascriptAlert();
		Assert.assertTrue(alertHandled, "Failed to handle JavaScript alert");

		boolean confirmHandled = javascriptAlertsPage.handlejavascriptConfirm(true);
		Assert.assertTrue(confirmHandled, "Failed to handle JavaScript confirm alert");

		boolean promptHandled = javascriptAlertsPage.handleJavascriptPrompt("I'm sending some keys", true);
		Assert.assertTrue(promptHandled, "Failed to handle JavaScript prompt");
	}
}
