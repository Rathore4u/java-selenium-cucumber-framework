package com.aescis.page.functions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.aescis.lib.helper.PropertiesLoader;
import com.aescis.lib.utils.AbstractBasePage;
import com.aescis.page.locators.CustomerSummaryLocators;

public class CustomerSummaryPageObject extends AbstractBasePage {

    final CustomerSummaryLocators customerSummaryLocators;

    @Autowired
    public CustomerSummaryPageObject(final WebDriver driver) {
        super(driver);
        customerSummaryLocators = PageFactory.initElements(driver, CustomerSummaryLocators.class);
    }

    public Properties testProps() {
        return PropertiesLoader.getInstance().load("message.properties");
    }

    public void verifyCustomerSummaryPageLoaded() {
        waitForVisible(customerSummaryLocators.streamEnergyCommercial);
        this.verifyARBillingTabDisplay();
    }

    public void verifyARBillingTabDisplay() {
        assertElementIsVisible(customerSummaryLocators.streamEnergyCommercial,
                testProps().getProperty("customerSummaryPage.verification"));
    }

    public void clickARBilling() {
        clickUsingJavaScript(customerSummaryLocators.arBilling);
    }

    public void clickPbCancel() {
        clickUsingJavaScript(customerSummaryLocators.pbcancel);
    }

    public void verifyCloseButtonDisplay() {
        setHandleToLastWindow();
        assertElementIsVisible(customerSummaryLocators.close,
                testProps().getProperty("customerSummaryPage.verification"));
        setHandleToMainWindow();
    }

    public void clickCloseButton() {
        setHandleToLastWindow();
        clickUsingJavaScript(customerSummaryLocators.close);
        setHandleToMainWindow();
    }

    public void clickCancelButton() {
        setHandleToLastWindow();
        clickUsingJavaScript(customerSummaryLocators.cancel);
        setHandleToMainWindow();
    }

    public void clickSaveButton() {
        setHandleToLastWindow();
        clickUsingJavaScript(customerSummaryLocators.save);
        setHandleToMainWindow();
    }

    public void verifyBalanceHeader(String header) {
        boolean flag = false;
        for (WebElement currentElement : customerSummaryLocators.balanceHeaders) {
            String text = currentElement.getText().replaceAll("(?:\\n|\\r)", " ");
            if (text.toLowerCase().trim().equals(header.toLowerCase().trim())) {
                flag = true;
            }
        }
        Assert.assertTrue(flag);
    }

    public String getBalanceDataFromHeader(String header) {
        for (int i = 0; i < customerSummaryLocators.balanceHeaders.size(); i++) {
            WebElement currentElement = customerSummaryLocators.balanceHeaders.get(i);
            String text = currentElement.getText().replaceAll("(?:\\n|\\r)", " ");
            if (text.toLowerCase().trim().equals(header.toLowerCase().trim())) {
                return customerSummaryLocators.balanceData.get(i).getText();
            }
        }
        return null;
    }

    public void clickCalculator() {
        clickUsingJavaScript(customerSummaryLocators.calculator);
    }

    public void verifyBudgetBillingDetailsTitle() {
        assertElementIsVisible(customerSummaryLocators.budgetBillingDetailsTitle,
                testProps().getProperty("customerSummaryPage.verification"));
    }

    public void verifyCustomerName(String customerName) {
        assertTextIsVisible(customerSummaryLocators.customerName,
                testProps().getProperty("customerSummaryPage.verification"), customerName);
    }

    public void verifyBudgetAmount(String budgetAmount) {
        assertTextIsVisible(customerSummaryLocators.budgetAmount,
                testProps().getProperty("customerSummaryPage.verification"), budgetAmount);
    }

    public void verifyCustomerNameDisplayed(String customerName) {
        waitForVisible(customerSummaryLocators.customerNameLabel);
        String name = customerSummaryLocators.customerNameLabel.getText();
        assertTrue(name.contains(customerName));
    }

    public void clickOnEditContactInformationButton() {
        clickElement(customerSummaryLocators.editContactInformationButton);
    }

    public void verifyFieldsBecomeEditable() {
        assertElementIsVisible(customerSummaryLocators.customerTypeDropdown,
                testProps().getProperty("customerSummaryPage.verification"));
    }

    public void editHomePhoneField(String phone) {
        typeEditBox(customerSummaryLocators.homePhoneTextbox, phone);
    }

