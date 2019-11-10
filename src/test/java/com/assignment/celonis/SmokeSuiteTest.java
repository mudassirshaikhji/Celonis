package com.assignment.celonis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import utils.Utilities;

public class SmokeSuiteTest extends BaseTest {

	
	@Test
	@DisplayName("When trying to login with invalid credentials, show an appropriate error message")
	void loginUsingInvalidCredentials() {
		// Initialize
		final String expectedErrorMessage = "Email or password are incorrect.";
		final String screenshotName = "InvalidCredentials";
		// Stimulate
		signIn.loginInvalidCredentials(invalidUsername, invalidUpassword);
		String errorMessage = signIn.getErrorMessageInvalidLogin();
		Utilities.takeScreenShot(driver, screenshotName);
		// Assert
		assertEquals(expectedErrorMessage, errorMessage);
	}

	@Test
	@DisplayName("Log in successful with valid credentials")
	void successfulLogin() {
		// Initialize
		final String expectedToolTipText = "Mudassir Shaikhji";
		final String screenshotName = "ValidCredentials";
		// stimulate
		homePage = signIn.login(username, password);
		String avatarName = homePage.returnAvatarName();
		Utilities.takeScreenShot(driver, screenshotName);
		// Assert
		assertEquals(expectedToolTipText, avatarName);
	}

	@Test
	@DisplayName("Verifying that the forgot password page loads successfully")
	void checkIfForgotPasswordPageLoads() {
		// Initialize
		final String expectedToolTipText = "Forgot your password?";
		final String screenshotName = "ForgotYourPassword";
		// stimulate
		forgotPasswordPage = signIn.goTOForgotPasswordPage();
		String forgotPasswordText = forgotPasswordPage.pageLoadedString();
		Utilities.takeScreenShot(driver, screenshotName);
		// Assert
		assertEquals(expectedToolTipText, forgotPasswordText);
	}
	
	@Test
	@DisplayName("Verifying that the Order To Cash page successfully loads")
	public void checkIfOrderToCashPageLoads() {
		// Initialize
		final String expectedText = "Order-to-Cash Analysis";
		final String screenshotName = "OrderToCash";
		// stimulate
		homePage = signIn.login(username, password);
		orderCashPage = homePage.navigateToOrderToCashPage();
		String actualText = orderCashPage.returnOrderToCashAnalysisText();
		Utilities.takeScreenShot(driver, screenshotName);
		// Assert
		assertEquals(expectedText, actualText);
	}
	
	@Test
	@DisplayName("Verifying that the Purchase To Pay page successfully loads")
	void checkIfPurchaseToPayPageLoads() {
		// Initialize
		final String expectedText = "Purchase-to-Pay Analysis";
		final String screenshotName = "PurchaseToPay";
		// stimulate
		homePage = signIn.login(username, password);
		ptpPage = homePage.navigateToPurchaseToPayPage();
		String actualText = ptpPage.returnPurchaseToPayText();
		Utilities.takeScreenShot(driver, screenshotName);
		// Assert
		assertEquals(expectedText, actualText);
	}
	
	@Test
	@DisplayName("Verifying if the Service now Ticketing page successfully loads")
	void checkIfServiceNowTicketingPageLoads() {
		// Initialize
		final String expectedText = "INCIDENT MANAGEMENT (TICKET STATUS)";
		final String screenshotName = "ServiceNowTicketing";
		// stimulate
		homePage = signIn.login(username, password);
		sntPage = homePage.navigateToServiceNowTicketingPage();
		String actualText = sntPage.returnServiceNowTicketingText();
		Utilities.takeScreenShot(driver, screenshotName);
		// Assert
		assertEquals(expectedText, actualText);
	}
	
	@Test
	@DisplayName("User is able to sign out")
	void signOut() {
		// Initialize
		final String screenshotName = "signOut";
		// stimulate
		homePage = signIn.login(username, password);
		signedOutPage = homePage.signOut();
		boolean isTextVisible = signedOutPage.isSignInToYourTeamTextVisible();
		Utilities.takeScreenShot(driver, screenshotName);
		// Assert
		assertTrue(isTextVisible);		
	}
	
	@Test
	@DisplayName("Global search with input which does not return any result")
	void executeInvalidGlobalSearch() {
		// Initialize
		final String screenshotName = "InvalidGlobalSearch";
		final String expectedText = "No results found";
		final String searchText = "This search will not return any result";
		// stimulate
		homePage = signIn.login(username, password);
		homePage.executeGlobalSearch(searchText);
		String actualText = homePage.verifyNoResultsFoundText();
		Utilities.takeScreenShot(driver, screenshotName);
		// Assert
		assertEquals(expectedText, actualText);		
	}
	
	@Test
	@DisplayName("Global search with valid input which returns some result")
	void executeValidGlobalSearch() {
		// Initialize
		final String screenshotName = "ValidGlobalSearch";
		final String searchText = "ServiceNow Ticketing";
		final String expectedText = "--> " + searchText;
		// stimulate
		homePage = signIn.login(username, password);
		homePage.executeGlobalSearch(searchText);
		String actualText = homePage.verifyValidResult();
		Utilities.takeScreenShot(driver, screenshotName);
		// Assert
		assertEquals(expectedText, actualText);		
	}
	
}

