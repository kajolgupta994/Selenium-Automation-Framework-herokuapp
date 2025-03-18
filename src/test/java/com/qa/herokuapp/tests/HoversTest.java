package com.qa.herokuapp.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.pages.HomePage;
import com.qa.herokuapp.pages.HoversPage;

public class HoversTest extends TestBase {
	private WebDriver driver;
	private HomePage homePage;
	private HoversPage hoversPage;

	@Test
	public void handleHoverOnImages() {
		homePage = new HomePage(getDriver());
		hoversPage = new HoversPage(getDriver());

		LOGGER.info("Navigating to the Hovers page...");
		homePage.clickOnHoversLinkText();

		LOGGER.info("Hover over on images...");
		hoversPage.hoverOverOnImages();

	}

}
