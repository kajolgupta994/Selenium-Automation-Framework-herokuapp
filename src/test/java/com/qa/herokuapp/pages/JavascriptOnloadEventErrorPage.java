package com.qa.herokuapp.pages;

import java.util.List;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.PageFactory;

import com.qa.herokuapp.base.TestBase;

public class JavascriptOnloadEventErrorPage extends TestBase {

	private WebDriver driver;

	public JavascriptOnloadEventErrorPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Handle javascript onload error
	public void captureJSErrors() {
		try {

			LogEntries logs = driver.manage().logs().get(LogType.BROWSER);
			List<LogEntry> logList = logs.getAll();
			for (LogEntry logEntry : logList) {
				LOGGER.info("Console Log: " + logEntry.getMessage());
				if (logEntry.getMessage().contains("Cannot read properties of undefined")) {
					LOGGER.info("JavaScript error found!");
				}
			}

		} catch (TimeoutException | NoSuchElementException | UnhandledAlertException e) {
			LOGGER.error("Failed to handle JavaScript onload error", e);

		}
	}

}
