package com.aescis.stepdefinition.SparkStagingCSR;

import com.aescis.lib.WebDriverActions;
import com.aescis.lib.helper.ScumberException;
import com.aescis.page.functions.spark.AccountsPageObject;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AccountsPageSD {
    private AccountsPageObject accountPageObject;
    private WebDriver itsDriver;

    @Before
    public void before(final Scenario scenario) throws ScumberException {
        itsDriver = WebDriverActions.openBrowser(scenario);
        accountPageObject = PageFactory.initElements(itsDriver, AccountsPageObject.class);
    }

    @When("^search for account number \"([^\"]*)\"$")
    public void searchAccountNumber(String accountNumber) {
        accountPageObject.searchForAccountNumber(accountNumber);
    }

    @Then("^verify account searched is displayed$")
    public void verifyAccountSearchedIsDisplayed() {
        accountPageObject.verifyAccountsSection();
    }

    @When("^click on utility accounts tab in accounts section$")
    public void accountsUtilityTab() {
        accountPageObject.clickAccountUtilityTab();
    }

    @Then("^verify utility accounts tab opened$")
    public void verifyUtilityAccountsTabSection() {
        accountPageObject.verifyUtilityAccountsSection();
    }

    @When("^click on transaction history button$")
    public void clickTransactionHistory() {
        accountPageObject.clickTransactionHistoryIcon();
    }

    @When("^click on search button$")
    public void clickTransactionSearchButton() {
        accountPageObject.clickTransactionSearch();
    }

    @Then("^verify transaction history loaded$")
    public void verifyTransactionHistoryLoaded() {
        accountPageObject.verifyTransactionHistoryLoaded();
    }

    @When("^enter date range from date \"([^\"]*)\" and to date \"([^\"]*)\"$")
    public void enterTransactionSearchDateRange(String fromDate, String toDate) {
        accountPageObject.enterDateRange(fromDate, toDate);
    }

    @Then("^verify account number \"([^\"]*)\" searched is displayed$")
    public void verifyAccountNumberSearchedIsDisplayed(String accountNumber) {
        accountPageObject.verifyAccountNumberHeaderSection(accountNumber);
    }

    @When("^user click on communication log tab$")
    public void clickOnCommunicationLogTab() {
        accountPageObject.clickCommunicationLogTab();
    }

    @When("^user clicks on edit button on first row of communication log$")
    public void clickCommunicationLogEditButton() {
        accountPageObject.clickEditCommunicationLogFirstItem();
    }

    @Then("^communication log grid row become editable$")
    public void verifyCommunicationLogRowIsEditable() {
        accountPageObject.verifyEditableCommunicationLogRow();
    }

    @When("^change the priority field value and save$")
    public void change_the_priority_field_value_and_save() {
        accountPageObject.selectPriorityValueAndSave();
    }

    @Then("^priority entry should be changed successfully$")
    public void priority_entry_should_be_changed_successfully() {
        accountPageObject.verifyEditedCommunicationLogSaved();
    }
}
