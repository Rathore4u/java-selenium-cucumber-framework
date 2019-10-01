package com.aescis.stepdefinition.StreamStagingCSR;

import java.util.logging.Logger;

import com.aescis.lib.WebDriverActions;
import com.aescis.lib.helper.ScumberException;
import com.aescis.page.functions.stream.EmailTemplateAdministrationPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EmailTemplateAdministrationSD {
    private final static Logger Log = Logger.getLogger(SteamStagingRatePackageManagerSD.class.getName());
    private final String pageUrl = "/callcenter/popup/ebillemailtemplateadministration.aspx";
    
    private WebDriver itsDriver;
    private EmailTemplateAdministrationPageObject itsEmailTemplateAdministrationPage;

    public EmailTemplateAdministrationSD() {
        Log.info("Constructor: EmailTemplateAdministrationSD");
    }

    @Before
    public void before(final Scenario scenario) throws ScumberException {
        itsDriver = WebDriverActions.openBrowser(scenario);
        itsEmailTemplateAdministrationPage = PageFactory.initElements(itsDriver,
                EmailTemplateAdministrationPageObject.class);
    }

    @Then("^Email Template Administration is displayed$")
    public void verifyEmailTemplateAdministrationPageDisplayed() {
        itsEmailTemplateAdministrationPage.verifyEmailTemplateAdministrationPageDisplayed();
    }

    @When("^Click to Add Ebill Configuration button$")
    public void clickAddEbillConfigurationButton() {
        itsEmailTemplateAdministrationPage.clickAddEbillConfigurationButton();
    }

    @Then("^Add Ebill Configuration Section becomes visible\\.$")
    public void verifyAddEbillConfigurationSectionDisplayed() {
        itsEmailTemplateAdministrationPage.verifyAddEbillConfigurationSectionDisplayed();
    }

    @When("^Click on Cancel button$")
    public void clickOnCancelButton() {
        itsEmailTemplateAdministrationPage.clickOnCancelButton();
    }

    @Then("^Add Ebill Configuration Section becomes invisible\\.$")
    public void verifyAddEbillConfigurationSectionBecomesInvisible() {
        itsEmailTemplateAdministrationPage.verifyAddEbillConfigurationSectionBecomesInvisible();
    }
    
    @When("^Navigate to URL-> \"([^\"]*)\" /callcenter/popup/ebillemailtemplateadministration\\.aspx$")
    public void navigateToUrlCallcenterPopupEbillEmailTemplateAdministrationaspx(String appUrl) {
    	String url = appUrl.concat(pageUrl);
		itsDriver.get(url);
    }
    
    @When("^Click on Cancel button in Add Ebill Configuration Section$")
    public void clickOnCancelButtonInAddEbillConfigurationSection() {
    	itsEmailTemplateAdministrationPage.cancelAddBillConfiguration();
    }
    
    @Then("^EBill Email Template Administration is displayed$")
    public void ebillEmailTemplateAdministrationIsDisplayed() {
    	itsEmailTemplateAdministrationPage.verifyEbillEmailTemplate();
    }
    
    @Then("^Add Ebill Default Configuration Section becomes visible\\.$")
    public void addEbillDefaultConfigurationSectionBecomesVisible() {
    	itsEmailTemplateAdministrationPage.verifyAddEbillDefaultConfigurationSectionDisplayed();
    }
    
    @Then("^Add Ebill Default Configuration Section becomes invisible\\.$")
    public void addEbillDefaultConfigurationSectionBecomesInvisible() {
    	itsEmailTemplateAdministrationPage.verifyAddEbillDefaultConfigurationSectionDisplayed();
    }
}