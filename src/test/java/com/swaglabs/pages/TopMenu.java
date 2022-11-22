package com.swaglabs.pages;

import com.swaglabs.helpers.PageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopMenu extends PageHelper {
	private WebDriver driver;
	private By leftNavigationMenuEle = By.id("react-burger-menu-btn");
	private By signoutEle = By.id("logout_sidebar_link");
	private By shoppingCartBadgeEle = By.className("shopping_cart_badge");
	private By cartIconEle = By.className("shopping_cart_link");
	private By productPageHeaderEle = By.className("title");

	public TopMenu(WebDriver driver) {
		super(driver);
	}

	public void expandLeftNavigationMenu() {
		click(leftNavigationMenuEle);
	}

	public void clickOnSignout() {
		click(signoutEle);
	}

	public String getProductCountBadgeOnCartIconText() {
		return getText(shoppingCartBadgeEle);

	}

	public void clickOnCartIcon() {
		click(cartIconEle);
	}

	public String getProductPageHeaderText() {
		return getText(productPageHeaderEle);
	}
}
