package com.qa.herokuapp.pages;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.herokuapp.base.TestBase;

public class BrokenImagesPage extends TestBase {
    private WebDriver driver;
    private int brokenImageCount = 0;
    public String status = "passed";

    @FindBy(xpath = "//div[@class='example']//img")
    private List<WebElement> imageList;

    public BrokenImagesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void getBrokenImageCounts() {
        try {
            LOGGER.info("Checking for broken images on the page.");
            
            for (WebElement image : imageList) {
                if (image != null) {
                    if (image.getAttribute("naturalWidth").equals("0")) {
                        LOGGER.warn("Broken image detected: {}", image.getAttribute("outerHTML"));
                        brokenImageCount++;
                    }
                }
            }
            
            LOGGER.info("Total broken images found: {}", brokenImageCount);
            
        } catch (Exception e) {
            status = "failed";
            LOGGER.error("An error occurred while checking for broken images: {}", e.getMessage(), e);
        }
        status = "passed";
    }
}
