package com.aescis.page.locators.accent;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ExceptionTypeConfigurationLocators {

	@Autowired
	public ExceptionTypeConfigurationLocators(final WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[normalize-space(.)=\"Invoice Administration\"]")
	public WebElement pageHeading;

	@FindBy(css = "input[value=\"Add validation type\"]")
	public WebElement addValidationTypeButton;

	@FindBy(css = "input[value=\"Test all validations\"]")
	public WebElement testAllValidationsButton;

	@FindBy(id = "ModalValidationTest")
	public WebElement validationRuleTesterModal;

	@FindBy(css = "input[ng-model=\"Invoiceid\"]")
	public WebElement invoiceId;

	@FindBy(css = "input[value=\"Start tests\"]")
	public WebElement startTests;

	@FindBy(xpath = "//*[normalize-space(.)=\"Validation rule editor\"]")
	public WebElement validationRuleEditorPopUp;

	@FindBy(css = "select[ng-model=\"form.ddlValidationType\"]")
	public WebElement validationRuleType;

	@FindBy(css = "select[ng-model=\"form.ddlPlanType\"]")
	public WebElement ratePlan;

	@FindBy(css = "#ModalValidation input[value=\"Ok\"]")
	public WebElement validationRuleEditorOkButton;

	@FindBy(css = "#ModalValidation input[value=\"Cancel\"]")
	public WebElement validationRuleEditorCancelButton;

	@FindBy(css = "span[data-content=\"did not pass\"]")
	public WebElement didNotPassLogo;

	@FindBy(css = "span[data-content=\"passed\"]:not([class=\"ng-hide\"])")
	public WebElement passedLogo;

	@FindBy(id = "ModalConfirmation")
	public WebElement exceptionTypeTestingPopUp;

	@FindBy(css = "#ModalConfirmation input[value=\"Yes\"]")
	public WebElement confirmExceptionTypeTestingPopUp;

	@FindBys(@FindBy(css = "button[ng-click=\"itemEditWithModal(item)\"]"))
	public List<WebElement> editIcon;

	@FindBys(@FindBy(css = "button[ng-click=\"itemRemove(item)\"]"))
	public List<WebElement> deleteicon;

	@FindBys(@FindBy(xpath = "//td[normalize-space(.)=\"Has Rate Plan 'Variable'\"]"))
	public List<WebElement> ratePlanValiable;
	
	public By modalValidation = By.id("ModalValidation");

	public WebElement ruleAdded(WebDriver itsDriver, String ruleName) {
		String xpath = String.format("//td[normalize-space(.)=\"%s\"]", ruleName);
		return itsDriver.findElement(By.xpath(xpath));
	}
}
