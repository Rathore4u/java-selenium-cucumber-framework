package com.aescis.stepdefinition.StreamStagingCSR;

import java.util.logging.Logger;

import com.aescis.lib.WebDriverActions;
import com.aescis.lib.helper.ScumberException;
import com.aescis.page.functions.CustomerSummaryPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StreamStagingCallcenterSD {
    private final static Logger Log = Logger.getLogger(StreamStagingCallcenterSD.class.getName());
    private String budgetBilling;

    private WebDriver itsDriver;
    private CustomerSummaryPageObject itsCustomerSummaryPage;

    public StreamStagingCallcenterSD() {
        Log.info("Constructor: StreamStagingCallcenterSD");
    }

    @Before
    public void before(final Scenario scenario)
            throws ScumberException {
        itsDriver = WebDriverActions.openBrowser(scenario);
        itsCustomerSummaryPage = PageFactory.initElements(itsDriver, CustomerSummaryPageObject.class);
    }

    @Then("^Check Balance Table for \"([^\"]*)\"$")
    public void verifyBalanceHeader(String header) {
        itsCustomerSummaryPage.verifyBalanceHeader(header);
    }

    @When("^Note down the value \"([^\"]*)\"$")
    public void noteBudgetBilling(String header) {
        budgetBilling = itsCustomerSummaryPage.getBalanceDataFromHeader(header);
    }

    @When("^Click Calculator$")
    public void clickCalculator() {
        itsCustomerSummaryPage.clickCalculator();
    }

    @Then("^Verify Budget Billing Details Page$")
    public void verifyBudgetBillingDetailsTitle() {
        itsCustomerSummaryPage.verifyBudgetBillingDetailsTitle();
    }

    @Then("^Verify Customer Name is \"([^\"]*)\"$")
    public void verifyCustomerName(String customerName) {
        itsCustomerSummaryPage.verifyCustomerName(customerName);
    }

    @Then("^Verify the value Noted before$")
    public void verifyBudgetAmount() {
        itsCustomerSummaryPage.verifyBudgetAmount(budgetBilling);
    }
}