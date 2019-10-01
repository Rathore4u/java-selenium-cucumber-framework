package com.aescis.stepdefinition.IsgEnergyCSR;

import java.util.logging.Logger;

import com.aescis.lib.WebDriverActions;
import com.aescis.lib.helper.ScumberException;
import com.aescis.page.functions.igs.IgsInvoicePrintAdminitrationPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;

public class IgsInvoicePrintAdminitrationSD {
    private final static Logger Log = Logger.getLogger(IgsInvoicePrintAdminitrationSD.class.getName());
    private WebDriver itsDriver;
    private IgsInvoicePrintAdminitrationPageObject itsInvoice;

    public IgsInvoicePrintAdminitrationSD() {
        Log.info("Constructor: IgsInvoicePrintAdminitrationSD");
    }

    @Before
    public void before(final Scenario scenario) throws ScumberException {
        itsDriver = WebDriverActions.openBrowser(scenario);
        itsInvoice = PageFactory.initElements(itsDriver, IgsInvoicePrintAdminitrationPageObject.class);
    }

    @Then("^Then INVOICE BATCH PRINT ADMINISTRATION Screen Loaded\\.$")
    public void verifyInvoiceBatchPrintAdministrationPageDisplayed() {
        itsInvoice.verifyInvoiceBatchPrintAdminitrationPageDisplayed();
    }
}
