package com.swaglabs.pages;

import com.swaglabs.helpers.PageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends PageHelper {

	private By productNameEle = By.className("inventory_item_name");
	private By productPriceEle = By.className("inventory_item_price");
	private By productQuantityEle = By.className("cart_quantity");
	private By productTotalCostEle = By.className("summary_total_label");
	private By finishButtonEle = By.id("finish");

	public CheckoutOverviewPage(WebDriver driver) {
		super(driver);
	}

	public String getProductName() {
		return getText(productNameEle);
	}

	public String getProductPrice() {
		return getText(productPriceEle);
	}

	public String getProductQuantity() {
		return getText(productQuantityEle);
	}

	public String getTotalCost() {
		return getText(productTotalCostEle);
	}

	public void clickOnFinishButton() {
		click(finishButtonEle);
	}

}
