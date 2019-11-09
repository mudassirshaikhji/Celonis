package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;

public class Utilities {

	public static void click(WebDriver driver, WebElement element, long timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
		element.click();
	}
	
	public static void click(WebDriver driver, By element, long timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(element));
		driver.findElement(element).click();
	}
	
	public static void sendKeys(WebDriver driver, WebElement element, long timeout, String keyToSend) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(keyToSend);
	}
	
	public static void sendKeys(WebDriver driver, By element, long timeout, String keyToSend) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(element));
		driver.findElement(element).sendKeys(keyToSend);
	}
	
	public static void takeScreenShot(WebDriver driver, String screenShotName) {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String fileName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
		try {
			FileUtils.copyFile(src, new File("screenshots/" + screenShotName + "_" + fileName+ ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String readProperties(String propertyToRead) {
		Properties property = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("src/test/resources/parameter.properties");
			property.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return property.getProperty(propertyToRead);
	}
	
	public static void waitUntilVisibilityOfElementLocated(WebDriver driver, By element, long timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	
	public static String getTextFromAWebElement(WebDriver driver, By element, long timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(element));
		return driver.findElement(element).getText();
	}

	public static void waitUntilPresenceOfElementLocated(WebDriver driver, By element, long timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(element));		
	}
}
