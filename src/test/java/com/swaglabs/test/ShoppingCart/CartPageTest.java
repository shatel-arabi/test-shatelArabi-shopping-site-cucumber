package com.swaglabs.test.ShoppingCart;

import com.swaglabs.helpers.TestHelper;
import com.swaglabs.pages.CartPage;
import com.swaglabs.pages.Loginpage;
import com.swaglabs.pages.ProductsPage;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class CartPageTest extends TestHelper {
    @BeforeTest
    public void loginFirst() {
        Loginpage loginpage = new Loginpage(driver);
        loginpage.login("standard_user", "secret_sauce");
    }

    @Test
    public void verifyShoppingCart() {
        String expectedItemOne = "Sauce Labs Fleece Jacket";
        String expectedCartItemOneQTY = "1";
        String expectedContinueShoppingBtn = "CONTINUE SHOPPING";
        String expectedCheckOutBtn = "CHECKOUT";

        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);
        productsPage.fleeceJktaddToCart();
        productsPage.clickCartIcon();

        verifyEquals("Cart page not showing the added item:", expectedItemOne, cartPage.getCartItemOne());
        verifyEquals("Added item quantity is not matched:", expectedCartItemOneQTY, cartPage.getVerifyCartItemOneQTY());
        verifyEquals("Continue Shopping button not showing on cart page: ", expectedContinueShoppingBtn, cartPage.setContinueShoppingBtn());
        verifyEquals("Check-Out button not showing on cart page: ", expectedCheckOutBtn, cartPage.setCheckoutBtn());
    }

}