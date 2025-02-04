package com.qa.herokuapp.pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.helper.WebDriverWaitUtils;

public class DynamicControlsPage extends TestBase {
	private WebDriver driver;

	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement checkbox;

	@FindBy(xpath = "//button[text()='Remove']")
	private WebElement removeButton;

	@FindBy(xpath = "//button[text()='Add']")
	private WebElement addButton;

	@FindBy(xpath = "//button[text()='Enable']")
	private WebElement enableButton;

	@FindBy(xpath = "//input[@type='text']")
	private WebElement inputBox;

	@FindBy(xpath = "//button[text()='Disable']")
	private WebElement disableButton;

	@FindBy(id = "message")
	private WebElement message; // Message element (It's enabled! or It's disabled!)

	@FindBy(xpath = "//button[contains(text(), 'Disable') or contains(text(), 'Enable')]")
	private WebElement enableDisableButton;

	public DynamicControlsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// **Method 1: Check and Uncheck the Checkbox**
	public void checkUncheckCheckbox() {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), checkbox);
		try {
			if (checkbox.isDisplayed() && checkbox.isSelected()) {
				checkbox.click();
				LOGGER.info("Checkbox unchecked");
			} else {
				checkbox.click();
				LOGGER.info("Checkbox checked");
			}
		} catch (ElementNotInteractableException e) {
			LOGGER.error("Checkbox is not interactable: " + e.getMessage());
		}
	}

	// Remove the checkbox
	public void removeCheckbox() {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), removeButton);

		if (isElementPresent(removeButton)) {
			removeButton.click();
			WebDriverWaitUtils.waitForTheInvisibilityOfElement(driver, Duration.ofSeconds(10), removeButton);
			LOGGER.info("Checkbox removed.");
		}
	}
	// Add back the checkbox
	public void addCheckbox() {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), addButton);
		if (isElementPresent(addButton)) {
			addButton.click();
			WebDriverWaitUtils.waitForTheInvisibilityOfElement(driver, Duration.ofSeconds(10), addButton);
			LOGGER.info("Checkbox added back.");
		}

	}
	
	// check if remove or add buttons are present or not
	public boolean isElementPresent(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	// **Method 3: Enable and Disable Input Field**
	public void enableDisableTextBox() {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), enableDisableButton);

		String buttonText = enableDisableButton.getText().trim();
		LOGGER.info("Current button text before click: " + buttonText);

		enableDisableButton.click();

		if (buttonText.equalsIgnoreCase("Enable")) {
			// Wait for the text field to become enabled
			WebDriverWaitUtils.waitForElementToBeClickable(driver, Duration.ofSeconds(10), inputBox);
			LOGGER.info("Text box is now enabled.");

			// Wait for success message
			WebDriverWaitUtils.waitForTextToBePresent(driver, Duration.ofSeconds(10), "It's enabled!", message);
		} else if (buttonText.equalsIgnoreCase("Disable")) {
			// Wait for the text field to become disabled
			WebDriverWaitUtils.waitForElementToNotBeClickable(driver, Duration.ofSeconds(10), inputBox);
			LOGGER.info("Text box is now disabled.");

			// Wait for success message
			WebDriverWaitUtils.waitForTextToBePresent(driver, Duration.ofSeconds(10), "It's disabled!", message);
		}
	}

	// **Method 4: Retrieve Message After an Action**
	public String getMessageText() {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), message);
		return message.getText();
	}

}
