package com.swaglabs.test;

import com.swaglabs.helpers.TestHelper;
import com.swaglabs.pages.CartPage;
import com.swaglabs.pages.Loginpage;
import com.swaglabs.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class ProductPageTest extends TestHelper {
    @BeforeMethod
    public void loginFirst() {
        Loginpage loginpage = new Loginpage(driver);
        loginpage.login("standard_user", "secret_sauce");
    }

    @Test
    public void verifyAddToCart() {
        String expectedRemoveButton = "REMOVE";
        String expectedCartItemNum = "1";
        String expectedItemOne = "Sauce Labs Fleece Jacket";

        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);
        productsPage.fleeceJktaddToCart();
        productsPage.clickCartIcon();

        verifyEquals("After clicked on add to cart button, not showed remove button", expectedRemoveButton, productsPage.fleeceJktRemove());
        verifyEquals("After clicking add to cart, not show 1 item: ", productsPage.getCartIcon(), expectedCartItemNum);
        verifyEquals("Cart page not showing the added item:", expectedItemOne, cartPage.getCartItemOne());
    }


}
