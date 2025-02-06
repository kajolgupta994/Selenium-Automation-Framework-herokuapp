package com.qa.herokuapp.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.helper.ActionUtils;

public class DragAndDropPage extends TestBase {
	protected WebDriver driver;

	@FindBy(id = "column-a")
	private WebElement columnA;

	@FindBy(id = "column-b")
	private WebElement columnB;

	@FindBy(xpath = "//div[@id='columns']/div")
	private List<WebElement> columns;

	public DragAndDropPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void dragAndDropVisaVersa() {
		try {
			LOGGER.info("Dragging Column A to Column B.");
			ActionUtils.dragAndDropWithWait(driver, columnA, columnB, Duration.ofSeconds(3));
			LOGGER.info("Dragged Column A to Column B successfully.");

			LOGGER.info("Dragging Column B to Column A.");
			ActionUtils.dragAndDropWithWait(driver, columnB, columnA, Duration.ofSeconds(3));
			LOGGER.info("Dragged Column B to Column A successfully.");
		} catch (Exception e) {
			LOGGER.error("Error occurred during drag and drop operation: " + e.getMessage());
		}
	}

	public String getColumnAText() {
		String text = columnA.getText();
		LOGGER.info("Column A text: " + text);
		return text;
	}

	public String getColumnBText() {
		String text = columnB.getText();
		LOGGER.info("Column B text: " + text);
		return text;
	}
}
