package com.aescis.lib.utils;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashSet;
import java.util.List;
import java.util.logging.Logger;

public class WebElementCheck extends WebElementWait
{
	private final static Logger Log = Logger.getLogger(WebElementCheck.class.getName());

	public WebElementCheck(final WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/** @param element - web element
	* @param valueToCheck - text to check
	*/
	public boolean checkTextToBePresentInElement(final WebElement element, final String valueToCheck)
	{
		final WebDriverWait itsWait = new WebDriverWait(itsDriver, 30);
		return itsWait.until(ExpectedConditions.textToBePresentInElement(element, valueToCheck)).booleanValue();
	}

	/**This method will assert/check for true output of a condition
	 * @param message - message when the output of condition is false
	 * @param conditionToCheck - condition to evaluate
	 */
	protected void assertCheckIfTrue(final String message, final boolean conditionToCheck)
	{
		Assert.assertTrue(message, conditionToCheck);
	}

	/**
	 * This method will assert/check for false output of a condition
	 * @param message - message when the output of condition is true
	 * @param conditionToCheck - condition to evaluate
	 */
	public void assertCheckIfNotNull(final String message, final boolean conditionToCheck)
	{
		Assert.assertNotNull(message, conditionToCheck);
	}

	/**
	 * This method will assert/check for false output of a condition
	 *
	 * @param message - message when the output of condition is true
	 * @param conditionToCheck - condition to evaluate
	 */
	protected void assertCheckIfFalse(final String message, final boolean conditionToCheck)
	{
		Assert.assertFalse(message, conditionToCheck);
	}

	/**
	 * This method will go through all the texts of the elements to check is a text is present
	 *
	 * @param listOfElements - list of Elements
	 * @param textToCheck - value that needs to be replaced from xpath
	 */
	protected void checkIfTextOfAnElementIsPresentInAList(
			final List<WebElement> listOfElements,
			final String textToCheck)
	{
		final HashSet<String> textFromElements = new HashSet<String>();

		for (final WebElement element : listOfElements)
		{
			textFromElements.add(element.getText().trim());
		}

		assertCheckIfTrue(String.format("FAIL: value '%s' is not present in the list : %s ", textToCheck,
				textFromElements), textFromElements.contains(textToCheck));
	}

	/**
	 * This method checks if the object is not null
	 * @param message - message if the object is NULL
	 * @param objectToCheckNotNull - an Object to check
	 */
	protected void assertCheckIfNotNull(final String message, final Object objectToCheckNotNull)
	{
		Assert.assertNotNull(message, objectToCheckNotNull);
	}

	/**
	 * This method will go through all the texts of the elements to check is a text is NOT present
	 * @param listOfElements - list of Elements
	 * @param textToCheck - value that needs to be replaced from xpath
	 */
	public void checkIfTextOfAnElementIsNotPresentInAList(
			final List<WebElement> listOfElements,
			final String textToCheck)
	{
		final HashSet<String> textFromElements = new HashSet<String>();

		for (final WebElement element : listOfElements)
		{
			textFromElements.add(element.getText().trim());
		}

		assertCheckIfFalse(String.format("FAIL: value '%s' is present in the list : %s ", textToCheck,
				textFromElements), textFromElements.contains(textToCheck));
	}

	/**
	 * @param message
	 */
	public void assertFail(final String message)
	{
		Assert.fail(message);
	}

	/**Check if element is visible or not
	 * @param webElement
	 * @param message
	 */
	public void assertElementIsVisible(final WebElement webElement, final String message)
	{
		waitForVisible(webElement);
		Assert.assertTrue(message, webElement.isDisplayed());
	}

	/**Check if element is visible or not
	 * @param webElement
	 * @param message
	 */
	public void assertElementIsNotVisible(final WebElement webElement, final By locator, final String message)
	{
		waitForNotVisible(locator);
		assertElementIsNotVisible(webElement, message);
	}

	/**Check if text is present for selected object
	 * @param webElement
	 * @param message
	 * @param text
	 */
	public void assertTextIsVisible(final WebElement webElement, final String message, final String text)
	{
		waitForVisible(webElement);
		final String elementText = webElement.getText();
		Assert.assertTrue(message + elementText, elementText.contains(text));
	}

	/**Check count of objects
	 * @param webElements
	 * @param message
	 * @param expectedCount
	 */
	public void assertCountOfElements(final List<WebElement> webElements, final String message, final int expectedCount)
	{
		final int count = webElements.size();
		Assert.assertEquals(message, expectedCount, count);
	}
	
	/**Check if element is not
	 * @param webElement
	 * @param message
	 */
	public void assertElementIsNotVisible(final WebElement webElement, final String message)
	{
		try {
			Assert.assertFalse(message, webElement.isDisplayed());
		} catch (NoSuchElementException e) {
			Assert.assertFalse(message, false);
		}
	}

	/**Check if element is not checked
	 * @param webElement
	 */
	public void assertElementIsNotChecked(final WebElement webElement) {
		Assert.assertFalse(webElement.isSelected());
	}
}
