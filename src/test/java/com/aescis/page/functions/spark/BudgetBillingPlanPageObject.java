package com.aescis.page.functions.spark;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Properties;

import com.aescis.lib.helper.PropertiesLoader;
import com.aescis.lib.utils.AbstractBasePage;
import com.aescis.page.locators.spark.BudgetBillingPlanLocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BudgetBillingPlanPageObject extends AbstractBasePage {
    final BudgetBillingPlanLocators budgetBillingPlanLocators;

    @Autowired
    public BudgetBillingPlanPageObject(final WebDriver driver) {
        super(driver);
        budgetBillingPlanLocators = PageFactory.initElements(driver, BudgetBillingPlanLocators.class);
    }

    public Properties testProps() {
        return PropertiesLoader.getInstance().load("BudgetBillingPlanMessage.properties");
    }

    public void verifyBudgetBillingPageDisplayed() {
        waitForVisible(budgetBillingPlanLocators.budgetBillingPlanForm);
        assertElementIsVisible(budgetBillingPlanLocators.budgetBillingPlanForm,
                testProps().getProperty("BudgetBillingPlanPage.verification"));
    }

    public void verifyCustomerName(String customerName) {
        String text = budgetBillingPlanLocators.CustomerNameLabel.getText();
        assertTrue(text.contains(customerName));
    }

    public void verifyTrueUpTypeValue(String value) {
        String text = budgetBillingPlanLocators.trueUpType.getText();
        assertTrue(text.contains(value));
    }

    public void clickOnBudgetBillingHistoryTab() {
        clickElement(budgetBillingPlanLocators.BudgetBillingHistoryTab);
    }

    public void verifyBudgetBillingHistoryTabIsLoaded() {
        String status = budgetBillingPlanLocators.BudgetBillingHistoryTab.getAttribute("class");
        assertTrue(status.contains("active"));
    }
}