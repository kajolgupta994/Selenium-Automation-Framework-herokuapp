package com.qa.herokuapp.pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.helper.WebDriverWaitUtils;

public class DynamicLoadingPage extends TestBase {
	private WebDriver driver;

	@FindBy(xpath = "//button[text()='Start']")
	private WebElement startButton;

	@FindBy(id = "finish")
	private WebElement getFinishMsg;

	@FindBy(xpath = "//a[contains(text(), 'Example 1')]")
	private WebElement exampleOneText;

	@FindBy(xpath = "//a[contains(text(), 'Example 2')]")
	private WebElement exampleTwoText;

	public DynamicLoadingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// **Click on the Example 1 text**
	public void exampleOneTest() {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), exampleOneText);

		exampleOneText.click();
		LOGGER.info("Example 1 text is clicked.");

		// Wait for the start button to become visible
		WebDriverWaitUtils.waitForElementToBeClickable(driver, Duration.ofSeconds(10), startButton);
		startButton.click();
		LOGGER.info("Example 1: Start button is clicked.");

		// Wait for success message
		WebDriverWaitUtils.waitForTextToBePresent(driver, Duration.ofSeconds(10), "Hello World!", getFinishMsg);

	}

	// **Click on the Example 2 text**
	public void exampleTwoTest() {

		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), exampleTwoText);
		exampleTwoText.click();
		LOGGER.info("Example 2 text is clicked.");

		// Wait for the start button to become visible
		WebDriverWaitUtils.waitForElementToBeClickable(driver, Duration.ofSeconds(10), startButton);
		startButton.click();
		LOGGER.info("Example 2: Start button is clicked.");

		// Wait for success message
		WebDriverWaitUtils.waitForTextToBePresent(driver, Duration.ofSeconds(10), "Hello World!", getFinishMsg);

	}

	// ** Retrieve Message After an Action**
	public String getFinishText() {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), getFinishMsg);
		return getFinishMsg.getText();
	}

}
