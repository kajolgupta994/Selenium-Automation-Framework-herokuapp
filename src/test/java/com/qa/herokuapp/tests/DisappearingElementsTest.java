package com.qa.herokuapp.tests;

import org.testng.annotations.Test;
import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.pages.DisappearingElementsPage;
import com.qa.herokuapp.pages.HomePage;

public class DisappearingElementsTest extends TestBase {
	protected DisappearingElementsPage handleDisappearingElementsPage;
	protected HomePage homePage;

	@Test
	public void validateDisappearingElement() {
		homePage = new HomePage(driver);

		// Navigate to the Disappearing Elements page
		homePage.clickOnDisappearingElementsLinkText();

		handleDisappearingElementsPage = new DisappearingElementsPage(driver);

		// Click on menus
		handleDisappearingElementsPage.ClickOnMenusDynamically();
	}
}
