package com.qa.herokuapp.tests;

import org.testng.annotations.Test;

import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.pages.HomePage;
import com.qa.herokuapp.pages.InputPage;

public class InputTest extends TestBase {
	private HomePage homePage;
	private InputPage inputPage;

	@Test
	public void handleInputTextField() {
		homePage = new HomePage(getDriver());
		inputPage = new InputPage(getDriver());

		LOGGER.info("Navigating to the input page...");
		homePage.clickOnInputsLinkText();

		LOGGER.info("Handling input field...");
		inputPage.handleInputField("abcde");
		inputPage.handleInputFields(" ");

	}

}
