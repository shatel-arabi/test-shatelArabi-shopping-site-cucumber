package com.swaglabs.pages;

import com.swaglabs.helpers.PageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductViewPage extends PageHelper {

	private By addToCartEle = By.id("add-to-cart-sauce-labs-backpack");
	private By removeButtonEle = By.id("remove-sauce-labs-backpack");

	public ProductViewPage(WebDriver driver) {
		super(driver);
	}

	public void clickOnAddToCart() {
		click(addToCartEle);
	}

	public String getRemoveButtonText() {
		return getText(removeButtonEle);

	}
}
