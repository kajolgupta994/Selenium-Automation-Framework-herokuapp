package com.qa.herokuapp.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.herokuapp.base.TestBase;

public class SecureFileDownloadPage extends TestBase {

	private WebDriver driver;

	@FindBy(xpath = "//div[@class='example']/h3")
	private WebElement secureMessage;

	@FindBy(xpath = "//div[@class='example']//a") // Adjust if other file types exist
	private List<WebElement> documentList;

	public SecureFileDownloadPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Download First File
	public void downloadAllFiles() {
	    try {
	        if (documentList.size() > 0) {
	            for (WebElement file : documentList) {
	                String fileName = file.getText();
	                file.click();
	                LOGGER.info("Clicked on file: " + fileName);
	                // Optionally, add a wait to ensure file downloads before clicking the next
	                Thread.sleep(3000); // Adjust if needed
	            }
	        } else {
	            LOGGER.error("No files available for download!");
	        }
	    } catch (Exception e) {
	        LOGGER.error("Error downloading files: " + e.getMessage());
	    }
	}

	// Retrieve Success Message
	public String getSuccessMsg() {
		return secureMessage.getText();
	}
}
