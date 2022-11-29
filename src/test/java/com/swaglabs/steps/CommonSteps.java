package com.swaglabs.steps;

import com.swaglabs.helpers.DriverUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class CommonSteps {
    public static WebDriver driver;

    @Before
    public void setupDriver() {
        driver = DriverUtils.loadWebDriver();
    }


    @After
    public void tearDownDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("I am on swaglabs login page")
    public void i_am_on_swaglabs_login_page() {
        driver.get("https://www.saucedemo.com/");

    }

    public static WebDriver getDriver() {
        return driver;
    }
}
