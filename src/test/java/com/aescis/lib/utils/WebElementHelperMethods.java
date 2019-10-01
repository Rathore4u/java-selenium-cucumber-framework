package com.aescis.lib.utils;

import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class WebElementHelperMethods extends WebElementCheck {
	private final static Logger Log = Logger.getLogger(WebElementHelperMethods.class.getName());
	private final Actions action = new Actions(itsDriver);

	protected WebElementHelperMethods(final WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method will to move to element using the linktext attribute
	 * 
	 * @param linkText
	 */
	protected void moveToElementByLinkText(final String linkText) {
		final WebElement we = itsWait.until(ExpectedConditions.elementToBeClickable(By.linkText(linkText)));
		final String message = String.format("FAIL : Element with linktext '%s'", linkText);

		assertCheckIfNotNull(message, we);
		hoverOverElement(we);
	}

	/**
	 * Hovers over the specified element
	 * 
	 * @param we - webelement
	 */
	protected void hoverOverElement(final WebElement we) {
		final String message = String.format("FAIL : Element with these details is NULL : '%s'", we);
		assertCheckIfNotNull(message, we);
		action.moveToElement(we).build().perform();
	}

	/**
	 * This method will give the handle of the window
	 * 
	 * @param title - title of the window
	 */
	protected WebDriver getHandleToWindow(final String title) {
		WebDriver popup = null;
		final Set<String> windowIterator = itsDriver.getWindowHandles();
		Log.info("Total no of windows: " + windowIterator.size());

		for (final String window : windowIterator) {
			final String windowHandle = window;
			popup = itsDriver.switchTo().window(windowHandle);
			Log.info("Window Title: " + popup.getTitle() + " URL: " + popup.getCurrentUrl());

			if (popup.getTitle().contains(title)) {
				Log.info("Selected Window Title : " + popup.getTitle());
				return popup;
			}
		}
		final String popupTitle = popup != null ? popup.getTitle() : "<<Missing_Popup>>";
		Log.info("Window Title: " + popupTitle);
		return popup;
	}

	/**
	 * This method will find the parent of an element
	 * 
	 * @param element - webelement
	 * @param level   - level
	 */
	protected WebElement findParentElement(final WebElement element, final int level) {
		WebElement localElement = element;
		for (int i = 0; i < level; i++) {
			localElement = localElement.findElement(By.xpath(".."));
		}
		return localElement;
	}

	/**
	 * This method will take the xpath replace target string with replacement, find
	 * the element and then click on it
	 * 
	 * @param xpath       - xpath of webelement
	 * @param target      - value that needs to be replaced from xpath
	 * @param replacement - this value will be replaced by teh target in the xpath
	 */
	protected void clickOnElementAfterReplaceValueFromXpath(final String xpath, final String target,
			final String relacement) {
		clickOnElementFromXpath(xpath.replace(target, relacement));
	}

	/**
	 * This method will click on the element when the given text matches
	 * 
	 * @param listOfElements - list of Elements
	 * @param textToCheck    - value that needs to be replaced from xpath
	 */
	protected void clickOnElementWhenTextMatches(final List<WebElement> listOfElements, final String textToCheck) {
		boolean found = false;
		for (final WebElement element : listOfElements) {
			if (element.getText().trim().contains(textToCheck)) {
				element.click();
				found = true;
				break;
			}
		}
		if (found == false) {
			Assert.fail(String.format("FAIL : '%s' Button is not present ", textToCheck));
		}
	}

	/**
	 * This method is to click clear and then populate the provided string in an
	 * element
	 * 
	 * @param element        - webelement
	 * @param textToPopulate - value that needs to be replaced from xpath
	 */
	protected void clickClearSendkeys(final WebElement element, final String textToPopulate) {
		waitUntilElementIsClickable(element);
		waitUntilElementIsVisible(element);
		element.clear();
		element.sendKeys(textToPopulate);
	}

	/**
	 * This method clicks on the element when he given xpath
	 * 
	 * @param xpath - xpath
	 */
	protected void clickOnElementFromXpath(final String xpath) {
		itsDriver.findElement(By.xpath(xpath)).click();
	}

	/**
	 * This method will take the xpath replace target string with replacement, find
	 * the element and then return the element
	 * 
	 * @param xpath       - xpath of webelement
	 * @param target      - value that needs to be replaced from xpath
	 * @param replacement - this value will be replaced by teh target in the xpath
	 */
	protected WebElement getElementAfterReplaceValueFromXpath(final String xpath, final String target,
			final String replacement) throws NoSuchElementException {
		return itsDriver.findElement(By.xpath(xpath.replace(target, replacement)));
	}

	/**
	 * This method will click on webelement using javascript
	 * 
	 * @param element - webelement
	 */
	protected void clickUsingJavaScript(final WebElement element) {
		try {
			final JavascriptExecutor js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].click();", element);
		} catch (final Exception exception) {
			assertFail("Unable to click on element " + exception.getStackTrace());
		}
	}

	/**
	 * Type text value in textbox element
	 * 
	 * @param editBox
	 * @param valueToType
	 */
	protected void typeEditBox(final WebElement editBox, final String valueToType) {
		waitForVisible(editBox);
		editBox.clear();
		editBox.sendKeys(valueToType);
	}

	/**
	 * Select radio button for given element
	 * 
	 * @param rdoElement
	 * @throws Exception
	 */
	protected void selectRadioButton(final WebElement rdoElement) {
		waitForVisible(rdoElement);
		if (!rdoElement.isSelected()) {
			rdoElement.click();
		}
	}

	/**
	 * Select list option by visible option text in a drop down list
	 * 
	 * @param listDropDown
	 * @param optionText
	 */
	protected void selectListByVisibleText(final WebElement listElement, final String optionText) {
		waitForVisible(listElement);
		final Select selectList = new Select(listElement);
		Log.info("Select list option: " + optionText);
		selectList.selectByVisibleText(optionText);
	}

	/**
	 * Click on webelement
	 * 
	 * @param webElement
	 */
	protected void clickElement(final WebElement webElement) {
		waitForVisible(webElement);
		webElement.click();
	}

	/**
	 * Set "value" attribute of element with attribute "name"
	 * 
	 * @param name
	 * @param value
	 */
	protected void setValue(final String name, final String value) {
		((JavascriptExecutor) itsDriver)
				.executeScript("document.getElementsByName('" + name + "')[0].setAttribute('value', '" + value + "')");
	}

	/**
	 * Get "value" attribute of an element
	 * 
	 * @param webElement
	 * @return
	 */
	protected String getAttributeValue(final WebElement webElement) {
		return webElement.getAttribute("value");
	}

	/**
	 * Wait for alert and click "Accept" if flag is true, otherwise simply close it.
	 * 
	 * @param isAccept
	 */
	protected void waitAlertAndClose(final boolean isAccept) {
		new WebDriverWait(itsDriver, WAIT_TIMEOUT_DEFAULT).until(ExpectedConditions.alertIsPresent());
		final Alert alert = itsDriver.switchTo().alert();
		if (isAccept) {
			alert.accept();
		} else {
			alert.dismiss();
		}
	}

	/**
	 * Switch Handle to first Window opened.
	 */
	protected void setHandleToMainWindow() {
		Object[] nameOrHandle = itsDriver.getWindowHandles().toArray();
		String lastHandle = nameOrHandle[0].toString();
		itsDriver.switchTo().window(lastHandle);
	}

	/**
	 * Switch Handle to last Window opened.
	 */
	protected void setHandleToLastWindow() {
		Object[] nameOrHandle = itsDriver.getWindowHandles().toArray();
		String lastHandle = nameOrHandle[nameOrHandle.length - 1].toString();
		itsDriver.switchTo().window(lastHandle);
	}

	/**
	 * Select drop down
	 * 
	 * @param webElement
	 */
	protected void selectDropdownOption(final WebElement webElement, final String value) {
		waitForVisible(webElement);
		Select select = new Select(webElement);
		select.selectByVisibleText(value);
	}

	protected void pressKey(final WebElement target, Keys key) {
		waitForVisible(target);
		target.sendKeys(key);
	}

	protected void scrollToTheTop() {
		final JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
	}
}
