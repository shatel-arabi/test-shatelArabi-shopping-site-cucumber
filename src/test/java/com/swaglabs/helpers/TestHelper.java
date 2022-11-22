package com.swaglabs.helpers;

import com.swaglabs.helpers.utils.Utils;
import com.swaglabs.pages.Loginpage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.*;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.WebDriver;


public class TestHelper {
    private static Logger logger = LogManager.getLogger(TestHelper.class);

    public static WebDriver driver;
    @Rule
    public ErrorCollector errorCollector = new ErrorCollector();

    @Before
    public void setupDriver() {
        String url = EnvironmentUtils.getEnvironmentProperties("url");
        driver = DriverUtils.loadWebDriver();
        //Loading website
        try {
            driver.get(url);
        } catch (Exception e) {
            Utils.takeScreenshot(driver);
            logger.error("Assert failed. See screenshot: {}", Constants.DEFAULT_DIRECTORY);
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void verifyEquals(String message, String expected, String actual) {
        try {
            Assert.assertEquals(message, expected, actual);
        } catch (Error e) {
            errorCollector.addError(e);
            Utils.takeScreenshot(driver);
            logger.error("Assert failed. See screenshot: {}", Constants.DEFAULT_DIRECTORY); //TODO add path

        }
    }


    public void verifyTrue(String message, Boolean condition) {
        try {
            Assert.assertTrue(message, condition);
        } catch (Error e) {
            errorCollector.addError(e);
            Utils.takeScreenshot(driver);
            logger.error("Assert failed. See screenshot: {}", Constants.DEFAULT_DIRECTORY); //TODO add path

        }
    }

    public void verifyNotTrue(String message, Boolean condition) {
        try {
            Assert.assertFalse(message, condition);
        } catch (Error e) {
            errorCollector.addError(e);
            Utils.takeScreenshot(driver);
            logger.error("Assert failed. See screenshot: {}", Constants.DEFAULT_DIRECTORY); //TODO add path

        }
    }

}
