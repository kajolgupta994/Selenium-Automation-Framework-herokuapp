package com.qa.herokuapp.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.pages.FloatingMenuPage;
import com.qa.herokuapp.pages.HomePage;

public class FloatingMenuTest extends TestBase {
	private FloatingMenuPage floatingMenuPage;
	private HomePage homePage;

	@Test
	public void testFloadingMenu() {
		homePage = new HomePage(getDriver());
		floatingMenuPage = new FloatingMenuPage(getDriver());

		homePage.clickOnFloatingMenuLinkText();
		floatingMenuPage.clickOnMenus();
		Assert.assertTrue(floatingMenuPage.isMenuVisibleAfterScroll(), "Floating menu should remain visible.");
	}

}
