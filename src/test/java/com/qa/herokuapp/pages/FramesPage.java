package com.qa.herokuapp.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.helper.WebDriverWaitUtils;

public class FramesPage extends TestBase {
	private WebDriver driver;

	@FindBy(xpath = "//a[text()='Nested Frames']")
	private WebElement nestedFrames;
	/*
	 * @FindBy(xpath="//frame[@name='frame-left']") private WebElement leftFrame;
	 * 
	 * @FindBy(xpath="//frame[@name='frame-middle']") private WebElement
	 * middleFrame;
	 * 
	 * @FindBy(xpath="//frame[@name='frame-right']") private WebElement rightFrame;
	 */

	@FindBy(xpath = "//frameset[@name='frameset-middle']/frame")
	private List<WebElement> topFrames;

	@FindBy(xpath = "//frame[@name='frame-bottom']")
	private WebElement bottomFrame;

	@FindBy(xpath = "//a[text()='iFrame']")
	private WebElement iFrame;

	public FramesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickNestedFrames() {
		try {
			WebDriverWaitUtils.waitForElementToBeClickable(driver, Duration.ofSeconds(10), nestedFrames);
			nestedFrames.click();
		} catch (Exception e) {
			LOGGER.error("Unable to click on nested frames");
		}
	}

	public void handleTopFrames() {
		try {
			// Switch to the parent frame first
			driver.switchTo().frame("frame-top");
			LOGGER.info("Switched to top frame");

			// Now handle the left, middle, and right frames
			String[] frameNames = { "frame-left", "frame-middle", "frame-right" };

			for (String frameName : frameNames) {
				driver.switchTo().frame(frameName);
				LOGGER.info("Switched to inner frame: " + frameName);

				// Perform actions inside the frame (if any)
				driver.switchTo().parentFrame(); // Go back to 'frame-top'
			}

			driver.switchTo().defaultContent(); // Switch back to the main page
		} catch (Exception e) {
			LOGGER.error("Unable to switch to top frames");
		}
	}

	public void handleBottomFrames() {
		try {
			driver.switchTo().frame("frame-bottom"); // Switch to the bottom frame
			LOGGER.info("Switched to bottom frame");

			// Perform actions inside the bottom frame (if needed)

			driver.switchTo().defaultContent(); // Switch back to main document
		} catch (Exception e) {
			LOGGER.error("Unable to switch to bottom frame");
		}
	}

	public void clickiFrame() {
		try {
			WebDriverWaitUtils.waitForElementToBeClickable(driver, Duration.ofSeconds(10), iFrame);
			iFrame.click();
		} catch (Exception e) {
			LOGGER.error("iFrame does not found");
		}
	}

}
