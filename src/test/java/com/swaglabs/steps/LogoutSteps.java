package com.swaglabs.steps;

import com.swaglabs.pages.CartPage;
import com.swaglabs.pages.Loginpage;
import com.swaglabs.pages.ProductsPage;

public class LogoutSteps {
    private Loginpage loginpage = new Loginpage(CommonSteps.getDriver());
    private ProductsPage productsPage = new ProductsPage(CommonSteps.getDriver());
    private CartPage cartPage = new CartPage(CommonSteps.getDriver());
}
