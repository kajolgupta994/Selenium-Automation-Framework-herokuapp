package com.qa.herokuapp.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicControlsPage {
	private WebDriver driver;
	@FindBy(id = "checkbox")
	private WebElement checkbox;
	@FindBy(xpath = "//button[text()='Remove']")
	private WebElement removeButton;
	@FindBy(xpath = "//button[text()='Enable']")
	private WebElement enableButton;
	@FindBy(xpath = "//form[@id='input-example']/input[@type='text']")
	private WebElement inputBox;
	@FindBy(xpath = "//button[text()='Disable']")
	private WebElement disableButton;
	@FindBy(id = "message")
	private WebElement message; // It's disabled! or It's enabled!

	public DynamicControlsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
}
