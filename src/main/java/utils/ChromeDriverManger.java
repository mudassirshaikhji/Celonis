package utils;

import java.io.File;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManger extends DriverManager {

	@Override
	protected void createWebDriver() {
		
		
		//ChromeOptions options = new ChromeOptions();
		setUp();
		this.driver = new ChromeDriver();
		
	}
	
	private void setUp() {
		 String chromeDriverPath = new File("src/test/resources").getAbsolutePath()+ "\\" + "chromedriver.exe";
		 System.setProperty("webdriver.chrome.driver", chromeDriverPath);
	}

}
