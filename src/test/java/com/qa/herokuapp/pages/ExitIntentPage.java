package com.qa.herokuapp.pages;

import java.time.Duration;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.Dimension;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.helper.WebDriverWaitUtils;

public class ExitIntentPage extends TestBase {
	private WebDriver driver;

	@FindBy(className = "modal")
	private WebElement modal;

	@FindBy(xpath = "//p[text()='Close']")
	private WebElement closeButton;

	public ExitIntentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void triggerExitIntent() {
		try {
			Robot robot = new Robot(); // Step 1: Create Robot instance
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // Step 2: Get screen size

			// Step 3: Move mouse inside viewport first
			robot.mouseMove(screenSize.width / 2, screenSize.height / 2);
			Thread.sleep(500); // Small delay to ensure movement is registered

			// Step 4: Move mouse outside viewport (top-left corner)
			robot.mouseMove(0, 0);
			LOGGER.info("Mouse moved outside viewport to trigger Exit Intent.");

			// Step 5: Small delay to allow modal to appear
			Thread.sleep(3000);
			LOGGER.info("Exit Intent triggered, waiting for modal to appear.");
		} catch (AWTException | InterruptedException e) {
			LOGGER.error("Error while triggering Exit Intent: " + e.getMessage());
		}
	}

	// Close the Exit Intent modal
	public void closeModal() {
		LOGGER.info("Waiting for the modal to appear...");
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(20), modal);

		if (modal.isDisplayed()) {
			LOGGER.info("Modal is visible. Clicking Close button...");
			closeButton.click();
			LOGGER.info("Modal closed successfully.");
		} else {
			LOGGER.warn("Modal not visible, cannot close.");
		}
	}
}
