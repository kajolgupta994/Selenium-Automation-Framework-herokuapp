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

		homePage = new HomePage(driver);

		homePage.clickOnCheckboxesLinkText();
		handleCheckboxespage = new CheckboxesPage(driver);
		handleCheckboxespage.selectAndDeselectCheckboxes();

	}

}
