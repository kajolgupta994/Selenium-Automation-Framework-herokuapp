package com.qa.herokuapp.pages;

import java.time.Duration;
import java.util.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.helper.WebDriverWaitUtils;

public class CheckboxesPage extends TestBase {
    private WebDriver driver;
    @FindBy(xpath = "//form[@id='checkboxes']/input")
    private List<WebElement> getCheckboxes;

    public CheckboxesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectAndDeselectCheckboxes() {
        WebDriverWaitUtils.waitForTheVisibilityOfListWebElements(driver, Duration.ofSeconds(10), getCheckboxes);
        LOGGER.info("Waiting for checkboxes to be visible");
        
        for (int i = 0; i < getCheckboxes.size(); i++) {
            WebElement checkbox = getCheckboxes.get(i);
            if (!checkbox.isSelected()) {
                checkbox.click();
                LOGGER.info("Checkbox {} is selected.", i + 1);
            } else {
                checkbox.click();
                LOGGER.info("Checkbox {} is de-selected.", i + 1);
            }
        }
    }
}
