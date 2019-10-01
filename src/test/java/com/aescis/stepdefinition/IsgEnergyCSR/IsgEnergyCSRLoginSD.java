package com.aescis.stepdefinition.IsgEnergyCSR;

import java.util.logging.Logger;

import com.aescis.lib.WebDriverActions;
import com.aescis.lib.helper.ScumberException;
import com.aescis.page.functions.LoginPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class IsgEnergyCSRLoginSD {
    private final static Logger Log = Logger.getLogger(IsgEnergyCSRLoginSD.class.getName());
    private LoginPageObject itsLoginPage;
    private WebDriver itsDriver;

    public IsgEnergyCSRLoginSD() {
        Log.info("Constructor: IsgEnergyCSRLoginSD");
    }

    @Before
    public void before(final Scenario scenario) throws ScumberException {
        itsDriver = WebDriverActions.openBrowser(scenario);
        itsLoginPage = PageFactory.initElements(itsDriver, LoginPageObject.class);
    }

    @Given("^ISG login page is open$")
    public void verifyIsgLoginPageIsOpen() {
        itsLoginPage.verifyLoginPageDisplayed();
    }

    @When("^I click Login button$")
    public void clickLoginButton() {
        itsLoginPage.clickOnLoginButton();
    }

    @Given("^user navigates to IGS Energy application using this url \"([^\"]*)\"$")
    public void navigateToUrl(String url) throws Throwable {
        itsDriver.get(url);
    }
}