package com.swaglabs.pages;

import com.swaglabs.helpers.PageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends PageHelper {
	private By addedProductEle = By.className("inventory_item_name");
	private By quantityEle = By.className("cart_quantity_label");
	private By cartProductQuantityEle = By.className("cart_quantity");
	private By checkoutButtonEle = By.id("checkout");
	private By removeButtonEle = By.id("remove-sauce-labs-backpack");
	private By continueShoppingEle = By.id("continue-shopping");
	private By removedProductEle = By.xpath("//*[@class='removed_cart_item']");

	public CartPage(WebDriver driver) {
		super(driver);
	}

	public String getAddedProductName() {
		return getText(addedProductEle);
	}

	public String getQuantityText() {
		return getText(quantityEle);
	}

	public String getProductAmountText() {
		return getText(cartProductQuantityEle);
	}

	public void clickOnRemoveButton() {
		click(removeButtonEle);
	}

	public void clickOnContinueShopping() {
		click(continueShoppingEle);
	}

	public void clickOnCheckoutButton() {
		click(checkoutButtonEle);
	}

}
