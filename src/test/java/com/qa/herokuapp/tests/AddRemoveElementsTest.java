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
		// Step 1: Navigate to the Add/Remove Elements page
		homePage = new HomePage(driver);
		homePage.clickOnAddRemoveElementLink();

		// Step 2: Add an element
		addRemoveElementsPage = new AddRemoveElementsPage(driver);
		addRemoveElementsPage.clickAddElementButton();

		// Step 3: Verify the Delete button is displayed
		boolean isDeleteButtonDisplayed = addRemoveElementsPage.isDeleteButtonDisplayed();
		Assert.assertTrue(isDeleteButtonDisplayed, "Delete button should be displayed after adding an element.");
	}

	@Test
	public void addDeleteElement() {
		// Reuse the addElement() test to add an element
		addElement();

		// Step 1: Verify the Delete button is displayed
		boolean isDeleteButtonDisplayed = addRemoveElementsPage.isDeleteButtonDisplayed();
		Assert.assertTrue(isDeleteButtonDisplayed, "Delete button should be displayed before attempting deletion.");

		// Step 2: Click the Delete button to remove the element
		addRemoveElementsPage.clickDeleteButton();

		// Step 3: Verify the Delete button is no longer displayed
		boolean isDeleteButtonStillDisplayed = addRemoveElementsPage.isDeleteButtonNotDisplayed();
		Assert.assertFalse(isDeleteButtonStillDisplayed, "Delete button should not be displayed after deletion.");
	}

}
