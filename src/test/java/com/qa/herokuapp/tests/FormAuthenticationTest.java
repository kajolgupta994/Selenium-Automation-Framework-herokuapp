package com.qa.herokuapp.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.pages.FormAuthenticationPage;
import com.qa.herokuapp.pages.HomePage;

public class FormAuthenticationTest extends TestBase {
    private FormAuthenticationPage formAuthenticationPage;
    private HomePage homePage;

    @BeforeClass
    public void setup() {
        homePage = new HomePage(getDriver());
        formAuthenticationPage = new FormAuthenticationPage(getDriver());
    }

    @Test(priority = 0)
    public void verifyLoginWithValidUsernamePassword() {
        LOGGER.info("Clicking on the Form Authentication link...");
        homePage.clickOnFormAuthenticartionLinkText();

        LOGGER.info("Entering valid username and password...");
        formAuthenticationPage.sendUsername("tomsmith");
        formAuthenticationPage.sendPassword("SuperSecretPassword!");
        formAuthenticationPage.submit();

        LOGGER.info("Validating success message...");
        String msg = formAuthenticationPage.getSuccessMessage().trim();
        Assert.assertTrue(msg.contains("Welcome to the Secure Area"), "Login failed!");

        LOGGER.info("Logging out...");
        formAuthenticationPage.logout();
        
        LOGGER.info("Validating logout message...");
        String logoutMsg = formAuthenticationPage.getLogoutSuccessMessage().trim();
        Assert.assertTrue(logoutMsg.contains("You logged out of the secure area"), "Logout failed.");
    }

    @Test(priority = 1)
    public void verifyLoginWithInvalidUsernamePassword() {
        LOGGER.info("Entering invalid username and password...");
        formAuthenticationPage.sendUsername(" ");
        formAuthenticationPage.sendPassword(" ");
        formAuthenticationPage.submit();

        LOGGER.info("Validating error message...");
        String msg = formAuthenticationPage.getUsernameErrorMessage().trim();
        Assert.assertTrue(msg.contains("Your username is invalid!"), "Error message mismatch for invalid credentials.");
    }

    @Test(priority = 2)
    public void verifyLoginWithValidUsernameAndInvalidPassword() {
        LOGGER.info("Entering valid username and invalid password...");
        formAuthenticationPage.sendUsername("tomsmith");
        formAuthenticationPage.sendPassword("wrongpassword");
        formAuthenticationPage.submit();

        LOGGER.info("Validating error message...");
        String msg = formAuthenticationPage.getPasswordErrorMessage().trim();
        Assert.assertTrue(msg.contains("Your password is invalid!"), "Error message mismatch for invalid password.");
    }

    @Test(priority = 3)
    public void verifyLoginWithInvalidUsernameAndValidPassword() {
        LOGGER.info("Entering invalid username and valid password...");
        formAuthenticationPage.sendUsername("wronguser");
        formAuthenticationPage.sendPassword("SuperSecretPassword!");
        formAuthenticationPage.submit();

        LOGGER.info("Validating error message...");
        String msg = formAuthenticationPage.getUsernameErrorMessage().trim();
        Assert.assertTrue(msg.contains("Your username is invalid!"), "Error message mismatch for invalid username.");
    }

    @Test(priority = 4)
    public void verifyLoginWithNoUsernameAndPassword() {
        LOGGER.info("Clicking submit button without entering credentials...");
        formAuthenticationPage.submit();

        LOGGER.info("Validating error message...");
        String msg = formAuthenticationPage.getUsernameErrorMessage().trim();
        Assert.assertTrue(msg.contains("Your username is invalid!"), "Error message mismatch for empty credentials.");
    }
}
