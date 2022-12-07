package com.swaglabs.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Assert.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageHelper {

	public WebDriver driver;
	private JavascriptExecutor js;

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
		//driver.findElement(locator).click();
		new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_SECONDS_FIVE))
				.until(ExpectedConditions.elementToBeClickable(locator)).click();
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

	public Map<String, String> getStringMap(List<String> headerName, List<String> columnValue) {
		Map<String, String> map = new HashMap<>();

		if (headerName.size() == columnValue.size()) {
			for (int i = 0; i < headerName.size(); i++) {
				map.put(headerName.get(i), columnValue.get(i));
			}
		} else {
			Assert.fail("Failed to create map, header and column value size not matched.\nHeader Value: "
					+ headerName.size() + "\nRow Value: " + columnValue.size());
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
	 * Handle mouseover action using Actions moveToElement()
	 *
	 * @param locator
	 * @return
	 */
	public WebElement moveToElement(By locator) {
		WebElement element = driver.findElement(locator);
		new Actions(driver).moveToElement(element).build().perform();
		return element;
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
			// ignore
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
			new WebDriverWait(driver, Duration.ofSeconds(timeOutSec))
					.until(ExpectedConditions.numberOfWindowsToBe(expectedNumOfWin));
			List<String> windows = new ArrayList<>(driver.getWindowHandles());
			driver.switchTo().window(windows.get(switchToWindowIndex));
		} catch (Exception e) {
			Assert.fail("Unable to switch to window by index: [" + switchToWindowIndex + "]\n" + e.getMessage());
		}
	}

	/**
	 * JavascriptExecutor to interact with the browser elements. Use these instead
	 * of sendKeys(), click() if facing challenges to interact on special UI
	 * framework.
	 *
	 * @param elementId
	 * @param value
	 */
	public void jsExecutorEnterById(String elementId, String value) {
		js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementsById('" + elementId + "')[0].value='" + value + "'");
	}

	public void jsExecutorEnterByName(String elementName, String value) {
		js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementsByName('" + elementName + "')[0].value='" + value + "'");
	}

	public void jsExecutorClickById(String elementId) {
		if (driver.findElement(By.id(elementId)).isDisplayed()) {
			js = (JavascriptExecutor) driver;
			js.executeScript("document.getElementById('" + elementId + "').click();");
		}
	}

	public void jsExecutorClickByName(String elementName) {
		if (driver.findElement(By.name(elementName)).isDisplayed()) {
			js = (JavascriptExecutor) driver;
			js.executeScript("document.getElementByName('" + elementName + "').click();");
		}
	}

}
