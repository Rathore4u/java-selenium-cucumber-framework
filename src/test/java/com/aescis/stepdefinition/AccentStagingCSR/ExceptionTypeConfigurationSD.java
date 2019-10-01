package com.aescis.stepdefinition.AccentStagingCSR;

import com.aescis.lib.WebDriverActions;
import com.aescis.lib.helper.ScumberException;
import com.aescis.page.functions.ExceptionTypeConfigurationPageObjects;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

public class ExceptionTypeConfigurationSD {
	private final static Logger Log = Logger.getLogger(ExceptionTypeConfigurationSD.class.getName());
	private final String pageUrl = "/administration/correspondence/exceptiontypeconfiguration.aspx";

	private WebDriver itsDriver;
	private ExceptionTypeConfigurationPageObjects itsExceptionTypeConfiguration;

	public ExceptionTypeConfigurationSD() {
		Log.info("Constructor: ExceptionTypeConfigurationSD");
	}

	@Before
	public void before(final Scenario scenario) throws ScumberException {
		itsDriver = WebDriverActions.openBrowser(scenario);
		itsExceptionTypeConfiguration = PageFactory.initElements(itsDriver, ExceptionTypeConfigurationPageObjects.class);
	}

	@When("^Navigate to URL-> \"([^\"]*)\" /administration/correspondence/exceptiontypeconfiguration\\.aspx$")
	public void navigateToUrlAdministrationCorrespondenceExceptionTypeConfigurationaspx(String appUrl) {
		String url = appUrl.concat(pageUrl);
		itsDriver.get(url);
	}

	@Then("^INVOICE ADMINISTRATION page loaded$")
	public void invoiceAdministrationPageLoaded() {
		itsExceptionTypeConfiguration.verifyPageLoaded();
	}

	@When("^Click Add validation type button in INVOICE ADMINISTRATION page$")
	public void clickAddValidationTypeButtonInInvoiceAdministrationPage() {
		itsExceptionTypeConfiguration.clickAddValidationButton();
	}

	@Then("^VALIDATION RULE EDITOR pop up is displayed$")
	public void validationRuleEditorPopUpIsDisplayed() {
		itsExceptionTypeConfiguration.verifyRuleEditionPopupDisplayed();
	}

	@Then("^Click Cancel on VALIDATION RULE EDITOR pop up$")
	public void clickCancelOnValidationRuleEditorPopUp() {
		itsExceptionTypeConfiguration.clickCancelInValidationRuleEditorPopup();
	}

	@Then("^VALIDATION RULE EDITOR pop up is not displayed$")
	public void validationRuleEditorPopUpIsNotDisplayed() {
		itsExceptionTypeConfiguration.verifyRuleEditionPopupNotDisplayed();
	}

	@When("^Select VALIDATION RULE TYPE as \"([^\"]*)\"$")
	public void selectValidationRuleTypeAs(String ruleType) {
		itsExceptionTypeConfiguration.selectValidationRuleType(ruleType);
	}

	@When("^Select RATE PLAN as \"([^\"]*)\"$")
	public void selectRatePlanAs(String ratePlan) {
		itsExceptionTypeConfiguration.selectRatePlan(ratePlan);
	}

	@When("^Click Ok on VALIDATION RULE EDITOR pop up$")
	public void clickOkOnValidationRuleEditorPopUp() {
		itsExceptionTypeConfiguration.clickOkInValidationRuleEditorPopup();
	}

	@Then("^Validation Rule \"([^\"]*)\" is added$")
	public void validationRuleIsAdded(String rule) {
		itsExceptionTypeConfiguration.verifyRuleAdded(rule);
	}

	@When("^Click edit button on newly added validation rule$")
	public void clickEditButtonOnNewlyAddedValidationRule() {
		itsExceptionTypeConfiguration.clickEditOnNewlyAddedRule();
	}

	@When("^Click delete button on newly added validation rule$")
	public void clickDeleteButtonOnNewlyAddedValidationRule() {
		itsExceptionTypeConfiguration.clickDeleteOnNewlyAddedRule();
	}

	@When("^Exception Type Testing pop up is displayed$")
	public void exceptionTypeTestingPopUpIsDisplayed() {
		itsExceptionTypeConfiguration.verifyExceptionTypeTestingPopupDisplayed();
	}

	@When("^Click yes on Exception Type Testing pop up$")
	public void clickYesOnExceptionTypeTestingPopUp() {
		itsExceptionTypeConfiguration.confirmDeleteExceptionTypeTesting();
	}

	@Then("^Validation Rule \"([^\"]*)\" is deleted$")
	public void validationRuleIsDeleted(String rule) {
		itsExceptionTypeConfiguration.verifyRuleDeleted(rule);
	}

	@When("^Click Test all validations button in INVOICE ADMINISTRATION page$")
	public void clickTestAllValidationsButtonInInvoiceAdministrationPage() {
		itsExceptionTypeConfiguration.clickTestAllValidations();
	}

	@Then("^VALIDATION RULE TESTER pop up is displayed$")
	public void validationRuleTesterPopUpIsDisplayed() {
		itsExceptionTypeConfiguration.verifyValidationRuleTesterPopupDisplayed();
	}

	@When("^Enter invoice id \"([^\"]*)\" in VALIDATION RULE TESTER pop up$")
	public void enterInvoiceIdInValidationRuleTesterPopUp(String id) {
		itsExceptionTypeConfiguration.enterInvoiceId(id);
	}

	@When("^Click Start tests button in VALIDATION RULE TESTER pop up$")
	public void clickStartTestsButtonInValidationRuleTesterPopUp() {
		itsExceptionTypeConfiguration.clickStartTests();
	}

	@Then("^Test Results populated$")
	public void testResultsPopulated() {
		itsExceptionTypeConfiguration.verifyTestResultsPopulated();
	}

    @Then("^Passed test results populated on VALIDATION RULE TESTER pop up$")
    public void testPassedResultsPopulated() {
        itsExceptionTypeConfiguration.verifyPassedTestResultsPopulated();
    }
}
