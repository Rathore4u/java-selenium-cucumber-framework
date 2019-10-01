package com.aescis.stepdefinition.AccentStagingCSR;

import com.aescis.lib.WebDriverActions;
import com.aescis.lib.helper.ScumberException;
import com.aescis.page.functions.HomePageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.When;

public class HomePageSD {

    private WebDriver itsDriver;
    private HomePageObject itsHomePage;

    @Before
    public void before(final Scenario scenario) throws ScumberException {
        itsDriver = WebDriverActions.openBrowser(scenario);
        itsHomePage = PageFactory.initElements(itsDriver, HomePageObject.class);
    }

    @When("^From Top Menu Search \"([^\"]*)\" for \"([^\"]*)\"$")
    public void fromTopMenuSearchForSpecificCriteria(String textToSearch, String criteria) {
        itsHomePage.fromTopMenuSearchForSpecificCriteria(textToSearch, criteria);
    }
}