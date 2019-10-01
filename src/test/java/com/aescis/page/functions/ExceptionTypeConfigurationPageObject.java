package com.aescis.page.functions;

import java.util.Properties;

import com.aescis.lib.helper.PropertiesLoader;
import com.aescis.lib.utils.AbstractBasePage;
import com.aescis.page.locators.ExceptionTypeConfigurationLocators;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ExceptionTypeConfigurationPageObject extends AbstractBasePage {
    final ExceptionTypeConfigurationLocators exceptionTypeConfigurationLocators;

    @Autowired
    public ExceptionTypeConfigurationPageObject(final WebDriver driver) {
        super(driver);
        exceptionTypeConfigurationLocators = PageFactory.initElements(driver, ExceptionTypeConfigurationLocators.class);
    }

    public Properties testProps() {
        return PropertiesLoader.getInstance().load("message.properties");
    }

    public void verifyPageOpen() {
        waitForVisible(exceptionTypeConfigurationLocators.addValidationType);
        assertElementIsVisible(exceptionTypeConfigurationLocators.addValidationType,
                testProps().getProperty("exceptionTypeConfigurationPage.verification"));
    }

    public void clickAddValidationType() {
        clickElement(exceptionTypeConfigurationLocators.addValidationType);
    }

    public void verifyValidationRuleType() {
        assertElementIsVisible(exceptionTypeConfigurationLocators.validationRuleType,
                testProps().getProperty("exceptionTypeConfigurationPage.verification"));
    }

    public void clickCancelButton() {
        clickElement(exceptionTypeConfigurationLocators.cancelButton);
        waitForNotVisible(exceptionTypeConfigurationLocators.modalFrame());
    }

    public void clickOkButton() {
        clickElement(exceptionTypeConfigurationLocators.okButton);
        waitForNotVisible(exceptionTypeConfigurationLocators.modalFrame());
    }

    public void selectValidationTypeRule(String option) {
        selectListByVisibleText(exceptionTypeConfigurationLocators.validationRuleType, option);
    }

    public void selectRatePlanType(String option) {
        selectListByVisibleText(exceptionTypeConfigurationLocators.planType, option);
    }

    public void verifyValidationRuleEntered(String ruleName) {
        verifyValidationRule(ruleName, true);
    }

    public void verifyValidationRuleDeleted(String ruleName) {
        verifyValidationRule(ruleName, false);
    }

    private void verifyValidationRule(String ruleName, boolean expectedValue) {
        boolean flag = !expectedValue;
        for (WebElement currentRowElement : exceptionTypeConfigurationLocators.rulesGridNames) {
            String text = currentRowElement.getText();
            if (text.toLowerCase().trim().equals(ruleName.toLowerCase().trim())) {
                flag = expectedValue;
            }
        }
        Assert.assertTrue(flag);
    }

    public void clickRemoveRule(String ruleName) {
        for (int i = 0; i < exceptionTypeConfigurationLocators.rulesGridNames.size(); i++) {
            WebElement currentRowElement = exceptionTypeConfigurationLocators.rulesGridNames.get(i);
            String text = currentRowElement.getText();
            if (text.toLowerCase().trim().equals(ruleName.toLowerCase().trim())) {
                clickElement(exceptionTypeConfigurationLocators.removeButtons.get(i));
            }
        }
    }

    public void verifyConfirmPopup() {
        assertElementIsVisible(exceptionTypeConfigurationLocators.yesButton,
                testProps().getProperty("exceptionTypeConfigurationPage.verification"));
    }

    public void clickYesButton() {
        clickElement(exceptionTypeConfigurationLocators.yesButton);
        waitForNotVisible(exceptionTypeConfigurationLocators.modalConfirmation());
    }

    public void clickTestAllValidations() {
        clickElement(exceptionTypeConfigurationLocators.testAllValidations);
    }

    public void verifyInvoicePopup() {
        assertElementIsVisible(exceptionTypeConfigurationLocators.invoiceId,
                testProps().getProperty("exceptionTypeConfigurationPage.verification"));
    }

    public void enterInvoiceId(String id) {
        typeEditBox(exceptionTypeConfigurationLocators.invoiceId, id);
    }

    public void clickStartTests() {
        clickElement(exceptionTypeConfigurationLocators.startTests);
    }

    public void verifyValidationTestResults() {
        assertElementIsVisible(exceptionTypeConfigurationLocators.validationTestResults,
                testProps().getProperty("exceptionTypeConfigurationPage.verification"));
    }
}
