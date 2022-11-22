package com.swaglabs.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.swaglabs.helpers.TestHelper;
import com.swaglabs.pages.LoginPage;
import com.swaglabs.pages.TopMenu;

public class LoginTest extends TestHelper {

	@Test
	public void verifyLogInWithValidData() {
		LoginPage logInPage = new LoginPage(driver);
		TopMenu topMenu = new TopMenu(driver);

		logInPage.submitLogin("standard_user", "secret_sauce");
		String actualHeader = topMenu.getProductPageHeaderText();
		Assert.assertEquals( actualHeader, "PRODUCTS", "After logg in page header not matched");
	}

}
