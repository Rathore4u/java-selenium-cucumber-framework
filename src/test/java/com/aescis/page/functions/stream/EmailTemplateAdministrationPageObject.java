package com.aescis.page.functions.stream;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Properties;

import com.aescis.lib.helper.PropertiesLoader;
import com.aescis.lib.utils.AbstractBasePage;
import com.aescis.page.locators.stream.EmailTemplateAdministrationLocators;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class EmailTemplateAdministrationPageObject extends AbstractBasePage {
    final EmailTemplateAdministrationLocators emailTemplateAdministrationLocators;

    @Autowired
    public EmailTemplateAdministrationPageObject(final WebDriver driver) {
        super(driver);
        emailTemplateAdministrationLocators = PageFactory.initElements(driver,
                EmailTemplateAdministrationLocators.class);
    }

    public Properties testProps() {
        return PropertiesLoader.getInstance().load("message.properties");
    }

    public void verifyEmailTemplateAdministrationPageDisplayed() {
        assertElementIsVisible(emailTemplateAdministrationLocators.emailTemplateAdministrationPageTitle,
                testProps().getProperty("emailTemplateAdministrationLocators.verification"));
    }

    public void clickAddEbillConfigurationButton() {
        clickElement(emailTemplateAdministrationLocators.addEbillConfigurationButton);
    }

    public void verifyAddEbillConfigurationSectionDisplayed() {
        assertElementIsVisible(emailTemplateAdministrationLocators.addConfigurationSection,
                testProps().getProperty("addConfigurationSection.verification"));
    }
    
    public void verifyAddEbillDefaultConfigurationSectionDisplayed() {
        assertElementIsVisible(emailTemplateAdministrationLocators.addConfigurationDefaultSection,
                testProps().getProperty("addConfigurationSection.verification"));
    }
    
    public void verifyAddEbillDefaultConfigurationSectionBecomesInvisible() {
        Boolean isVisible = true;
        try {
            isVisible = emailTemplateAdministrationLocators.addConfigurationDefaultSection.isDisplayed();
        } catch (NoSuchElementException e) {
            isVisible = false;
        }
        assertFalse(isVisible);
    }

    public void clickOnCancelButton() {
        clickElement(emailTemplateAdministrationLocators.cancelButton);
    }

    public void verifyAddEbillConfigurationSectionBecomesInvisible() {
        boolean isVisible = true;
        try {
            isVisible = emailTemplateAdministrationLocators.addConfigurationSection.isDisplayed();
        } catch (NoSuchElementException e) {
            isVisible = false;
        }
        assertFalse(isVisible);
    }
    
    public void cancelAddBillConfiguration() {
    	waitUntilElementIsClickable(emailTemplateAdministrationLocators.cancelAddBillConfiguration);
        clickElement(emailTemplateAdministrationLocators.cancelAddBillConfiguration);
    }
    
    public void verifyEbillEmailTemplate() {
    	waitForVisible(emailTemplateAdministrationLocators.ebillEmailTemplate);
    	assertElementIsVisible(emailTemplateAdministrationLocators.ebillEmailTemplate,
                testProps().getProperty("addConfigurationSection.verification"));
    }
}