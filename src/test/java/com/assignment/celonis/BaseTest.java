package com.assignment.celonis;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import celonisPages.CelonisCloudHomePage;
import celonisPages.ForgotPasswordPage;
import celonisPages.OrderToCashPage;
import celonisPages.PurchaseToPayPage;
import celonisPages.ServiceNowTicketingPage;
import celonisPages.SignInPage;
import celonisPages.SignedOutPage;
import utils.DriverManager;
import utils.DriverMangerFactory;
import utils.DriverType;
import utils.Utilities;

public class BaseTest {

	 DriverManager driverManager;
	 WebDriver driver;
	 final String URL = Utilities.readProperties("url");
	 String username = Utilities.readProperties("username");
	 String password = Utilities.readProperties("password");
	 String invalidUsername = Utilities.readProperties("invalidUserName");
	 String invalidUpassword = Utilities.readProperties("invalidPassword");
	 String browser = Utilities.readProperties("browser");
	 SignInPage signIn;
	 CelonisCloudHomePage homePage;
	 ForgotPasswordPage forgotPasswordPage;
	 OrderToCashPage orderCashPage;
	 PurchaseToPayPage ptpPage;
	 ServiceNowTicketingPage sntPage;
	 SignedOutPage signedOutPage;
	
		
	@BeforeEach
	void setUp() {
		if(browser.equalsIgnoreCase("Chrome")) {
			driverManager = DriverMangerFactory.getDriverManager(DriverType.CHROME); 
		}else if(browser.equalsIgnoreCase("IE")) {
			driverManager = DriverMangerFactory.getDriverManager(DriverType.IE); 
		}else if(browser.equalsIgnoreCase("Firefox")) {
			driverManager = DriverMangerFactory.getDriverManager(DriverType.FIREFOX); 
		}else {
			driverManager = DriverMangerFactory.getDriverManager(DriverType.CHROME); 
		}
			
		
		driver = driverManager.getWebDriver();
		driver.get(URL);
	    driver.manage().window().maximize();
	    driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    signIn = new SignInPage(this.driver);
				
	}
		
	

	@AfterEach
	void tearDown() {
		driverManager.quitWebDriver();
	}
	
	
	
}
