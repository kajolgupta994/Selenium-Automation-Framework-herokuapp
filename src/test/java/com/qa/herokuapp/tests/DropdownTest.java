package com.qa.herokuapp.tests;

import org.testng.annotations.Test;

import com.qa.herokuapp.base.TestBase;

import com.qa.herokuapp.pages.HomePage;

import com.qa.herokuapp.pages.DropdownPage;

public class DropdownTest extends TestBase {

	private HomePage homePage;
	private DropdownPage dropdownPage;

	@Test
	public void validateDropdownValues() {
		LOGGER.info("Initializing HomePage object.");
		homePage = new HomePage(getDriver());

		LOGGER.info("Initializing DropdownPage object.");
		dropdownPage = new DropdownPage(getDriver());

		LOGGER.info("Navigating to Dropdown page.");
		homePage.clickOnDropdownLinkText();
		LOGGER.info("Navigated to Dropdown page.");

		LOGGER.info("Selecting dropdown options.");
		dropdownPage.selectDropdownOptions();
		LOGGER.info("Dropdown option selection completed.");
	}
}
