package com.aescis.page.functions.stream;

import com.aescis.lib.helper.PropertiesLoader;
import com.aescis.lib.utils.AbstractBasePage;
import com.aescis.page.locators.spark.AccountsLocators;
import com.aescis.page.locators.stream.AutoInvoiceConfigurationPageLocators;
import com.aescis.page.locators.stream.EmailTemplateAdministrationLocators;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class AutoInvoiceConfigurationPageObject extends AbstractBasePage {
    private final AutoInvoiceConfigurationPageLocators autoInvoiceConfigPageLocators;

    @Autowired
    public AutoInvoiceConfigurationPageObject(final WebDriver driver) {
        super(driver);
        autoInvoiceConfigPageLocators = PageFactory.initElements(driver, AutoInvoiceConfigurationPageLocators.class);
    }

    static private Properties testProps() {
        return PropertiesLoader.getInstance().load("message.properties");
    }

    public void verifyAutoInvoicePage() {
        assertElementIsVisible(autoInvoiceConfigPageLocators.autoInvoiceConfigHeading, testProps().getProperty("autoInvoiceConfigurationPage.verification"));
    }

    public void clickDefaultRunEditIcon() {
        clickElement(autoInvoiceConfigPageLocators.editConfigurationIcon.get(0));
        waitForVisible(autoInvoiceConfigPageLocators.runHoursTextBox);
    }

    public void enterRunHoursValue(String hoursValue) {
        typeEditBox(autoInvoiceConfigPageLocators.runHoursTextBox, hoursValue);
    }

    public void clickSaveInConfiguration() {
        clickElement(autoInvoiceConfigPageLocators.saveIconInConfigPage);
    }

    public void verifyHoursValueEntered(String hoursValue) {
        assertElementIsVisible(autoInvoiceConfigPageLocators.defaultRunHoursValue(itsDriver, hoursValue), hoursValue);
    }

    public void clickRunWeekendsEditIcon() {
        clickElement(autoInvoiceConfigPageLocators.editConfigurationIcon.get(1));
    }

    public void selectYesInRunWeekDays() {
        clickElement(autoInvoiceConfigPageLocators.yesRunOnWeekend);
    }

    public void selectNoInRunWeekDays() {
        clickElement(autoInvoiceConfigPageLocators.noRunOnWeekend);
    }
}