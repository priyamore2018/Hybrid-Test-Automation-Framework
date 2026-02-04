package org.qabrains.hooks.qa;

import org.apache.logging.log4j.Logger;
import org.qabrains.base.qa.BaseTest;
import org.qabrains.listener.qa.ItestListen;
import org.qabrains.utilities.qa.LogUtil;
import org.qabrains.utilities.qa.ScreenshotUtil;

import com.aventstack.extentreports.Status;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class BrowserHooks extends BaseTest {

	public static Logger log = LogUtil.getLogger(BrowserHooks.class);

	@Before
	public static void setUp(Scenario scenario) throws InterruptedException {
		initialization();
		log.info("Browser Launch Sucessfully");
		Thread.sleep(2000);
	}

	@After
	public static void tearDown(Scenario scenario) {
		ItestListen itestListen = new ItestListen();

		if (scenario.getStatus().toString() == "FAILED") {
			String screenshotPath = ScreenshotUtil.captureScreenshot();
			log.info("Screenshot captured............");	
			if (screenshotPath != null) {
				itestListen.getTest().addScreenCaptureFromPath(screenshotPath);
			}
		}
		
		driver.quit();
		log.info("Browser closed Sucessfully");
	}

}
