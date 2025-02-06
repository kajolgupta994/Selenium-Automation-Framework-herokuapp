package com.qa.herokuapp.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.pages.DragAndDropPage;
import com.qa.herokuapp.pages.HomePage;

public class DragAndDropTest extends TestBase {
    private DragAndDropPage dragAndDropPage;
    private HomePage homePage;

    @Test
    public void testDragAndDrop() {
    	
        LOGGER.info("Initializing HomePage object.");
        homePage = new HomePage(getDriver());
        
        LOGGER.info("Initializing DragAndDropPage object.");
        dragAndDropPage = new DragAndDropPage(getDriver());

        LOGGER.info("Navigating to Drag and Drop page.");
        homePage.clickOnDragAndDropLinkText();
        LOGGER.info("Navigated to Drag and Drop page.");

        LOGGER.info("Performing drag and drop operation.");
        dragAndDropPage.dragAndDropVisaVersa();
        LOGGER.info("Drag and drop operation completed.");

        LOGGER.info("Validating drag and drop results.");
        Assert.assertEquals(dragAndDropPage.getColumnAText(), "A", "Column A should contain Column A");
        Assert.assertEquals(dragAndDropPage.getColumnBText(), "B", "Column B should contain Column B");
        LOGGER.info("Validation of drag and drop results completed successfully.");
    }
}