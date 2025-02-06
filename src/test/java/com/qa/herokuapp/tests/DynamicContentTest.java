package com.qa.herokuapp.tests;

import org.testng.annotations.Test;
import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.pages.DynamicContentPage;
import com.qa.herokuapp.pages.HomePage;

public class DynamicContentTest extends TestBase {
	private HomePage homePage;
	private DynamicContentPage dynamicContentPage;

	@Test
	public void validateDropdownChange() {

		homePage = new HomePage(getDriver());
		dynamicContentPage = new DynamicContentPage(getDriver());

		LOGGER.info("Clicking on Dynamic Content link...");
		homePage.clickOnDynamicContentLinkText();
		LOGGER.info("Navigated to Dynamic Content page.");

		LOGGER.info("Validating content changes on refresh...");
		dynamicContentPage.navigateAndValidateDynamicContent();
		LOGGER.info("Dynamic content validation completed.");
	}

}
