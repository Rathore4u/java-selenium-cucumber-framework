package com.aescis.page.locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ExceptionTypeConfigurationLocators {
    @Autowired
    public ExceptionTypeConfigurationLocators(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[value='Add validation type']")
    public WebElement addValidationType;

    @FindBy(css = "input[value='Test all validations']")
    public WebElement testAllValidations;

    @FindBy(css = "input[value='Cancel']")
    public WebElement cancelButton;

    @FindBy(css = "input[value='Ok']")
    public WebElement okButton;

    @FindBy(css = "select[ng-model='form.ddlValidationType']")
    public WebElement validationRuleType;

    @FindBy(css = "select[ng-model='form.ddlPlanType']")
    public WebElement planType;

    @FindBys(@FindBy(xpath = "//table[@class='BasicGrid']//tr/td[2]"))
    public List<WebElement> rulesGridNames;

    @FindBys(@FindBy(css = "button[ng-click='itemRemove(item)']"))
    public List<WebElement> removeButtons;

    public By modalFrame() {
        return By.cssSelector("div.modal-body");
    }

    public By modalConfirmation() {
        return By.cssSelector("div#ModalConfirmation");
    }

    @FindBy(css = "input[value='Yes']")
    public WebElement yesButton;

    @FindBy(css = "input[ng-model='Invoiceid']")
    public WebElement invoiceId;

    @FindBy(css = "input[value='Start tests']")
    public WebElement startTests;

    @FindBy(css = "div#ModalValidationTest table.BasicGrid")
    public WebElement validationTestResults;
}
