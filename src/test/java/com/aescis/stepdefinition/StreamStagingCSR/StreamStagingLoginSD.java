package com.aescis.stepdefinition.StreamStagingCSR;

import com.aescis.lib.WebDriverActions;
import com.aescis.lib.helper.ScumberException;
import com.aescis.page.functions.CustomerSummaryPageObject;
import com.aescis.page.functions.HomePageObject;
import com.aescis.page.functions.LoginPageObject;
import com.aescis.page.functions.RatingPageObject;
import com.aescis.page.functions.stream.AutoInvoiceConfigurationPageObject;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

public class StreamStagingLoginSD {
    private final static Logger Log = Logger.getLogger(StreamStagingLoginSD.class.getName());

    private WebDriver itsDriver;
    private LoginPageObject itsLoginPage;
    private HomePageObject itsHomePage;
    private RatingPageObject itsRatingPage;
    private String ratePageUrl = "/callcenter/includes/ratelist.aspx";
    private CustomerSummaryPageObject itsCustomerSummaryPage;
    private String customerSummary = "/callCenter/summary.aspx?CustID=552201";
    private String autoInvoiceConfig = "/administration/invoice/autoinvoiceconfig.aspx";
    private AutoInvoiceConfigurationPageObject autoInvoiceConfigurationPageObject;

    public StreamStagingLoginSD() {
        Log.info("Constructor: StreamStagingLoginSD");
    }

    @Before
    public void before(final Scenario scenario)
            throws ScumberException {
        itsDriver = WebDriverActions.openBrowser(scenario);
        itsLoginPage = PageFactory.initElements(itsDriver, LoginPageObject.class);
        itsHomePage = PageFactory.initElements(itsDriver, HomePageObject.class);
        itsRatingPage = PageFactory.initElements(itsDriver, RatingPageObject.class);
        itsCustomerSummaryPage = PageFactory.initElements(itsDriver, CustomerSummaryPageObject.class);
        autoInvoiceConfigurationPageObject = PageFactory.initElements(itsDriver, AutoInvoiceConfigurationPageObject.class);
    }

    @Given("^user navigates to URL : \"([^\"]*)\" application$")
    public void navigateAdminUI(final String appURL) {
        itsDriver.get(appURL);
    }

    @Given("^that I am on StreamStagingCSR login page$")
    public void checkLoginPageIsDisplayed() {
        itsLoginPage.verifyLoginPageDisplayed();
    }

    @Given("^StreamStagingCSR login page is open$")
    public void streamstagingcsr_login_page_is_open() {
        itsLoginPage.verifyLoginPageDisplayed();
    }

    @When("^fill userName : \"([^\"]*)\"$")
    public void enterUserName(String userName) {
        itsLoginPage.enterUserName(userName);
    }

    @When("^fill password : \"([^\"]*)\"$")
    public void enterPassword(String password) {
        itsLoginPage.enterPassword(password);
    }

    @When("^hit login button at StreamStaginCSR login page$")
    public void clickLoginButton() {
        itsLoginPage.clickOnLoginButton();
    }

    @Then("^home page of StreamStagingCSR should open$")
    public void verifyHomePageOpened() {
        itsHomePage.verifyHomePageOpen();
    }

    @Then("^rating page is loaded$")
    public void verifyRatingPageLoaded() {
        itsRatingPage.verifyRatingPageLoaded();
    }

    @Then("^Text area for Rate Code visible$")
    public void verifyTextAreaRateCodeVisible() {
        itsRatingPage.verifyRatingTextAreaOpen();
    }

    @When("^Rate Code field is filled with : \"([^\"]*)\" value$")
    public void rateCodeFieldFilledWithCode(String rateCode) {
        itsRatingPage.enterSearchField(rateCode);
    }

    @When("^click search button on rate list page$")
    public void clickSearchOnRateList() {
        itsRatingPage.clickSearchButton();
    }

    @Then("^no result should be returned in results$")
    public void verifyNoSearchResults() {
        itsRatingPage.verifyNoSearchResults();
    }

    @When("^Rate Code field is filled with \"([^\"]*)\" value$")
    public void enterRateCodeFieldWithValue(String rateCodeSearchValue) {
        itsRatingPage.enterSearchField(rateCodeSearchValue);
    }

    @Then("^search results should have rows starting with \"([^\"]*)\"$")
    public void verifySearchResultStartingWithValue(String startingWithValue) {
        itsRatingPage.verifySearchResultsStartingWith(startingWithValue);
    }

    @Then("^Customer summary page is loaded$")
    public void verifyCustomerSummaryPageLoaded() {
        itsCustomerSummaryPage.verifyCustomerSummaryPageLoaded();
    }

