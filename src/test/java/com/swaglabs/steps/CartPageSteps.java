package com.swaglabs.steps;

import com.swaglabs.pages.CartPage;
import com.swaglabs.pages.Loginpage;
import com.swaglabs.pages.ProductsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CartPageSteps {
    private Loginpage loginpage = new Loginpage(CommonSteps.getDriver());
    private ProductsPage productsPage = new ProductsPage(CommonSteps.getDriver());
    private CartPage cartPage = new CartPage(CommonSteps.getDriver());

    @Given("I log in on the page first")
    public void I_log_in_on_the_page_first() {
        loginpage.usernameInput("standard_user");
        loginpage.passwordInput("secret_sauce");
        loginpage.clickOnLogInButton();

    }

    @Given("I click on a product's Add to cart button")
    public void i_click_on_a_product_s_Add_to_cart_button() {
        productsPage.fleeceJktaddToCart();
    }

    @When("I click on the shopping cart sign")
    public void i_click_on_the_shopping_cart_sign() {
        productsPage.clickCartIcon();
    }


    @Then("I see added product in cart page")
    public void i_see_added_product_in_cart_page() {
        String actualProduct = cartPage.getCartItemOne();
        Assert.assertEquals(actualProduct, "Sauce Labs Fleece Jacket", "Cart page not showing the added item:");

    }


    @And("I see continue shopping button")
    public void i_see_continue_shopping_button() {
        Assert.assertEquals(cartPage.setContinueShoppingBtn(), "CONTINUE SHOPPING", "not found continue shoppping button");
    }

    @And("I see added product quantity")
    public void i_see_added_product_quantity() {
        Assert.assertEquals(cartPage.getVerifyCartItemOneQTY(), "1", "not found");
    }


}
