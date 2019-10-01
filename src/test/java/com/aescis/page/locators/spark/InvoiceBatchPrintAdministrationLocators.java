package com.aescis.page.locators.spark;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class InvoiceBatchPrintAdministrationLocators {

    @Autowired
    public InvoiceBatchPrintAdministrationLocators(final WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "img[src*='/ic_help_blue.gif']")
    public WebElement helpIcon;

    @FindBy(xpath = "//h1[normalize-space(.)='INVOICE BATCH PRINT ADMINISTRATION']")
    public WebElement pageHeading;

    @FindBy(css = "a[href='LetterBatchPrint.aspx']")
    public WebElement letterBatchPrintAdministration;

    @FindBy(xpath = "//h1[normalize-space(.)='LETTER BATCH PRINT ADMINISTRATION']")
    public WebElement letterBatchPrintAdministrationHeading;

    @FindBy(id = "tbInvoiceID")
    public WebElement reportInvoiceTextBox;

    @FindBy(id = "PageTitle")
    public WebElement invoiceEstimatesPageTitle;

    @FindBy(css = "input[id*='tbDateFrom']")
    public WebElement fromDateTextBox;

    @FindBy(css = "input[id*='tbDateTo']")
    public WebElement toDateTextBox;

    @FindBy(css = "[id*='bnList']")
    public WebElement listEstimatesButton;

    @FindBy(css = "[id*='uprPage'][aria-hidden='false']")
    public WebElement loadingEstimatesIcon;

    @FindBys(@FindBy(css = "[id*='upGrid'] tr"))
    public List<WebElement> estimatesSearchResults;

    public By loadingIcon() {
        return By.cssSelector("[id*='uprPage'][aria-hidden='false']");
    }
}
