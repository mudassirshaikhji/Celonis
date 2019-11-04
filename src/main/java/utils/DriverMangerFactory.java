package utils;

public class DriverMangerFactory {


	public static DriverManager getDriverManager(DriverType type) {
		
		switch(type) {
			case CHROME: return new ChromeDriverManger();
			case FIREFOX: return new FirefoxDriverManger();
			case IE: return new IEDriverManager();
			default: return new ChromeDriverManger();
		
	}
  }
}
