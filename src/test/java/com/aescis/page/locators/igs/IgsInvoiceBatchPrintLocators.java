package com.aescis.page.locators.igs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class IgsInvoiceBatchPrintLocators {

    @Autowired
    public IgsInvoiceBatchPrintLocators(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[.='INVOICE BATCH PRINT ADMINISTRATION']")
    public WebElement invoicePrintAdministrationTitle;
}