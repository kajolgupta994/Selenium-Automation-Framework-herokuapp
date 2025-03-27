package com.qa.herokuapp.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.helper.WebDriverWaitUtils;

public class ShiftingContentPage extends TestBase {

	private WebDriver driver;

	@FindBy(xpath = "//div[@class='example']/a[1]")
	private WebElement menuElement;

	@FindBy(xpath = "//div[@class='example']/a[2]")
	private WebElement anImage;

	@FindBy(xpath = "//div[@class='example']/a[3]")
	private WebElement aList;

	@FindBy(xpath = "//a[text()='click here']")
	private List<WebElement> clickHereLinks;

	@FindBy(xpath = "//ul/li")
	private List<WebElement> menuList;

	public ShiftingContentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnMenuElement() {
		try {
			WebDriverWaitUtils.waitForElementToBeClickable(driver, Duration.ofSeconds(10), menuElement);
			menuElement.click();
			LOGGER.info("Clicked on 'Menu Element' link.");
			
			
			
			for (WebElement link : clickHereLinks) {
				WebDriverWaitUtils.waitForElementToBeClickable(driver, Duration.ofSeconds(5), link);
				link.click();
				LOGGER.info("Clicked on a 'Click Here' link.");
				driver.navigate().back();
			}
			
			for (WebElement item : menuList) {
				WebDriverWaitUtils.waitForElementToBeClickable(driver, Duration.ofSeconds(5), item);
				item.click();
				Thread.sleep(1000);
				driver.navigate().back();
				LOGGER.info("Clicked on menu item: " + item.getText());
			}

		} catch (Exception e) {
			LOGGER.error("Unable to click on 'Menu Element': " + e.getMessage());
		}
	}

	public void clickAnImage() {
		try {
			WebDriverWaitUtils.waitForElementToBeClickable(driver, Duration.ofSeconds(10), anImage);
			anImage.click();
			LOGGER.info("Clicked on 'An Image' link.");

			for (WebElement link : clickHereLinks) {
				WebDriverWaitUtils.waitForElementToBeClickable(driver, Duration.ofSeconds(5), link);
				link.click();
				LOGGER.info("Clicked on a 'Click Here' link.");
				driver.navigate().back();
			}

		} catch (Exception e) {
			LOGGER.error("Unable to click on 'An Image': " + e.getMessage());
		}
	}

	public void clickOnList(int maxClicks) {
		try {

			for (int i = 0; i < maxClicks; i++) {

				WebDriverWaitUtils.waitForElementToBeClickable(driver, Duration.ofSeconds(10), aList);
				aList.click();
				LOGGER.info("Clicked on 'A List' - Attempt " + (i + 1));

				driver.navigate().back(); // Navigate back to repeat the process
				LOGGER.info("Navigated back to 'A List' page.");

			}

		} catch (Exception e) {
			LOGGER.error("Unable to click on 'A List': " + e.getMessage());
		}
	}

}
