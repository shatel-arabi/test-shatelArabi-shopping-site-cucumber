package com.swaglabs.pages;

import com.swaglabs.helpers.PageHelper;
import com.swaglabs.helpers.model.Customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInfoPage extends PageHelper {

	private By firstNameFieldEle = By.name("firstName");
	private By lastNameFieldEle = By.name("lastName");
	private By zipCodeFieldEle = By.name("postalCode");
	private By continueButtonEle = By.id("continue");

	public CheckoutInfoPage(WebDriver driver) {
		super(driver);
	}

	public void enterFirstName(String firstName) {
		setField(firstNameFieldEle, firstName);
	}

	public void enterLastName(String lastName) {
		setField(lastNameFieldEle, lastName);
	}

	public void enterZipCode(String zipCode) {
		setField(zipCodeFieldEle, zipCode);
	}

	public void clickOnContinueButton() {
		click(continueButtonEle);
	}

	public void submitCustomerInformation(Customer customer) {
		enterFirstName(customer.getFirstName());
		enterLastName(customer.getLastName());
		enterZipCode(Customer.getZipCode());
		clickOnContinueButton();
	}

}
