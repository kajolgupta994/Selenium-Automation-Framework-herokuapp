package com.qa.herokuapp.tests;

import static org.testng.Assert.*;

import java.time.Duration;

import org.testng.annotations.Test;

import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.helper.ImplicitWaitUtils;
import com.qa.herokuapp.pages.HomePage;
import com.qa.herokuapp.pages.BasicAuthLoginPage;

public class BasicAuthLoginTest extends TestBase {

	private BasicAuthLoginPage basicAuthLoginPage;

	@Test
	public void validLogin() {

		// Call LoginPage driver;
		basicAuthLoginPage = new BasicAuthLoginPage(driver);

		// Step 2: Basic Authentication
		LOGGER.info("Trying to get the valid username from the config.properties file...");
		String username = properties.getProperty("username");
		LOGGER.info("Username is retrieved.");
		
		LOGGER.info("Trying to get the valid password from the config.properties file...");
		String password = properties.getProperty("password");
		LOGGER.info("Password is retrieved.");
		

		LOGGER.info("Set the basic-auth base url");
		String authUrl = "@the-internet.herokuapp.com/basic_auth";
		LOGGER.info("Trying to navigate to Basic Auth page and fill the credentials...");
		driver.get("https://" + username + ":" + password + authUrl);
		
		
		// Verify the successful login message
		String successMessage = BasicAuthLoginPage.getSuccessMsg();
		assertTrue(successMessage.contains("Congratulations! You must have the proper credentials."),
				"Login was not successful!");

	}

	@Test
	public void invalidLogin() {

		// Call LoginPage driver;
		basicAuthLoginPage = new BasicAuthLoginPage(getDriver());

		// Step 2: Basic Authentication
		LOGGER.info("Trying to get the invalid username from the config.properties file...");
		String username = properties.getProperty("invalidUsername");
		LOGGER.info("Username is retrieved.");

		LOGGER.info("Trying to get the invalid password from the config.properties file...");
		String password = properties.getProperty("invalidPassword");
		LOGGER.info("Password is retrieved.");

		LOGGER.info("Setting the basic-auth base url");
		String authUrl = "https://" + username + ":" + password + "@the-internet.herokuapp.com/basic_auth";
		
		LOGGER.info("Trying to navigate to Basic Auth page and fill the credentials...");
		driver.get(authUrl);
		
		LOGGER.info("Storing the expected url...");
		String expectedUrl = "https://the-internet.herokuapp.com/basic_auth";
		LOGGER.info("Stored the expected url.");
		
		LOGGER.info("Trying to get the page current url...");
		String currentUrl = BasicAuthLoginPage.getCurrentUrl();
		LOGGER.info("The current url is received.");

		assertNotEquals(currentUrl, expectedUrl, "Invalid login should not load the correct page!");

	}

}
