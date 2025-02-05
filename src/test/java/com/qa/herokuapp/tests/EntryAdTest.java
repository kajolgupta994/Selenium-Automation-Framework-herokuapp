package com.qa.herokuapp.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.pages.EntryAdPage;
import com.qa.herokuapp.pages.HomePage;

public class EntryAdTest extends TestBase {
	private EntryAdPage entryAdPage;
	private HomePage homePage;

	@BeforeMethod
	public void setup() {
		homePage = new HomePage(getDriver());
		entryAdPage = new EntryAdPage(getDriver());
	}

	@Test
	public void testCloseModal() {
		LOGGER.info("Navigating to Entry Ad Page...");
        homePage.clickOnEntryAdLinkText();
        LOGGER.info("Successfully navigated to Entry Ad Page.");

		LOGGER.info("Testing modal close functionality...");
		entryAdPage.closeModal();
		
		LOGGER.info("Testing modal re-enable functionality...");
		entryAdPage.reEnableModal();
		
	}

}
