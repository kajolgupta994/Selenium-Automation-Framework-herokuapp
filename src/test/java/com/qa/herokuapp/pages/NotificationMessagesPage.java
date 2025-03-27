package com.qa.herokuapp.pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.helper.WebDriverWaitUtils;

public class NotificationMessagesPage extends TestBase {

	private WebDriver driver;

	@FindBy(xpath = "//a[text()='Click here']")
	private WebElement clickHere;

	@FindBy(xpath = "//div[@id='flash']")
	private WebElement getNotificationText;

	public NotificationMessagesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Click the "Click Here" button to generate a notification
	public void clickHere() {
		try {
			WebDriverWaitUtils.waitForElementToBeClickable(driver, Duration.ofSeconds(10), clickHere);
			clickHere.click();
			LOGGER.info("Clicked on 'Click Here' link.");
		} catch (Exception e) {
			LOGGER.error("Unable to click on 'Click Here': " + e.getMessage());
		}
	}

	// Retrieve the notification message
	public String getNotificationText() {
		try {
			WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), getNotificationText);
			String text = getNotificationText.getText();
			return text;
		} catch (Exception e) {
			LOGGER.error("Unable to retrieve text from notification: " + e.getMessage());
			return "";
		}
	}

	// Click until a specific notification is received
	public boolean clickUntilSuccess(String expectedText, int maxRetries) {
		for (int i = 0; i < maxRetries; i++) {
			clickHere();
			String actualText = getNotificationText();
			if (actualText.contains(expectedText)) {
				LOGGER.info("Expected notification found: " + actualText);
				return true;
			} else {
				LOGGER.warn("Unexpected notification: " + actualText + " | Retrying...");

			}
		}
		LOGGER.error("Failed to get expected notification after " + maxRetries + " attempts.");
		return false;

	}

}
