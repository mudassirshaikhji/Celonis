package celonisPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Utilities;

public class CelonisCloudHomePage {

	//Log out locators
	private By avatar = By.cssSelector(".ce-avatar__letter.text-uppercase");
	private By logOutOption = By.xpath("//button[contains(text(),'Logout')]");
	
	
	//sign In locators
	private By avatarName = By.cssSelector("div.ce-avatar__bg");
	
	private By topSearch = By.cssSelector(".ce-cloud-header-link.ce-cloud-header-link--bordered");
	private By topActualSearchBar = By.cssSelector(".ce-global-search__input.ce-input-element");
	private By noResultsFoundGlobalSearch = By.xpath("//h2[@class='ce-placeholder__title']");
	private By serviceNowSearchResult = By.xpath("//span[contains(text(),'ServiceNow')]");
	private By orderTOCash = By.xpath("//div[contains(text(), 'Order to Cash - Process Overview (EUR) - EN')]");
	private By orderToCashEntry = By.xpath("//a[@data-testing-uid='analysisListComponent-analysisName-Order to Cash - Process Overview (EUR) - EN-button']");
	private By purchaseToPayEntry = By.xpath("//a[@data-testing-uid='analysisListComponent-analysisName-Purchase to Pay - Demo - EN (EUR)-button']");
	private By serviceNowTicketingEntry = By.xpath("//a[@data-testing-uid='analysisListComponent-analysisName-ServiceNow - Ticket Status-button']");
	private By allWorkspaces = By.linkText("All Workspaces");
	
	private WebDriver driver;
	
	private long timeout = 15;
	 
	
	public CelonisCloudHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String returnAvatarName() {
//		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(avatar));
		Utilities.waitUntilVisibilityOfElementLocated(driver, avatarName, timeout);
		return driver.findElement(avatarName).getAttribute("title");
	}
	
	public OrderToCashPage navigateToOrderToCashPage() {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(orderTOCash));
		Utilities.waitUntilVisibilityOfElementLocated(driver, orderToCashEntry, timeout);
		Utilities.click(driver, allWorkspaces, timeout);
		Utilities.click(driver, orderToCashEntry, timeout);
		return new OrderToCashPage(driver);
	}
	
	
	public PurchaseToPayPage navigateToPurchaseToPayPage() {
		Utilities.waitUntilVisibilityOfElementLocated(driver, purchaseToPayEntry, timeout);
		Utilities.click(driver, allWorkspaces, timeout);
		Utilities.click(driver, purchaseToPayEntry, timeout);
		return new PurchaseToPayPage(driver);
	}
	
	public ServiceNowTicketingPage navigateToServiceNowTicketingPage() {
		Utilities.waitUntilVisibilityOfElementLocated(driver, serviceNowTicketingEntry, timeout);
		Utilities.click(driver, allWorkspaces, timeout);
		Utilities.click(driver, serviceNowTicketingEntry, timeout);
		return new ServiceNowTicketingPage(driver);
	}
	
	public SignedOutPage signOut() {
//		Utilities.click(driver, avatar, timeout);
		Utilities.waitUntilVisibilityOfElementLocated(driver, avatarName, timeout);
		Utilities.click(driver, avatarName, timeout);
		Utilities.click(driver, logOutOption, timeout);
		return new SignedOutPage(driver);
	}
	
	public void executeGlobalSearch(String searchText) {
		Utilities.click(driver, topSearch, timeout);
		Utilities.click(driver, topActualSearchBar, timeout);
		Utilities.sendKeys(driver, topActualSearchBar, timeout, searchText);
	}
	
	public String verifyNoResultsFoundText() {
		Utilities.waitUntilVisibilityOfElementLocated(driver, noResultsFoundGlobalSearch, timeout);
		return Utilities.getTextFromAWebElement(driver, noResultsFoundGlobalSearch, timeout);
	}
	
	public String verifyValidResult() {
		Utilities.waitUntilVisibilityOfElementLocated(driver, serviceNowSearchResult, timeout);
		return Utilities.getTextFromAWebElement(driver, serviceNowSearchResult, timeout);
		
	}
	
}
