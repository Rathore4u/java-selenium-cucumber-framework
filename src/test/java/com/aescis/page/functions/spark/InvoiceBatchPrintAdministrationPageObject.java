package com.aescis.page.functions.spark;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.aescis.lib.helper.PropertiesLoader;
import com.aescis.lib.utils.AbstractBasePage;
import com.aescis.page.locators.LoginLocators;
import com.aescis.page.locators.spark.InvoiceBatchPrintAdministrationLocators;

/**
 * <!--
 * ==========================================================================================================
 * --> This Class contains all method's specific to INVOICE BATCH PRINT
 * ADMINISTRATION page
 * 
 * @author Rajpal Singh
 * @lastrev fixXXXXX - new class <!--
 *          --------------------------------------------------------------------------------------------------------
 *          -->
 */
public class InvoiceBatchPrintAdministrationPageObject extends AbstractBasePage {
	final LoginLocators loginPageLocators;
	final InvoiceBatchPrintAdministrationLocators invoiceBatchPrintAdministrationLocators;

	@Autowired
	public InvoiceBatchPrintAdministrationPageObject(final WebDriver driver) {
		super(driver);
		loginPageLocators = PageFactory.initElements(driver, LoginLocators.class);
		invoiceBatchPrintAdministrationLocators = PageFactory.initElements(driver,
				InvoiceBatchPrintAdministrationLocators.class);
	}

	public Properties testProps() {
		return PropertiesLoader.getInstance().load("invoiceBatchPrintAdministrationMessage.properties");
	}

	public void verifyPageLoaded() {
		waitForVisible(invoiceBatchPrintAdministrationLocators.helpIcon);
		assertElementIsVisible(invoiceBatchPrintAdministrationLocators.pageHeading,
				testProps().getProperty("invoiceBatchPrintAdministrationPage.verification"));
	}

	public void clickLetterBatchPrintAdministration() {
		clickElement(invoiceBatchPrintAdministrationLocators.letterBatchPrintAdministration);
	}

	public void verifyLetterBatchPrintAdministrationPage() {
		assertElementIsVisible(invoiceBatchPrintAdministrationLocators.letterBatchPrintAdministrationHeading,
				testProps().getProperty("letterBatchPrintAdministrationPage.verification"));
	}

	public void verifyPageInvoiceBatchPageLoaded() {
	    waitForVisible(invoiceBatchPrintAdministrationLocators.reportInvoiceTextBox);
		assertElementIsVisible(invoiceBatchPrintAdministrationLocators.pageHeading,
				testProps().getProperty("invoiceBatchPrintAdministrationPage.verification"));
	}

    public void verifyInvoiceEstimatesPage() {
        checkTextToBePresentInElement(invoiceBatchPrintAdministrationLocators.invoiceEstimatesPageTitle, "Estimate List - TDSP Charges without Consumption");
    }

    public void enterSearchFilterDate(String fromDate, String toDate) {
        typeEditBox(invoiceBatchPrintAdministrationLocators.fromDateTextBox, fromDate);
        typeEditBox(invoiceBatchPrintAdministrationLocators.toDateTextBox, toDate);
        clickElement(invoiceBatchPrintAdministrationLocators.listEstimatesButton);
        waitForVisible(invoiceBatchPrintAdministrationLocators.loadingEstimatesIcon);
        waitForNotVisible(invoiceBatchPrintAdministrationLocators.loadingIcon());
    }

    public void verifyInvoiceEstimatesResultsSection() {
        assertElementIsVisible(invoiceBatchPrintAdministrationLocators.estimatesSearchResults.get(0), testProps().getProperty("invoiceEstimatesSearchResult.verification"));
    }
}