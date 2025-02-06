package com.qa.herokuapp.tests;

import org.testng.annotations.Test;

import com.qa.herokuapp.base.TestBase;

import com.qa.herokuapp.pages.HomePage;

import com.qa.herokuapp.pages.CheckboxesPage;

public class CheckboxesTest extends TestBase {

	private HomePage homePage;
	private CheckboxesPage handleCheckboxespage;

	@Test
	public void testClickingCheckboes() {

		homePage = new HomePage(getDriver());
		handleCheckboxespage = new CheckboxesPage(getDriver());

		LOGGER.info("Navigating to the Checkboxes Page...");
		homePage.clickOnCheckboxesLinkText();
		LOGGER.info("Navigated to the Checkboxes Page.");
		
		
		handleCheckboxespage.selectAndDeselectCheckboxes();

	}

}
