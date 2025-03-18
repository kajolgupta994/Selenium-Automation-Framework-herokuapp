package com.qa.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.herokuapp.base.TestBase;

public class InputPage extends TestBase {
	private WebDriver driver;

	@FindBy(xpath = "//input[@type='number']")
	private WebElement inputField;

	public InputPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void handleInputField(String str) {
		try {
			if (str.matches("\\d+")) { // Check if input is numeric
				inputField.sendKeys(str);
			} else {
				LOGGER.error("Invalid input: Only numeric values are allowed.");
			}

		} catch (Exception e) {
			LOGGER.error("Unable to enter input", e);
		}
	}

	public void handleInputFields(String str) {
		try {
			if (str.matches("[0-9]*")) { // Allow empty input and numbers
				inputField.sendKeys(str);
			} else {
				LOGGER.error("Invalid input: Only numeric values allowed.");
			}
		} catch (Exception e) {
			LOGGER.error("Unable to enter input", e);
		}

	}
}