    public void clickOnSaveButtonFromContaxtInformationInCustomerSummaryPage() {
        scrollToTheTop();
        clickElement(customerSummaryLocators.contactInformationSaveButton);
    }

    public void verifyHomePhoneFieldValue(String phone) {
        String text = customerSummaryLocators.homePhoneTextbox.getAttribute("value");
        assertEquals(text, phone);
    }

    public void selectCustomerType(String customerType) {
        waitForVisible(customerSummaryLocators.customerTypeDropdown);
        selectListByVisibleText(customerSummaryLocators.customerTypeDropdown, customerType);
    }

    public void verifyDataLabelText(String text, WebDriver itsDriver) {
        waitForVisible(customerSummaryLocators.getDataLabelByText(itsDriver, text));
        assertElementIsVisible(customerSummaryLocators.getDataLabelByText(itsDriver, text), text);
    }

    public void enterDba(String dba) {
        waitForVisible(customerSummaryLocators.dbaTextbox);
        typeEditBox(customerSummaryLocators.dbaTextbox, dba);
    }

    public void enterFirstName(String firstName) {
        waitForVisible(customerSummaryLocators.firstNameTextbox);
        typeEditBox(customerSummaryLocators.firstNameTextbox, firstName);
    }

    public void enterMiddleName(String middleName) {
        waitForVisible(customerSummaryLocators.middleNameTextbox);
        typeEditBox(customerSummaryLocators.middleNameTextbox, middleName);
    }

    public void enterLastName(String lastName) {
        waitForVisible(customerSummaryLocators.lastNameTextbox);
        typeEditBox(customerSummaryLocators.lastNameTextbox, lastName);
    }

    public void enterPermitContactName(String permitContactName) {
        waitForVisible(customerSummaryLocators.permitContactNameTextbox);
        waitUntilElementIsClickable(customerSummaryLocators.permitContactNameTextbox);
        typeEditBox(customerSummaryLocators.permitContactNameTextbox, permitContactName);
    }

    public void enterBillingInformationContactName(String contact) {
        waitForVisible(customerSummaryLocators.billingAddressContactTextbox);
        waitUntilElementIsClickable(customerSummaryLocators.billingAddressContactTextbox);
        typeEditBox(customerSummaryLocators.billingAddressContactTextbox, contact);
    }

    public void enterBillingInformationAddressOne(String addressLineOne) {
        waitForVisible(customerSummaryLocators.billingAddressAddressOneTextbox);
        waitUntilElementIsClickable(customerSummaryLocators.billingAddressAddressOneTextbox);
        typeEditBox(customerSummaryLocators.billingAddressAddressOneTextbox, addressLineOne);
    }

    public void enterBillingInformationAddressTwo(String addressLineTwo) {
        waitUntilElementIsClickable(customerSummaryLocators.billingAddressAddressTwoTextbox);
        waitForVisible(customerSummaryLocators.billingAddressAddressTwoTextbox);
        typeEditBox(customerSummaryLocators.billingAddressAddressTwoTextbox, addressLineTwo);
    }

    public void enterBillingInformationCity(String city) {
        waitForVisible(customerSummaryLocators.billingAddressCityTextbox);
        waitUntilElementIsClickable(customerSummaryLocators.billingAddressCityTextbox);
        typeEditBox(customerSummaryLocators.billingAddressCityTextbox, city);
    }

    public void enterBillingInformationCountry(String country) {
        waitForVisible(customerSummaryLocators.billingAddressCountryTextbox);
        waitUntilElementIsClickable(customerSummaryLocators.billingAddressCityTextbox);
        typeEditBox(customerSummaryLocators.billingAddressCountryTextbox, country);
    }

    public void selectBillingInformationState(String state) {
        waitForVisible(customerSummaryLocators.billingAddressStateDropdown);
        waitUntilElementIsClickable(customerSummaryLocators.billingAddressStateDropdown);
        selectListByVisibleText(customerSummaryLocators.billingAddressStateDropdown, state);
    }

    public void enterBillingInformationZip(String zip) {
        waitForVisible(customerSummaryLocators.billingAddressZipTextbox);
        waitUntilElementIsClickable(customerSummaryLocators.billingAddressStateDropdown);
        typeEditBox(customerSummaryLocators.billingAddressZipTextbox, zip);
    }

    public void enterBillingInformationOtherPhone(String otherPhone) {
        waitForVisible(customerSummaryLocators.billingAddressOtherPhoneTextbox);
        waitUntilElementIsClickable(customerSummaryLocators.billingAddressOtherPhoneTextbox);
        typeEditBox(customerSummaryLocators.billingAddressOtherPhoneTextbox, otherPhone);
    }

