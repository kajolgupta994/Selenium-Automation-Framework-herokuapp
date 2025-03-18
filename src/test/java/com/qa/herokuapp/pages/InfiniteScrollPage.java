package com.qa.herokuapp.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.herokuapp.base.TestBase;

public class InfiniteScrollPage extends TestBase {
	private WebDriver driver;
	private JavascriptExecutor js;
	
	@FindBy(xpath = "//div[@class='jscroll-added']")
	private List<WebElement> scrollElements;

	public InfiniteScrollPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor) driver;
	}

	public void handleInfiniteScroll() {
		
		try {
			int previousElementCount = 0;			
			int scrollCount = 0;
			int maxScrolls = 10; // Set a limit to avoid infinite loop

			while (scrollCount < maxScrolls) {
				
				js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
				Thread.sleep(2000); // Wait for new elements to load
				
				int currentElementCount = scrollElements.size();
				
				if (currentElementCount > previousElementCount) {
					LOGGER.info("New content loaded. Total elements: " + currentElementCount);
					previousElementCount = currentElementCount;
				}  
				scrollCount++; // Always increase scroll count to enforce max limit
			}
			LOGGER.info("Scrolling stopped after " + scrollCount + " attempts.");
		} catch (Exception e) {
			LOGGER.error("Unable to handle infinite scroll", e);
		}
	}

}
