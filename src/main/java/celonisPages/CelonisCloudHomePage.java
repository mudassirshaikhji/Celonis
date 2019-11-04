package celonisPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Utilities;

public class CelonisCloudHomePage {

	private By avatar = By.xpath("//div[@class='ce-avatar__bg']");
	private By orderTOCash = By.xpath("//div[contains(text(), 'Order to Cash - Process Overview (EUR) - EN')]");
	private By orderToCashEntry = By.xpath("//a[@data-testing-uid='analysisListComponent-analysisName-Order to Cash - Process Overview (EUR) - EN-button']");
	private By purchaseToPayEntry = By.xpath("//a[@data-testing-uid='analysisListComponent-analysisName-Purchase to Pay - Demo - EN (EUR)-button']");
	private By serviceNowTicketingEntry = By.xpath("//a[@data-testing-uid='analysisListComponent-analysisName-ServiceNow - Ticket Status-button']");
	private By allWorkspaces = By.linkText("All Workspaces");
	private By logOutOption = By.cssSelector("button[data-testing-uid='userMenu-logout-button']");
	private WebDriver driver;
	
	private long timeout = 15;
	 
	
	public CelonisCloudHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String returnAvatarName() {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(avatar));
		return driver.findElement(avatar).getAttribute("title");
	}
	
	public OrderToCashPage navigateToOrderToCashPage() {
		//Utilities.click(driver, driver.findElement(orderTOCash), timeout);
		new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(orderTOCash));
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(driver.findElement(orderToCashEntry)));
		driver.findElement(allWorkspaces).click();
		driver.findElement(orderToCashEntry).click();
		return new OrderToCashPage(driver);
	}
	
	
	public PurchaseToPayPage navigateToPurchaseToPayPage() {
		//Utilities.click(driver, driver.findElement(orderTOCash), timeout);
		//new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(purchaseToPayEntry));
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(driver.findElement(purchaseToPayEntry)));
		driver.findElement(allWorkspaces).click();
		driver.findElement(purchaseToPayEntry).click();
		return new PurchaseToPayPage(driver);
	}
	
	public ServiceNowTicketingPage navigateToServiceNowTicketingPage() {
		//Utilities.click(driver, driver.findElement(orderTOCash), timeout);
		//new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(purchaseToPayEntry));
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(driver.findElement(serviceNowTicketingEntry)));
		driver.findElement(allWorkspaces).click();
		driver.findElement(serviceNowTicketingEntry).click();
		return new ServiceNowTicketingPage(driver);
	}
	
	public SignedOutPage signOut() {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(avatar));
		driver.findElement(avatar).click();
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(logOutOption));
		driver.findElement(logOutOption).click();
		return new SignedOutPage(driver);
	}
}
