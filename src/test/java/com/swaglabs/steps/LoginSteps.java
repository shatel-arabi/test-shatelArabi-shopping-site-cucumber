package com.swaglabs.steps;

import com.swaglabs.pages.Loginpage;
import com.swaglabs.pages.ProductsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginSteps {
    private Loginpage loginpage = new Loginpage(CommonSteps.getDriver());
    private ProductsPage productsPage = new ProductsPage(CommonSteps.getDriver());
    @Given("I enter {string} in username field")
    public void i_enter_in_username_field(String username) {

        loginpage.usernameInput(username);
    }

    @Given("I enter {string} in password field")
    public void i_enter_in_password_field(String password) {
        loginpage.passwordInput(password);
    }

    @When("I click on login button")
    public void I_click_on_login_button() {
        loginpage.clickOnLogInButton();
    }

    @Then("I see {string} page")
    public void i_see_Product_page(String expectedTitle) {
        String actualPageTitle = productsPage.getProductPageTitle();
        Assert.assertEquals(actualPageTitle,expectedTitle,"page title not matched");
    }


}
