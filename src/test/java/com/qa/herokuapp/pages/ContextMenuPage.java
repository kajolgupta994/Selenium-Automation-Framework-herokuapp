package com.qa.herokuapp.pages;

import java.time.Duration;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.helper.ActionUtils;
import com.qa.herokuapp.helper.AlertUtils;
import com.qa.herokuapp.helper.WebDriverWaitUtils;

public class ContextMenuPage extends TestBase {
	private WebDriver driver;

	@FindBy(id = "hot-spot")
	private WebElement hotSpot;

	public ContextMenuPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void rightClickOnContextMenuBoxAndHold() {
		LOGGER.info("Waiting for context menu box to be visible...");
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), hotSpot);

		LOGGER.info("Performing right-click and holding it until alert is displayed...");
		ActionUtils.alertContextClickAndHold(driver, hotSpot);

		try {
			LOGGER.info("Waiting for alert to appear...");
			String alertText = AlertUtils.alertGetText(driver);
			LOGGER.info("Alert text: " + alertText);

			LOGGER.info("Accepting the alert...");
			AlertUtils.alertAccept(driver);

			LOGGER.info("Releasing mouse hold...");
			ActionUtils.releaseClick(driver);
		} catch (NoAlertPresentException e) {
			LOGGER.error("No alert present: " + e.getMessage());
		}
	}
}
