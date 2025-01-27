package com.qa.herokuapp.helper;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverWaitUtils {
	protected WebDriver driver;
	protected static WebDriverWait wait;
	

	public static void waitForTheVisibilityOfElement(WebDriver driver, Duration timeout, WebElement element) {
		wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitForTheInvisibilityOfElement(WebDriver driver, Duration timeout, WebElement element) {
		wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public static void waitForElementToBeClickable(WebDriver driver, Duration timeout, WebElement element) {
		wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public static void waitForTheVisibilityOfListWebElements(WebDriver driver, Duration timeout,
			List<WebElement> element) {
		wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}

	public static Alert checkIfAlertIsPresent(WebDriver driver, Duration timeout) {
		wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.alertIsPresent());
	}

}
