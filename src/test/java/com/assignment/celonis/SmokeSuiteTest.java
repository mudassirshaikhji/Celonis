package com.assignment.celonis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import celonisPages.CelonisCloudHomePage;
import celonisPages.ForgotPasswordPage;
import celonisPages.OrderToCashPage;
import celonisPages.PurchaseToPayPage;
import celonisPages.ServiceNowTicketingPage;
import celonisPages.SignInPage;
import celonisPages.SignedOutPage;
import utils.Utilities;

public class SmokeSuiteTest extends BaseTest {

	
	
	@Test
	@DisplayName("When trying to login with invalid credentials, show an appropriate error message")
	//@Disabled
	void loginUsingInvalidCredentials() {
		// Initialize
		final String expectedErrorMessage = "Email or password are incorrect.";
		final String screenshotName = "InvalidCredentials";
		// Stimulate
		signIn.loginInvalidCredentials(invalidUsername, invalidUpassword);
		String errorMessage = signIn.getErrorMessageInvalidLogin();
		Utilities.takeScreenShot(driver, screenshotName);
		// Assert or Verify
		assertEquals(expectedErrorMessage, errorMessage);
	}

	@Test
	@DisplayName("Log in successful with valid credentials")
	//@Disabled
	void successfulLogin() {
		// Initialize
		final String expectedToolTipText = "Mudassir Shaikhji";
		final String screenshotName = "ValidCredentials";
		// stimulate
		homePage = signIn.login(username, password);
		String avatarName = homePage.returnAvatarName();
		Utilities.takeScreenShot(driver, screenshotName);
		// Assert or verify
		assertEquals(expectedToolTipText, avatarName);
	}

	@Test
	@DisplayName("Verifying that the forgot password page loads successfully")
	//@Disabled
	void checkIfForgotPasswordPageLoads() {
		final String expectedToolTipText = "Forgot your password?";
		final String screenshotName = "ForgotYourPassword";
		forgotPasswordPage = signIn.goTOForgotPasswordPage();
		String forgotPasswordText = forgotPasswordPage.pageLoadedString();
		Utilities.takeScreenShot(driver, screenshotName);
		assertEquals(expectedToolTipText, forgotPasswordText);
	}
	
	@Test
	@DisplayName("Verifying that the Order To Cash page successfully loads")
	//@Disabled
	public void checkIfOrderToCashPageLoads() {
		final String expectedText = "Order-to-Cash Analysis";
		final String screenshotName = "OrderToCash";
		homePage = signIn.login(username, password);
		orderCashPage = homePage.navigateToOrderToCashPage();
		String actualText = orderCashPage.returnOrderToCashAnalysisText();
		Utilities.takeScreenShot(driver, screenshotName);
		assertEquals(expectedText, actualText);
	}
	
	@Test
	@DisplayName("Verifying that the Purchase To Pay page successfully loads")
	//@Disabled
	void checkIfPurchaseToPayPageLoads() {
		final String expectedText = "Purchase-to-Pay Analysis";
		final String screenshotName = "PurchaseToPay";
		homePage = signIn.login(username, password);
		ptpPage = homePage.navigateToPurchaseToPayPage();
		String actualText = ptpPage.returnPurchaseToPayText();
		Utilities.takeScreenShot(driver, screenshotName);
		assertEquals(expectedText, actualText);
	}
	
	@Test
	@DisplayName("Verifying if the Service now Ticketing page successfully loads")
	//@Disabled
	void checkIfServiceNowTicketingPageLoads() {
		final String expectedText = "INCIDENT MANAGEMENT (TICKET STATUS)";
		final String screenshotName = "ServiceNowTicketing";
		homePage = signIn.login(username, password);
		sntPage = homePage.navigateToServiceNowTicketingPage();
		String actualText = sntPage.returnServiceNowTicketingText();
		Utilities.takeScreenShot(driver, screenshotName);
		assertEquals(expectedText, actualText);
	}
	
//	@ParameterizedTest
//	@DisplayName("Verify that the user can successfully log out")
//	@ValueSource(strings = {"Chorme", "IE", "Firefox"})
//	@Disabled
	@Test
	void signOut() {
		final String screenshotName = "signOut";
		homePage = signIn.login(username, password);
		signedOutPage = homePage.signOut();
		boolean isTextVisible = signedOutPage.isSignInToYourTeamTextVisible();
		Utilities.takeScreenShot(driver, screenshotName);
		assertTrue(isTextVisible);		
	}
}