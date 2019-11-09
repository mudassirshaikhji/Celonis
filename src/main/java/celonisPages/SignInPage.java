package celonisPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Utilities;

public class SignInPage {
	
	private By email = By.name("username");
	private By password = By.name("password");
	private By SignIn = By.cssSelector(".btn-text");
	private By forgotPassword = By.cssSelector("a[href='/ui/login/forgot-password/']");
	private By invalidUserOrPassword = By.xpath("//span[contains(text(),'Email or password are incorrect.')]");
	private WebDriver driver;
	private final long timeout = 5;
	
	public SignInPage(WebDriver driver) {
		this.driver = driver;
		
	}

	public CelonisCloudHomePage login(String username, String password) {
		enterCredentials(username, password);
		driver.findElement(SignIn).click();
		return new CelonisCloudHomePage(driver);
	}
	
	public void loginInvalidCredentials(String username, String password) {
		enterCredentials(username, password);
		driver.findElement(SignIn).click();
	}
	
	public String getErrorMessageInvalidLogin() {
//		new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(invalidUserOrPassword));
		Utilities.waitUntilPresenceOfElementLocated(driver, invalidUserOrPassword, timeout);
//		return driver.findElement(invalidUserOrPassword).getText();
		return Utilities.getTextFromAWebElement(driver, invalidUserOrPassword, timeout);
	}
	
	public ForgotPasswordPage goTOForgotPasswordPage() {
		Utilities.click(driver, driver.findElement(forgotPassword), timeout);
		return new ForgotPasswordPage(driver);
	}
	
	private void enterCredentials(String username, String password) {
		driver.findElement(email).sendKeys(username);
		driver.findElement(this.password).sendKeys(password);
	}
	
}
