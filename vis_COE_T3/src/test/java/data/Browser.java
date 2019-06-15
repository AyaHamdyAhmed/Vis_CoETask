package data;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browser {

	static WebDriver driver;
/**
 * takes browser name and configure browser drivers
 * **/
	public static void setBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if(browserName.equalsIgnoreCase("ie")){
			//set path to IE.exe
			System.setProperty("webdriver.ie.driver","src/test/resources/drivers/IEDriverServer.exe");
			//create IE instance
			driver = new InternetExplorerDriver();
		}
		else{
			//If no browser passed throw exception
			try {
				throw new Exception("Browser is not correct");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static WebDriver getBrowser() {
		//		System.out.println("getbrwoserrrrrrrrrrrrrrrrrrrrr");
		return driver;
	}
}
