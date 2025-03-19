package com.qa.herokuapp.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.helper.ActionUtils;
import com.qa.herokuapp.helper.WebDriverWaitUtils;

public class JQueryMenuUIPage extends TestBase {

	private WebDriver driver;

	@FindBy(xpath = "//a[text()='Enabled']")
	private WebElement enabledMenu;

	@FindBy(xpath = "//ul/li/a[text()='Downloads']")
	private WebElement downloadsMenu;

	@FindBy(xpath = "//ul/li/a[text()='Downloads']/following-sibling::ul/li")
	private List<WebElement> downloadsSubMenus;

	@FindBy(xpath = "//a[text()='Back to JQuery UI']")
	private WebElement backToJQueryUIButton;

	@FindBy(xpath = "//a[text()='Menu']")
	private WebElement menu;

	public JQueryMenuUIPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Handle the initial navigation and menu interaction
	public boolean handleJQueryUIMenu() {

		try {
			ActionUtils.alertClickAndHold(driver, enabledMenu);
			Thread.sleep(2000); // Simulate human-like interaction delay

			ActionUtils.alertClickAndHold(driver, downloadsMenu);
			Thread.sleep(2000);

			return true;
		} catch (Exception e) {
			LOGGER.info("Unable to interact with the main menus", e);
			return false;
		}
	}

	// Handle the download submenus under the "Downloads" menu
	public boolean handleDownloadSubmenus() {
		try {
			WebDriverWaitUtils.waitForTheVisibilityOfListWebElements(driver, Duration.ofSeconds(10), downloadsSubMenus);

			// Iterate over each submenu option
			for (int i = 0; i < downloadsSubMenus.size(); i++) {

				// Click on the current submenu item
				downloadsSubMenus.get(i).click();

				Thread.sleep(7000); // Simulate download delay

				// Refresh the page to load submenu again
				driver.navigate().refresh();

				// Reopen the "Downloads" menu if it gets closed after clicking a submenu
				handleJQueryUIMenu();
			}
			return true;

		} catch (Exception e) {
			LOGGER.error("Failed to handle download submenus", e);
			return false;
		}
	}

	// Click the "Back to JQuery UI" button
	public boolean clickBackToJQueryUI() {
		try {
			WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), backToJQueryUIButton);
			backToJQueryUIButton.click();
			Thread.sleep(2000); // Wait for navigation to complete
			return true;
		} catch (Exception e) {
			LOGGER.error("Failed to click 'Back to JQuery UI'", e);
			return false;
		}
	}

	// Click the "Menu" button
	public boolean clickOnMenuOption() {
		try {
			WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), menu);
			menu.click();
			Thread.sleep(2000); // Wait for navigation to complete
			return true;
		} catch (Exception e) {
			LOGGER.error("Failed to click 'Menu'", e);
			return false;
		}
	}

}
