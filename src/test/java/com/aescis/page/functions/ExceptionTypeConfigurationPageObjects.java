package com.aescis.page.functions;

import static org.junit.Assert.assertFalse;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.aescis.lib.helper.PropertiesLoader;
import com.aescis.lib.utils.AbstractBasePage;
import com.aescis.page.locators.accent.ExceptionTypeConfigurationLocators;

public class ExceptionTypeConfigurationPageObjects extends AbstractBasePage {
	private final ExceptionTypeConfigurationLocators exceptionTypeConfigurationLocators;

	@Autowired
	public ExceptionTypeConfigurationPageObjects(final WebDriver driver) {
		super(driver);
		exceptionTypeConfigurationLocators = PageFactory.initElements(driver, ExceptionTypeConfigurationLocators.class);
	}

	public Properties testProps() {
		return PropertiesLoader.getInstance().load("exceptionTypeConfiguration.properties");
	}

	public void verifyPageLoaded() {
		waitForVisible(exceptionTypeConfigurationLocators.pageHeading);
		assertElementIsVisible(exceptionTypeConfigurationLocators.pageHeading,
				testProps().getProperty("page.verification"));
	}

	public void clickAddValidationButton() {
		waitForElementHidden(exceptionTypeConfigurationLocators.modalValidation);
		waitUntilElementIsClickable(exceptionTypeConfigurationLocators.addValidationTypeButton);
		clickElement(exceptionTypeConfigurationLocators.addValidationTypeButton);
	}

	public void verifyRuleEditionPopupDisplayed() {
		waitForVisible(exceptionTypeConfigurationLocators.validationRuleEditorPopUp);
		assertElementIsVisible(exceptionTypeConfigurationLocators.validationRuleEditorPopUp,
				testProps().getProperty("ruleEditionPopUp.verification"));
	}

	public void verifyRuleEditionPopupNotDisplayed() {
		waitForElementHidden(exceptionTypeConfigurationLocators.validationRuleEditorPopUp);
		assertElementIsNotVisible(exceptionTypeConfigurationLocators.validationRuleEditorPopUp,
				testProps().getProperty("ruleEditionPopUp.verification"));
	}

	public void selectValidationRuleType(String type) {
		selectDropdownOption(exceptionTypeConfigurationLocators.validationRuleType, type);
	}

	public void selectRatePlan(String ratePlan) {
		selectDropdownOption(exceptionTypeConfigurationLocators.ratePlan, ratePlan);
	}

	public void clickOkInValidationRuleEditorPopup() {
		waitUntilElementIsClickable(exceptionTypeConfigurationLocators.validationRuleEditorOkButton);
		clickElement(exceptionTypeConfigurationLocators.validationRuleEditorOkButton);
	}

	public void clickCancelInValidationRuleEditorPopup() {
		waitUntilElementIsClickable(exceptionTypeConfigurationLocators.validationRuleEditorCancelButton);
		clickElement(exceptionTypeConfigurationLocators.validationRuleEditorCancelButton);
	}

	public void clickTestAllValidations() {
		waitUntilElementIsClickable(exceptionTypeConfigurationLocators.testAllValidationsButton);
		clickElement(exceptionTypeConfigurationLocators.testAllValidationsButton);
	}

	public void enterInvoiceId(String id) {
		waitForVisible(exceptionTypeConfigurationLocators.invoiceId);
		typeEditBox(exceptionTypeConfigurationLocators.invoiceId, id);
	}

	public void clickStartTests() {
		waitUntilElementIsClickable(exceptionTypeConfigurationLocators.startTests);
		clickElement(exceptionTypeConfigurationLocators.startTests);
	}

	public void verifyValidationRuleTesterPopupDisplayed() {
		waitForVisible(exceptionTypeConfigurationLocators.validationRuleTesterModal);
		assertElementIsVisible(exceptionTypeConfigurationLocators.validationRuleTesterModal,
				testProps().getProperty("ruleTesterPopUp.verification"));
	}

	public void verifyTestResultsPopulated() {
		waitForVisible(exceptionTypeConfigurationLocators.didNotPassLogo);
		assertElementIsVisible(exceptionTypeConfigurationLocators.didNotPassLogo,
				testProps().getProperty("testResults.verification"));
	}

	public void verifyPassedTestResultsPopulated() {
		waitForVisible(exceptionTypeConfigurationLocators.passedLogo);
		assertElementIsVisible(exceptionTypeConfigurationLocators.passedLogo,
				testProps().getProperty("testResults.verification"));
	}

	public void verifyExceptionTypeTestingPopupDisplayed() {
		waitForVisible(exceptionTypeConfigurationLocators.exceptionTypeTestingPopUp);
		assertElementIsVisible(exceptionTypeConfigurationLocators.exceptionTypeTestingPopUp,
				testProps().getProperty("exceptionTypePopup.verification"));
	}

	public void confirmDeleteExceptionTypeTesting() {
		waitUntilElementIsClickable(exceptionTypeConfigurationLocators.confirmExceptionTypeTestingPopUp);
		clickElement(exceptionTypeConfigurationLocators.confirmExceptionTypeTestingPopUp);
		waitForElementHidden(exceptionTypeConfigurationLocators.confirmExceptionTypeTestingPopUp);
	}

	public void clickEditOnNewlyAddedRule() {
		int last = exceptionTypeConfigurationLocators.editIcon.size() - 1;
		clickElement(exceptionTypeConfigurationLocators.editIcon.get(last));
	}

	public void clickDeleteOnNewlyAddedRule() {
		int last = exceptionTypeConfigurationLocators.deleteicon.size() - 1;
		clickElement(exceptionTypeConfigurationLocators.deleteicon.get(last));
	}

	public void verifyRuleAdded(String ruleName) {
		waitForVisible(exceptionTypeConfigurationLocators.ruleAdded(itsDriver, ruleName));
		assertElementIsVisible(exceptionTypeConfigurationLocators.ruleAdded(itsDriver, ruleName), ruleName);
	}

	public void verifyRuleDeleted(String ruleName) {
		boolean deleted = true;
		if (exceptionTypeConfigurationLocators.ratePlanValiable.size() == 0)
			deleted = false;

		assertFalse(testProps().getProperty("ruleDeleted.verification"), deleted);
	}
}
