package org.qabrains.config.qa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

	public static Properties getConfig() {

		Properties properties = new Properties();

		String path = "src/test/resources/config.properties";

		try {
			FileInputStream file = new FileInputStream(path);
			properties.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
}
