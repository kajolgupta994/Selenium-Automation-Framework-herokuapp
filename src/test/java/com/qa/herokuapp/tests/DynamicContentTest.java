package com.qa.herokuapp.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.pages.DynamicContentPage;
import com.qa.herokuapp.pages.HomePage;


public class DynamicContentTest extends TestBase {
	private HomePage homePage;
	private DynamicContentPage dynamicContentPage;

	@Test
	public void validateDropdownValues() {

		homePage = new HomePage(driver);

		LOGGER.info("Click on the Dynamic Content link text: ");
		homePage.clickOnDynamicContentLinkText();
		LOGGER.info("Clicked on the Dynamic Content link text.");
		dynamicContentPage = new DynamicContentPage(driver);
		LOGGER.info("Trying to get texts from the dynamically changing columns...");
		dynamicContentPage.navigateToEachRow();
		LOGGER.info("All the texts are recieved.");
	}

	
}
