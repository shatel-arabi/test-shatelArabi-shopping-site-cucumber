package com.swaglabs.pages;

import com.swaglabs.helpers.PageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends PageHelper {
    private By sideBurgerMenu = By.id("react-burger-menu-btn");
    private By sauceLabFleeceJacket = By.id("add-to-cart-sauce-labs-fleece-jacket");
    private By sauceLabFleeceJacketRemove = By.id("remove-sauce-labs-fleece-jacket");
    private By logOutButton = By.id("logout_sidebar_link");
    private By cartIcon = By.className("shopping_cart_badge");
    private By productPageTitle = By.xpath("//*[@class='title']");

    public ProductsPage(WebDriver driver) {super(driver);}
    public void clickOnBurgerMenu() {
        click(sideBurgerMenu);
    }

    public void clickOnLogOut() {
        click(logOutButton);
    }

    public void fleeceJktaddToCart() {
        click(sauceLabFleeceJacket);
    }

    public String fleeceJktRemove() {
        return getText(sauceLabFleeceJacketRemove);
    }
    public String getCartIcon() {
        return getText(cartIcon);
    }

    public void clickCartIcon() {
        click(cartIcon);
    }
    public String getProductPageTitle() {
        return getText(productPageTitle);
    }


}
