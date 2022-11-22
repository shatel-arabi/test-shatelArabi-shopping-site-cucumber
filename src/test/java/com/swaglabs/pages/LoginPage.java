package com.swaglabs.pages;

import com.swaglabs.helpers.PageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageHelper {

	private By userNameEle = By.id("user-name");
	private By loginButtonEle = By.id("login-button");
	private By passwordEle = By.id("password");

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void enterUsername(String username) {
		setField(userNameEle, username);
	}

	public void enterPassword(String password) {
		setField(passwordEle, password);
	}

	public void clickOnLoginButton() {
		click(loginButtonEle);
	}

	public void submitLogin(String userName, String password) {
		setField(userNameEle, userName);
		setField(passwordEle, password);
		click(loginButtonEle);
	}

}
