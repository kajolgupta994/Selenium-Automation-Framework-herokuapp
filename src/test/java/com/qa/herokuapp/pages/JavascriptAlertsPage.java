package com.qa.herokuapp.pages;

import java.time.Duration;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.helper.AlertUtils;
import com.qa.herokuapp.helper.WebDriverWaitUtils;

public class JavascriptAlertsPage extends TestBase {

	private WebDriver driver;

	@FindBy(xpath = "//ul/li/button[text()='Click for JS Alert']")
	private WebElement jsAlert;

	@FindBy(id = "result")
	private WebElement result;

	@FindBy(xpath = "//ul/li/button[text()='Click for JS Confirm']")
	private WebElement jsConfirm;

	@FindBy(xpath = "//ul/li/button[text()='Click for JS Prompt']")
	private WebElement jsPrompt;

	public JavascriptAlertsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Handle the first alert
	public boolean handleJavascriptAlert() {
		try {
			WebDriverWaitUtils.waitForElementToBeClickable(driver, Duration.ofSeconds(10), jsAlert);
			jsAlert.click();
			AlertUtils.alertAccept(driver);

			String resultText = result.getText().trim();
			LOGGER.info("Alert result message: " + resultText);

			return true;
		} catch (TimeoutException | NoSuchElementException | UnhandledAlertException e) {
			LOGGER.error("Failed to handle JavaScript alert", e);
			return false;
		}
	}

	// Handle the JavaScript confirm
	public boolean handlejavascriptConfirm(boolean accept) {
		try {
			WebDriverWaitUtils.waitForElementToBeClickable(driver, Duration.ofSeconds(10), jsConfirm);
			jsConfirm.click();

			if (accept) {
				AlertUtils.alertAccept(driver);
			} else {
				AlertUtils.alertDismiss(driver);
			}

			String resultText = result.getText().trim();
			LOGGER.info("Confirm alert result message: " + resultText);

			return true;
		} catch (TimeoutException | NoSuchElementException | UnhandledAlertException e) {
			LOGGER.error("Failed to handle JavaScript confirm alert", e);
			return false;
		}
	}

	// Handle the JavaScript prompt
	public boolean handleJavascriptPrompt(String str, boolean accept) {
		try {
			WebDriverWaitUtils.waitForElementToBeClickable(driver, Duration.ofSeconds(10), jsPrompt);
			jsPrompt.click();

			if (accept) {
				AlertUtils.alertSendkeys(driver, str);
				AlertUtils.alertAccept(driver);
			} else {
				AlertUtils.alertDismiss(driver);
			}

			String resultText = result.getText().trim();
			LOGGER.info("Prompt alert result message: " + resultText);

			return true;
		} catch (TimeoutException | NoSuchElementException | UnhandledAlertException e) {
			LOGGER.error("Failed to handle JavaScript prompt alert", e);
			return false;
		}
	}
}
