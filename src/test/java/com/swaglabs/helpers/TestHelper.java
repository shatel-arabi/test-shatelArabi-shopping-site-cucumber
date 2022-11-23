package com.swaglabs.helpers;

import com.swaglabs.helpers.utils.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
	public void verifyEquals(String message, String expected, String actual) {
		try {
			Assert.assertEquals(message, expected, actual);
		} catch (Error e) {
			//errorCollector.addError(e);
			Utils.takeScreenshot(driver);
			logger.error("Assert failed. See screenshot: {}", Constants.DEFAULT_DIRECTORY); //TODO add path

		}
	}
	public void verifyTrue(String message, Boolean condition) {
		try {
			Assert.assertTrue( condition,message);
		} catch (Error e) {
			//errorCollector.addError(e);
			//Utils.takeScreenshot(driver);
			logger.error("Assert failed. See screenshot: {}", Constants.DEFAULT_DIRECTORY); //TODO add path

		}
	}

}
