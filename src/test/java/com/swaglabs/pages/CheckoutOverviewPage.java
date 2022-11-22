package com.swaglabs.pages;

import com.swaglabs.helpers.PageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends PageHelper {
    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    private By checkoutItemOne = By.xpath("(//*[@class='inventory_item_name'])[1]");
    private By paymentInfo = By.xpath("(//*[@class='summary_value_label'])[1]");
    private By shippingInfo = By.xpath("(//*[@class='summary_value_label'])[2]");
    private By totalAmount = By.xpath("//*[@class='summary_total_label']");
    private By finishBtn = By.id("finish");

    public String getCheckoutItemOne() {
        return getText(checkoutItemOne);
    }

    public String getPaymentInfo() {
        return getText(paymentInfo);
    }

    public String getShippingInfo() {
        return getText(shippingInfo);
    }

    public String getTotalAmount() {
        return getText(totalAmount);
    }

    public void clickFinishBtn() {
        click(finishBtn);
    }


}
