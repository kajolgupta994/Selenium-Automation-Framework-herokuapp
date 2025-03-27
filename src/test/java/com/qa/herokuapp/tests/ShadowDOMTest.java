package com.qa.herokuapp.tests;

import org.testng.annotations.Test;
import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.pages.HomePage;
import com.qa.herokuapp.pages.ShadowDOMPage;

public class ShadowDOMTest extends TestBase {
    private HomePage homePage;
    private ShadowDOMPage shadowDOMPage;

    @Test
    public void validateShadowDOMElements() {
        homePage = new HomePage(getDriver());
        shadowDOMPage = new ShadowDOMPage(getDriver());

        LOGGER.info("Navigating to the Shadow DOM page...");
        homePage.clickOnShadowDOMLinkText();

        // Validate Shadow DOM Elements
        shadowDOMPage.validateShadowDOM();
    }
}
