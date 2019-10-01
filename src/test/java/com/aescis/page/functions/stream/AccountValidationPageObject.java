package com.aescis.page.functions.stream;

import com.aescis.lib.helper.PropertiesLoader;
import com.aescis.lib.utils.AbstractBasePage;
import com.aescis.page.locators.stream.AccountValidationPageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Properties;

public class AccountValidationPageObject extends AbstractBasePage {
    private final AccountValidationPageLocators accountValidationPageLocators;

    @Autowired
    public AccountValidationPageObject(final WebDriver driver) {
        super(driver);
        accountValidationPageLocators = PageFactory.initElements(driver, AccountValidationPageLocators.class);
    }

    private static Properties testProps() {
        return PropertiesLoader.getInstance().load("message.properties");
    }

    public void verifyCreditAccountValidationPage() {
        assertElementIsVisible(accountValidationPageLocators.buttonValidateSEP, testProps().getProperty("creditAndAccountValidationPage.verification"));
    }

    public void enterAccountSearchFieldsWithInvalidValues() {
        String testName = "test";
        String testPhoneNumber = "(111) 111-1111";
        String testNumber = "111111111";
        typeEditBox(accountValidationPageLocators.firstNameTextBox, testName);
        typeEditBox(accountValidationPageLocators.lastNameTextBox, testName);
        typeEditBox(accountValidationPageLocators.phoneNumberTextBox, testPhoneNumber);
        typeEditBox(accountValidationPageLocators.fullSSNText, testNumber);
        typeEditBox(accountValidationPageLocators.addressOneTextField, testName);
        typeEditBox(accountValidationPageLocators.addressTwoTextField, testName);
        typeEditBox(accountValidationPageLocators.cityTextField, testName);
        typeEditBox(accountValidationPageLocators.zipCodeOneTextField, testNumber);
        typeEditBox(accountValidationPageLocators.zipCodeTwoTextField, testNumber);
        typeEditBox(accountValidationPageLocators.aglcAccountTextBox, testNumber);
        typeEditBox(accountValidationPageLocators.sepTextBox, testNumber);
    }

    public void clickValidateSEPButton() {
        clickElement(accountValidationPageLocators.buttonValidateSEP);
    }

    public void verifyErrorMessageOnInvalidAccountDetails() {
        assertTextIsVisible(accountValidationPageLocators.accountValidationError,
                testProps().getProperty("accountValidationErrorMessage.verification"),
                "AGLC/SEP account number could not be found. Please change the data and try again.");
    }
}