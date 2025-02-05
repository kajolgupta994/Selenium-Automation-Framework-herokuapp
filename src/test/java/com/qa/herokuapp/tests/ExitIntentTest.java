package com.qa.herokuapp.tests;

import org.testng.annotations.Test;
import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.pages.ExitIntentPage;
import com.qa.herokuapp.pages.HomePage;

public class ExitIntentTest extends TestBase {
    private ExitIntentPage exitIntentPage;
    private HomePage homePage;

    @Test
    public void testExitIntent() {
        homePage = new HomePage(getDriver());
        exitIntentPage = new ExitIntentPage(getDriver());

        LOGGER.info("Navigating to Exit Intent Page...");
        homePage.clickOnExitIntentLinkText();
        LOGGER.info("Successfully navigated to Exit Intent Page.");


        LOGGER.info("Triggering Exit Intent by moving mouse outside viewport...");
        exitIntentPage.triggerExitIntent();
        
        LOGGER.info("Verifying if modal appears...");
        exitIntentPage.closeModal();
    }

}
