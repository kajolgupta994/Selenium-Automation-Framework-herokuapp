package com.qa.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasicAuthLoginPage {
	private static WebDriver driver;

	public BasicAuthLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getSuccessMsg() {
		return driver.getPageSource();
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
}
