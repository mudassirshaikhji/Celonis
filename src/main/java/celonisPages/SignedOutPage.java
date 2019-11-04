package celonisPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignedOutPage {

	private WebDriver driver;
	private final long timeout = 5;
	private By verificationSignInToYourTeamText = By.className("ce-login-layout__title");
	
	public SignedOutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isSignInToYourTeamTextVisible() {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(driver.findElement(verificationSignInToYourTeamText)));
		if(driver.findElement(verificationSignInToYourTeamText).isDisplayed())
				return true;
		else
			return false;
	}
}
