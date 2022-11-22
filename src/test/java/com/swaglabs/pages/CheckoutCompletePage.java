package com.swaglabs.pages;

import com.swaglabs.helpers.PageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends PageHelper {

	private By checkoutCompletePageHeaderTextEle = By.className("complete-header");

	public CheckoutCompletePage(WebDriver driver) {
		super(driver);
	}

	public String getCheckoutCompletePageHeaderText() {
		return getText(checkoutCompletePageHeaderTextEle);
	}
}
