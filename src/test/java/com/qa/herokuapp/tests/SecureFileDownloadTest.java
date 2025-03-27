package com.qa.herokuapp.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.pages.HomePage;
import com.qa.herokuapp.pages.SecureFileDownloadPage;

public class SecureFileDownloadTest extends TestBase {
	private HomePage homePage;
	private SecureFileDownloadPage secureFileDownloadPage;

	@Test
	public void validateSecureDownloadWithValidCredentials() {

		homePage = new HomePage(getDriver());
		secureFileDownloadPage = new SecureFileDownloadPage(getDriver());

		LOGGER.info("Navigating to the secure download page...");
		homePage.clickOnSecureFileDownloadLinkText();

		// Basic Authentication
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");

		LOGGER.info("Navigating to secure file download page using basic auth...");
		String authUrl = "https://" + username + ":" + password + "@the-internet.herokuapp.com/download_secure";
		driver.get(authUrl);

		// Verify successful login
	    String successMessage = secureFileDownloadPage.getSuccessMsg();
	    assertTrue(successMessage.contains("Secure File Downloader"), "Login was not successful!");

	    // Download all files
	    secureFileDownloadPage.downloadAllFiles();
	}
	

}
