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
		homePage = new HomePage(driver);

		// Step 1: Navigate to the Challenging DOM page

		homePage.clickOnChallengingDOMLinkText();

		handleDynamicWebElementPage = new DynamicWebElementPage(driver);

		// Step 2: Click on button displaying now
		handleDynamicWebElementPage.ClickOnButtonDynamically();

		// Step 3: Validate table data
		String Data = handleDynamicWebElementPage.getTableCellValues();
		if (Data.isEmpty()) {
			System.out.println("Table data is empty.");
		} else {
			System.out.println(Data);
		}

		// Step 4: Get canvas data
		String canvasContent = handleDynamicWebElementPage.getCanvasDataAsBase64();
		if (canvasContent != null) {
			System.out.println("Canvas content(Base64) " + canvasContent);
		} else {
			System.out.println("Failed to retrieve canvas content.");
		}

		// Step 5: Click on the action buttons(edit, delete) to check if enabled and
		// clickable
		handleDynamicWebElementPage.clickActionButtons();

	}
}