    public void enterBillingInformationFaxPhone(String fax) {
        waitForVisible(customerSummaryLocators.billingAddressFaxPhoneTextbox);
        waitUntilElementIsClickable(customerSummaryLocators.billingAddressFaxPhoneTextbox);
        typeEditBox(customerSummaryLocators.billingAddressFaxPhoneTextbox, fax);
    }

    public void enterBillingInformationEmail(String email) {
        waitForVisible(customerSummaryLocators.billingAddressEmailTextbox);
        waitUntilElementIsClickable(customerSummaryLocators.billingAddressEmailTextbox);
        typeEditBox(customerSummaryLocators.billingAddressEmailTextbox, email);
    }

    public void enterCorrespondenceInformationAddressOne(String addressLineOne) {
        waitForVisible(customerSummaryLocators.correspondenceAddressAddressOneTextbox);
        waitUntilElementIsClickable(customerSummaryLocators.correspondenceAddressAddressOneTextbox);
        typeEditBox(customerSummaryLocators.correspondenceAddressAddressOneTextbox, addressLineOne);
    }

    public void enterCorrespondenceInformationAddressTwo(String addressLineTwo) {
        waitUntilElementIsClickable(customerSummaryLocators.correspondenceAddressAddressTwoTextbox);
        waitForVisible(customerSummaryLocators.correspondenceAddressAddressTwoTextbox);
        typeEditBox(customerSummaryLocators.correspondenceAddressAddressTwoTextbox, addressLineTwo);
    }

    public void enterCorrespondenceInformationCity(String city) {
        waitForVisible(customerSummaryLocators.correspondenceAddressCityTextbox);
        waitUntilElementIsClickable(customerSummaryLocators.correspondenceAddressCityTextbox);
        typeEditBox(customerSummaryLocators.correspondenceAddressCityTextbox, city);
    }

    public void selectCorrespondenceInformationState(String state) {
        waitForVisible(customerSummaryLocators.correspondenceAddressStateDropdown);
        waitUntilElementIsClickable(customerSummaryLocators.correspondenceAddressStateDropdown);
        selectListByVisibleText(customerSummaryLocators.correspondenceAddressStateDropdown, state);
    }

    public void enterCorrespondenceInformationZip(String zip) {
        waitForVisible(customerSummaryLocators.correspondenceAddressZipTextbox);
        waitUntilElementIsClickable(customerSummaryLocators.correspondenceAddressStateDropdown);
        typeEditBox(customerSummaryLocators.correspondenceAddressZipTextbox, zip);
    }

    public void enterCorrespondenceInformationHomePhone(String phone) {
        waitForVisible(customerSummaryLocators.correspondenceAddressHomePhoneTextbox);
        waitUntilElementIsClickable(customerSummaryLocators.correspondenceAddressHomePhoneTextbox);
        typeEditBox(customerSummaryLocators.correspondenceAddressHomePhoneTextbox, phone);
    }

    public void enterCorrespondenceInformationEmail(String email) {
        waitForVisible(customerSummaryLocators.correspondenceAddressEmailTextbox);
        waitUntilElementIsClickable(customerSummaryLocators.correspondenceAddressEmailTextbox);
        typeEditBox(customerSummaryLocators.correspondenceAddressEmailTextbox, email);
    }

    public void enterPowerOutageContactHomePhone(String phone) {
        waitForVisible(customerSummaryLocators.powerOutageContactHomePhone);
        waitUntilElementIsClickable(customerSummaryLocators.powerOutageContactHomePhone);
        typeEditBox(customerSummaryLocators.powerOutageContactHomePhone, phone);
    }

    public void enterPowerOutageContactOtherPhone(String phone) {
        waitForVisible(customerSummaryLocators.powerOutageContactOtherPhone);
        waitUntilElementIsClickable(customerSummaryLocators.powerOutageContactOtherPhone);
        typeEditBox(customerSummaryLocators.powerOutageContactOtherPhone, phone);
    }

    public void enterPowerOutageConactEmail(String email) {
        waitForVisible(customerSummaryLocators.powerOutageContactEmail);
        waitUntilElementIsClickable(customerSummaryLocators.powerOutageContactEmail);
        typeEditBox(customerSummaryLocators.powerOutageContactEmail, email);
    }
}
