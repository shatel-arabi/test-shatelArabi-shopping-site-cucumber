package com.swaglabs.pages;

import com.swaglabs.helpers.PageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends PageHelper {
    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }
    private By checkouSuccessMessage = By.xpath("//*[@class='complete-header']");

    public String getSuccessMessage(){
        return getText(checkouSuccessMessage);
    }
}
