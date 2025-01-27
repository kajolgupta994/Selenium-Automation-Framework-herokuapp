package com.qa.herokuapp.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import com.qa.herokuapp.helper.WebDriverWaitUtils;

public class DropdownPage {
	protected WebDriver driver;
	@FindBy(id = "dropdown")
	private WebElement dropdown;

	public DropdownPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void selectDropdownOptions() {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(5), dropdown);
		Select select = new Select(dropdown);
		List<WebElement> options = select.getOptions();
		if (options.isEmpty()) {
			System.out.println("No options available in the dropdown.");
			return;
		}
		for (int i = 1; i < options.size(); i++) {
			WebElement option = options.get(i);
			System.out.println("Attempting to select option: " + option.getText());
			try {
				if (option.isDisplayed() && option.isEnabled()) {
					WebDriverWaitUtils.waitForElementToBeClickable(driver, Duration.ofSeconds(5), option);
					select.selectByIndex(i);
					WebElement selectedOption = select.getFirstSelectedOption();
					System.out.println("Successfully selected: " + selectedOption.getText());
				} else {
					System.out.println("Skipping non-visible or disabled option: " + option.getText());
				}
			} catch (Exception e) {
				System.out.println("Error selecting the option: " + option.getText() + ":" + e.getMessage());

			}
		}
	}

}