    @When("^Select ARBilling Tab fin in grid row$")
    public void clickARBillingTab() {
        itsCustomerSummaryPage.clickARBilling();
    }

    @When("^Click to Reversal button$")
    public void clickRevealButton() {
        itsCustomerSummaryPage.clickPbCancel();
    }

    @Then("^Reversal Popup opened$")
    public void reversalPopupOpened() throws Throwable {
        itsCustomerSummaryPage.verifyCloseButtonDisplay();
    }

    @When("^Click to Close button$")
    public void clickCloseButton() {
        itsCustomerSummaryPage.clickCloseButton();
    }

    @When("^Click to Cancel button$")
    public void clickCancelButton() {
        itsCustomerSummaryPage.clickCloseButton();
    }

    @When("^Click to Save button$")
    public void clickSaveButton() {
        itsCustomerSummaryPage.clickCloseButton();
    }

    @When("^Navigate to URL-> \"([^\"]*)\" /callcenter/includes/ratelist\\.aspx$")
    public void navigateToUrlCallCenterIncludesRatelistAspx(String appUrl){
    	String url = appUrl.concat(ratePageUrl);
		itsDriver.get(url);
    }


    @When("^Navigate to URL-> \"([^\"]*)\" Callcenter CustomerSummary$")
    public void navigateToUrlCallCenterCustomerSummary(String appUrl) {
    	String url = appUrl.concat(customerSummary);
		itsDriver.get(url);
    }
    
    @When("^Click to Customer Search$")
    public void clickOnCustomerSearch() {
        itsHomePage.clickOnCustomerSearch();
    }

    @When("^user navigates to auto invoice page \"([^\"]*)\" url$")
    public void navigateToAutoInvoicePage(String appUrl) {
        String url = appUrl.concat(autoInvoiceConfig);
        itsDriver.get(url);
    }

    @Then("^verify display auto invoice configuration page$")
    public void verifyAutoInvoiceConfigurationPage() {
        autoInvoiceConfigurationPageObject.verifyAutoInvoicePage();
    }

    @When("^click on default run hours field edit icon$")
    public void clickRunHoursEditIcon() {
        autoInvoiceConfigurationPageObject.clickDefaultRunEditIcon();
    }

    @When("^enter value \"([^\"]*)\" in the default run hours edit box$")
    public void enterDefaultRunHoursValue(String hours) {
        autoInvoiceConfigurationPageObject.enterRunHoursValue(hours);
    }

    @When("^click on save button in invoice configuration page$")
    public void clickSaveButtonInvoiceConfigurationPage() {
        autoInvoiceConfigurationPageObject.clickSaveInConfiguration();
    }

    @Then("^verify new value \"([^\"]*)\" is saved without error$")
    public void verifyHoursValueSaved(String hoursValue) {
        autoInvoiceConfigurationPageObject.verifyHoursValueEntered(hoursValue);
    }

    @When("^click on run weekends field edit icon$")
    public void clickRunWeekendsEditIcon() {
        autoInvoiceConfigurationPageObject.clickRunWeekendsEditIcon();
    }

    @When("^select \"([^\"]*)\" option and save the changes$")
    public void selectYesInRunWeekDaysAndSave(String option) {
        autoInvoiceConfigurationPageObject.selectYesInRunWeekDays();
        autoInvoiceConfigurationPageObject.clickSaveInConfiguration();
        autoInvoiceConfigurationPageObject.verifyHoursValueEntered(option);
    }

    @Then("^verify new run weekend option \"([^\"]*)\" is saved without error$")
    public void verifyNewRunWeekendOptionIsSaved(String option) {
        autoInvoiceConfigurationPageObject.verifyHoursValueEntered(option);
    }

    @When("^reset the default run hours and run weekend field to old value$")
    public void resetDefaultRunAndWeekdaysSettings() {
        String emptyValue = "";
        autoInvoiceConfigurationPageObject.clickDefaultRunEditIcon();
        autoInvoiceConfigurationPageObject.enterRunHoursValue(emptyValue);
        autoInvoiceConfigurationPageObject.clickSaveInConfiguration();
        autoInvoiceConfigurationPageObject.clickRunWeekendsEditIcon();
        autoInvoiceConfigurationPageObject.selectNoInRunWeekDays();
        autoInvoiceConfigurationPageObject.clickSaveInConfiguration();
    }

    @Then("^verify default run hours and run weekend field values are reset$")
    public void runHoursAndWeekEndFieldShouldReset() {
        String emptyValue = "";
        String optionValue = "No";
        autoInvoiceConfigurationPageObject.verifyHoursValueEntered(emptyValue);
        autoInvoiceConfigurationPageObject.verifyHoursValueEntered(optionValue);
    }
}
