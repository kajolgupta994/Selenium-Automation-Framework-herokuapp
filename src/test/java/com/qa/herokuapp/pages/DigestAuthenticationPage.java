package com.qa.herokuapp.pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.helper.WebDriverWaitUtils;

public class DigestAuthenticationPage extends TestBase {
    protected WebDriver driver;
    
    @FindBy(xpath = "//p")
    private WebElement getSuccessMessage;

    public DigestAuthenticationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void sendLoginDataUsingAutoItScript() {
        try {
            LOGGER.info("Executing AutoIT script for Digest Authentication...");
            Runtime.getRuntime().exec(System.getProperty("user.dir")
                    + "\\src\\main\\java\\resources\\AutoIT\\HandleDigestAuthentication.exe");
            LOGGER.info("AutoIT script executed successfully.");
        } catch (IOException e) {
            LOGGER.error("No such file found: " + e.getMessage());
        }
    }

    public String getSuccessMessage() {
        WebElement getSuccessMsg = getSuccessMessage;
        LOGGER.info("Waiting for success message to be visible...");
        WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), getSuccessMsg);
        String message = getSuccessMsg.getText();
        LOGGER.info("Success message retrieved: " + message);
        return message;
    }
}
