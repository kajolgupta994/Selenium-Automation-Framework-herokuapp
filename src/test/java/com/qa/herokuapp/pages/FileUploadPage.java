package com.qa.herokuapp.pages;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.helper.WebDriverWaitUtils;

public class FileUploadPage extends TestBase {
	private WebDriver driver;

	@FindBy(id = "file-upload")
	private WebElement chooseFileButton;

	@FindBy(id = "file-submit")
	private WebElement uploadButton;

	@FindBy(id = "uploaded-files")
	private WebElement uploadedFileName;

	@FindBy(id = "drag-drop-upload")
	private WebElement dropZone;

	@FindBy(css = "#drag-drop-upload .dz-filename span")
	private WebElement dragDropUploadedFileName;

	public FileUploadPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void uploadFile(String filePath) {
		LOGGER.info("Starting file upload via input element...");

		File file = new File(filePath);
		if (!file.exists()) {
			LOGGER.error("File not found: " + filePath);
			throw new RuntimeException("File does not exist: " + filePath);
		}

		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), chooseFileButton);
		chooseFileButton.sendKeys(filePath);
		uploadButton.click();

		LOGGER.info("File uploaded successfully using input element.");
	}

	public String getUploadedFileName() {
		LOGGER.info("Fetching uploaded file name...");
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), uploadedFileName);
		String uploadedFile = uploadedFileName.getText();
		LOGGER.info("Uploaded file name: " + uploadedFile);
		return uploadedFile;
	}

	public void uploadFileUsingActions(String filePath) {
		LOGGER.info("Starting drag-and-drop file upload...");

		File file = new File(filePath);
		if (!file.exists()) {
			LOGGER.error("File not found: " + filePath);
			throw new RuntimeException("File does not exist: " + filePath);
		}

		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), dropZone);
		LOGGER.info("Drop zone is visible.");

		try {
			// Inject file into drop zone using JavaScript
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String script = "var dropZone = arguments[0];" + "var dataTransfer = new DataTransfer();"
					+ "var file = new File([''], '" + file.getName() + "', {type: 'application/pdf'});"
					+ "dataTransfer.items.add(file);"
					+ "dropZone.dispatchEvent(new DragEvent('drop', {dataTransfer: dataTransfer}));";

			js.executeScript(script, dropZone);
			LOGGER.info("File dropped successfully via JavaScript.");
		} catch (Exception e) {
			LOGGER.error("Failed to perform drag-and-drop file upload: " + e.getMessage());
			throw new RuntimeException("Drag-and-drop upload failed!", e);
		}
	}

	public String getDragAndDropUploadedFileName() {
		LOGGER.info("Waiting for the visibility of uploaded filename after drag-and-drop...");

		try {
			WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(20), dragDropUploadedFileName);
			String uploadedFile = dragDropUploadedFileName.getText();
			LOGGER.info("Drag-and-drop uploaded file name: " + uploadedFile);
			return uploadedFile;
		} catch (TimeoutException e) {
			LOGGER.error("Uploaded filename not visible after drag-and-drop. Possible upload failure.");
			throw new RuntimeException("Drag-and-drop upload filename not found!", e);
		}
	}
}
