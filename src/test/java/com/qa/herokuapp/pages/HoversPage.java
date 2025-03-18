package com.qa.herokuapp.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.helper.ActionUtils;

public class HoversPage extends TestBase {
	private WebDriver driver;
	@FindBy(xpath = "//div[@class='figure']")
	private List<WebElement> images;
	@FindBy(xpath = "//div[@class='figure']/div/h5")
	private List<WebElement> figCaption;
	@FindBy(xpath = "//div[@class='figure']//a")
	private List<WebElement> viewProfiles;

	public HoversPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void hoverOverOnImages() {
		try {
			for (int i = 0; i < images.size(); i++) {

				try {
					ActionUtils.moveToElement(driver, images.get(i));
					Thread.sleep(2000);
				} catch (Exception e) {
					LOGGER.error("Unable to hover over images");
				}

				// Get the corresponding caption and profile link
				String captionText = figCaption.get(i).getText();
				WebElement profileLink = viewProfiles.get(i);

				LOGGER.info("Hovered on: " + captionText);
				LOGGER.info("Viewing profile of: " + captionText);

				// Click on profile, then navigate back
				try {
					profileLink.click();
					Thread.sleep(2000);
				} catch (Exception e) {
					LOGGER.error("Unable to click on view profile");
				}
				driver.navigate().back();
			}

		} catch (Exception e) {
			LOGGER.info("Unable to get to the images" + e);
		}
	}

}
