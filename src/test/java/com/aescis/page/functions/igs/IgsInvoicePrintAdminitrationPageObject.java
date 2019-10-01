package com.aescis.page.functions.igs;

import java.util.Properties;

import com.aescis.lib.helper.PropertiesLoader;
import com.aescis.lib.utils.AbstractBasePage;
import com.aescis.page.locators.igs.IgsInvoiceBatchPrintLocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class IgsInvoicePrintAdminitrationPageObject extends AbstractBasePage {
    final IgsInvoiceBatchPrintLocators invoiceBatchLocators;

    @Autowired
    public IgsInvoicePrintAdminitrationPageObject(final WebDriver driver) {
        super(driver);
        invoiceBatchLocators = PageFactory.initElements(driver, IgsInvoiceBatchPrintLocators.class);
    }

    public Properties testProps() {
        return PropertiesLoader.getInstance().load("message.properties");
    }

    public void verifyInvoiceBatchPrintAdminitrationPageDisplayed() {
        assertElementIsVisible(invoiceBatchLocators.invoicePrintAdministrationTitle,
                testProps().getProperty("loginPage.verification"));
    }
}