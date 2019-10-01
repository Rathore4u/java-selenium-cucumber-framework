package com.aescis.page.locators.spark;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AccountsLocators {
    @Autowired
    public AccountsLocators(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "tbQuickSearch")
    public WebElement searchTextBox;

    @FindBy(css = "button[onClick*='QuickSearch']")
    public WebElement accountSearchIcon;

    @FindBy(xpath = "//h2[contains(text(),'002532166')]")
    public WebElement accountsSection;

    @FindBy(xpath = "//a[contains(text(),'Utility Accounts')]")
    public WebElement accountsUtilityTab;

    @FindBy(xpath = "//legend[contains(text(),'Address Fragment')]")
    public WebElement addressFragmentSection;

    @FindBy(css = "a[id*='aTransactionHistory']")
    public WebElement transactionHistoryIcon;

    @FindBy(css = ".blockOverlay")
    public WebElement loadingOverlay;

    @FindBy(css = "input[name*='tbDateFrom']")
    public WebElement transactionFromDate;

    @FindBy(css = "input[name*='tbDateTo']")
    public WebElement transactionToDate;

    @FindBy(css = "input[id*='ucTransactionHistory_ibSearch']")
    public WebElement searchButtonInTransactionSearch;

    @FindBys(@FindBy(css = "div[id*='ucTransactionHistory_upTH'] tr"))
    public List<WebElement> transactionHistorySearchResult;

    @FindBy(xpath = "//a[contains(text(),'Communication Log')]")
    public WebElement communicationLogTab;

    @FindBys(@FindBy(id = "ibEditNote"))
    public List<WebElement> editCommunicationLog;

    @FindBy(css = "img[id*='ibSave'][src*='save.gif']")
    public WebElement saveCommunicationLogEditField;

    public By loadingWaitOverlay() {
        return By.cssSelector(".blockOverlay");
    }

    public WebElement accountSectionHeader(WebDriver itsDriver, String accountNumber) {
        String xpath = String.format("//h2[contains(text(),\"%s\")]", accountNumber);
        return itsDriver.findElement(By.xpath(xpath));
    }

    @FindBy(css = "[id*=ddlPriority]")
    public WebElement priorityEditDropDown;

    @FindBy(css = "[id*=ddlPriority] option[selected]")
    public WebElement prioritySelectedOption;

    public By saveIconInCommunicationLogSection() {
        return By.cssSelector("img[id*='ibSave'][src*='save.gif']");
    }
}
