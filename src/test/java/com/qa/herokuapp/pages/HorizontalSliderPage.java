package com.qa.herokuapp.pages;

import java.time.Duration;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.helper.ActionUtils;
import com.qa.herokuapp.helper.WebDriverWaitUtils;

public class HorizontalSliderPage extends TestBase {

	protected WebDriver driver;

	@FindBy(xpath = "//input[@type='range']")
	private WebElement slider;
	@FindBy(xpath = "//span[@id='range']")
	private WebElement sliderRange;

	public HorizontalSliderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void setSliderValue(double targetValue) {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), slider);
		double currentValue = Double.parseDouble(sliderRange.getText());
		double stepSize = 0.5;
		double moveBy = (targetValue - currentValue) / stepSize;

		LOGGER.info("Current slider value: " + currentValue);

		for (int i = 0; i < Math.abs(moveBy); i++) {
			if (moveBy > 0) {
				ActionUtils.moveToElements(driver, slider, Keys.ARROW_RIGHT);
			} else {
				ActionUtils.moveToElements(driver, slider, Keys.ARROW_LEFT);

			}

			// **Wait for the slider value to update after each move**
			try {
				Thread.sleep(200); // Small delay to let UI update
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// **Update the currentValue after each move**
			currentValue = Double.parseDouble(sliderRange.getText());
			LOGGER.info("Updated slider value: " + currentValue);

			// **Break loop early if target is reached**
			if (currentValue == targetValue) {
				break;
			}
		}
		LOGGER.info("Slider range is set to: " + sliderRange.getText());
	}

}
