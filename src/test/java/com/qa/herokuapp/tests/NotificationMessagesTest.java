package com.qa.herokuapp.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.pages.HomePage;
import com.qa.herokuapp.pages.NotificationMessagesPage;

public class NotificationMessagesTest extends TestBase {
	private HomePage homePage;
	private NotificationMessagesPage notificationMessagesPage;

	@Test
	public void validateNotificationMessages() {

		homePage = new HomePage(getDriver());
		notificationMessagesPage = new NotificationMessagesPage(getDriver());

		LOGGER.info("Navigating to the Notification Messages page...");
		homePage.clickOnNotificationMessagesLinkText();

		LOGGER.info("Clicking 'Click Here' and validating notification...");
		boolean isSuccess = notificationMessagesPage.clickUntilSuccess("Action successful", 5);

		// Assert the test outcome
		Assert.assertTrue(isSuccess, "Failed to get expected notification.");

	}

}
