package com.qa.herokuapp.pages;

import java.io.File;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.helper.WebDriverWaitUtils;

public class FileDownloadPage extends TestBase {
	private WebDriver driver;
	private static final String DOWNLOAD_PATH = System.getProperty("user.dir") + "\\test-output\\file_downloads";

	@FindBy(xpath = "//div[@class='example']/a")
	private List<WebElement> listOfFiles;

	public FileDownloadPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void downloadFile() {
		WebDriverWaitUtils.waitForTheVisibilityOfListWebElements(driver, Duration.ofSeconds(10), listOfFiles);
		LOGGER.info("Total files available for download: " + listOfFiles.size());

		for (WebElement file : listOfFiles) {
			String fileName = file.getText();
			File downloadedFile = new File(Paths.get(DOWNLOAD_PATH, fileName).toString());

			if (downloadedFile.exists()) {
				LOGGER.info(fileName + " already exists. Skipping download.");
				continue;
			}

			LOGGER.info("Initiating download for file: " + fileName);
			file.click();

			if (waitForFileDownload(fileName, 30)) {
				LOGGER.info("File downloaded successfully: " + fileName);
			} else {
				LOGGER.warn("File download failed: " + fileName);
			}
		}
	}

	public boolean waitForFileDownload(String fileName, int timeoutSeconds) {
		File file = new File(Paths.get(DOWNLOAD_PATH, fileName).toString());
		int counter = 0;

		LOGGER.info("Waiting for file download to complete: " + fileName);

		while (counter < timeoutSeconds) {
			if (file.exists()) {
				LOGGER.info("File found: " + fileName + " after " + counter + " seconds.");
				return true;
			}
			try {
				Thread.sleep(1000); // Wait 1 second before checking again
			} catch (InterruptedException e) {
				LOGGER.error("Interrupted while waiting for file download: " + e.getMessage());
			}
			counter++;
		}

		LOGGER.warn("File not downloaded within timeout: " + fileName);
		return false;
	}

}
