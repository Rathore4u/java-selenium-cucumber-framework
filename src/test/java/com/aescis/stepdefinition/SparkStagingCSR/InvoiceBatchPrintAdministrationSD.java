package com.aescis.stepdefinition.SparkStagingCSR;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aescis.lib.WebDriverActions;
import com.aescis.lib.helper.ScumberException;
import com.aescis.page.functions.LoginPageObject;
import com.aescis.page.functions.spark.InvoiceBatchPrintAdministrationPageObject;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class InvoiceBatchPrintAdministrationSD {
	private final static Logger Log = Logger.getLogger(InvoiceBatchPrintAdministrationSD.class.getName());

	private WebDriver itsDriver;
	private LoginPageObject itsLoginPage;
	private InvoiceBatchPrintAdministrationPageObject invoiceBatchPrintAdministrationPage;
	private String pageUrl = "/administration/print/batchprint.aspx";
	private String estimatesPageUrl = "/Administration/Invoice/Estimates.aspx?ClientID=48&CSPID=1";

	public InvoiceBatchPrintAdministrationSD() {
		Log.info("Constructor: StreamStagingLoginSD");
	}

	@Before
	public void before(final Scenario scenario) throws ScumberException {
		itsDriver = WebDriverActions.openBrowser(scenario);
		itsLoginPage = PageFactory.initElements(itsDriver, LoginPageObject.class);
		invoiceBatchPrintAdministrationPage = PageFactory.initElements(itsDriver,
				InvoiceBatchPrintAdministrationPageObject.class);
	}

	@Given("^Login page loaded$")
	public void login_page_loaded() throws Throwable {
		itsLoginPage.verifyLoginPageDisplayed();
	}

	@When("^Navigate to URL-> \"([^\"]*)\" /administration/print/batchprint\\.aspx$")
	public void navigate_to_URL_administration_print_batchprint_aspx(String sparkUrl) throws Throwable {
		String url = sparkUrl.concat(pageUrl);
		itsDriver.get(url);
	}

	@When("^user navigates to URL : \"([^\"]*)\"/administration/print/batchprint\\.aspx\" application$")
	public void user_navigates_to_URL_administration_print_batchprint_aspx_application(String arg1) throws Throwable {

	}

	@Then("^INVOICE BATCH PRINT ADMINISTRATION Screen Loaded$")
	public void invoice_BATCH_PRINT_ADMINISTRATION_Screen_Loaded() throws Throwable {
		invoiceBatchPrintAdministrationPage.verifyPageLoaded();
	}

	@When("^Click to Letter Batch Print Administration$")
	public void click_to_Letter_Batch_Print_Administration() throws Throwable {
		invoiceBatchPrintAdministrationPage.clickLetterBatchPrintAdministration();
	}

	@Then("^Letter Batch Print Administration screen is loaded$")
	public void letter_Batch_Print_Administration_screen_is_loaded() throws Throwable {
		invoiceBatchPrintAdministrationPage.verifyLetterBatchPrintAdministrationPage();
	}

    @Then("^verify INVOICE BATCH PRINT ADMIN Screen Loaded$")
    public void invoiceBatchPrintAdminScreen() {
        invoiceBatchPrintAdministrationPage.verifyPageInvoiceBatchPageLoaded();
    }

    @When("^Navigate to Invoice Batch print URL \"([^\"]*)\"$")
    public void navigateToAdministrationBatchPrintPage(String sparkUrl) {
        String url = sparkUrl.concat(pageUrl);
        itsDriver.get(url);
    }

    @When("^user navigate to invoice estimates \"([^\"]*)\" url$")
    public void navigateToInvoiceEstimatesPage(String sparkUrl) {
        String url = sparkUrl.concat(estimatesPageUrl);
        itsDriver.get(url);
    }

    @Then("^verify spark estimate list page is opened$")
    public void verifySparkEstimatesPage() {
       invoiceBatchPrintAdministrationPage.verifyInvoiceEstimatesPage();
    }

    @When("^update search filter from field as \"([^\"]*)\" and to field as \"([^\"]*)\" and click on list$")
    public void updateFilterSearchDatesForInvoiceEstimates(String fromDate, String toDate) {
        invoiceBatchPrintAdministrationPage.enterSearchFilterDate(fromDate, toDate);
    }

    @Then("^verify invoice estimates list updated with new rows of results$")
    public void verifyInvoiceEstimatesListed() {
		invoiceBatchPrintAdministrationPage.verifyInvoiceEstimatesResultsSection();
    }
}
