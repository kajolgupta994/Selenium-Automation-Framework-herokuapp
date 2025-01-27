package com.qa.herokuapp.pages;

import java.util.List;

import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.HttpStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrokenImagesPage {
	private WebDriver driver;
	int getBrokenImageCount = 0;
	public String status = "passed";

	@FindBy(xpath = "//div[@class='example']//img")
	private List<WebElement> imageList;

	public BrokenImagesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void getBrokenImageCounts() {
		try {

			for (WebElement image : imageList) {
				if (image != null) {
					if (image.getAttribute("naturalWidth").equals("0")) {
						System.out.println(image.getAttribute("outerHTML") + "is broken");
						getBrokenImageCount++;
					}
				}

			}

		} catch (Exception e) {

			e.printStackTrace();
			status = "failed";
			System.out.println(e.getMessage());
		}
		status = "passed";
		System.out.println("The page has " + getBrokenImageCount + " broken images");
	}
}
