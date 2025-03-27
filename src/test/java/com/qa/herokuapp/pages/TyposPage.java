package com.qa.herokuapp.pages;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.helper.WebDriverWaitUtils;

public class TyposPage extends TestBase {

	private WebDriver driver;

	@FindBy(xpath = "//div[@class='example']/p[2]")
	private WebElement paraTag;

	public TyposPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getPageText() {
		try {
			WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), paraTag);
			return paraTag.getText();

		} catch (Exception e) {
			LOGGER.error("Unable to get the text: " + e.getMessage());
			return "";
		}
	}

	public boolean isSpellingCorrect(String text) {
		List<String> dictionary = Arrays.asList("Sometimes", "you'll", "see", "a", "typo,", "other", "times", "you",
				"won't.");
		for (String word : text.split("\\s+")) {
			if (dictionary.contains(word.replaceAll("[^a-zA-Z']", ""))) {
				return false;
			}
		}
		return true;
	}

}
