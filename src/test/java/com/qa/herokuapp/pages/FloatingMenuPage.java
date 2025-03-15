package com.qa.herokuapp.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.herokuapp.base.TestBase;

public class FloatingMenuPage extends TestBase {

	private WebDriver driver;

	@FindBy(css = "#menu a")
	private List<WebElement> menuItems;

	public FloatingMenuPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnMenus() {
		try {
			for (WebElement menu : menuItems) {
				menu.click();
				LOGGER.info(menu.getText() + " is clicked");
			}
		} catch (Exception e) {
			LOGGER.error("Error while clicking menu items: " + e.getMessage());
		}
	}

	public boolean isMenuVisibleAfterScroll() {

		JavascriptExecutor js;
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500);");
		return menuItems.get(0).isDisplayed();
	}

}
