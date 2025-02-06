package com.qa.herokuapp.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.pages.AddRemoveElementsPage;
import com.qa.herokuapp.pages.HomePage;

public class AddRemoveElementsTest extends TestBase {
	private AddRemoveElementsPage addRemoveElementsPage;
	private HomePage homePage;

	@Test
	public void addElement() {
		
		homePage = new HomePage(getDriver());
		addRemoveElementsPage = new AddRemoveElementsPage(getDriver());
		
		// Step 1: Navigate to the Add/Remove Elements page
		LOGGER.info("Navigating to the Add/Remove Element page...");		
		homePage.clickOnAddRemoveElementLink();
		LOGGER.info("Navigated to the Add/Remove Element page.");

		// Step 2: Add an element
		LOGGER.info("Clicking on Add element button...");
		addRemoveElementsPage.clickAddElementButton();
		LOGGER.info("Clicked the Add element button...");
		
		// Step 3: Verify the Delete button is displayed
		LOGGER.info("Waiting for the visiblity of delete button...");		
		boolean isDeleteButtonDisplayed = addRemoveElementsPage.isDeleteButtonDisplayed();
		Assert.assertTrue(isDeleteButtonDisplayed, "Delete button should be displayed after adding an element.");
	}

	@Test
	public void addDeleteElement() {
		// Reuse the addElement() test to add an element
		LOGGER.info("Calling the addElement() again to test add and delete element simultaneously...");
		addElement();
		
		// Step 1: Verify the Delete button is displayed
		LOGGER.info("Wait for the delete button to visible...");		
		boolean isDeleteButtonDisplayed = addRemoveElementsPage.isDeleteButtonDisplayed();
		Assert.assertTrue(isDeleteButtonDisplayed, "Delete button should be displayed before attempting deletion.");

		// Step 2: Click the Delete button to remove the element
		LOGGER.info("Trying to click the Delete button to remove the element...");
		addRemoveElementsPage.clickDeleteButton();
		LOGGER.info("Delete button is clicked.");

		// Step 3: Verify the Delete button is no longer displayed
		LOGGER.info("Verify the Delete button is no longer displayed");
		boolean isDeleteButtonStillDisplayed = addRemoveElementsPage.isDeleteButtonNotDisplayed();
		Assert.assertFalse(isDeleteButtonStillDisplayed, "Delete button should not be displayed after deletion.");
	}

}
