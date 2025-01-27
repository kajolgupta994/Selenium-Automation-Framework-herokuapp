package com.qa.herokuapp.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.herokuapp.helper.ActionUtils;
import com.qa.herokuapp.helper.AlertUtils;
import com.qa.herokuapp.helper.WebDriverWaitUtils;

public class DynamicContentPage {
	private WebDriver driver;

	@FindBy(xpath = "//div[@id='content']/div[@class='row']")
	private List<WebElement> rows;

	public DynamicContentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateToEachRow() {

		WebDriverWaitUtils.waitForTheVisibilityOfListWebElements(driver, Duration.ofSeconds(10), rows);
		for (WebElement row : rows) {
			System.out.println(row.getText());
		}

	}
}
