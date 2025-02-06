package com.qa.herokuapp.tests;

import org.testng.annotations.Test;
import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.pages.DisappearingElementsPage;
import com.qa.herokuapp.pages.HomePage;

public class DisappearingElementsTest extends TestBase {
    protected DisappearingElementsPage handleDisappearingElementsPage;
    protected HomePage homePage;

    @Test
    public void validateDisappearingElement() {
        LOGGER.info("Initializing HomePage and DisappearingElementsPage objects.");
        homePage = new HomePage(driver);
        handleDisappearingElementsPage = new DisappearingElementsPage(getDriver());

        LOGGER.info("Navigating to the Disappearing Elements Page...");
        homePage.clickOnDisappearingElementsLinkText();
        LOGGER.info("Navigated to the Disappearing Elements Page.");

        LOGGER.info("Starting the process of clicking on menus dynamically.");
        handleDisappearingElementsPage.ClickOnMenusDynamically();
        LOGGER.info("Completed clicking on menus dynamically.");
    }
}
