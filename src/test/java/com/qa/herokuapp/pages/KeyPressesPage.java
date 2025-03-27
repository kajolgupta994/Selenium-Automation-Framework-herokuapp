package com.qa.herokuapp.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.herokuapp.base.TestBase;

public class KeyPressesPage extends TestBase {

	private WebDriver driver;

	@FindBy(id = "target")
	private WebElement inputField;

	@FindBy(id = "result")
	private WebElement result;

	public KeyPressesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Handle the input field for entering any keys from the keyboard
	public void handleKeyPressedField(String input) {

		try {
			
			for(char ch : input.toCharArray()) {
				String keysToSend = String.valueOf(ch);
				inputField.sendKeys(keysToSend);
				
				 // Capture and print the result dynamically
	            String resultText = result.getText();
	            LOGGER.info("Typed: " + keysToSend + " | Displayed Result: " + resultText);
			}
			
			/* or
			 * inputField.sendKeys(input); LOGGER.info("Entered text: " + input);
			 * 
			 * // Handle special keys (e.g., Enter, Tab, Shift)
			 * inputField.sendKeys(Keys.ENTER); LOGGER.info("Pressed ENTER key");
			 * 
			 * // Validate the result String resultText = result.getText();
			 * LOGGER.info("Displayed result: " + resultText);
			 */

		} catch (Exception e) {
			 LOGGER.error("Error while handling key presses: " + e.getMessage());

		}
	}

}
