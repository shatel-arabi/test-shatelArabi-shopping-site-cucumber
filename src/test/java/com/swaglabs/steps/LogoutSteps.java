package com.swaglabs.steps;

import com.swaglabs.pages.CartPage;
import com.swaglabs.pages.Loginpage;
import com.swaglabs.pages.ProductsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LogoutSteps {
    private Loginpage loginpage = new Loginpage(CommonSteps.getDriver());
    private ProductsPage productsPage = new ProductsPage(CommonSteps.getDriver());
    private CartPage cartPage = new CartPage(CommonSteps.getDriver());


    @Given("I login on the page first")
    public void i_login_on_the_page_first() {
        loginpage.usernameInput("standard_user");
        loginpage.passwordInput("secret_sauce");
        loginpage.clickOnLogInButton();
    }

    @Given("I click on burger menu")
    public void i_click_on_burger_menu() {
        productsPage.clickOnBurgerMenu();
    }

    @When("I click on logout button")
    public void i_click_on_logout_button() {
        productsPage.clickOnLogOut();
    }

    @Then("I see login button page")
    public void i_see_login_button_page() {
        Assert.assertTrue(loginpage.verifyLogInBtn(), "After logged-out,Login button not showed");

    }

}
