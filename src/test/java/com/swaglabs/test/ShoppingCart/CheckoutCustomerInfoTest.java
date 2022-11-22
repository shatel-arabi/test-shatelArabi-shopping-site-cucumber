package com.swaglabs.test.ShoppingCart;

import com.swaglabs.helpers.TestHelper;
import com.swaglabs.pages.*;
import org.junit.Before;
import org.junit.Test;

public class CheckoutCustomerInfoTest extends TestHelper {
    @Before
    public void loginFirst() {
        Loginpage loginpage = new Loginpage(driver);
        loginpage.login("standard_user", "secret_sauce");
    }

    @Test
    public void verifyCheckoutOverviewPage() {
        String expectedProduct = "Sauce Labs Fleece Jacket";
        String expectedPaymentInfo = "SauceCard #31337";
        String expectedTotal = "Total: $53.99";
        String expectedSuccessMsg = "THANK YOU FOR YOUR ORDER";

        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutInfoPage checkoutInfoPage = new CheckoutInfoPage(driver);
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);


        productsPage.fleeceJktaddToCart();
        productsPage.clickCartIcon();
        cartPage.clickCheckoutBtn();
        checkoutInfoPage.inputFirstname("Testfirstname");
        checkoutInfoPage.inputLastname("testlastname");
        checkoutInfoPage.inputPostalCode("12345");
        checkoutInfoPage.clickContinueBtn();

        verifyEquals("Checkout overview page not showing the same product: ", checkoutOverviewPage.getCheckoutItemOne(), expectedProduct);
        verifyEquals("Payment infomation not matched: ", checkoutOverviewPage.getPaymentInfo(), expectedPaymentInfo);
        verifyEquals("Total ammount not matched: ", checkoutOverviewPage.getTotalAmount(), expectedTotal);
        checkoutOverviewPage.clickFinishBtn();

        verifyEquals("The order isn't completed: ", checkoutCompletePage.getSuccessMessage(), expectedSuccessMsg);

    }

}
