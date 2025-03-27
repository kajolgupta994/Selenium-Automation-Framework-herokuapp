package com.qa.herokuapp.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.helper.WebDriverWaitUtils;

public class RedirectLinkPage extends TestBase {

	private WebDriver driver;

	@FindBy(xpath = "//a[text()='here']")
	private WebElement clickHere;

	@FindBy(xpath = "//ul/li/a") // Fix: Targeting anchor tags inside <li>
	private List<WebElement> statusCodeList;

	@FindBy(xpath = "//div[@class='example']/p")
	private WebElement successMessage;

	@FindBy(xpath = "//p/a[text()='here']")
	private WebElement statusCodesPage;

	public RedirectLinkPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Click the "Click Here" button to get to the status codes page
	public void clickHere() {
		try {
			WebDriverWaitUtils.waitForElementToBeClickable(driver, Duration.ofSeconds(10), clickHere);
			clickHere.click();
			LOGGER.info("Clicked on 'Click Here' link.");

			// Wait for the status codes page to load
			WebDriverWaitUtils.waitForTheVisibilityOfListWebElements(driver, Duration.ofSeconds(10), statusCodeList);
			LOGGER.info("Navigated to the Status Codes page.");
		} catch (Exception e) {
			LOGGER.error("Unable to click on 'Click Here': " + e.getMessage());
		}
	}

	// Click each status code and verify the success message
	public void clickOnStatuses() {
		try {
			WebDriverWaitUtils.waitForTheVisibilityOfListWebElements(driver, Duration.ofSeconds(10), statusCodeList);

			for (WebElement status : statusCodeList) {
				String statusText = status.getText();
				LOGGER.info("Clicking on status: " + statusText);

				status.click(); // Click on the status link

				// Wait for the success message to appear
				WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), successMessage);
				String result = getStatusCodeSuccessMessage();

				LOGGER.info("Success message received: " + result);

				// Navigate back to the status codes page
				LOGGER.info("Navigating back to the Status Codes page...");
				driver.navigate().back();

				// Re-wait for the list of status codes before continuing
				WebDriverWaitUtils.waitForTheVisibilityOfListWebElements(driver, Duration.ofSeconds(10),
						statusCodeList);
			}
		} catch (Exception e) {
			LOGGER.error("Error while handling status codes: " + e.getMessage());
		}
	}

	// Get the message displayed after clicking a status code
	public String getStatusCodeSuccessMessage() {
		try {
			String result = successMessage.getText().trim();
			LOGGER.info("Received message: " + result);
			return result;
		} catch (Exception e) {
			LOGGER.error("Unable to retrieve success message: " + e.getMessage());
			return "";
		}
	}
}
