package com.aescis.stepdefinition.AepStagingCSR;

import com.aescis.lib.WebDriverActions;
import com.aescis.lib.helper.ScumberException;
import com.aescis.page.functions.ExceptionTypeConfigurationPageObject;
import com.aescis.page.functions.aep.CustomerCloneUtilityPageObject;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AepEnergyAppSD {

    private final static Logger Log	= Logger.getLogger(AepEnergyAppSD.class.getName());

    private WebDriver itsDriver;
    private CustomerCloneUtilityPageObject itsCustomerClonePage;
    private String pageUrl = "/administration/customers/clonecustomer.aspx?custid=32335";
    private String exceptiontypeconfigurationUrl = "/administration/correspondence/exceptiontypeconfiguration.aspx";
    private ExceptionTypeConfigurationPageObject itsExceptionTypePage;

    public AepEnergyAppSD()
    {
        Log.info("Constructor: AepEnergyAppStepDefinition");
    }

    @Before
    public void before(final Scenario scenario)
            throws ScumberException
    {
        itsDriver = WebDriverActions.openBrowser(scenario);
        itsCustomerClonePage = PageFactory.initElements(itsDriver, CustomerCloneUtilityPageObject.class);
        itsExceptionTypePage = PageFactory.initElements(itsDriver, ExceptionTypeConfigurationPageObject.class);
    }

    @Then("^customer clone utility page should open$")
    public void verifyCustomerCloneUtilityPageLoaded(){
        itsCustomerClonePage.verifyCloneCustomerUtilityPageDisplayed();
    }

    @When("^user enters no. of clones as \"([^\"]*)\"$")
    public void userEntersNoOfClones(String count) {
        itsCustomerClonePage.enterNoOfClones(count);
    }

    @And("^user clicks clone customer button$")
    public void clickCloneCustomerButton(){
        itsCustomerClonePage.clickCloneCustomerButton();
        itsDriver.switchTo().alert().accept();
    }

    @Then("^customer is cloned successfully$")
    public void verifyCustomerClonedSuccessfully(){
        itsCustomerClonePage.verifyCloneSuccessful();
    }

    @When("^Navigate to URL -> \"([^\"]*)\" customer clone utility$")
    public void navigateToCustomerCloneUtility(String aepUrl) {
        String url = aepUrl.concat(pageUrl);
        itsDriver.get(url);
    }

    @When("^Navigate to URL \"([^\"]*)\" Exceptiontypeconfiguration$")
	public void navigateExceptionTypeConfigurationAspx(String domainUrl) throws Throwable {
		String url = domainUrl.concat(exceptiontypeconfigurationUrl);
		itsDriver.get(url);
    }

    @Then("^Exceptiontypeconfiguration page loaded$")
    public void verifyExceptiontypeconfigurationPageLoaded() {
        itsExceptionTypePage.verifyPageOpen();
    }

    @When("^Click Add Validation Type$")
    public void clickAddValidationType() {
        itsExceptionTypePage.clickAddValidationType();
    }

    @Then("^Verify Validation Rule Type display$")
    public void verifyValidationRuleType() {
        itsExceptionTypePage.verifyValidationRuleType();
    }

    @When("^Click Cancel Button$")
    public void clickCancelButton() {
        itsExceptionTypePage.clickCancelButton();
    }

    @When("^Click Ok Button$")
    public void clickOkButton() {
        itsExceptionTypePage.clickOkButton();
    }

    @When("^Select Validation Type Rule as \"([^\"]*)\"$")
    public void selectValidationTypeRule(String option) {
        itsExceptionTypePage.selectValidationTypeRule(option);
    }

    @When("^Select Rate Plan as \"([^\"]*)\"$")
    public void selectRatePlanType(String option) {
        itsExceptionTypePage.selectRatePlanType(option);
    }

    @Then("^Validation Rule Entered in grid as \"([^\"]*)\"$")
    public void verifyValidationRuleEntered(String ruleName) {
        itsExceptionTypePage.verifyValidationRuleEntered(ruleName);
    }

    @When("^Remove Rule Entered as \"([^\"]*)\"$")
    public void clickRemoveRule(String ruleName) {
        itsExceptionTypePage.clickRemoveRule(ruleName);
    }

    @Then("^Are you sure display$")
    public void verifyConfirmPopup() {
        itsExceptionTypePage.verifyConfirmPopup();
    }

    @When("^Click Yes Button$")
    public void clickYesButton() {
        itsExceptionTypePage.clickYesButton();
    }

    @Then("^Rule deleted as \"([^\"]*)\"$")
    public void verifyValidationRuleDeleted(String ruleName) {
        itsExceptionTypePage.verifyValidationRuleDeleted(ruleName);
    }

    @When("^Click Test All Validations$")
    public void clickTestAllValidations() {
        itsExceptionTypePage.clickTestAllValidations();
    }

    @Then("^Verify Invoice Popup$")
    public void verifyInvoicePopup() {
        itsExceptionTypePage.verifyInvoicePopup();
    }

    @When("^Put Invoice Id=(\\d+)$")
    public void enterInvoiceId(Integer id) {
        itsExceptionTypePage.enterInvoiceId(id.toString());
    }

    @When("^Click Start Tests$")
    public void clickStartTests() {
        itsExceptionTypePage.clickStartTests();
    }

    @Then("^Verify Validation Test Results$")
    public void verifyValidationTestResults() {
        itsExceptionTypePage.verifyValidationTestResults();
    }
}
