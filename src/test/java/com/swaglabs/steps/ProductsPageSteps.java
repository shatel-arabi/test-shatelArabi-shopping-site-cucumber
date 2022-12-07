package com.swaglabs.steps;

import com.swaglabs.pages.CartPage;
import com.swaglabs.pages.Loginpage;
import com.swaglabs.pages.ProductsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ProductsPageSteps {
    private Loginpage loginpage = new Loginpage(CommonSteps.getDriver());
    private ProductsPage productsPage = new ProductsPage(CommonSteps.getDriver());
    private CartPage cartPage = new CartPage(CommonSteps.getDriver());

    @Given("I log in the page first")
    public void I_log_in_the_page_first() {
        loginpage.usernameInput("standard_user");
        loginpage.passwordInput("secret_sauce");
        loginpage.clickOnLogInButton();

    }

    @Given("I click on Add to cart button")
    public void i_click_on_Add_to_cart_button() {
        productsPage.fleeceJktaddToCart();

    }

    @When("I click on shopping cart sign")
    public void i_click_on_shopping_cart_sign() {
        productsPage.clickCartIcon();
    }

    @Then("I see {string} item in cart page")
    public void i_see_page_Item(String expectedItemOne) {
        String actualItemOne = cartPage.getCartItemOne();
        Assert.assertEquals(expectedItemOne, actualItemOne, "Cart page not showing the added item:");

    }

    @Then("I see {string} remove button")
    public void I_see_remove_button(String expectedRemoveButton) {
        String actualRemoveButton = productsPage.fleeceJktRemove();
        Assert.assertEquals(expectedRemoveButton, actualRemoveButton, "After clicked on add to cart button, not showed remove button");

    }

    @Then("I see {string} added product quantity")
    public void I_see_added_product_quantity(String expectedCartItemNum) {
        String actualQuantity = productsPage.getCartIcon();
        Assert.assertEquals(expectedCartItemNum, actualQuantity, "After clicking add to cart, not show 1 item: ");

    }

}
