package com.qa.herokuapp.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.pages.GeolocationPage;
import com.qa.herokuapp.pages.HomePage;

public class GeolocationTest extends TestBase {
	private WebDriver driver;

	private HomePage homePage;
	private GeolocationPage geolocationPage;

	@Test
	public void testGeoLocation() {
		homePage = new HomePage(getDriver());
		geolocationPage = new GeolocationPage(getDriver());
		// Navigate to the Geolocation page
		homePage.clickOnGeolocationLinkText();
		LOGGER.info("Navigated to the Geolocation page.");

		// Click on the "Where am I?" button
		geolocationPage.clickOnWhereAmIButton();
		LOGGER.info("Clicked on the 'Where am I?' button.");

	}

}
