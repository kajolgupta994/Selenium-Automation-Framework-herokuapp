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
import org.testng.annotations.Listeners;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.*;
import java.time.Duration;

@Listeners(com.qa.herokuapp.helper.ITestListenerUtils.class)
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
		if (properties == null) {
			loadConfig(); // Fallback in case @BeforeSuite did not execute
		}
		String browser = properties.getProperty("browser");
		if (browser == null) {
			throw new IllegalStateException("Browser property is not set in config.properties");
		}
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();

			// ChromeOptions - Adding download directory configuration
			String downloadPath = System.getProperty("user.dir") + "\\test-output\\file_downloads";
			ChromeOptions options = new ChromeOptions();
			
			// Set preferences for file download
			HashMap<String, Object> chromePrefs = new HashMap<>();
			chromePrefs.put("download.default_directory", downloadPath);
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.prompt_for_download", false);
			chromePrefs.put("download.directory_upgrade", true);
			chromePrefs.put("plugins.always_open_pdf_externally", true); // Open PDFs externally instead of in-browser
			options.setExperimentalOption("prefs", chromePrefs);

			// Required options for running in Jenkins (headless mode)
			if (System.getProperty("headless", "false").equalsIgnoreCase("true")) {
				options.addArguments("--headless=new"); // New headless mode
				options.addArguments("--disable-gpu");
				options.addArguments("--window-size=1920,1080"); // Viewport size
				options.addArguments("--remote-allow-origins=*");
				options.addArguments("--disable-dev-shm-usage"); // Prevent memory issues in Jenkins
				options.addArguments("--no-sandbox"); // Needed for CI/CD environments
				options.addArguments("--disable-popup-blocking"); // Ensure popups don’t interfere
			}

			driver = new ChromeDriver(options);

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
