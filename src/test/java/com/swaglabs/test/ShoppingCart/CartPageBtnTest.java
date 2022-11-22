package com.swaglabs.test.ShoppingCart;

import com.swaglabs.helpers.TestHelper;
import com.swaglabs.pages.CartPage;
import com.swaglabs.pages.Loginpage;
import com.swaglabs.pages.ProductsPage;
import org.junit.Before;
import org.junit.Test;

public class CartPageBtnTest extends TestHelper {
    @Before
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
        verifyEquals("Item is not removed: ", expectedItemQTY, cartPage.verifyEmptyCart());
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
