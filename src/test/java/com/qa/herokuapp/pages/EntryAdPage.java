package com.qa.herokuapp.pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.helper.WebDriverWaitUtils;

public class EntryAdPage extends TestBase {
	private WebDriver driver;

	@FindBy(className = "modal")
	private WebElement modal;

	@FindBy(xpath = "//p[text()='Close']")
	private WebElement closeButton;

	@FindBy(id = "restart-ad")
	private WebElement clickHereLink;

	public EntryAdPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Close the modal**
	public void closeModal() {
		LOGGER.info("Wait for the modal to appear");
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), modal);
		LOGGER.info("Modal is appeared now.");

		try {
			if (modal.isDisplayed()) {
				LOGGER.info("Click to the Close button to close the modal...");
				closeButton.click();
				LOGGER.info("Close button is clicked.");
			}
		} catch (NoSuchElementException e) {
			LOGGER.info("Modal does not appear." + e.getMessage());
		}

	}

	// re-enable it and close it again
	public void reEnableModal() {

		LOGGER.info("Wait for the modal to disappear before re-enabling");
		WebDriverWaitUtils.waitForTheInvisibilityOfElement(driver, Duration.ofSeconds(10), modal);
		int maxRetries = 3;
		int attempt = 0;
		boolean isModalVisible = false;
		while (attempt < maxRetries) {
			try {
				LOGGER.info("Attempt " + (attempt + 1) + ": Clicking 'Click Here' to re-enable the modal.");
				clickHereLink.click();
				WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), modal);
				if (modal.isDisplayed()) {
					LOGGER.info("Modal is re-enabled now.");
					LOGGER.info("Clicking the Close button...");
					closeButton.click();
					LOGGER.info("Close button is clicked.");
					isModalVisible = true;
					break;
				}
			} catch (Exception e) {
				LOGGER.warn("Modal did not appear after click. Retrying... " + e.getMessage());
			}
			attempt++;

		}
		if (!isModalVisible) {
			LOGGER.error("Failed to re-enable modal after " + maxRetries + " attempts.");
		}
	}

}
