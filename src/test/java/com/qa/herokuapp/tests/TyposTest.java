package com.qa.herokuapp.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.pages.HomePage;
import com.qa.herokuapp.pages.TyposPage;

public class TyposTest extends TestBase {
	private HomePage homePage;
	private TyposPage typosPage;

	@BeforeClass
	public void setup() {
		homePage = new HomePage(getDriver());
		typosPage = new TyposPage(getDriver());

		LOGGER.info("Navigating to the typos page...");
		homePage.clickOnTyposLinkText();
	}

	@Test(priority = 1)
	public void validateTyposOnPage() {
		String actualText = typosPage.getPageText();
		String expectedText = "Sometimes you'll see a typo, other times you won't.";

		LOGGER.info("Validating text on the Typos page..."+actualText);
		Assert.assertEquals(actualText, expectedText, "TYPO FOUND on the page!");
	}
	
	@Test(priority = 2)
	public void validatePageTextForTypos() {
	    String pageText = typosPage.getPageText();
	    Assert.assertTrue(typosPage.isSpellingCorrect(pageText), "TYPO FOUND in the text!");
	}

}
