package com.qa.herokuapp.base;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.*;
import java.time.Duration;

public abstract class TestBase {

	protected WebDriver driver;
	protected Properties properties;
	protected final Logger LOGGER;

	// Constructor where we initialize the logger for the current class
	public TestBase() {
		this.LOGGER = LogManager.getLogger(this.getClass());
	}

	// Method to get the logger instance for the current class
	public Logger getLogger() {
		return this.LOGGER;
	}
	public WebDriver getDriver() {
	    return driver;
	}
	@BeforeSuite
	public void loadConfig() {
		properties = new Properties();
		String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties";
		try (FileInputStream fis = new FileInputStream(filePath)) {

			properties.load(fis);

		} catch (IOException e) {
			LOGGER.info("Error loading the config.properties file: ", e);
			e.printStackTrace();
		}
	}

	@BeforeClass
	public void initializeBrowser() {
		String browser = properties.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else {
			throw new IllegalArgumentException("Unsupported browser. " + browser);
		}

		int implicitWait = Integer.parseInt(System.getProperty("implicitWait", "10"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
		driver.manage().window().maximize();
		driver.get(properties.getProperty("url"));

	}

	@AfterClass
	public void closeBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}

}
