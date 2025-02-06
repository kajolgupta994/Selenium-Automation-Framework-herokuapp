package com.qa.herokuapp.pages;

import java.time.Duration;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.helper.WebDriverWaitUtils;

public class DisappearingElementsPage extends TestBase {
    protected WebDriver driver;

    private List<WebElement> getMenus;

    public DisappearingElementsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void ClickOnMenusDynamically() {
        By menuLocator = By.xpath("//li/a");
        getMenus = driver.findElements(menuLocator);
        
        LOGGER.info("Fetching menu elements from the page.");

        for (WebElement menu : getMenus) {
            try {
                WebDriverWaitUtils.waitForElementToBeClickable(driver, Duration.ofSeconds(10), menu);
                LOGGER.info("Clicking on menu: " + menu.getText());
                
                if (menu.isDisplayed() && menu.isEnabled()) {
                    try {
                        menu.click();
                    } catch (ElementNotInteractableException | JavascriptException e) {
                        LOGGER.warn("Fallback to JavascriptExecutor due to: " + e.getMessage());
                        // Use JavascriptExecutor as a backup if .click() fails.
                        JavascriptExecutor js = (JavascriptExecutor) driver;
                        js.executeScript("arguments[0].click();", menu);
                    }

                    // Wait and navigate back to Disappearing Elements page
                    Thread.sleep(3000);
                    driver.navigate().back();
                    LOGGER.info("Navigated back to the Disappearing Elements page.");

                } else {
                    LOGGER.warn("Menu is not visible or enabled: " + menu.getText());
                }

            } catch (StaleElementReferenceException e) {
                LOGGER.error("Stale element encountered. Restarting the process.", e);
                ClickOnMenusDynamically(); // Restart the process
                break;
            } catch (Exception e) {
                LOGGER.error("An exception occurred: " + e.getMessage(), e);
            }
        }
    }
}
