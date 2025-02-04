package com.qa.herokuapp.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.pages.DynamicControlsPage;
import com.qa.herokuapp.pages.HomePage;

public class DynamicControlsTest extends TestBase {
	private DynamicControlsPage dynamicControlsPage;
	private HomePage homePage;

	@Test
	public void testDynamicControls()  {
		homePage = new HomePage(getDriver());
		dynamicControlsPage = new DynamicControlsPage(getDriver());
		SoftAssert softAssert = new SoftAssert(); // Initialize SoftAssert

		LOGGER.info("Navigating to Dynamic Controls Page");
		homePage.clickOnDynamicControlsLinkText();
		LOGGER.info("Successfully navigated to Dynamic Controls");

		// **Step 1: Check and Uncheck the Checkbox**
		LOGGER.info("Checking and Unchecking the checkbox");
		dynamicControlsPage.checkUncheckCheckbox(); // Check
		dynamicControlsPage.checkUncheckCheckbox(); // Uncheck
		LOGGER.info("Checkbox toggling completed");

		// **Step 2: Remove and Add the Checkbox**
		LOGGER.info("Removing the checkbox");
		dynamicControlsPage.removeCheckbox();
		String removeMessage = dynamicControlsPage.getMessageText();
		LOGGER.info("Checkbox removed. Message: " + removeMessage);
		softAssert.assertTrue(removeMessage.contains("It's gone!"), "Checkbox remove message mismatch!");

		LOGGER.info("Adding the checkbox back");
		dynamicControlsPage.addCheckbox();
		String addMessage = dynamicControlsPage.getMessageText();
		LOGGER.info("Checkbox added back. Message: " + addMessage);
		softAssert.assertTrue(addMessage.contains("It's back!"), "Checkbox add message mismatch!");

		// **Step 3: Disable and Enable the Input Field**
		LOGGER.info("Click the enabled button");
		dynamicControlsPage.enableDisableTextBox();
		LOGGER.info("Enabled button is clicked...");
		LOGGER.info("Verifying the enable message...");
		String enableMessage = dynamicControlsPage.getMessageText();
		LOGGER.info("Actual enable message received: " + enableMessage);
		softAssert.assertTrue(enableMessage.contains("It's enabled!"),
				"❌ Input field enable message mismatch! Expected: 'It's enabled!' but found: " + enableMessage);

		// Now click the disable button
		LOGGER.info("Click the disabled button");
		dynamicControlsPage.enableDisableTextBox();
		LOGGER.info("Disable button is clicked...");
		LOGGER.info("Disabling the input field");
		LOGGER.info("Verifying the disable message...");		
		String disableMessage = dynamicControlsPage.getMessageText();
		LOGGER.info("Actual disable message received: " + disableMessage);
		softAssert.assertTrue(disableMessage.contains("It's disabled!"),
				"❌ Input field disable message mismatch! Expected: 'It's disabled!' but found: " + disableMessage);

		
		softAssert.assertAll(); // Ensure all assertions are checked
	}
}
