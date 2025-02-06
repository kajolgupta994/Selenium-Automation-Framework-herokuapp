package com.qa.herokuapp.tests;

import org.testng.annotations.Test;

import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.pages.BrokenImagesPage;
import com.qa.herokuapp.pages.HomePage;

public class BrokenImagesTest extends TestBase {
	private BrokenImagesPage brokenImagesPage;
	private HomePage homePage;

	@Test
	public void brokenImageTest() {
		homePage = new HomePage(getDriver());
		brokenImagesPage = new BrokenImagesPage(getDriver());

		LOGGER.info("Navigating to Broken Images Page...");
		homePage.clickOnBrokenImagesLinkText();
		LOGGER.info("Successfully navigated to Broken Images Page.");

		brokenImagesPage.getBrokenImageCounts();
	}
}
