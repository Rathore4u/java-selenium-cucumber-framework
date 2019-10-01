package com.aescis.page.locators.aep;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerCloneUtilityLocators {
    @Autowired
    public CustomerCloneUtilityLocators(final WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "bnClone")
    public WebElement cloneCustomerButton;

    @FindBy(id = "tbNumClones")
    public WebElement noOfClonesTextBox;

    @FindBy(id = "lbMessage")
    public WebElement cloneSuccessMessage;
}
