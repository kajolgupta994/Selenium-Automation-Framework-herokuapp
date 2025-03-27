package com.qa.herokuapp.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.pages.HomePage;
import com.qa.herokuapp.pages.MultipleWindowsPage;

public class MutipleWindowsTest extends TestBase {
	private HomePage homePage;
	private MultipleWindowsPage multipleWindowsPage;

	@Test
	public void handleJQueryMenu() {

		homePage = new HomePage(getDriver());
		multipleWindowsPage = new MultipleWindowsPage(getDriver());

		LOGGER.info("Navigating to the Multiple Windows page...");
		homePage.clickOnMultipleWindowsLinkText();

		multipleWindowsPage.clickHere();

		String result = multipleWindowsPage.getTextFromNewWindow();
		

		// Verify that the new window contains expected text
		Assert.assertEquals(result, "New Window", "Text does not match!");
	}

}
