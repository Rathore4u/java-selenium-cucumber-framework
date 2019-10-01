package com.aescis.page.functions;

import com.aescis.lib.helper.PropertiesLoader;
import com.aescis.lib.utils.AbstractBasePage;
import com.aescis.page.locators.HomePageLocators;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Properties;

public class HomePageObject extends AbstractBasePage {

    final HomePageLocators homePageLocators;

    @Autowired
    public HomePageObject(final WebDriver driver) {
        super(driver);
        homePageLocators = PageFactory.initElements(driver, HomePageLocators.class);
    }

    public Properties testProps() {
        return PropertiesLoader.getInstance().load("message.properties");
    }

    public void verifyHomePageOpen() {
        waitForVisible(homePageLocators.logoutButton);
        assertElementIsVisible(homePageLocators.logoutButton,  testProps().getProperty("homePage.verification"));
    }
    
    public void clickOnCustomerSearch() {
		clickElement(homePageLocators.customerSearch);
    }
    
    public void selectSearchDropdownValue(String valueToSelect) {
        selectListByVisibleText(homePageLocators.searchDropdown, valueToSelect);
    }

    public void enterValueInSearchTextbox(String text) {
        typeEditBox(homePageLocators.searchTextbox, text);
    }

    public void fromTopMenuSearchForSpecificCriteria(String textToSearch, String criteria) {
        this.selectSearchDropdownValue(criteria);
        this.enterValueInSearchTextbox(textToSearch);
        pressKey(homePageLocators.searchTextbox, Keys.ENTER);
    }
}
