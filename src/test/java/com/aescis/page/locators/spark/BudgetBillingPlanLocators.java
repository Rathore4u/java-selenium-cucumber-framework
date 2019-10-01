package com.aescis.page.locators.spark;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BudgetBillingPlanLocators {

    @Autowired
    public BudgetBillingPlanLocators(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "form[action*='BudgetBillingEdit']")
    public WebElement budgetBillingPlanForm;

    @FindBy(css = "span[id*='CustomerName']")
    public WebElement CustomerNameLabel;

    @FindBy(css = "span[id*='TrueUpType']")
    public WebElement trueUpType;

    @FindBy(css = "a[href*='BudgetBillingHistory']")
    public WebElement BudgetBillingHistoryTab;
}