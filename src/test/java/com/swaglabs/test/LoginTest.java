package com.swaglabs.test;

import com.swaglabs.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.swaglabs.helpers.TestHelper;
import com.swaglabs.pages.Loginpage;


public class LoginTest extends TestHelper {
    @BeforeMethod
    public void loginFirst() {
        Loginpage loginpage = new Loginpage(driver);
        loginpage.login("standard_user", "secret_sauce");
    }
    @Test
    public void verifyLogInWithValidData() {
        Loginpage loginpage = new Loginpage(driver);
        ProductsPage productsPage = new ProductsPage(driver);

        loginpage.login("standard_user", "secret_sauce");
        String actualHeader = productsPage.getProductPageTitle();
        verifyEquals(actualHeader, "PRODUCTS", "After logg in page header not matched");
    }

}
