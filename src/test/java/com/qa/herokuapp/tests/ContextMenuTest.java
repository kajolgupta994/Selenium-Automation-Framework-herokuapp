package com.qa.herokuapp.tests;

import org.testng.annotations.Test;

import com.qa.herokuapp.base.TestBase;

import com.qa.herokuapp.pages.ContextMenuPage;
import com.qa.herokuapp.pages.HomePage;

public class ContextMenuTest extends TestBase {
	private ContextMenuPage handleContextMenuPage;
	private HomePage homePage;

	@Test
	public void testRightClickOnContextMenuBox() {
		
		homePage = new HomePage(getDriver());
		handleContextMenuPage = new ContextMenuPage(getDriver());
		
		LOGGER.info("Navigating to the Context Menu Page...");
		homePage.clickOnContextMenuLinkText();
		LOGGER.info("Navigated to the Context Menu Page.");		
		
		//Context click on the content menu and hold it until alert it shown
		handleContextMenuPage.rightClickOnContextMenuBoxAndHold();

	}

}
