package com.qa.herokuapp.tests;

import org.testng.annotations.Test;

import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.pages.FramesPage;
import com.qa.herokuapp.pages.HomePage;

public class FramesTest extends TestBase {

	private HomePage homePage;
	private FramesPage framesPage;

	@Test
	public void handleNestedFrames() {
		homePage = new HomePage(getDriver());
		framesPage = new FramesPage(getDriver());

		LOGGER.info("Navigating to Frames page...");
		homePage.clickOnFramesLinkText();

		LOGGER.info("Navigating to Nested Frames...");
		framesPage.clickNestedFrames();

		LOGGER.info("Handling Top Frames...");
		framesPage.handleTopFrames();

		LOGGER.info("Handling Bottom Frame...");
		framesPage.handleBottomFrames();
	}

}
