package com.aescis.page.functions.accent;

import com.aescis.lib.helper.PropertiesLoader;
import com.aescis.lib.utils.AbstractBasePage;
import com.aescis.page.locators.accent.AccountWarningAdminLocators;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountWarningAdminPageObject extends AbstractBasePage {
    private final AccountWarningAdminLocators accountWarningAdminLocators;

    @Autowired
    public AccountWarningAdminPageObject(final WebDriver driver) {
        super(driver);
        accountWarningAdminLocators = PageFactory.initElements(driver, AccountWarningAdminLocators.class);
    }

    static private Properties testProps() {
        return PropertiesLoader.getInstance().load("message.properties");
    }

    public void verifyPage() {
        waitForVisible(accountWarningAdminLocators.warningTextBox);
        assertTextIsVisible(accountWarningAdminLocators.heading,  testProps().getProperty("accountWarningPage.verification"),
                "Account Warning Admininstration");
    }

    public void enterWarningText(String text) {
        typeEditBox(accountWarningAdminLocators.warningTextBox, text);
    }

    public void enterWarningTextInEditRow(String text) {
        typeEditBox(accountWarningAdminLocators.warningTextBoxEdit, text);
    }

    public void clickInsertButton() {
        clickElement(accountWarningAdminLocators.insertButton);
    }

    public void verifyRowSaved() {
        assertElementIsVisible(accountWarningAdminLocators.editButton,
                testProps().getProperty("warningRowSaved.verification"));
    }

    public void verifyRowEditable() {
        assertElementIsVisible(accountWarningAdminLocators.warningTextBoxEdit,
                testProps().getProperty("warningRowSaved.verification"));
    }

    public void clickEditButton() {
        clickElement(accountWarningAdminLocators.editButton);
    }

    public void clickActiveCheckbox() {
        clickElement(accountWarningAdminLocators.activeCheckBox);
    }

    public void setCalendarDate() {
        clickElement(accountWarningAdminLocators.calendarIcon);
        clickElement(accountWarningAdminLocators.anyDate);
    }

    public void clickUpdateButton() {
        clickElement(accountWarningAdminLocators.updateButton);
    }

    public void clickDeleteButton() {
        clickElement(accountWarningAdminLocators.deleteButton);
    }

    public void verifyRowDeleted() {
        assertElementIsVisible(accountWarningAdminLocators.warningTextBox, testProps().getProperty("warningRowSaved.verification"));
    }
}
