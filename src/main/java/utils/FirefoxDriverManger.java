package utils;

import java.io.File;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManger extends DriverManager {

	@Override
	protected void createWebDriver() {
		
		this.setUp();
		this.driver = new FirefoxDriver();
		
	}

	//setup
	private void setUp() {
		 String firefoxDriverPath = new File("src/test/resources").getAbsolutePath()+ "\\" + "geckodriver.exe";
		 System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
	}
}
