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
		homePage = new HomePage(driver);
		
		//Click on the Content Menu 
		homePage.clickOnContextMenuLinkText();

		handleContextMenuPage = new ContextMenuPage(driver);
		
		//Context click on the content menu and hold it until alert it shown
		handleContextMenuPage.rightClickOnContextMenuBoxAndHold();

	}

}
