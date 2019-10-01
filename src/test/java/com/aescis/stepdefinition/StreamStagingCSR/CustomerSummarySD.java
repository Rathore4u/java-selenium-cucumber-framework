package com.aescis.stepdefinition.StreamStagingCSR;

import java.util.logging.Logger;

import com.aescis.lib.WebDriverActions;
import com.aescis.lib.helper.ScumberException;
import com.aescis.page.functions.CustomerSummaryPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CustomerSummarySD {
    private final static Logger Log = Logger.getLogger(SteamStagingRatePackageManagerSD.class.getName());

    private WebDriver itsDriver;
    private CustomerSummaryPageObject itsCustomerSummaryPage;

    public CustomerSummarySD() {
        Log.info("Constructor: CustomerSummarySD");
    }

    @Before
    public void before(final Scenario scenario) throws ScumberException {
        itsDriver = WebDriverActions.openBrowser(scenario);
        itsCustomerSummaryPage = PageFactory.initElements(itsDriver, CustomerSummaryPageObject.class);
    }

    @Then("^\"([^\"]*)\" customer summary page is loaded$")
    public void verifyCustomerName(String customerName) {
        itsCustomerSummaryPage.verifyCustomerNameDisplayed(customerName);
    }

    @When("^Click Edit on Customer Info->Contact Information\\.$")
    public void clickOnEditContactInformationButton() {
        itsCustomerSummaryPage.clickOnEditContactInformationButton();
    }

    @Then("^Fields become editable\\.$")
    public void verifyFieldsBecomeEditable() {
        itsCustomerSummaryPage.verifyFieldsBecomeEditable();
    }

    @When("^Change the Home Phone field value to \"([^\"]*)\"$")
    public void editHomePhoneField(String phone) {
        itsCustomerSummaryPage.editHomePhoneField(phone);
    }

    @When("^Click on Save Button from Contact Information Section in Customer Summary page$")
    public void clickOnSaveButtonFromContaxtInformationInCustomerSummaryPage() {
        itsCustomerSummaryPage.clickOnSaveButtonFromContaxtInformationInCustomerSummaryPage();
    }

    @Then("^Home Phone field value \"([^\"]*)\" should be Saved\\.$")
    public void verifyHomePhoneFieldValue(String phone) {
        itsCustomerSummaryPage.verifyHomePhoneFieldValue(phone);
    }

    @When("^Edit Contact Information: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void editContactInformation(String customerType, String dba, String permitContactName) {
        itsCustomerSummaryPage.selectCustomerType(customerType);
        itsCustomerSummaryPage.enterDba(dba);
        itsCustomerSummaryPage.enterPermitContactName(permitContactName);
    }

    @When("^Edit Billing Information: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void editBillingInformation(String contact, String addressLineOne, String addressLineTwo, String city,
            String country, String state, String zip, String homePhone, String otherPhone, String fax, String email) {
        itsCustomerSummaryPage.enterBillingInformationContactName(contact);
        itsCustomerSummaryPage.enterBillingInformationAddressOne(addressLineOne);
        itsCustomerSummaryPage.enterBillingInformationAddressTwo(addressLineTwo);
        itsCustomerSummaryPage.enterBillingInformationCity(city);
        itsCustomerSummaryPage.enterBillingInformationCountry(country);
        itsCustomerSummaryPage.selectBillingInformationState(state);
        itsCustomerSummaryPage.enterBillingInformationZip(zip);
        itsCustomerSummaryPage.editHomePhoneField(homePhone);
        itsCustomerSummaryPage.enterBillingInformationOtherPhone(otherPhone);
        itsCustomerSummaryPage.enterBillingInformationFaxPhone(fax);
        itsCustomerSummaryPage.enterBillingInformationEmail(email);
    }

    @When("^Edit Correspondence Information: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void editCorrespondenceInformation(String addressLineOne, String addressLineTwo, String city, String state,
            String zip, String homePhone, String email) {
        itsCustomerSummaryPage.enterCorrespondenceInformationAddressOne(addressLineOne);
        itsCustomerSummaryPage.enterCorrespondenceInformationAddressTwo(addressLineTwo);
        itsCustomerSummaryPage.enterCorrespondenceInformationCity(city);
        itsCustomerSummaryPage.selectCorrespondenceInformationState(state);
        itsCustomerSummaryPage.enterCorrespondenceInformationZip(zip);
        itsCustomerSummaryPage.enterCorrespondenceInformationHomePhone(homePhone);
        itsCustomerSummaryPage.enterCorrespondenceInformationEmail(email);
    }

    @When("^Edit Power Outage Contact Information: \"([^\"]*)\",\"([^\"]*)\", \"([^\"]*)\"$")
    public void editPowerOutageContactInformation(String homePhone, String otherPhone, String email) {
        itsCustomerSummaryPage.enterPowerOutageContactHomePhone(homePhone);
        itsCustomerSummaryPage.enterPowerOutageContactOtherPhone(otherPhone);
        itsCustomerSummaryPage.enterPowerOutageConactEmail(email);
    }

    @When("^Verify Contact Information: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void verifyContactInformation(String customerType, String dba, String permitContactName) {
        itsCustomerSummaryPage.verifyDataLabelText(customerType, itsDriver);
        itsCustomerSummaryPage.verifyDataLabelText(dba, itsDriver);
        itsCustomerSummaryPage.verifyDataLabelText(permitContactName, itsDriver);
    }

    @When("^Verify Billing Information: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void verifyBillingInformation(String contactName, String addressLine1, String addressLine2, String city,
            String country, String state, String zip, String homePhone, String otherPhone, String fax, String email) {
        itsCustomerSummaryPage.verifyDataLabelText(contactName, itsDriver);
        itsCustomerSummaryPage.verifyDataLabelText(addressLine1, itsDriver);
        itsCustomerSummaryPage.verifyDataLabelText(addressLine2, itsDriver);
        itsCustomerSummaryPage.verifyDataLabelText(city, itsDriver);
        itsCustomerSummaryPage.verifyDataLabelText(country, itsDriver);
        itsCustomerSummaryPage.verifyDataLabelText(state, itsDriver);
        itsCustomerSummaryPage.verifyDataLabelText(zip, itsDriver);
        itsCustomerSummaryPage.verifyDataLabelText(homePhone, itsDriver);
        itsCustomerSummaryPage.verifyDataLabelText(otherPhone, itsDriver);
        itsCustomerSummaryPage.verifyDataLabelText(fax, itsDriver);
        itsCustomerSummaryPage.verifyDataLabelText(email, itsDriver);
    }

    @When("^verify Correspondence Information: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void verifyCorrespondenceInformation(String addressLine1, String addressLine2, String city, String state,
            String zip, String homePhone, String email) {
        itsCustomerSummaryPage.verifyDataLabelText(addressLine1, itsDriver);
        itsCustomerSummaryPage.verifyDataLabelText(addressLine2, itsDriver);
        itsCustomerSummaryPage.verifyDataLabelText(city, itsDriver);
        itsCustomerSummaryPage.verifyDataLabelText(state, itsDriver);
        itsCustomerSummaryPage.verifyDataLabelText(zip, itsDriver);
        itsCustomerSummaryPage.verifyDataLabelText(homePhone, itsDriver);
        itsCustomerSummaryPage.verifyDataLabelText(email, itsDriver);
    }

    @When("^verify Power Outage Contact Information: \"([^\"]*)\",\"([^\"]*)\", \"([^\"]*)\"$")
    public void verifyPowerOutageContactInformation(String homePhone, String otherPhone, String email) {
        itsCustomerSummaryPage.verifyDataLabelText(homePhone, itsDriver);
        itsCustomerSummaryPage.verifyDataLabelText(otherPhone, itsDriver);
        itsCustomerSummaryPage.verifyDataLabelText(email, itsDriver);
    }
}