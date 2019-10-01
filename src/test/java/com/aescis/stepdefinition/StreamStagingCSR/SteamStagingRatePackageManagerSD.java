package com.aescis.stepdefinition.StreamStagingCSR;

import java.util.logging.Logger;

import com.aescis.lib.WebDriverActions;
import com.aescis.lib.helper.ScumberException;
import com.aescis.page.functions.stream.RatePackageManagementPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SteamStagingRatePackageManagerSD {
    private final static Logger Log = Logger.getLogger(SteamStagingRatePackageManagerSD.class.getName());

    private WebDriver itsDriver;
    private RatePackageManagementPageObject itsRatePackageManagementPage;

    public SteamStagingRatePackageManagerSD() {
        Log.info("Constructor: SteamStagingRatePackageManagerSD");
    }

    @Before
    public void before(final Scenario scenario) throws ScumberException {
        itsDriver = WebDriverActions.openBrowser(scenario);
        itsRatePackageManagementPage = PageFactory.initElements(itsDriver, RatePackageManagementPageObject.class);
    }

    @Then("^Rate Package Management screen displayed\\.$")
    public void verfyPackageManagementScreenDisplayed() {
        itsRatePackageManagementPage.verifyRatePackageManagementPageIsDisplayed();
    }

    @When("^Enter \"([^\"]*)\" in the package name field$")
    public void entePackageName(String packageName) {
        itsRatePackageManagementPage.enterPackageName(packageName);
    }

    @When("^Press enter from inside Package Name field$")
    public void pressEnterFromInsidePackageNameField() {
        itsRatePackageManagementPage.pressEnterFromInsidePackageName();
    }

    @Then("^All the rate packages with name starting with name \"([^\"]*)\" should be loaded in grid\\.$")
    public void allTheRatePackageNamesStartWithThensertedText(String text) {
        itsRatePackageManagementPage.verifyAllRatePackageNamesStartWith(text);
    }

    @Then("^Grid is cleaned-up and message No records matched your criteria displayed$")
    public void NoRecordsMatchedYourCriteriaMessageDisplayed() {
        itsRatePackageManagementPage.verifyNoRecordsMatchedYourCriteriaMessageDisplayed();
    }
}