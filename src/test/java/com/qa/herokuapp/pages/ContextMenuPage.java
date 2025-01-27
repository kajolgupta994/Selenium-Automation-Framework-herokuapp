package com.qa.herokuapp.pages;

import java.time.Duration;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.herokuapp.helper.ActionUtils;
import com.qa.herokuapp.helper.AlertUtils;
import com.qa.herokuapp.helper.WebDriverWaitUtils;

public class ContextMenuPage {
	private WebDriver driver;

	@FindBy(id = "hot-spot")
	private WebElement hotSpot;

	public ContextMenuPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void rightClickOnContextMenuBoxAndHold() {

		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), hotSpot);
		// Perform right-click on the element
		System.out.println("Performing right-click and hold it until alert is shown up...");
		ActionUtils.alertContextClickAndHold(driver, hotSpot);

		try {
			// Wait for the alert to appear and get its text
			String alertText = AlertUtils.alertGetText(driver);
			System.out.println(alertText);

			// Click ok button from the javascript alert
			AlertUtils.alertAccept(driver);

			// Release mouse hold
			ActionUtils.releaseClick(driver);

		} catch (NoAlertPresentException e) {
			System.out.println("No alert present: " + e.getMessage());
		}

	}
}
