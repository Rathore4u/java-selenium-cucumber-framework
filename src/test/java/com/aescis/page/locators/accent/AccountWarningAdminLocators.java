package com.aescis.page.locators.accent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountWarningAdminLocators {
    @Autowired
    public AccountWarningAdminLocators(final WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div.PageContentTitleBar")
    public WebElement heading;

    @FindBy(id = "lvWarnings_ctrl0_tbWarningTextInsert")
    public WebElement warningTextBox;

    @FindBy(id = "lvWarnings_ctrl0_bnInsert")
    public WebElement insertButton;

    @FindBy(id = "lvWarnings_ctrl0_bnEdit")
    public WebElement editButton;

    @FindBy(id = "lvWarnings_ctrl0_cbActiveEdit")
    public WebElement activeCheckBox;

    @FindBy(id = "lvWarnings_ctrl0_bnUpdateEdit")
    public WebElement updateButton;

    @FindBy(id = "lvWarnings_ctrl0_calCreateDateEdit_imgCalButton")
    public WebElement calendarIcon;

    @FindBy(css = "[id*=CreateDateEdit_calDate_20]")
    public WebElement anyDate;

    @FindBy(id = "lvWarnings_ctrl0_bnDelete")
    public WebElement deleteButton;

    @FindBy(id = "lvWarnings_ctrl0_tbWarningTextEdit")
    public WebElement warningTextBoxEdit;
}
