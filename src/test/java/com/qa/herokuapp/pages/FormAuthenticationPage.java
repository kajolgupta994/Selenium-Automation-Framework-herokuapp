package com.qa.herokuapp.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.helper.WebDriverWaitUtils;

public class FormAuthenticationPage extends TestBase {
	private WebDriver driver;
	@FindBy(id = "username")
	private WebElement username;
	@FindBy(id = "password")
	private WebElement password;
	@FindBy(xpath = "//button[@class='radius']")
	private WebElement submitBtn;
	@FindBy(xpath = "//div[contains(text(),'Your username is invalid!')]")
	private WebElement usernameErrorMsg;
	@FindBy(xpath = "//div[contains(text(),'Your password is invalid!')]")
	private WebElement passwordErrorMsg;
	@FindBy(xpath = "//h4[text()='Welcome to the Secure Area. When you are done click logout below.']")
	private WebElement successMsg;
	@FindBy(xpath = "//i[text()=' Logout']")
	private WebElement logoutBtn;
	@FindBy(xpath = "//div[contains(text(),'You logged out of the secure area!')]")
	private WebElement logoutSuccessMsg;

	public FormAuthenticationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void sendUsername(String usr) {
		try {
			WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), username);
			username.sendKeys(usr);
		} catch (Exception e) {
			LOGGER.error("Username field is not available!", e);
		}
	}

	public void sendPassword(String pwd) {
		try {
			WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), password);
			password.sendKeys(pwd);
		} catch (Exception e) {
			LOGGER.error("Password field is not available!", e);
		}
	}

	public void submit() {

		try {
			WebDriverWaitUtils.waitForElementToBeClickable(driver, Duration.ofSeconds(10), submitBtn);
			submitBtn.click();
		} catch (Exception e) {
			LOGGER.error("Submit button is not clickable!", e);
		}
	}

	public void logout() {

		try {
			WebDriverWaitUtils.waitForElementToBeClickable(driver, Duration.ofSeconds(10), logoutBtn);
			logoutBtn.click();
		} catch (Exception e) {
			LOGGER.error("Logout button is not clickable!", e);
		}
	}

	public String getSuccessMessage() {

		try {
			WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), successMsg);
			return successMsg.getText().trim();
		} catch (Exception e) {
			LOGGER.error("Success message not found!", e);
			return "";
		}
	}

	public String getUsernameErrorMessage() {
		try {
			WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), usernameErrorMsg);
			return usernameErrorMsg.getText().trim();
		} catch (Exception e) {
			LOGGER.error("Username error message not found!", e);
			return "";
		}
	}

	public String getPasswordErrorMessage() {
		try {
			WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), passwordErrorMsg);
			return passwordErrorMsg.getText().trim();
		} catch (Exception e) {
			LOGGER.error("Password error message not found!", e);
			return "";
		}
	}

	public String getLogoutSuccessMessage() {
		try {
			WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), logoutSuccessMsg);
			return logoutSuccessMsg.getText().trim();
		} catch (Exception e) {
			LOGGER.error("Logout success message not found!", e);
			return "";
		}
	}

}
