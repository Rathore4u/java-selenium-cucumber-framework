package com.aescis.page.functions;

import com.aescis.lib.helper.PropertiesLoader;
import com.aescis.lib.utils.AbstractBasePage;
import com.aescis.page.locators.RatingPageLocators;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Properties;

public class RatingPageObject extends AbstractBasePage {

	final RatingPageLocators ratingPageLocators;

	@Autowired
	public RatingPageObject(final WebDriver driver) {
		super(driver);
		ratingPageLocators = PageFactory.initElements(driver, RatingPageLocators.class);
	}

	public Properties testProps() {
		return PropertiesLoader.getInstance().load("message.properties");
	}

	public void verifyRatingPageLoaded() {
		waitForVisible(ratingPageLocators.ratingCodeSearchBox);
		this.verifyRatingTextAreaOpen();
	}

	public void verifyRatingTextAreaOpen() {
		assertElementIsVisible(ratingPageLocators.ratingCodeSearchBox,
				testProps().getProperty("ratingPage.verification"));
	}

	public void clickSearchButton() {
		waitUntilElementIsClickable(ratingPageLocators.ratingPageSearchButton);
		clickElement(ratingPageLocators.ratingPageSearchButton);
	}

	public void enterSearchField(String value) {
		typeEditBox(ratingPageLocators.ratingCodeSearchBox, value);
	}

	public void verifyNoSearchResults() {
		waitForVisible(ratingPageLocators.ratingPageSearchResultArea);
	}

	public void verifySearchResultsStartingWith(String value) {
		boolean flag = false;
		for (int i = 0; i < ratingPageLocators.ratingPageSearchResultRows.size(); i++) {
			WebElement currentRowElement = ratingPageLocators.ratingPageSearchResultRows.get(i);
			String text = currentRowElement.getText();
			if (!text.isEmpty()) {
				flag = text.toLowerCase().startsWith(value.toLowerCase());
				Assert.assertTrue(flag);
			}
		}
	}
}
