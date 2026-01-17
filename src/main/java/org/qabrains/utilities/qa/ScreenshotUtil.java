package org.qabrains.utilities.qa;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.qabrains.base.qa.BaseTest;

import com.google.common.io.Files;

public class ScreenshotUtil extends BaseTest {
	private static final String SCREENSHOT_PATH = "ScreenshotResult/";

	public static String captureScreenshot() {

		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String screenshotName = "Scenario_" + timestamp + ".png";

		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File(SCREENSHOT_PATH + screenshotName);
		
		try {
			Files.copy(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String finalPath = destFile.getAbsolutePath();
		return finalPath;
		
// File f1=new File("/Users/hrushi/Desktop/Priyanka/eclipse_workspace/QABrainsProject/ScreenshotResult/Scenario_20260101_000551.png");

	}

}
