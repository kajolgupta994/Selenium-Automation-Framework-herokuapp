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
        LOGGER.info("Setting up the test environment...");
        homePage = new HomePage(getDriver());
        fileDownloadPage = new FileDownloadPage(getDriver());
        LOGGER.info("Test environment setup completed.");
    }

    @Test
    public void testFileDownload() {
        LOGGER.info("Navigating to File Download Page...");
        homePage.clickOnFileDownloadLinkText();
        LOGGER.info("Successfully navigated to File Download Page.");

        LOGGER.info("Initiating file download process...");
        fileDownloadPage.downloadFile();
        LOGGER.info("File download process completed.");
    }
}
