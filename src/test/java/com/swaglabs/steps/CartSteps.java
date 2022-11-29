//package com.swaglabs.steps;
//
//import com.swaglabs.pages.CartPage;
//import com.swaglabs.pages.Loginpage;
//import com.swaglabs.pages.ProductsPage;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.testng.Assert;
//
//public class CartSteps {
//        private Loginpage loginpage = new Loginpage(CommonSteps.getDriver());
//    private ProductsPage productsPage = new ProductsPage(CommonSteps.getDriver());
//    private CartPage cartPage = new CartPage(CommonSteps.getDriver());
//
//    @Given("I log in the page first")
//    public void I_log_in_the_page_first() {
////        loginpage.login("standard_user","secret_sauce");
////        loginpage.clickOnLogInButton();
//        loginpage.usernameInput("standard_user");
//        loginpage.passwordInput("secret_sauce");
//        loginpage.clickOnLogInButton();}
//
//    @Given("I click on product's Add to cart button")
//    public void i_click_on_products_Add_to_cart_button() {
//        productsPage.fleeceJktaddToCart();
//
//    }
//
//    @When("I click on the shopping cart sign")
//    public void i_click_on_the_shopping_cart_sign() {
//        productsPage.clickCartIcon();
//    }
//
//    @Then("I see {string} item in cart page")
//    public void i_see_item_in_cart_page(String expectedproductName) {
//        // = "Sauce Labs Fleece Jacket";
//        String actualProduct = cartPage.getCartItemOne();
//        Assert.assertEquals(actualProduct, expectedproductName, "Cart page not showing the added item:");
//
//
//    }
//
//    @And("I see {string} continue shopping button")
//    public void i_see_continue_shopping_button(String expectedcontinueBtn) {
//      //  String expectedcontinueBtn = "CONTINUE SHOPPING";
//        String actualContinueBtn = cartPage.setContinueShoppingBtn();
//        Assert.assertEquals(actualContinueBtn, expectedcontinueBtn, "Continue Shopping button not showing on cart page:");
//
//    }
//
////    @And("I see {string} added product quantity")
////    public void i_see_added_product_quantity() {
////       // String expectedQuantity = "1";
////        String actualQuantity = cartPage.getVerifyCartItemOneQTY();
////        Assert.assertEquals(actualQuantity, expectedQuantity, "Added item quantity is not matched:");
////
////
////    }
//
//
//
//}
