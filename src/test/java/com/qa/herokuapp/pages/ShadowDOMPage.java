package com.qa.herokuapp.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.qa.herokuapp.base.TestBase;

public class ShadowDOMPage extends TestBase {

    private WebDriver driver;
    private JavascriptExecutor jsExecutor;

    public ShadowDOMPage(WebDriver driver) {
        this.driver = driver;
        this.jsExecutor = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    // Method to access Shadow DOM elements
    public void validateShadowDOM() {
        try {
            // Access the Shadow Host
            WebElement shadowHost = driver.findElement(By.cssSelector("my-shadow-dom"));
            
            // Get the Shadow Root using JavaScript
            WebElement shadowRoot = (WebElement) jsExecutor.executeScript("return arguments[0].shadowRoot;", shadowHost);

            // Find the first <span> inside the shadow root
            WebElement spanText = shadowRoot.findElement(By.cssSelector("span"));
            LOGGER.info("Shadow DOM Span Text: " + spanText.getText());

            // Find the list items inside shadow root
            List<WebElement> listItems = shadowRoot.findElements(By.cssSelector("ul[slot='my-text'] li"));
            for (WebElement item : listItems) {
                LOGGER.info("List Item: " + item.getText());
            }

        } catch (Exception e) {
            LOGGER.error("Error interacting with Shadow DOM: " + e.getMessage());
        }
    }
}
