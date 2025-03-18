package com.qa.herokuapp.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.pages.HomePage;
import com.qa.herokuapp.pages.InfiniteScrollPage;

public class InfiniteScrollTest extends TestBase {
	private WebDriver driver;
	private HomePage homePage;
	private InfiniteScrollPage infiniteScrollPage;

	@Test
	public void handleHoverOnImages() {
		homePage = new HomePage(getDriver());
		infiniteScrollPage = new InfiniteScrollPage(getDriver());

		LOGGER.info("Navigating to the Infinite Scroll page...");
		homePage.clickOnInfiniteScrollLinkText();

		LOGGER.info("Handling infinite scroll...");
		infiniteScrollPage.handleInfiniteScroll();
	}

}
