package com.aescis.stepdefinition.StreamStagingCSR;

import java.util.logging.Logger;

import com.aescis.lib.WebDriverActions;
import com.aescis.lib.helper.ScumberException;
import com.aescis.page.functions.CustomerSummaryPageObject;
import com.aescis.page.functions.SearchPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StreamStagingSearchSD {
    private final static Logger Log = Logger.getLogger(StreamStagingSearchSD.class.getName());
    public static String budgetBilling;

    private WebDriver itsDriver;
    private SearchPageObject itsSearchPage;

    public StreamStagingSearchSD() {
        Log.info("Constructor: StreamStagingSearchSD");
    }

    @Before
    public void before(final Scenario scenario)
            throws ScumberException {
        itsDriver = WebDriverActions.openBrowser(scenario);
        itsSearchPage = PageFactory.initElements(itsDriver, SearchPageObject.class);
    }

    @When("^Enter PremiseZip as \"([^\"]*)\"$")
    public void enterPremiseZip(String premiseZip) {
        itsSearchPage.enterPremiseZip(premiseZip);
    }

    @When("^Enter AccountNo as \"([^\"]*)\"$")
    public void enterAccountNo(String accountNo) {
        itsSearchPage.enterAccountNo(accountNo);
    }

    @When("^Enter First Name as \"([^\"]*)\"$")
    public void enterFirstName(String firstName) {
        itsSearchPage.enterFirstName(firstName);
    }

    @When("^Enter Last Name as \"([^\"]*)\"$")
    public void enterLastName(String lastName) {
        itsSearchPage.enterLastName(lastName);
    }

    @When("^Click Search Button$")
    public void clickSearchButton() {
        itsSearchPage.clickSearchButton();
    }

    @Then("^Check Show Results$")
    public void verifyResultsDisplay() {
        itsSearchPage.verifyResultsDisplay();
    }

    @Then("^Verify Results for \"([^\"]*)\"$")
    public void verifyResultsInclude(String text) {
        itsSearchPage.verifyResultsInclude(text);
    }
}