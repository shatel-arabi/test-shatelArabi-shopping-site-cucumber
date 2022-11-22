package com.swaglabs.test;

import com.swaglabs.helpers.TestHelper;
import com.swaglabs.pages.Loginpage;
import com.swaglabs.pages.ProductsPage;
import org.junit.Before;
import org.junit.Test;

public class LoginPageTest extends TestHelper {
    @Before
    public void loginFirst() {
        Loginpage loginpage = new Loginpage(driver);
        loginpage.login("standard_user", "secret_sauce");
    }

    @Test
    public void verifyLogin() {

        ProductsPage productsPage = new ProductsPage(driver);
        String actualHeader = productsPage.getProductPageTitle();
        verifyEquals("After logg in page header not matched", "PRODUCTS", actualHeader);
    }

    @Test
    public void verifyLogOut() {

        Loginpage loginpage = new Loginpage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.clickOnBurgerMenu();
        productsPage.clickOnLogOut();
        verifyTrue("After logged-out,Login button not showed",
                loginpage.verifyLogInBtn());
    }

}
