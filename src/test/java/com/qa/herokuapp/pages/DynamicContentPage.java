package com.qa.herokuapp.pages;

import java.time.Duration;
import java.util.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.herokuapp.helper.WebDriverWaitUtils;

public class DynamicContentPage {
	private WebDriver driver;

	@FindBy(xpath = "//div[@id='content']/div[@class='row']")
	private List<WebElement> rows;

	public DynamicContentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateAndValidateDynamicContent() {

		WebDriverWaitUtils.waitForTheVisibilityOfListWebElements(driver, Duration.ofSeconds(10), rows);
		List<String> initialContent = new ArrayList<>();
		for (WebElement row : rows) {
			initialContent.add(row.getText().trim());
		}
		driver.navigate().refresh();
		WebDriverWaitUtils.waitForTheVisibilityOfListWebElements(driver, Duration.ofSeconds(10), rows);

		List<String> newContent = new ArrayList<>();
		for (WebElement row : rows) {
			newContent.add(row.getText().trim());
		}

		// Logging the content before and after refresh
		System.out.println("Before Refresh: " + initialContent);
		System.out.println("After Refresh: " + newContent);
		Assert.assertNotEquals(initialContent, newContent, "Dynamic content did not change after refresh!");
	}
}
