package com.qa.herokuapp.pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.helper.WebDriverWaitUtils;

public class DigestAuthenticationPage extends TestBase {
	protected WebDriver driver;

	@FindBy(xpath = "//p[contains(text(), 'Congratulations! You must have the proper credentials.')]")
	private WebElement getSuccessMessage;

	public DigestAuthenticationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void sendLoginDataUsingAutoItScript() {
		try {
			LOGGER.info("Executing AutoIT script for Digest Authentication...");
			Runtime.getRuntime().exec(System.getProperty("user.dir")
					+ "\\src\\main\\java\\resources\\AutoIT\\HandleDigestAuthentication.exe");
			LOGGER.info("AutoIT script executed successfully.");
			Thread.sleep(5000);
		} catch (IOException | InterruptedException e) {
			LOGGER.error("No such file found: " + e.getMessage());

		}

	}

	public String getSuccessMessage() {
		LOGGER.info("Waiting for success message to appear...");
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(15), getSuccessMessage);

		WebElement getSuccessMsg = getSuccessMessage;
		if (getSuccessMsg == null) {
			LOGGER.error("Success message not found!");
			return "No success message found";
		}
		String message = getSuccessMsg.getText();
		LOGGER.info("Success message retrieved: " + message);
		return message;
	}
}
