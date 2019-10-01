package com.aescis.page.locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerSummaryLocators {

    @Autowired
    public CustomerSummaryLocators(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='Customer Info']")
    public WebElement streamEnergyCommercial;

    @FindBy(xpath = "//a[text()='AR / Billing']")
    public WebElement arBilling;

    @FindBy(css = "a[title='Reverse this late fee.']")
    public WebElement pbcancel;

    @FindBy(css = ".Button.Button-Tiny.noprint")
    public WebElement close;

    @FindBy(css = ".Button.Button-Tiny")
    public WebElement cancel;

    @FindBy(id = "ctl00_cphContent_bnSave")
    public WebElement save;

    @FindBys(@FindBy(xpath = "//table[contains(@id,'ucArBalance_tblAR')]//th"))
    public List<WebElement> balanceHeaders;

    @FindBys(@FindBy(xpath = "//table[contains(@id,'ucArBalance_tblAR')]//td"))
    public List<WebElement> balanceData;

    @FindBy(css = "a[title='Budget Billing Edit Page.']")
    public WebElement calculator;

    @FindBy(xpath = "//div[normalize-space(.)='Budget Billing Details']")
    public WebElement budgetBillingDetailsTitle;

    @FindBy(css = "span[id$=lbCustomerName]")
    public WebElement customerName;

    @FindBy(css = "span[id$=BudgetAmount]")
    public WebElement budgetAmount;

    @FindBy(css = ".lm_service h1")
    public WebElement customerNameLabel;

    @FindBy(css = "input[id*='ibEditContact']")
    public WebElement editContactInformationButton;

    @FindBy(css = "select[name*='ddCustomerType']")
    public WebElement customerTypeDropdown;

    @FindBy(css = "input[name*='tbHomePhone']")
    public WebElement homePhoneTextbox;

    @FindBy(css = "input[id*='ibSaveContact']")
    public WebElement contactInformationSaveButton;

    @FindBy(css = "input[name*='tbDBA']")
    public WebElement dbaTextbox;

    @FindBy(css = "input[name*='tbFirstName']")
    public WebElement firstNameTextbox;

    @FindBy(css = "input[name*='tbMiddleName']")
    public WebElement middleNameTextbox;

    @FindBy(css = "input[name*='tbLastName']")
    public WebElement lastNameTextbox;

    @FindBy(css = "input[name*='tbPermitContactName']")
    public WebElement permitContactNameTextbox;

    @FindBy(css = "input[name*='cscBillAddress_tbAttention']")
    public WebElement billingAddressContactTextbox;

    @FindBy(css = "input[name*='cscBillAddress_tbAddress1']")
    public WebElement billingAddressAddressOneTextbox;

    @FindBy(css = "input[name*='cscBillAddress_tbAddress2']")
    public WebElement billingAddressAddressTwoTextbox;

    @FindBy(css = "input[name*='cscBillAddress_tbCity']")
    public WebElement billingAddressCityTextbox;

    @FindBy(css = "input[name*='cscBillAddress_tbCounty']")
    public WebElement billingAddressCountryTextbox;

    @FindBy(css = "select[name*='cscBillAddress_ddState']")
    public WebElement billingAddressStateDropdown;

    @FindBy(css = "input[name*='cscBillAddress_tbZip']")
    public WebElement billingAddressZipTextbox;

    @FindBy(css = "input[name*='cscBillAddress_tbPhoneExtension']")
    public WebElement billingAddressExtensionTextbox;

    @FindBy(css = "input[name*='cscBillAddress_tbWorkPhone']")
    public WebElement billingAddressWorkPhoneTextbox;

    @FindBy(css = "input[name*='cscBillAddress_tbOtherPhone']")
    public WebElement billingAddressOtherPhoneTextbox;

    @FindBy(css = "input[name*='cscBillAddress_tbFaxPhone']")
    public WebElement billingAddressFaxPhoneTextbox;

    @FindBy(css = "input[name*='cscBillAddress_tbEmail']")
    public WebElement billingAddressEmailTextbox;

    // ----------------------
    @FindBy(css = "input[name*='cscCorrAddress_tbAddress1']")
    public WebElement correspondenceAddressAddressOneTextbox;

    @FindBy(css = "input[name*='cscCorrAddress_tbAddress2']")
    public WebElement correspondenceAddressAddressTwoTextbox;

    @FindBy(css = "input[name*='cscCorrAddress_tbCity']")
    public WebElement correspondenceAddressCityTextbox;

    @FindBy(css = "select[name*='cscCorrAddress_ddState']")
    public WebElement correspondenceAddressStateDropdown;

    @FindBy(css = "input[name*='cscCorrAddress_tbZip']")
    public WebElement correspondenceAddressZipTextbox;

    @FindBy(css = "input[name*='cscCorrAddress_tbHomePhone']")
    public WebElement correspondenceAddressHomePhoneTextbox;

    @FindBy(css = "input[name*='cscCorrAddress_tbEmail']")
    public WebElement correspondenceAddressEmailTextbox;

    @FindBy(css = "input[name*='cscPowerOutageContact_tbHomePhone']")
    public WebElement powerOutageContactHomePhone;

    @FindBy(css = "input[name*='cscPowerOutageContact_tbOtherPhone']")
    public WebElement powerOutageContactOtherPhone;

    @FindBy(css = "input[name*='cscPowerOutageContact_tbEmail']")
    public WebElement powerOutageContactEmail;

    public WebElement getDataLabelByText(WebDriver itsDriver, String text) {
		String xpath = String.format("//td[@class='fld' and contains(.,\"%s\")]", text);
		return itsDriver.findElement(By.xpath(xpath));
	}
}
