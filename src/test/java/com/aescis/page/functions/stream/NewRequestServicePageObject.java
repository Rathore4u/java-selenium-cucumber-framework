package com.aescis.page.functions.stream;

import com.aescis.lib.helper.PropertiesLoader;
import com.aescis.lib.utils.AbstractBasePage;
import com.aescis.page.locators.stream.NewRequestServicePageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Properties;

public class NewRequestServicePageObject extends AbstractBasePage {
    private final NewRequestServicePageLocators newRequestServicePageLocators;

    @Autowired
    public NewRequestServicePageObject(final WebDriver driver) {
        super(driver);
        newRequestServicePageLocators = PageFactory.initElements(driver, NewRequestServicePageLocators.class);
    }

    private static Properties testProps() {
        return PropertiesLoader.getInstance().load("message.properties");
    }

    public void verifyCustomerEnrollmentPage() {
        assertElementIsVisible(newRequestServicePageLocators.enrollmentStatusLabel, testProps().getProperty("creditAndAccountValidationPage.verification"));
    }

    public void verifyServiceStateField(String selectedState) {
        assertElementIsVisible(newRequestServicePageLocators.serviceStateSelected(itsDriver, selectedState), testProps().getProperty("serviceStateSelected.verification"));
    }

    public void verifyPreferencesOptionsUnchecked() {
        assertElementIsNotChecked(newRequestServicePageLocators.emailCheckBox);
        assertElementIsNotChecked(newRequestServicePageLocators.mailCheckBox);
    }

    public void verifyNonDisplayOfEmailMandatorySymbol() {
        assertElementIsNotVisible(newRequestServicePageLocators.emailMandatorySymbol, testProps().getProperty("emailMandatorySymbol.verification"));
    }

    public void updateServiceStateValue(String stateValue) {
        selectDropdownOption(newRequestServicePageLocators.serviceStateDropDown, stateValue);
    }
}