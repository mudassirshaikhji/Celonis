package celonisPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderToCashPage {

	private long timeout = 10;
	private WebDriver driver;
	private By orderToCashAnalysisText = By.xpath("//span[contains(text(),'Order-to-Cash Analysis')]");
	
	public OrderToCashPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String returnOrderToCashAnalysisText() {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(driver.findElement(orderToCashAnalysisText)));
		return driver.findElement(orderToCashAnalysisText).getText();
	}
	
}
