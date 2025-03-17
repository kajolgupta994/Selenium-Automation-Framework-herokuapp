package com.qa.herokuapp.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.helper.WebDriverWaitUtils;

public class GeolocationPage extends TestBase {
	private WebDriver driver;

	@FindBy(xpath = "//button[text()='Where am I?']")
	private WebElement getLocationBtn;

	@FindBy(id = "lat-value")
	private WebElement getLatValue;

	@FindBy(id = "long-value")
	private WebElement getLongValue;

	@FindBy(xpath = "//a[text()='See it on Google']")
	private WebElement seeOnGoogle;

	public GeolocationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnWhereAmIButton() {
		try {
			WebDriverWaitUtils.waitForElementToBeClickable(driver, Duration.ofSeconds(10), getLocationBtn);
			LOGGER.info("Clicking on 'Where am I?' button...");
			getLocationBtn.click();
			// Wait until latitude and longitude are visible and log the values
			if (getLatValue.isDisplayed() && getLongValue.isDisplayed()) {
				LOGGER.info("Latitude value is: " + getLatValue.getText());
				LOGGER.info("Longitude value is: " + getLongValue.getText());
			}

			// Click on 'See it on Google' link
			if (seeOnGoogle.isDisplayed()) {
				seeOnGoogle.click();
				LOGGER.info("Clicked on 'See it on Google' link.");
			}

		} catch (Exception e) {
			LOGGER.info("Unable to click the button: " + e.getMessage());
		}
	}

}
