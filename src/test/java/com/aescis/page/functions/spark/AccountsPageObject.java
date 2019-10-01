package com.aescis.page.functions.spark;

import com.aescis.lib.helper.PropertiesLoader;
import com.aescis.lib.utils.AbstractBasePage;
import com.aescis.page.locators.spark.AccountsLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Properties;

public class AccountsPageObject extends AbstractBasePage {
    private final AccountsLocators accountsLocators;

    @Autowired
    public AccountsPageObject(final WebDriver driver) {
        super(driver);
        accountsLocators = PageFactory.initElements(driver, AccountsLocators.class);
    }

    static private Properties testProps() {
        return PropertiesLoader.getInstance().load("message.properties");
    }

    public void searchForAccountNumber(String accountNumber) {
        typeEditBox(accountsLocators.searchTextBox, accountNumber);
        clickElement(accountsLocators.accountSearchIcon);
    }

    public void verifyAccountsSection() {
        assertElementIsVisible(accountsLocators.accountsSection, testProps().getProperty("accountSection.verification"));
    }

    public void clickAccountUtilityTab() {
        clickElement(accountsLocators.accountsUtilityTab);
    }

    public void verifyUtilityAccountsSection() {
        assertElementIsVisible(accountsLocators.addressFragmentSection, testProps().getProperty("accountUtilitySection.verification"));
    }

    public void clickTransactionHistoryIcon() {
        hoverOverElement(accountsLocators.transactionHistoryIcon);
        clickElement(accountsLocators.transactionHistoryIcon);
        waitForVisible(accountsLocators.loadingOverlay);
        waitForNotVisible(accountsLocators.loadingWaitOverlay());
    }

    public void enterDateRange(String fromDate, String toDate) {
        typeEditBox(accountsLocators.transactionFromDate, fromDate);
        typeEditBox(accountsLocators.transactionToDate, toDate);
    }

    public void clickTransactionSearch() {
        clickElement(accountsLocators.searchButtonInTransactionSearch);
        waitForVisible(accountsLocators.loadingOverlay);
        waitForNotVisible(accountsLocators.loadingWaitOverlay());
    }

    public void verifyTransactionHistoryLoaded() {
        assertElementIsVisible(accountsLocators.transactionHistorySearchResult.get(2), testProps().getProperty("transactionHistorySection.verification"));
    }

    public void verifyAccountNumberHeaderSection(String accountNumber) {
        assertElementIsVisible(accountsLocators.accountSectionHeader(itsDriver, accountNumber), testProps().getProperty("accountSection.verification"));
    }

    public void clickCommunicationLogTab() {
        clickElement(accountsLocators.communicationLogTab);
    }

    public void clickEditCommunicationLogFirstItem() {
        clickElement(accountsLocators.editCommunicationLog.get(0));
        waitForVisible(accountsLocators.saveCommunicationLogEditField);
    }

    public void verifyEditableCommunicationLogRow() {
        assertElementIsVisible(accountsLocators.saveCommunicationLogEditField, testProps().getProperty("communicationLogEditSection.verification"));
    }

    public void selectPriorityValueAndSave() {
        if (accountsLocators.prioritySelectedOption.getText().contains("Low")) {
            selectDropdownOption(accountsLocators.priorityEditDropDown, "High");
        } else {
            selectDropdownOption(accountsLocators.priorityEditDropDown, "Low");
        }
        clickElement(accountsLocators.saveCommunicationLogEditField);
        waitForElementHidden(accountsLocators.saveIconInCommunicationLogSection());
    }

    public void verifyEditedCommunicationLogSaved() {
        assertElementIsNotVisible(accountsLocators.saveCommunicationLogEditField, testProps().getProperty("communicationLogEdited.verification"));
    }
}
