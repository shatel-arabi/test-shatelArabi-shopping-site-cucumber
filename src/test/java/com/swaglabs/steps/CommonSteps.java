package com.swaglabs.steps;

import com.swaglabs.helpers.DriverUtils;
import com.swaglabs.pages.Loginpage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class CommonSteps {
    public static WebDriver driver;
  //  public Loginpage loginpage = new Loginpage(driver);

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
//    @Given("I login on the page first")
//    public void i_login_on_the_page_first() {
//        loginpage.usernameInput("standard_user");
//        loginpage.passwordInput("secret_sauce");
//        loginpage.clickOnLogInButton();
//    }
    public static WebDriver getDriver() {
        return driver;
    }
}
