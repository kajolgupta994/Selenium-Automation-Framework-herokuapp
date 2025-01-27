package com.qa.herokuapp.tests;

import static org.testng.Assert.*;

import java.time.Duration;

import org.testng.annotations.Test;

import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.helper.ImplicitWaitUtils;
import com.qa.herokuapp.pages.HomePage;
import com.qa.herokuapp.pages.LoginPage;

public class LoginTest extends TestBase {

	private LoginPage loginPage;

	@Test
	public void validLogin() {

		// Call LoginPage driver;
		loginPage = new LoginPage(driver);

		// Step 2: Basic Authentication
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		String authUrl = "@the-internet.herokuapp.com/basic_auth";
		driver.get("https://" + username + ":" + password + authUrl);

		// Verify the successful login message
		String successMessage = LoginPage.getSuccessMsg();
		assertTrue(successMessage.contains("Congratulations! You must have the proper credentials."),
				"Login was not successful!");

	}

	@Test
	public void invalidLogin() {

		// Call LoginPage driver;
		loginPage = new LoginPage(driver);

		// Step 2: Basic Authentication
		String username = properties.getProperty("invalidUsername");
		String password = properties.getProperty("invalidPassword");
		String authUrl = "https://" + username + ":" + password + "@the-internet.herokuapp.com/basic_auth";
		driver.get(authUrl);

		String expectedUrl = "https://the-internet.herokuapp.com/basic_auth";
		String currentUrl = LoginPage.getCurrentUrl();
		assertNotEquals(currentUrl, expectedUrl, "Invalid login should not load the correct page!");

	}

}
