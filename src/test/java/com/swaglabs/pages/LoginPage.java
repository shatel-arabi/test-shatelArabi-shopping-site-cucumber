package com.swaglabs.pages;

import com.swaglabs.helpers.PageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginpage extends PageHelper {
    // private final WebDriver driver;
    private By userNameEle = By.id("user-name");
    private By passWordEle = By.id("password");
    private By logInButtonEle = By.id("login-button");
    private By successMessageEle = By.xpath("//*[@class='title']");

    public Loginpage(WebDriver driver) {
        super(driver);
    }

    public void usernameInput(String username) {
        setField(userNameEle, username);
    }

    public void passwordInput(String password) {
        setField(passWordEle, password);
    }

    public void clickOnLogInButton() {
        click(logInButtonEle);
    }

    public String getSuccessMessageEle() {
        return getText(successMessageEle);
    }

    public boolean verifyLogInBtn() {
        return driver.findElement(logInButtonEle).isDisplayed();
    }

    public void login(String username, String password) {
        usernameInput(username);
        passwordInput(password);
        clickOnLogInButton();
    }

}
