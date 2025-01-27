package com.qa.herokuapp.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.herokuapp.helper.ActionUtils;
import com.qa.herokuapp.helper.WebDriverWaitUtils;

public class DragAndDropPage {
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
			ActionUtils.dragAndDropWithWait(driver, columnA, columnB, Duration.ofSeconds(3));
			ActionUtils.dragAndDropWithWait(driver, columnB, columnA, Duration.ofSeconds(3));

		} catch (Exception e) {
			System.out.println("Error occured: " + e.getMessage());
		}
	}

	public String getColumnAText() {
		return columnA.getText();
	}

	public String getColumnBText() {
		return columnB.getText();
	}

}
