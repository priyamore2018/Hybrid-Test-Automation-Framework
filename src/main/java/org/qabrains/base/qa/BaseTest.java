package org.qabrains.base.qa;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.qabrains.config.qa.ConfigurationReader;

public class BaseTest {

	public static WebDriver driver;

	protected static void initialization() {
		
		Properties properties= ConfigurationReader.getConfig();
		String browser = properties.getProperty("browser");
		String url = properties.getProperty("url");

		if (browser.equals("chrome")) {
			//added below lines
			ChromeOptions co=new ChromeOptions();
			co.addArguments("--headless=new");
	        co.addArguments("--disable-gpu");
			
			driver = new ChromeDriver(co);
		}else if(browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();

	}

}
