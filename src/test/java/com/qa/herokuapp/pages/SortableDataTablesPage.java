package com.qa.herokuapp.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.helper.WebDriverWaitUtils;

public class SortableDataTablesPage extends TestBase {

	private WebDriver driver;

	@FindBy(xpath = "//table[@id='table2']//th")
	private List<WebElement> table2Headers;

	@FindBy(xpath = "//table[@id='table2']//a[text()='edit']")
	private List<WebElement> table2EditOptions;

	@FindBy(xpath = "//table[@id='table2']//a[text()='delete']")
	private List<WebElement> table2DeleteOptions;

	@FindBy(xpath = "//table[@id='table1']//th")
	private List<WebElement> table1Headers;

	@FindBy(xpath = "//table[@id='table1']//a[text()='delete']")
	private List<WebElement> table1DeleteOptions;

	@FindBy(xpath = "//table[@id='table1']//a[text()='edit']")
	private List<WebElement> table1EditOptions;

	public SortableDataTablesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void handleSortEditAndDelete(List<WebElement> headers, List<WebElement> editOptions,
			List<WebElement> deleteOptions) {
		try {
			WebDriverWaitUtils.waitForTheVisibilityOfListWebElements(driver, Duration.ofSeconds(10), headers);

			for (WebElement header : headers) {
				WebDriverWaitUtils.waitForElementToBeClickable(driver, Duration.ofSeconds(5), header);
				header.click();
				LOGGER.info("Clicked on table header to sort the table.");
			}

			for (WebElement edit : editOptions) {
				WebDriverWaitUtils.waitForElementToBeClickable(driver, Duration.ofSeconds(5), edit);
				edit.click();
				if (!driver.getCurrentUrl().contains("sortable-data-tables")) {
					driver.navigate().back();
				}
				LOGGER.info("Clicked on edit button");
			}

			for (WebElement delete : deleteOptions) {
				WebDriverWaitUtils.waitForElementToBeClickable(driver, Duration.ofSeconds(5), delete);
				delete.click();
				if (!driver.getCurrentUrl().contains("sortable-data-tables")) {
					driver.navigate().back();
				}
				LOGGER.info("Clicked on delete button");
			}

		} catch (Exception e) {
			LOGGER.error("Error in handling table actions: ", e);
		}
	}

	public void handleSortEditAndDeleteOnTable1() {
		handleSortEditAndDelete(table1Headers, table1EditOptions, table1DeleteOptions);
	}

	public void handleSortEditAndDeleteOnTable2() {
		handleSortEditAndDelete(table2Headers, table2EditOptions, table2DeleteOptions);
	}

}
