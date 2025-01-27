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

		homePage = new HomePage(driver);

		homePage.clickOnDropdownLinkText();
		dropdownPage = new DropdownPage(driver);
		dropdownPage.selectDropdownOptions();

	}

}
