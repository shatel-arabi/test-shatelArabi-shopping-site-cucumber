package com.swaglabs.pages;

import com.swaglabs.helpers.PageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInfoPage extends PageHelper {

    public CheckoutInfoPage(WebDriver driver) {
        super(driver);
    }

    private By firstnameEle = By.id("first-name");
    private By lastnameEle = By.id("last-name");
    private By postalCodeEle = By.id("postal-code");
    private By continueBtn = By.id("continue");
    private By cancelBtn = By.id("cancel");

    public void inputFirstname(String firstname) {
        setField(firstnameEle, firstname);
    }

    public void inputLastname(String lastname) {
        setField(lastnameEle, lastname);
    }

    public void inputPostalCode(String postalCode) {
        setField(postalCodeEle, postalCode);
    }

    public void clickContinueBtn() {
        click(continueBtn);
    }

    public void clickCancelBtn() {
        click(cancelBtn);
    }


}
