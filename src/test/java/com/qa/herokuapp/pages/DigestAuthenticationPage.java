package com.qa.herokuapp.pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.herokuapp.helper.WebDriverWaitUtils;

public class DigestAuthenticationPage {
	protected WebDriver driver;
	@FindBy(xpath = "//p")
	private WebElement getSuccessMessage;

	public DigestAuthenticationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void sendLoginDataUsingAutoItScript() {
		try {
			// Execute AutoIT script
			Runtime.getRuntime().exec(System.getProperty("user.dir")
					+ "\\src\\main\\java\\resources\\AutoIT\\HandleDigestAuthentication.exe");
		} catch (IOException e) {
			System.out.println("No such file found: " + e.getMessage());
		}

	}

	public String getSuccessMessage() {
		WebElement getSuccessMsg = getSuccessMessage;
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), getSuccessMsg);

		return getSuccessMsg.getText();
		
	}

}
