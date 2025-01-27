package com.qa.herokuapp.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.pages.DigestAuthenticationPage;
import com.qa.herokuapp.pages.HomePage;

public class DigestAuthenticationTest extends TestBase {

	private HomePage homepage;
	private DigestAuthenticationPage handleDigestAuthenticationPage;
	
	@Test
	public void validDigestAuthLogin() {
		homepage = new HomePage(driver);
		
		LOGGER.info("Trying to click on Digest Authentication link text...");
		homepage.clickOnDigestAuthenticationLinkText();
		
		handleDigestAuthenticationPage = new DigestAuthenticationPage(driver);
		
		LOGGER.info("Trying to login using AutoIT script...");
		handleDigestAuthenticationPage.sendLoginDataUsingAutoItScript();
		String getText = handleDigestAuthenticationPage.getSuccessMessage();
		Assert.assertEquals(getText, "Congratulations! You must have the proper credentials.", "Login failed.");

	}

}
