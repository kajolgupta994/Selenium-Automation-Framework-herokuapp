package com.qa.herokuapp.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.herokuapp.base.TestBase;
import com.qa.herokuapp.helper.ImplicitWaitUtils;
import com.qa.herokuapp.helper.WebDriverWaitUtils;

public class HomePage extends TestBase {

	protected WebDriver driver;

	@FindBy(xpath = "//a[text()='Basic Auth']")
	private WebElement basicAuthPageLink;
	@FindBy(xpath = "//*[text()='Add/Remove Elements']")
	private WebElement addRemoveElements;
	@FindBy(xpath = "//a[text()='Broken Images']")
	private WebElement brokenImagesLinkTexrt;
	@FindBy(xpath = "//a[text()='Challenging DOM']")
	private WebElement clickOnChallengingDOMLinkText;
	@FindBy(xpath = "//a[text()='Checkboxes']")
	private WebElement checkboxesLinkText;
	@FindBy(xpath = "//a[text()='Context Menu']")
	private WebElement contextMenuLinkText;
	@FindBy(xpath = "//a[text()='Digest Authentication']")
	private WebElement digestAuthenticationLinkText;
	@FindBy(xpath = "//a[text()='Disappearing Elements']")
	private WebElement DisappearingElementsLinkText;
	@FindBy(xpath = "//a[text()='Drag and Drop']")
	private WebElement dragAndDropLinkText;
	@FindBy(xpath = "//a[text()='Dropdown']")
	private WebElement dropddownLinkText;
	@FindBy(xpath = "//a[text()='Dynamic Content']")
	private WebElement dynamicContentLinkText;
	@FindBy(xpath = "//a[text()='Dynamic Controls']")
	private WebElement dynamicControlsLinkText;
	@FindBy(xpath = "//a[text()='Dynamic Loading']")
	private WebElement dynamicLoadingLinkText;
	@FindBy(xpath = "//a[text()='Entry Ad']")
	private WebElement entryAdLinkText;
	@FindBy(xpath = "//a[text()='Exit Intent']")
	private WebElement exitIntentLinkText;
	@FindBy(xpath = "//a[text()='File Download']")
	private WebElement fileDownloadLinkText;
	@FindBy(xpath = "//a[text()='File Upload']")
	private WebElement fileUploadLinkText;
	@FindBy(xpath = "//a[text()='Floating Menu']")
	private WebElement floatingMenuLinkText;
	@FindBy(xpath = "//a[text()='Forgot Password']")
	private WebElement forgotPasswordLinkText;
	@FindBy(xpath = "//a[text()='Form Authentication']")
	private WebElement formAuthenticationLinkText;
	@FindBy(xpath = "//a[text()='Frames']")
	private WebElement framesLinkText;
	@FindBy(xpath = "//a[text()='Geolocation']")
	private WebElement GeolocationLinkText;
	@FindBy(xpath = "//a[text()='Horizontal Slider']")
	private WebElement horizontalSliderLinkText;
	@FindBy(xpath = "//a[text()='Hovers']")
	private WebElement hoversLinkText;
	@FindBy(xpath = "//a[text()='Infinite Scroll']")
	private WebElement infiniteScrollLinkText;
	@FindBy(xpath = "//a[text()='Inputs']")
	private WebElement inputsLinkText;
	@FindBy(xpath = "//a[text()='JQuery UI Menus']")
	private WebElement jQueryUIMenusLinkText;
	@FindBy(xpath = "//a[text()='JavaScript Alerts']")
	private WebElement javaScriptAlertsLinkText;
	@FindBy(xpath = "//a[text()='JavaScript onload event error']")
	private WebElement javaScriptOnloadEventLinkText;
	@FindBy(xpath = "//a[text()='Key Presses']")
	private WebElement keyPressesLinkText;
	@FindBy(xpath = "//a[text()='Large & Deep DOM']")
	private WebElement largeAndDeepDOMLinkText;
	@FindBy(xpath = "//a[text()='Multiple Windows']")
	private WebElement multipleWindowsLinkText;
	@FindBy(xpath = "//a[text()='Nested Frames']")
	private WebElement nestedFramesLinkText;
	@FindBy(xpath = "//a[text()='Notification Messages']")
	private WebElement notificationMessagesLinkText;
	@FindBy(xpath = "//a[text()='Redirect Link']")
	private WebElement redirectLinkLinkText;
	@FindBy(xpath = "//a[text()='Secure File Download']")
	private WebElement secureFileDownloadLinkText;
	@FindBy(xpath = "//a[text()='Shadow DOM']")
	private WebElement shadowDOMLinkText;
	@FindBy(xpath = "//a[text()='Shifting Content']")
	private WebElement shiftingContentLinkText;
	@FindBy(xpath = "//a[text()='Slow Resources']")
	private WebElement slowResourcesLinkText;
	@FindBy(xpath = "//a[text()='Sortable Data Tables']")
	private WebElement sortableDataTablesLinkText;
	@FindBy(xpath = "//a[text()='Status Codes']")
	private WebElement statusCodesLinkText;
	@FindBy(xpath = "//a[text()='Typos']")
	private WebElement typosLinkText;
	@FindBy(xpath = "//a[text()='WYSIWYG Editor']")
	private WebElement wYSIWYGEditorLinkText;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		LOGGER.info("Waiting for the page to load...");
		ImplicitWaitUtils.waitForThePageGetLoaded(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
		LOGGER.info("Page loaded successfully.");
	}

