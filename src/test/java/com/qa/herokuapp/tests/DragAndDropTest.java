package com.qa.herokuapp.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.herokuapp.base.TestBase;

import com.qa.herokuapp.pages.ContextMenuPage;
import com.qa.herokuapp.pages.DragAndDropPage;
import com.qa.herokuapp.pages.HomePage;

public class DragAndDropTest extends TestBase {
	private DragAndDropPage dragAndDropPage;
	private HomePage homePage;

	@Test
	public void testDragAndDrop() {
		homePage = new HomePage(driver);

		// Navigate to Drag and Drop page
		homePage.clickOnDragAndDropLinkText();

		dragAndDropPage = new DragAndDropPage(driver);

		// Perform drag and drop
		dragAndDropPage.dragAndDropVisaVersa();

		// Validate results
		Assert.assertEquals(dragAndDropPage.getColumnAText(), "A", "Column A should contain Column A");
		Assert.assertEquals(dragAndDropPage.getColumnBText(), "B", "Column B should contain Column B");

	}

}
