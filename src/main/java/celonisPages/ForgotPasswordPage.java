package celonisPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Utilities;

public class ForgotPasswordPage {
	
	private WebDriver driver;
	private By emailAddress = By.id("ce-input-7");
	private By getResetLink = By.xpath("//span[contains(text(),' Get reset link ')]");
	private By signIn = By.cssSelector("a[cetestinguid='login-menu-login-link']");
	private By forgotYourPasswordText = By.xpath("//span[contains(text(),'Forgot your password?')]");
	private long timeout = 10;
	
	public ForgotPasswordPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public SignInPage signIn() {
		Utilities.click(driver, driver.findElement(signIn), timeout);
		return new SignInPage(driver);
	}
	
	public String pageLoadedString() {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(forgotYourPasswordText));
		return driver.findElement(forgotYourPasswordText).getText();
	}
}
