package com.aescis.stepdefinition.StreamStagingCSR;

import com.aescis.lib.WebDriverActions;
import com.aescis.lib.helper.ScumberException;
import com.aescis.page.functions.CustomerSummaryPageObject;
import com.aescis.page.functions.stream.AccountValidationPageObject;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

public class AccountValidationSD {
    private static final String accountValidationUrl = "/clients/sge/enrollment/creditandaccountvalidation.aspx";

    private WebDriver itsDriver;
    private AccountValidationPageObject accountValidationPageObject;

    @Before
    public void before(final Scenario scenario) throws ScumberException {
        itsDriver = WebDriverActions.openBrowser(scenario);
        accountValidationPageObject = PageFactory.initElements(itsDriver, AccountValidationPageObject.class);
    }

    @When("^user navigate to credit and account validation \"([^\"]*)\" url$")
    public void navigateToCreditAndAccountValidationUrl(String appUrl) {
        String url = appUrl.concat(accountValidationUrl);
        itsDriver.get(url);
    }

    @Then("^verify account validation page is displayed$")
    public void verifyAccountValidationPage() {
        accountValidationPageObject.verifyCreditAccountValidationPage();
    }

    @When("^user enter invalid values for account number$")
    public void enterInvalidValuesForAccountSearch() {
        accountValidationPageObject.enterAccountSearchFieldsWithInvalidValues();
    }

    @When("^click on validate SEP in account validation page$")
    public void clickValidateSEPButtonInAccountValidationPage() {
        accountValidationPageObject.clickValidateSEPButton();
    }

    @Then("^verify error message account number could not found$")
    public void verifyErrorMessageAccountNumberNotFound() {
        accountValidationPageObject.verifyErrorMessageOnInvalidAccountDetails();
    }
}