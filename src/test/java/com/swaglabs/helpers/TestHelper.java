package com.swaglabs.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestHelper {

	private static Logger logger = LogManager.getLogger(TestHelper.class);

	public WebDriver driver;

	@BeforeTest
	public void setupDriver() {
		String url = EnvironmentUtils.getEnvironmentProperties("url");
		driver = DriverUtils.loadWebDriver();
		driver.get(url);

	}

	@AfterTest
	public void tearDownDriver() {
		if (driver != null) {
			driver.quit();
		}
	}

}
