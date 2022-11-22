package com.swaglabs.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.fail;

public class PageHelper {
    public WebDriver driver;

    public PageHelper(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * To clear and set a field
     *
     * @param locator
     * @param value
     */
    public void setField(By locator, String value) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

    /**
     * Wait for element to be clickable then click
     *
     * @param locator
     */
    public void click(By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_SECONDS_FIVE))
                .until(ExpectedConditions.elementToBeClickable(locator))
                .click();
    }

    /**
     * Get text and trim
     *
     * @param locator
     * @return
     */
    public String getText(By locator) {
        return driver.findElement(locator).getText().trim();
    }

    /**
     * Get list of strings
     *
     * @param locator
     * @return
     */
    public List<String> getStrings(By locator) {
        List<String> searchResultTextList = new ArrayList<>();
        List<WebElement> searchResults = driver.findElements(locator);
        for (WebElement searchResult : searchResults) {
            searchResultTextList.add(searchResult.getText().trim());
        }
        return searchResultTextList;
    }

    /**
     * Handle mouseover action using Actions moveToElement()
     *
     * @param locator
     * @return
     */
    public void moveToElement(By locator) {
        WebElement element = driver.findElement(locator);
        new Actions(driver).moveToElement(element).build().perform();

    }

    public Map<String, String> getStringMap(List<String> headerName, List<String> columnValue) {
        Map<String, String> map = new HashMap<>();

        if (headerName.size() == columnValue.size()) {
            for (int i = 0; i < headerName.size(); i++) {
                map.put(headerName.get(i), columnValue.get(i));
            }
        } else {
            fail("Failed to create map, header and column value size not matched.\nHeader Value: " + headerName.size() + "\nRow Value: " + columnValue.size());
        }
        return map;
    }

    /**
     * Set checkbox if not selected
     *
     * @param checkBox
     */
    public void setCheckbox(By checkBox) {
        WebElement webElement = driver.findElement(checkBox);
        if (!webElement.isSelected()) {
            webElement.click();
        }
    }

    /**
     * Set UI element attribute.
     *
     * @param element
     * @param attrName
     * @param contains
     * @param replace
     */
    public void setAttribute(WebElement element, String attrName, String contains, String replace) {
        if (element.getAttribute(attrName).contains(contains)) {
            element.getAttribute(attrName).replace(contains, replace);
        }
    }

    public void acceptBrowserAlert() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_SECONDS_FIVE));
            wait.until(ExpectedConditions.alertIsPresent()).accept();
            wait.until(ExpectedConditions.not(ExpectedConditions.alertIsPresent()));
        } catch (Exception e) {
            //ignore
        }
    }

    /**
     * Switching to new window by Window index. Zero based window index.
     *
     * @param timeOutSec
     * @param expectedNumOfWin
     * @param switchToWindowIndex
     */
    public void switchToWindowByIndex(int timeOutSec, int expectedNumOfWin, int switchToWindowIndex) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(timeOutSec)).until(ExpectedConditions.numberOfWindowsToBe(expectedNumOfWin));
            List<String> windows = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(windows.get(switchToWindowIndex));
        } catch (Exception e) {
            fail("Unable to switch to window by index: [" + switchToWindowIndex + "]\n" + e.getMessage());
        }
    }

}
