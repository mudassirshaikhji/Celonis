package utils;

import java.io.File;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class IEDriverManager extends DriverManager {

	    @Override
		protected void createWebDriver() {
			
			this.setUp();
			InternetExplorerOptions options = new InternetExplorerOptions();
			options.introduceFlakinessByIgnoringSecurityDomains();
			
			this.driver = new InternetExplorerDriver(options);
			
		}

	    private void setUp() {
			 String ieDriverPath = new File("src/test/resources").getAbsolutePath()+ "\\" + "IEDriverServer_1.exe";
			 System.setProperty("webdriver.ie.driver", ieDriverPath);
		}
		
	

}
