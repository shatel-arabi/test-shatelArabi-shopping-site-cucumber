package com.swaglabs.pages;

import com.swaglabs.helpers.PageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends PageHelper {
    private By verifyCartItemOne = By.xpath("(//*[@class='inventory_item_name'])[1]");
    private By sauceLabFleeceJacketRemove = By.id("remove-sauce-labs-fleece-jacket");
    private By cartItemOneQTY = By.xpath("//*[@class='cart_quantity']");
    private By emptyCartVerify = By.xpath("//*[@class='removed_cart_item']");
    private By checkoutBtn = By.id("checkout");
    private By continueShoppingBtn = By.xpath("//*[text()='Continue Shopping']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getCartItemOne() {
        return getText(verifyCartItemOne);
    }

    public void clickRemoveOnCartPage() {
        click(sauceLabFleeceJacketRemove);
    }

    public void clickContinueShoppingBtn() {
        click(continueShoppingBtn);
    }

    public String getRemoveBtn() {
        return getText(sauceLabFleeceJacketRemove);
    }

    public String getVerifyCartItemOneQTY() {
        return getText(cartItemOneQTY);
    }

    public boolean setVerifyCartItemOneQTY1() {

        return driver.findElement(cartItemOneQTY).isDisplayed();
    }

    public String verifyEmptyCart() {
        return getText(emptyCartVerify);
    }

    public String setContinueShoppingBtn() {
        return getText(continueShoppingBtn);
    }

    public String setCheckoutBtn() {
        return getText(checkoutBtn);
    }
    public void clickCheckoutBtn(){
        click(checkoutBtn);
    }

}
