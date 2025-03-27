package com.qa.herokuapp.pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.helper.WebDriverWaitUtils;

public class MultipleWindowsPage extends TestBase {

	private WebDriver driver;

	@FindBy(xpath = "//a[text()='Click Here']")
	private WebElement clickHere;

	@FindBy(xpath = "//div[@class='example']/h3")
	private WebElement result;

	public MultipleWindowsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Click on the "Click Here" link to open a new window
	public void clickHere() {

		try {

			WebDriverWaitUtils.waitForElementToBeClickable(driver, Duration.ofSeconds(10), clickHere);
			clickHere.click();
			LOGGER.info("Clicked on 'Click Here' link.");
		} catch (Exception e) {
			LOGGER.error("Unable to click on 'Click Here': " + e.getMessage());
		}
	}

	// Switch to the new window and get the text
	public String getTextFromNewWindow() {

		String mainWindow = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();

		for (String handle : windowHandles) {
			if (!handle.equals(mainWindow)) {
				driver.switchTo().window(handle);
				LOGGER.info("Switched to the new window");
				break;
			}
		}
		try {
			WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), result);
			String text = result.getText();
			LOGGER.info("Text from new window: " + text);
			driver.close();
			driver.switchTo().window(mainWindow);
			LOGGER.info("Switched back to the main window.");
			return text;
		} catch (Exception e) {
			LOGGER.error("Unable to retrieve text from new window: " + e.getMessage());
			return "";
		}
	}

}
