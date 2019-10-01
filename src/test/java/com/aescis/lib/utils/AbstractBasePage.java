package com.aescis.lib.utils;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractBasePage extends WebElementHelperMethods
{
	private final static Logger Log = Logger.getLogger(AbstractBasePage.class.getName());

	protected AbstractBasePage(final WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}

	/** Get element text or attribute value
	 * @param isAccept */
	protected String getElementText(final WebElement element)
	{
		waitForVisible(element);
		final String buttonText = element.getAttribute("value");
		return !buttonText.equals("") ? buttonText : element.getText();
	}

	/**
	 * Returns the value of the color attribute for that element
	 * @param colorAttribute = "color" or "background-color"
	 */
	protected String getElementColor(final WebElement element, final String colorAttribute)
	{
		waitForVisible(element);
		return element.getCssValue(colorAttribute);
	}

	/**
	 * Returns the value of the attribute for that element
	 * @param attribute = "class", "id" etc.
	 */
	protected String getElementAttribute(final WebElement element, final String attribute)
	{
		return element.getAttribute(attribute);
	}
}
