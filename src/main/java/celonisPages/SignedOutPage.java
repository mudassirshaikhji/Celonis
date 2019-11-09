package celonisPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Utilities;

public class SignedOutPage {

	private WebDriver driver;
	private final long timeout = 15;
	private By verificationSignInToYourTeamText = By.xpath("//h1[contains(text(), 'Sign in to your team')]");
	
	public SignedOutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isSignInToYourTeamTextVisible() {
		Utilities.waitUntilVisibilityOfElementLocated(driver, verificationSignInToYourTeamText, timeout);
		if(driver.findElement(verificationSignInToYourTeamText).isDisplayed())
				return true;
		else
			return false;
	}
}
