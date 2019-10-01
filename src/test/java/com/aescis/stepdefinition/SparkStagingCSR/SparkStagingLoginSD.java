package com.aescis.stepdefinition.SparkStagingCSR;

import com.aescis.lib.WebDriverActions;
import com.aescis.lib.helper.ScumberException;
import com.aescis.page.functions.HomePageObject;
import com.aescis.page.functions.LoginPageObject;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

public class SparkStagingLoginSD {
    private final static Logger Log = Logger.getLogger(SparkStagingLoginSD.class.getName());

    private WebDriver itsDriver;
    private LoginPageObject itsLoginPage;
    private HomePageObject itsHomePage;

    public SparkStagingLoginSD() {
        Log.info("Constructor: StreamStagingLoginSD");
    }

    @Before
    public void before(final Scenario scenario)
            throws ScumberException {
        itsDriver = WebDriverActions.openBrowser(scenario);
        itsLoginPage = PageFactory.initElements(itsDriver, LoginPageObject.class);
        itsHomePage = PageFactory.initElements(itsDriver, HomePageObject.class);
    }

    @When("^Login to CSR with userName : \"([^\"]*)\" and password : \"([^\"]*)\"$")
    public void login_to_CSR_with_userName_and_password(String userName, String password) throws Throwable {
    	itsLoginPage.enterUserName(userName);
    	itsLoginPage.enterPassword(password);
    	itsLoginPage.clickOnLoginButton();
    }


    @Then("^CSR main page displayed$")
    public void csr_main_page_displayed() throws Throwable {
    	 itsHomePage.verifyHomePageOpen();
    }
    
    @Then("^Generic logout$")
    public void generic_logout() throws Throwable {
    	itsDriver.manage().deleteAllCookies();
    }
}
