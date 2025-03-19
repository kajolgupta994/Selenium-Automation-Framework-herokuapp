package com.qa.herokuapp.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.helper.ActionUtils;
import com.qa.herokuapp.pages.HomePage;
import com.qa.herokuapp.pages.JQueryMenuUIPage;

public class JQueryMenuUITest extends TestBase {
	private HomePage homePage;
	private JQueryMenuUIPage jQueryMenuUIPage;

	@Test
	public void handleJQueryMenu() {
	
		homePage = new HomePage(getDriver());
		jQueryMenuUIPage = new JQueryMenuUIPage(getDriver());

		LOGGER.info("Navigating to the JQuery Menu UI page...");
		homePage.clickOnJqueryUIMenusLinkText();

		LOGGER.info("Handling JQuery Menu UI...");
		boolean menuHandled = jQueryMenuUIPage.handleJQueryUIMenu(); // Interact with the main menus

		// Assert the main menus are handled correctly
		Assert.assertTrue(menuHandled, "Failed to handle main menus");

		// Handle submenus in the Downloads section
		boolean downloadOptionsHandled = jQueryMenuUIPage.handleDownloadSubmenus();
		Assert.assertTrue(downloadOptionsHandled, "Failed to interact with download options");
		
		 // Click "Back to JQuery UI"
        boolean isBackClicked = jQueryMenuUIPage.clickBackToJQueryUI();
        Assert.assertTrue(isBackClicked, "Failed to navigate back to JQuery UI page");
        
        // Click "Menu"
        boolean isMenuClicked = jQueryMenuUIPage.clickOnMenuOption();
        Assert.assertTrue(isMenuClicked, "Failed to navigate back to menu page");

	}

}
