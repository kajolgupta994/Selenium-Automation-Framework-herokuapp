package com.qa.herokuapp.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.pages.DigestAuthenticationPage;
import com.qa.herokuapp.pages.HomePage;

public class DigestAuthenticationTest extends TestBase {

	private HomePage homePage;
	private DigestAuthenticationPage handleDigestAuthenticationPage;
	
	@Test
	public void validDigestAuthLogin() {
		homePage = new HomePage(getDriver());
		handleDigestAuthenticationPage = new DigestAuthenticationPage(getDriver());
		
		LOGGER.info("Navigating to the Digest Authentication Page...");
		homePage.clickOnDigestAuthenticationLinkText();
		LOGGER.info("Navigated to the Digest Authentication Page.");		
				
		LOGGER.info("Trying to login using AutoIT script...");
		handleDigestAuthenticationPage.sendLoginDataUsingAutoItScript();
		
		LOGGER.info("Trying to get the successful login message...");
		String getText = handleDigestAuthenticationPage.getSuccessMessage();
		LOGGER.info("Successful login message is received.");
		Assert.assertEquals(getText, "Congratulations! You must have the proper credentials.", "Login failed.");

	}

}
