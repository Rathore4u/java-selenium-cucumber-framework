package com.aescis.page.functions.aep;

import com.aescis.lib.helper.PropertiesLoader;
import com.aescis.lib.utils.AbstractBasePage;
import com.aescis.page.locators.aep.CustomerCloneUtilityLocators;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerCloneUtilityPageObject extends AbstractBasePage {

    private final CustomerCloneUtilityLocators customerCloneUtilityLocators;

    @Autowired
    public CustomerCloneUtilityPageObject(final WebDriver driver)
    {
        super(driver);
        customerCloneUtilityLocators = PageFactory.initElements(driver, CustomerCloneUtilityLocators.class);
    }

    private static Properties testProps()
    {
        return PropertiesLoader.getInstance().load("message.properties");
    }

    public void enterNoOfClones(final String count)
    {
        waitForVisible(customerCloneUtilityLocators.noOfClonesTextBox);
        typeEditBox(customerCloneUtilityLocators.noOfClonesTextBox, count);
    }

    public void clickCloneCustomerButton()
    {
        clickElement(customerCloneUtilityLocators.cloneCustomerButton);
    }

    public void verifyCloneCustomerUtilityPageDisplayed()
    {
        assertElementIsVisible(customerCloneUtilityLocators.cloneCustomerButton,
                testProps().getProperty("customerCloneUtilityPage.verification"));
    }

    public void verifyCloneSuccessful()
    {
        assertTextIsVisible(customerCloneUtilityLocators.cloneSuccessMessage,
                testProps().getProperty("customerCloneUtilityPage.verification"),
                "Clone Process Successful! Report of new customer IDs scheduled in your queue.");
    }
}
