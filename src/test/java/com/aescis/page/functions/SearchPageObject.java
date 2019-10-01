package com.aescis.page.functions;

import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.aescis.lib.helper.PropertiesLoader;
import com.aescis.lib.utils.AbstractBasePage;
import com.aescis.page.locators.SearchPageLocators;

/**
 * <!--
 * ==========================================================================================================
 * --> This Class contains all method's specific to Login page of LLM
 * application
 * 
 * @lastrev fixXXXXX - new class <!--
 *          --------------------------------------------------------------------------------------------------------
 *          -->
 */
public class SearchPageObject extends AbstractBasePage {
    final SearchPageLocators searchPageLocators;

    @Autowired
    public SearchPageObject(final WebDriver driver) {
        super(driver);
        searchPageLocators = PageFactory.initElements(driver, SearchPageLocators.class);
    }

    public Properties testProps() {
        return PropertiesLoader.getInstance().load("message.properties");
    }

    public void enterPremiseZip(String premiseZip) {
        waitForVisible(searchPageLocators.premiseZip);
        typeEditBox(searchPageLocators.premiseZip, premiseZip);
    }

    public void enterAccountNo(String accountNo) {
        waitForVisible(searchPageLocators.accountNo);
        typeEditBox(searchPageLocators.accountNo, accountNo);
    }

    public void enterFirstName(String firstName) {
        typeEditBox(searchPageLocators.firstName, firstName);
    }

    public void enterLastName(String lastName) {
        typeEditBox(searchPageLocators.lastName, lastName);
    }

    public void clickSearchButton() {
        clickElement(searchPageLocators.searchButton);
    }

    public void verifyResultsDisplay() {
        assertElementIsVisible(searchPageLocators.results, testProps().getProperty("searchPage.verification"));
    }

    public void verifyResultsInclude(String text) {
        boolean flag = false;
        for (int i = 1; i < searchPageLocators.resultsData.size(); i++) {
            WebElement currentElement = searchPageLocators.resultsData.get(i);
            String elementText = currentElement.getText();
            if (elementText.toLowerCase().trim().startsWith(text.toLowerCase().trim())) {
                flag = true;
                break;
            }
        }
        Assert.assertTrue(flag);
    }
}