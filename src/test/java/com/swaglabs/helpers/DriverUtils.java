package com.swaglabs.helpers;

import com.swaglabs.helpers.utils.Utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class DriverUtils {
    private static Logger logger = LogManager.getLogger(DriverUtils.class);

    public static WebDriver loadWebDriver() {
        String driverType = System.getProperty("DRIVER_TYPE");
        if (driverType == null) {
            logger.warn("Driver type was not set at run time, using default driver: {}", DriverType.CHROME.name());
            driverType = DriverType.CHROME.name();
        }
        logger.info("Driver Type from the run time system: {}", driverType);
        return loadWebDriver(DriverType.valueOf(driverType.toUpperCase()));
    }

    public static WebDriver loadWebDriver(DriverType driverType) {
        WebDriver webDriver = null;

        if (driverType.name().equalsIgnoreCase("chrome")) {
            //chrome
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();

        } else if (driverType.name().equalsIgnoreCase("edge") && System.getProperty("os.name").equals("Windows")) {
            //edge
            WebDriverManager.edgedriver().setup();
            webDriver = new EdgeDriver();

        } else if (driverType.name().equalsIgnoreCase("firefox")) {
            //firefox
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
        } else if (driverType.name().equalsIgnoreCase("safari") && System.getProperty("os.name").equals("Mac")) {
            //Safari
            WebDriverManager.safaridriver().setup();
            webDriver = new SafariDriver();
        }


        if (driverType == null) {
            webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.TIMEOUT_SECONDS_THIRTY));
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.TIMEOUT_SECONDS_TEN));
            webDriver.manage().window().maximize();
        } else {
            logger.error("Failed to load {} driver.", driverType);
        }

        return webDriver;
    }

    public static ChromeOptions chromeOptions() {
        Map<String, Object> chromePref = new HashMap<>();
        chromePref.put("download.default_directory", Utils.getSeleniumDefaultDownloadPath());

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePref);
        options.addArguments("disable-plugins");
        options.addArguments("disable-extensions");
        options.addArguments("disable-popup-blocking");
        options.addArguments("disable-infobars");
        options.addArguments("start-maximized");
        return options;
    }
}

