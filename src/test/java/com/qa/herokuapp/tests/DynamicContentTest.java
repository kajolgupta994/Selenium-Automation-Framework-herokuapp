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
	public void validateDropdownChange() {

		homePage = new HomePage(driver);
		LOGGER.info("Clicking on Dynamic Content link...");
		homePage.clickOnDynamicContentLinkText();
		LOGGER.info("Navigated to Dynamic Content page.");

		dynamicContentPage = new DynamicContentPage(driver);
		LOGGER.info("Validating content changes on refresh...");
		dynamicContentPage.navigateAndValidateDynamicContent();
		LOGGER.info("Dynamic content validation completed.");
	}

}
