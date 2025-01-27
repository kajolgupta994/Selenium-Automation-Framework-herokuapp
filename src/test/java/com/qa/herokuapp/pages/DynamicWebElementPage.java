package com.qa.herokuapp.pages;

import java.time.Duration;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.herokuapp.helper.WebDriverWaitUtils;

public class DynamicWebElementPage {
	protected WebDriver driver;
	@FindBy(xpath = "//a[contains(@class, 'button') and text()='qux']")
	private WebElement getQux;
	@FindBy(xpath = "//a[contains(@class, 'button alert') and text()='bar']")
	private WebElement getBar;
	@FindBy(xpath = "//a[contains(@class, 'button') and text()='baz']")
	private WebElement getBaz;
	@FindBy(xpath = "//a[contains(@class, 'button success') and text()='foo']")
	private WebElement getFoo;
	@FindBy(xpath = "//table/tbody/tr")
	private List<WebElement> getTableRows;
	@FindBy(id = "canvas")
	private WebElement getCanvas;

	public DynamicWebElementPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void ClickOnButtonDynamically() {
		List<WebElement> buttons = Arrays.asList(getQux, getBar, getBaz, getFoo);
		for (WebElement button : buttons) {
			try {
				WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), button);
				button.click();
				System.out.println("Clicked on: " + button.getText());
				break;
			} catch (Exception e) {
				System.out.println("Button not interactable: " + e.getMessage());

			}

		}
	}

	public String getTableCellValues() {

		StringBuilder tableData = new StringBuilder();

		for (WebElement row : getTableRows) {
			// Get all <td> cells except those containing buttons
			List<WebElement> cells = row.findElements(By.xpath("./td[not(./a)]"));

			for (WebElement cell : cells) {
				tableData.append(cell.getText()).append(" | "); // Append cell data to string
			}
			tableData.append("\n"); // Add newline after each row
		}

		return tableData.toString();

	}

	public String getCanvasDataAsBase64() {
		try {
			return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].toDataURL();", getCanvas);
		} catch (Exception e) {
			System.out.println("Unable to fetch canvas content: " + e.getMessage());
		}
		return null;
	}

	// Handle action buttons

	public void clickActionButtons() {

		for (int i = 0; i < getTableRows.size(); i++) {
			WebElement row = getTableRows.get(i);

			// Check if this row contains action buttons
			List<WebElement> actions = row.findElements(By.xpath("./td/a"));
			if (!actions.isEmpty()) {

				for (WebElement action : actions) {
					String actionText = action.getText();
					String xpath = String.format("./td/a[text()='%s']", actionText);

					try {
						WebElement button = row.findElement(By.xpath(xpath));

						if (button.isEnabled() && button.isDisplayed()) {
							button.click();
							System.out.println(actionText + " button is clicked on row number: " + (i + 1));

						} else {
							System.out.println(actionText + " button is not interactable on row number: " + (i + 1));
						}
					} catch (Exception e) {
						System.out.println("Error clicking the " + actionText + " button on row number:" + (i + 1)
								+ ".Error: " + e.getMessage());
					}
				}
			} else {
				System.out.println("Row number " + (i + 1) + " number does not contain any action button.");
			}
		}
	}

}
