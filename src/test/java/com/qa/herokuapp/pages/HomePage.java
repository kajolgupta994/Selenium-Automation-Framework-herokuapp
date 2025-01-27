package com.qa.herokuapp.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.herokuapp.helper.ImplicitWaitUtils;
import com.qa.herokuapp.helper.WebDriverWaitUtils;

public class HomePage {

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
		ImplicitWaitUtils.waitForThePageGetLoaded(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	public void clickOnBasicAuthText() {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), basicAuthPageLink);
		basicAuthPageLink.click();
	}

	public void clickOnAddRemoveElementLink() {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), addRemoveElements);
		addRemoveElements.click();
	}

	public void clickOnBrokenImagesLinkText() {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), brokenImagesLinkTexrt);
		brokenImagesLinkTexrt.click();
	}

	public void clickOnChallengingDOMLinkText() {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10),
				clickOnChallengingDOMLinkText);
		clickOnChallengingDOMLinkText.click();
	}

	public void clickOnCheckboxesLinkText() {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), checkboxesLinkText);
		checkboxesLinkText.click();
	}

	public void clickOnContextMenuLinkText() {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), contextMenuLinkText);
		contextMenuLinkText.click();
	}
	public void clickOnDigestAuthenticationLinkText() {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), digestAuthenticationLinkText);
		digestAuthenticationLinkText.click();
	}

	public void clickOnDisappearingElementsLinkText() {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), DisappearingElementsLinkText);
		DisappearingElementsLinkText.click();
	}

	public void clickOnDragAndDropLinkText() {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), dragAndDropLinkText);
		dragAndDropLinkText.click();
	}

	public void clickOnDropdownLinkText() {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), dropddownLinkText);
		dropddownLinkText.click();
	}

	public void clickOnDynamicContentLinkText() {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), dynamicContentLinkText);
		dynamicContentLinkText.click();
	}

	public void clickOnDynamicControlsLinkText() {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), dynamicControlsLinkText);
		dynamicControlsLinkText.click();
	}

	public void clickOnDynamicLoadingLinkText() {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), dynamicLoadingLinkText);
		dynamicLoadingLinkText.click();
	}

	public void clickOnEntryAdLinkText() {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), entryAdLinkText);
		entryAdLinkText.click();
	}

	public void clickOnExitIntentLinkText() {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), exitIntentLinkText);
		exitIntentLinkText.click();
	}

	public void clickOnFileDownloadLinkText() {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), fileDownloadLinkText);
		fileDownloadLinkText.click();
	}

	public void clickOnFileUplaodLinkText() {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), fileUploadLinkText);
		fileUploadLinkText.click();
	}

	public void clickOnFloatingMenuLinkText() {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), floatingMenuLinkText);
		floatingMenuLinkText.click();
	}

	public void clickOnForgotPasswordLinkText() {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), forgotPasswordLinkText);
		forgotPasswordLinkText.click();
	}

	public void clickOnFormAuthenticartionLinkText() {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), formAuthenticationLinkText);
		formAuthenticationLinkText.click();
	}

	public void clickOnFramesLinkText() {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), framesLinkText);
		framesLinkText.click();
	}

	public void clickOnGeolocationLinkText() {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), GeolocationLinkText);
		GeolocationLinkText.click();
	}

	public void clickOnHorizontalSliderLinkText() {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), horizontalSliderLinkText);
		horizontalSliderLinkText.click();
	}

	public void clickOnHoversLinkText() {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), hoversLinkText);
		hoversLinkText.click();
	}

	public void clickOnInfiniteScrollLinkText() {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), infiniteScrollLinkText);
		infiniteScrollLinkText.click();
	}

	public void clickOnInputsLinkText() {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), inputsLinkText);
		inputsLinkText.click();
	}

	public void clickOnJqueryUIMenusLinkText() {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), jQueryUIMenusLinkText);
		jQueryUIMenusLinkText.click();
	}

	public void clickOnJavaScriptAlertsLinkText() {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), javaScriptAlertsLinkText);
		javaScriptAlertsLinkText.click();
	}

	public void clickOnJavaScriptOnloadEventErrorLinkText() {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10),
				javaScriptOnloadEventLinkText);
		javaScriptOnloadEventLinkText.click();
	}

	public void clickOnKeyPressesLinkText() {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), keyPressesLinkText);
		keyPressesLinkText.click();
	}

	public void clickOnLargeAndDeepLinkText() {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), largeAndDeepDOMLinkText);
		largeAndDeepDOMLinkText.click();
	}

	public void clickOnMultipleWindowsLinkText() {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), multipleWindowsLinkText);
		multipleWindowsLinkText.click();
	}

	public void clickOnNestedFramesLinkText() {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), nestedFramesLinkText);
		nestedFramesLinkText.click();
	}

	public void clickOnNotificationMessagesLinkText() {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), notificationMessagesLinkText);
		notificationMessagesLinkText.click();
	}

	public void clickOnRedirectLinkLinkText() {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), redirectLinkLinkText);
		redirectLinkLinkText.click();
	}

	public void clickOnSecureFileDownloadLinkText() {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), secureFileDownloadLinkText);
		secureFileDownloadLinkText.click();
	}

	public void clickOnShadowDOMLinkText() {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), shadowDOMLinkText);
		shadowDOMLinkText.click();
	}

	public void clickOnShiftingContentLinkText() {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), shiftingContentLinkText);
		shiftingContentLinkText.click();
	}

	public void clickOnSlowResourcesLinkText() {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), slowResourcesLinkText);
		slowResourcesLinkText.click();
	}

	public void clickOnSortableDataTablesLinkText() {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), sortableDataTablesLinkText);
		sortableDataTablesLinkText.click();
	}

	public void clickOnStatusCodesLinkText() {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), statusCodesLinkText);
		statusCodesLinkText.click();
	}

	public void clickOnTyposLinkText() {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), typosLinkText);
		typosLinkText.click();
	}

	public void clickOnWYSIWYGEditorLinkText() {
		WebDriverWaitUtils.waitForTheVisibilityOfElement(driver, Duration.ofSeconds(10), wYSIWYGEditorLinkText);
		wYSIWYGEditorLinkText.click();
	}

}
