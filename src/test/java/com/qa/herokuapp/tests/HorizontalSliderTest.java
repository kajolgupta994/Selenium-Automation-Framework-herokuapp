package com.qa.herokuapp.tests;

import org.testng.annotations.Test;

import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.pages.HomePage;
import com.qa.herokuapp.pages.HorizontalSliderPage;

public class HorizontalSliderTest extends TestBase {

	private HomePage homePage;
	private HorizontalSliderPage horizontalSliderPage;

	@Test
	public void handleHorizontalSlider() {
		homePage = new HomePage(getDriver());
		horizontalSliderPage = new HorizontalSliderPage(getDriver());

		LOGGER.info("Navigating to horizontal slider page...");
	    homePage.clickOnHorizontalSliderLinkText();

	    LOGGER.info("Setting slider value to 3.5...");
	    horizontalSliderPage.setSliderValue(4.5); // Move slider to 4.5
	    
	}

}
