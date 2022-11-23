package com.swaglabs.test.ShoppingCart;

import com.swaglabs.helpers.TestHelper;
import com.swaglabs.pages.CartPage;
import com.swaglabs.pages.Loginpage;
import com.swaglabs.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class CartPageBtnTest extends TestHelper {
    @BeforeMethod
    public void loginFirst() {
        Loginpage loginpage = new Loginpage(driver);
        loginpage.login("standard_user", "secret_sauce");
    }

    @Test
    public void verifyRemoveProductBtn() {
        String expectedItemQTY = "";
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);

        productsPage.fleeceJktaddToCart();
        productsPage.clickCartIcon();
        cartPage.clickRemoveOnCartPage();
        Assert.assertEquals("Item is not removed: ", expectedItemQTY, cartPage.verifyEmptyCart());
    }

    @Test
    public void verifyContinueShoppingBtn() {

        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);
        productsPage.fleeceJktaddToCart();
        productsPage.clickCartIcon();
        cartPage.clickContinueShoppingBtn();
        verifyEquals("Continue Shopping button isn't working on cart page: ", "PRODUCTS", productsPage.getProductPageTitle());

    }
}
