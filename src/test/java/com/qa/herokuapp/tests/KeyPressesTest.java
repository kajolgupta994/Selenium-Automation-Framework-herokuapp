package com.qa.herokuapp.tests;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.pages.HomePage;
import com.qa.herokuapp.pages.KeyPressesPage;

public class KeyPressesTest extends TestBase {
	private HomePage homePage;
	private KeyPressesPage keyPressesPage;

	@Test
	public void handleJQueryMenu() {

		homePage = new HomePage(getDriver());
		keyPressesPage = new KeyPressesPage(getDriver());

		LOGGER.info("Navigating to the Key Presses page...");
		homePage.clickOnKeyPressesLinkText();

		LOGGER.info("Testing key presses...");
	    keyPressesPage.handleKeyPressedField("Hello123!");
	    keyPressesPage.handleKeyPressedField(Keys.BACK_SPACE.toString());
	    keyPressesPage.handleKeyPressedField(Keys.SPACE.toString());
	}

}
