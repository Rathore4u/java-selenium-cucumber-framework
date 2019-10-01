package com.aescis.stepdefinition.GreenMountainStagingCSR;

import com.aescis.lib.WebDriverActions;
import com.aescis.lib.helper.ScumberException;
import com.aescis.page.functions.LoginPageObject;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GreenMountainStagingSD {
    private WebDriver itsDriver;
    private LoginPageObject itsLoginPage;

    @Before
    public void before(final Scenario scenario)
            throws ScumberException {
        itsDriver = WebDriverActions.openBrowser(scenario);
        itsLoginPage = PageFactory.initElements(itsDriver, LoginPageObject.class);
    }

    @Given("^greenMountainStaging login page is open$")
    public void greenMountainStagingLoginPage() {
        itsLoginPage.verifyLoginPageDisplayed();
    }
}
