package com.aescis.stepdefinition.IsgEnergyCSR;

import java.util.logging.Logger;

import com.aescis.lib.WebDriverActions;
import com.aescis.lib.helper.ScumberException;
import com.aescis.page.functions.HomePageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class IsgEnergyCSRHomePageSD {
    private final static Logger Log = Logger.getLogger(IsgEnergyCSRLoginSD.class.getName());
    private WebDriver itsDriver;
    private HomePageObject itsHomePage;
    
    public IsgEnergyCSRHomePageSD() {
        Log.info("Constructor: AepEnergyAppStepDefinition");
    }

    @Before
    public void before(final Scenario scenario) throws ScumberException {
        itsDriver = WebDriverActions.openBrowser(scenario);
        itsHomePage = PageFactory.initElements(itsDriver, HomePageObject.class);
    }

    @Then("^Then the main page is open$")
    public void verifyMainPAgeIsOpen() {
        itsHomePage.verifyHomePageOpen();
    }

    @When("^I navigate to Batch Print url \"([^\"]*)\"$")
    public void navigateToUrl(String url)  {
        itsDriver.get(url);
    }
}