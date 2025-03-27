package com.qa.herokuapp.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.pages.HomePage;
import com.qa.herokuapp.pages.ShiftingContentPage;

public class ShiftingContentTest extends TestBase {
	private HomePage homePage;
	private ShiftingContentPage shiftingContentPage;

	@BeforeClass
	public void setup() {
		homePage = new HomePage(getDriver());
		shiftingContentPage = new ShiftingContentPage(getDriver());

		LOGGER.info("Navigating to the Shifting Content page...");
		homePage.clickOnShiftingContentLinkText();
	}

	@Test(priority = 1)
	public void validateMenuElement() {
		LOGGER.info("Clicking 'Menu Element'...");
		shiftingContentPage.clickOnMenuElement();

		// Navigate back to the Shifting Content main page
		driver.navigate().back();
		LOGGER.info("Navigated back to Shifting Content main page.");
	}

	@Test(priority = 2)
	public void validateAnImage() {
		LOGGER.info("Clicking 'An Image'...");
		shiftingContentPage.clickAnImage();

		// Navigate back to the Shifting Content main page
		driver.navigate().back();
		LOGGER.info("Navigated back to Shifting Content main page.");

	}

	@Test(priority = 3)
	public void validateAList() {
		LOGGER.info("Clicking 'A List'...");
		shiftingContentPage.clickOnList(3);
	}
}
