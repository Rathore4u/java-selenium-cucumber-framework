package com.aescis.page.locators.stream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class EmailTemplateAdministrationLocators {

    @Autowired
    public EmailTemplateAdministrationLocators(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[contains(., 'Email Template Administration')]")
    public WebElement emailTemplateAdministrationPageTitle;

    @FindBy(id = "btnAddNew")
    public WebElement addEbillConfigurationButton;

    @FindBy(id = "PanelAddForm")
    public WebElement addConfigurationSection;

    @FindBy(css = "input[id*='Cancel']")
    public WebElement cancelButton;
    
    @FindBy(css = "input[value='Cancel']")
    public WebElement cancelAddBillConfiguration;
    
    @FindBy(xpath = "//span[normalize-space(.)='EBill Email Templates:']")
    public WebElement ebillEmailTemplate;
    
    @FindBy(id = "PanelDefault")
    public WebElement addConfigurationDefaultSection;
}