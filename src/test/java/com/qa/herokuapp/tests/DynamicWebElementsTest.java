package com.qa.herokuapp.tests;

import org.testng.annotations.Test;
import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.pages.DynamicWebElementPage;
import com.qa.herokuapp.pages.HomePage;

public class DynamicWebElementsTest extends TestBase {
	protected DynamicWebElementPage handleDynamicWebElementPage;
	protected HomePage homePage;

	@Test
	public void handleDynamicElement() {
		homePage = new HomePage(getDriver());
		handleDynamicWebElementPage = new DynamicWebElementPage(getDriver());

		LOGGER.info("Step 1: Navigating to the Challenging DOM page...");
		homePage.clickOnChallengingDOMLinkText();
		LOGGER.info("Navigated to the Challenging DOM page.");

		LOGGER.info("Step 2: Clicking on button displaying now...");
		handleDynamicWebElementPage.ClickOnButtonDynamically();
		LOGGER.info("Button clicked dynamically.");

		LOGGER.info("Step 3: Validating table data...");
		String data = handleDynamicWebElementPage.getTableCellValues();
		if (data.isEmpty()) {
			LOGGER.warn("Table data is empty.");
		} else {
			LOGGER.info("Table data: \n" + data);
		}

		LOGGER.info("Step 4: Getting canvas data...");
		String canvasContent = handleDynamicWebElementPage.getCanvasDataAsBase64();
		if (canvasContent != null) {
			LOGGER.info("Canvas content (Base64): " + canvasContent);
		} else {
			LOGGER.error("Failed to retrieve canvas content.");
		}

		LOGGER.info("Step 5: Clicking on the action buttons (edit, delete) to check if enabled and clickable...");
		handleDynamicWebElementPage.clickActionButtons();
		LOGGER.info("Action buttons clicked (edit, delete) and checked for interactability.");
	}
}
