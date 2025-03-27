package com.qa.herokuapp.tests;

import org.testng.annotations.Test;

import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.pages.HomePage;
import com.qa.herokuapp.pages.RedirectLinkPage;

public class RedirectLinkTest extends TestBase {
	private HomePage homePage;
	private RedirectLinkPage redirectLinkPage;

	@Test
	public void validateNotificationMessages() {

		homePage = new HomePage(getDriver());
		redirectLinkPage = new RedirectLinkPage(getDriver());

		LOGGER.info("Navigating to the Redirect Link page...");
		homePage.clickOnRedirectLinkLinkText();

		LOGGER.info("Clicking 'Click Here' to navigate to Status Codes page...");
		redirectLinkPage.clickHere();

		LOGGER.info("Clicking on status codes and validating messages...");
		redirectLinkPage.clickOnStatuses();

		LOGGER.info("Test completed successfully.");
	}

}
