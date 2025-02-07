package com.qa.herokuapp.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.pages.FileDownloadPage;
import com.qa.herokuapp.pages.HomePage;

public class FileDownloadTest extends TestBase {
	private FileDownloadPage fileDownloadPage;
	private HomePage homePage;

	@BeforeMethod
	public void setup() {
		homePage = new HomePage(getDriver());
		fileDownloadPage = new FileDownloadPage(getDriver());
	}

	@Test
	public void testFileDownload() {
		LOGGER.info("Navigating to File Download Page...");
		homePage.clickOnFileDownloadLinkText();
		LOGGER.info("Successfully navigated to File Download Page.");

		LOGGER.info("Initiating file download process...");
		// This function will only work if browser = chrome is set in config.properties
		// file as we set TestBase.java with ChromeOptions class to work with file
		// downloads, if want to work with other browsers we need to set them like
		// ChromeOptions class
		fileDownloadPage.downloadFile();
		LOGGER.info("File download process completed.");
	}
}
