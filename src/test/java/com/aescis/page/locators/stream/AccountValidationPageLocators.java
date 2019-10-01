package com.aescis.page.locators.stream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountValidationPageLocators {
    @Autowired
    public AccountValidationPageLocators(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[id*='creditandAccountValidation_btnValidateSEP']")
    public WebElement buttonValidateSEP;

    @FindBy(css = "input[id*='txtFirstName']")
    public WebElement firstNameTextBox;

    @FindBy(css = "input[id*='txtLastName']")
    public WebElement lastNameTextBox;

    @FindBy(css = "input[id*='txtPhone']")
    public WebElement phoneNumberTextBox;

    @FindBy(css = "input[id*='txtSSN']")
    public WebElement fullSSNText;

    @FindBy(css = "input[id*='txtAddress1']")
    public WebElement addressOneTextField;

    @FindBy(css = "input[id*='txtAddress2']")
    public WebElement addressTwoTextField;

    @FindBy(css = "input[id*='txtCity']")
    public WebElement cityTextField;

    @FindBy(css = "input[id*='txtZip1']")
    public WebElement zipCodeOneTextField;

    @FindBy(css = "input[id*='txtZip2']")
    public WebElement zipCodeTwoTextField;

    @FindBy(css = "input[id*='txtAGLCAcct']")
    public WebElement aglcAccountTextBox;

    @FindBy(css = "input[id*='txtSEP']")
    public WebElement sepTextBox;

    @FindBy(css = "[id*='creditandAccountValidation_lblError']")
    public WebElement accountValidationError;
}