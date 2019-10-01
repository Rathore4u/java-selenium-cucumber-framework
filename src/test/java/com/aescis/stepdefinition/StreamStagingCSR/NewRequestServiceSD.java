package com.aescis.stepdefinition.StreamStagingCSR;

import com.aescis.lib.WebDriverActions;
import com.aescis.lib.helper.ScumberException;
import com.aescis.page.functions.stream.NewRequestServicePageObject;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class NewRequestServiceSD {
    private static final String newRequestServiceUl = "/Clients/SGE/Enrollment/EnrollCustomer.aspx";

    private WebDriver itsDriver;
    private NewRequestServicePageObject newRequestServicePageObject;

    @Before
    public void before(final Scenario scenario) throws ScumberException {
        itsDriver = WebDriverActions.openBrowser(scenario);
        newRequestServicePageObject = PageFactory.initElements(itsDriver, NewRequestServicePageObject.class);
    }

    @When("^user navigate to create new request service \"([^\"]*)\" url$")
    public void navigateToCreateNewRequestServiceUrl(String appUrl) {
        String url = appUrl.concat(newRequestServiceUl);
        itsDriver.get(url);
    }

    @Then("^customer Enrollment screen should be displayed$")
    public void verifyCustomerEnrollmentScreen() {
        newRequestServicePageObject.verifyCustomerEnrollmentPage();
    }

    @Then("^verify service state field is selected as \"([^\"]*)\" by default$")
    public void verifyServiceStateField(String stateValue) {
        newRequestServicePageObject.verifyServiceStateField(stateValue);
    }

    @Then("^verify preferences checkbox options are unchecked by default$")
    public void verifyPreferenceCheckBoxNotSelected() {
        newRequestServicePageObject.verifyPreferencesOptionsUnchecked();
    }

    @Then("^verify asterik sign is not displayed next to Email field$")
    public void verifyNonDisplayOfEmailMandatorySymbol() {
        newRequestServicePageObject.verifyNonDisplayOfEmailMandatorySymbol();
    }

    @When("^service state value is changed to \"([^\"]*)\"$")
    public void updateServiceStateValue(String stateName) {
        newRequestServicePageObject.updateServiceStateValue(stateName);
    }
}