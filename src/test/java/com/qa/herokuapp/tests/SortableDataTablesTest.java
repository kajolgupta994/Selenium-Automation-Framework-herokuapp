package com.qa.herokuapp.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.pages.HomePage;
import com.qa.herokuapp.pages.SortableDataTablesPage;

public class SortableDataTablesTest extends TestBase {
	private HomePage homePage;
	private SortableDataTablesPage sortableDataTablesPage;

	@BeforeClass
	public void setup() {
		homePage = new HomePage(getDriver());
		sortableDataTablesPage = new SortableDataTablesPage(getDriver());

		LOGGER.info("Navigating to the sortable data table page...");
		homePage.clickOnSortableDataTablesLinkText();
	}

	@Test(priority = 1)
	public void validateTable1() {
		LOGGER.info("Validating table1...");
		sortableDataTablesPage.handleSortEditAndDeleteOnTable1();
	}

	@Test(priority = 2)
	public void validateTable2() {
		LOGGER.info("Validating table2...");
		sortableDataTablesPage.handleSortEditAndDeleteOnTable2();

	}

}
