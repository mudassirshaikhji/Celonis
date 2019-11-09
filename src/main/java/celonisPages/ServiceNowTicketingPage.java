package celonisPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Utilities;

public class ServiceNowTicketingPage {
	
	private WebDriver driver;
	private long timeout;
	private By serviceNowTicketing= By.xpath("//font[contains(text(),'INCIDENT MANAGEMENT (TICKET STATUS)')]");
	
	public ServiceNowTicketingPage (WebDriver driver) {
		this.driver = driver;
	}

	public String returnServiceNowTicketingText() {
//		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(driver.findElement(serviceNowTicketing)));
		Utilities.waitUntilVisibilityOfElementLocated(driver, serviceNowTicketing, timeout);
//		return driver.findElement(serviceNowTicketing).getText();
		return Utilities.getTextFromAWebElement(driver, serviceNowTicketing, timeout);
	}
}
