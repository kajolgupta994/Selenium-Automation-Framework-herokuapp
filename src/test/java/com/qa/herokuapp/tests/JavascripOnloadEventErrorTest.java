package com.qa.herokuapp.tests;

import org.testng.annotations.Test;
import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.pages.HomePage;
import com.qa.herokuapp.pages.JavascriptOnloadEventErrorPage;

public class JavascripOnloadEventErrorTest extends TestBase {
	private HomePage homePage;
	private JavascriptOnloadEventErrorPage javascriptOnloadEventErrorPage;

	@Test
	public void handleJQueryMenu() {
		homePage = new HomePage(getDriver());
		javascriptOnloadEventErrorPage = new JavascriptOnloadEventErrorPage(getDriver());

		LOGGER.info("Navigating to the JavaScript Onload Event Error page...");
		homePage.clickOnJavaScriptOnloadEventErrorLinkText();

		LOGGER.info("Handling JavaScript Onload Event Error...");

		javascriptOnloadEventErrorPage.captureJSErrors();

	}
}
