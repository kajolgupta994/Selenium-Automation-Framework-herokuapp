package com.qa.herokuapp.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.helper.WebDriverWaitUtils;

public class DropdownPage extends TestBase {
	protected WebDriver driver;

	@FindBy(id = "dropdown")
	private WebElement dropdown;

	public DropdownPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void selectDropdownOptions() {
		LOGGER.info("Waiting for dropdown visibility.");
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(5), dropdown);
		Select select = new Select(dropdown);
		List<WebElement> options = select.getOptions();

		if (options.isEmpty()) {
			LOGGER.warn("No options available in the dropdown.");
			return;
		}

		for (int i = 1; i < options.size(); i++) {
			WebElement option = options.get(i);
			LOGGER.info("Attempting to select option: " + option.getText());

			try {
				if (option.isDisplayed() && option.isEnabled()) {
					WebDriverWaitUtils.waitForElementToBeClickable(driver, Duration.ofSeconds(5), option);
					select.selectByIndex(i);
					WebElement selectedOption = select.getFirstSelectedOption();
					LOGGER.info("Successfully selected: " + selectedOption.getText());
				} else {
					LOGGER.warn("Skipping non-visible or disabled option: " + option.getText());
				}
			} catch (Exception e) {
				LOGGER.error("Error selecting the option: " + option.getText() + " - " + e.getMessage());
			}
		}
	}
}
