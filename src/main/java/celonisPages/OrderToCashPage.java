package celonisPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Utilities;

public class OrderToCashPage {

	private long timeout = 10;
	private WebDriver driver;
	private By orderToCashAnalysisText = By.xpath("//span[contains(text(),'Order-to-Cash Analysis')]");
	
	public OrderToCashPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String returnOrderToCashAnalysisText() {
//		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(driver.findElement(orderToCashAnalysisText)));
		Utilities.waitUntilVisibilityOfElementLocated(driver, orderToCashAnalysisText, timeout);
//		return driver.findElement(orderToCashAnalysisText).getText();
		return Utilities.getTextFromAWebElement(driver, orderToCashAnalysisText, timeout);
	}
	
}
