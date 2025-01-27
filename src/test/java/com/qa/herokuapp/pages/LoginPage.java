package com.qa.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private static WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static String getSuccessMsg() {
		return driver.getPageSource();
	}

	public static String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
}
