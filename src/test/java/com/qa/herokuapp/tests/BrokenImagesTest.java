package com.qa.herokuapp.tests;

import org.testng.annotations.Test;

import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.pages.BrokenImagesPage;
import com.qa.herokuapp.pages.HomePage;

public class BrokenImagesTest extends TestBase {
	private BrokenImagesPage brokenImagesPage;
	private HomePage homePage;
	
	@Test
	public void brokenImageTest() {
		homePage = new HomePage(driver);
		homePage.clickOnBrokenImagesLinkText();
		
		brokenImagesPage = new BrokenImagesPage(driver);
		brokenImagesPage.getBrokenImageCounts();
	}
	

}
