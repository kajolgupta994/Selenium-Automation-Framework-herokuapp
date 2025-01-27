package com.qa.herokuapp.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.herokuapp.helper.WebDriverWaitUtils;

public class AddRemoveElementsPage {
	private WebDriver driver;

	@FindBy(xpath = "//*[text()='Add Element']")
	private WebElement addElementButton;
	@FindBy(xpath = "//*[@class='added-manually']")
	private WebElement deleteElementButton;
	

	public AddRemoveElementsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickAddElementButton() {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), addElementButton);
		addElementButton.click();
	}

	public boolean isDeleteButtonDisplayed() {
		try {
			WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), deleteElementButton);
			return deleteElementButton.isDisplayed();
		} catch (Exception e) {
			return false;
		}

	}

	public boolean isDeleteButtonNotDisplayed() {
		try {
			WebDriverWaitUtils.waitForTheInvisibilityOfElement(driver, Duration.ofSeconds(10), deleteElementButton);
			return deleteElementButton.isDisplayed();
		} catch (Exception e) {
			return false;
		}

	}

	public void clickDeleteButton() {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), deleteElementButton);
		deleteElementButton.click();
	}

}
