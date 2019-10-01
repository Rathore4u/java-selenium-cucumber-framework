package com.aescis.stepdefinition.SparkStagingCSR;

import java.util.logging.Logger;

import com.aescis.lib.WebDriverActions;
import com.aescis.lib.helper.ScumberException;
import com.aescis.page.functions.spark.BudgetBillingPlanPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BudgetBillingPlanSD {
	private final static Logger Log = Logger.getLogger(ChangeLogSD.class.getName());

	private WebDriver itsDriver;
	private BudgetBillingPlanPageObject itsBudgetBillingPlanPage;

	public BudgetBillingPlanSD() {
		Log.info("Constructor: BudgetBillingPlanSD");
	}

	@Before
	public void before(final Scenario scenario) throws ScumberException {
		itsDriver = WebDriverActions.openBrowser(scenario);
		itsBudgetBillingPlanPage = PageFactory.initElements(itsDriver, BudgetBillingPlanPageObject.class);
	}

	@When("^Navigate to \"([^\"]*)\" url$")
	public void navigateToUrl(String url) {
		itsDriver.get(url);
	}

	@Then("^\"([^\"]*)\" budget billing plan page is loaded$")
	public void budget_billing_plan_page_is_loaded(String customerName) {
		itsBudgetBillingPlanPage.verifyCustomerName(customerName);
	}

	@Then("^True Up Type is \"([^\"]*)\"$")
	public void verifyTrueUpTypeValue(String value) {
		itsBudgetBillingPlanPage.verifyTrueUpTypeValue(value);
	}

	@When("^Click on 'Budget Billing Plan History' tab$")
	public void clickOnBudgetBillingPlanHistoryTab() {
		itsBudgetBillingPlanPage.clickOnBudgetBillingHistoryTab();
	}

	@Then("^History page is loaded$")
	public void verifyHistoryPageIsLoaded() {
		itsBudgetBillingPlanPage.verifyBudgetBillingHistoryTabIsLoaded();
	}
}