	public void clickOnLinkText(WebElement linkTextElement) {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), linkTextElement);
		linkTextElement.click();
	}

	public void clickOnBasicAuthText() {
		clickOnLinkText(basicAuthPageLink);
	}

	public void clickOnAddRemoveElementLink() {
		clickOnLinkText(addRemoveElements);
	}

	public void clickOnBrokenImagesLinkText() {
		clickOnLinkText(brokenImagesLinkTexrt);
	}

	public void clickOnChallengingDOMLinkText() {
		clickOnLinkText(clickOnChallengingDOMLinkText);
	}

	public void clickOnCheckboxesLinkText() {
		clickOnLinkText(checkboxesLinkText);
	}

	public void clickOnContextMenuLinkText() {
		clickOnLinkText(contextMenuLinkText);
	}

	public void clickOnDigestAuthenticationLinkText() {
		clickOnLinkText(digestAuthenticationLinkText);
	}

	public void clickOnDisappearingElementsLinkText() {
		clickOnLinkText(DisappearingElementsLinkText);
	}

	public void clickOnDragAndDropLinkText() {
		clickOnLinkText(dragAndDropLinkText);
	}

	public void clickOnDropdownLinkText() {
		clickOnLinkText(dropddownLinkText);
	}

	public void clickOnDynamicContentLinkText() {
		clickOnLinkText(dynamicContentLinkText);
	}

	public void clickOnDynamicControlsLinkText() {
		clickOnLinkText(dynamicControlsLinkText);
	}

	public void clickOnDynamicLoadingLinkText() {
		clickOnLinkText(dynamicLoadingLinkText);
	}

	public void clickOnEntryAdLinkText() {
		clickOnLinkText(entryAdLinkText);
	}
	public void clickOnExitIntentLinkText() {
	    clickOnLinkText(exitIntentLinkText);
	}

	public void clickOnFileDownloadLinkText() {
		clickOnLinkText(fileDownloadLinkText);
	}

	public void clickOnFileUplaodLinkText() {
		clickOnLinkText(fileUploadLinkText);
	}

	public void clickOnFloatingMenuLinkText() {
		clickOnLinkText(floatingMenuLinkText);
	}

	public void clickOnForgotPasswordLinkText() {
		clickOnLinkText(forgotPasswordLinkText);
	}

	public void clickOnFormAuthenticartionLinkText() {
		clickOnLinkText(formAuthenticationLinkText);
	}

	public void clickOnFramesLinkText() {
		clickOnLinkText(framesLinkText);
	}

	public void clickOnGeolocationLinkText() {
		clickOnLinkText(GeolocationLinkText);
	}

	public void clickOnHorizontalSliderLinkText() {
		clickOnLinkText(horizontalSliderLinkText);
	}

	public void clickOnHoversLinkText() {
		clickOnLinkText(hoversLinkText);
	}

	public void clickOnInfiniteScrollLinkText() {
		clickOnLinkText(infiniteScrollLinkText);
	}

	public void clickOnInputsLinkText() {
		clickOnLinkText(inputsLinkText);
	}

	public void clickOnJqueryUIMenusLinkText() {
		clickOnLinkText(jQueryUIMenusLinkText);
	}

	public void clickOnJavaScriptAlertsLinkText() {
		clickOnLinkText(javaScriptAlertsLinkText);
	}

	public void clickOnJavaScriptOnloadEventErrorLinkText() {
		clickOnLinkText(javaScriptOnloadEventLinkText);
	}

	public void clickOnKeyPressesLinkText() {
		clickOnLinkText(keyPressesLinkText);
	}

	public void clickOnLargeAndDeepLinkText() {
		clickOnLinkText(largeAndDeepDOMLinkText);
	}

	public void clickOnMultipleWindowsLinkText() {
		clickOnLinkText(multipleWindowsLinkText);
	}

	public void clickOnNestedFramesLinkText() {
		clickOnLinkText(nestedFramesLinkText);
	}

	public void clickOnNotificationMessagesLinkText() {
		clickOnLinkText(notificationMessagesLinkText);
	}

	public void clickOnRedirectLinkLinkText() {
		clickOnLinkText(redirectLinkLinkText);
	}

	public void clickOnSecureFileDownloadLinkText() {
		clickOnLinkText(secureFileDownloadLinkText);
	}

	public void clickOnShadowDOMLinkText() {
		clickOnLinkText(shadowDOMLinkText);
	}

	public void clickOnShiftingContentLinkText() {
		clickOnLinkText(shiftingContentLinkText);
	}

	public void clickOnSlowResourcesLinkText() {
		clickOnLinkText(slowResourcesLinkText);
	}

	public void clickOnSortableDataTablesLinkText() {
		clickOnLinkText(sortableDataTablesLinkText);
	}

	public void clickOnStatusCodesLinkText() {
		clickOnLinkText(statusCodesLinkText);
	}

	public void clickOnTyposLinkText() {
		clickOnLinkText(typosLinkText);
	}

	public void clickOnWYSIWYGEditorLinkText() {
		clickOnLinkText(wYSIWYGEditorLinkText);
	}
}
