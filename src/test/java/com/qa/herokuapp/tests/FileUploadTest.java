package com.qa.herokuapp.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.pages.FileUploadPage;
import com.qa.herokuapp.pages.HomePage;

public class FileUploadTest extends TestBase {
	private FileUploadPage fileUploadPage;
	private HomePage homePage;

	@BeforeMethod
	public void setup() {
		homePage = new HomePage(getDriver());
		fileUploadPage = new FileUploadPage(getDriver());
	}

	@Test(priority = 1)
	public void testFileDownload() {
		LOGGER.info("Navigating to File Upload Page...");
		homePage.clickOnFileUplaodLinkText();
		LOGGER.info("Successfully navigated to File Upload Page.");

		String filePath = "C:\\Users\\kajol\\Downloads\\aaa (3).txt";
		LOGGER.info("Initiating file upload process for: " + filePath);
		fileUploadPage.uploadFile(filePath);
		LOGGER.info("File upload process completed.");

		String uploadedFile = fileUploadPage.getUploadedFileName();
		Assert.assertEquals(uploadedFile, "aaa (3).txt", "File upload failed!");
		LOGGER.info("File upload verified successfully.");

		driver.navigate().back();
	}

	@Test(priority = 2, dependsOnMethods = "testFileDownload")
	public void testDragAndDropFileUpload() {
		String filePath = "C:\\Users\\kajol\\Downloads\\Test2 (4).pdf";
		LOGGER.info("Starting drag-and-drop file upload for: " + filePath);

		fileUploadPage.uploadFileUsingActions(filePath);

		String uploadedFile = fileUploadPage.getDragAndDropUploadedFileName();
		Assert.assertEquals(uploadedFile, "Test2 (4).pdf", "Drag and Drop file upload failed!");
		LOGGER.info("Drag-and-drop file upload verified successfully.");
	}
}
