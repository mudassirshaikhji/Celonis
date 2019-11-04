package celonisPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PurchaseToPayPage {

	private long timeout = 10;
	private WebDriver driver;
	private By purchaseToPayText = By.xpath("//font[contains(text(),'Purchase-to-Pay Analysis')]");
	
	public PurchaseToPayPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String returnPurchaseToPayText() {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(driver.findElement(purchaseToPayText)));
		return driver.findElement(purchaseToPayText).getText();
	}
	
}
