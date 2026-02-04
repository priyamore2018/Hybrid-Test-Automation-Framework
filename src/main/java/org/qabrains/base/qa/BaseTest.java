package org.qabrains.base.qa;
import java.util.Properties;

import org.openqa.selenium.Dimension;
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
			
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--headless=new");
	        options.addArguments("--no-sandbox");
	        options.addArguments("--disable-dev-shm-usage");
	        options.addArguments("--disable-gpu");
	        options.addArguments("--window-size=1920,1080");
	        options.addArguments("--start-maximized");
	        
			driver = new ChromeDriver(options);
			
			//driver = new ChromeDriver();
		}else if(browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().window().setSize(new Dimension(1920, 1080));


	}

}
