package com.qa.herokuapp.pages;

import java.time.Duration;
import java.util.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.herokuapp.helper.WebDriverWaitUtils;

public class CheckboxesPage {
	private WebDriver driver;

	@FindBy(xpath = "//form[@id='checkboxes']/input")
	private List<WebElement> getCheckboxes;

	public CheckboxesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void selectAndDeselectCheckboxes() {
		WebDriverWaitUtils.waitForTheVisibilityOfListWebElements(driver, Duration.ofSeconds(10), getCheckboxes);
		for (int i = 0; i < getCheckboxes.size(); i++) {
			WebElement checkbox = getCheckboxes.get(i);
			if (!checkbox.isSelected()) {
				checkbox.click();
				System.out.println("checkbox " + (i + 1) + " is selected.");
			} else {
				checkbox.click();
				System.out.println("checkbox " + (i + 1) + " is de-selected.");
			}
		}
	}

}
