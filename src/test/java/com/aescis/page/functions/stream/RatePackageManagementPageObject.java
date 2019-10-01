package com.aescis.page.functions.stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Properties;

import com.aescis.lib.helper.PropertiesLoader;
import com.aescis.lib.utils.AbstractBasePage;
import com.aescis.page.locators.stream.RatePackageManagementLocators;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class RatePackageManagementPageObject extends AbstractBasePage {
    final RatePackageManagementLocators ratePackageManagementLocators;

    @Autowired
    public RatePackageManagementPageObject(final WebDriver driver) {
        super(driver);
        ratePackageManagementLocators = PageFactory.initElements(driver, RatePackageManagementLocators.class);
    }

    public Properties testProps() {
        return PropertiesLoader.getInstance().load("message.properties");
    }

    public void verifyRatePackageManagementPageIsDisplayed() {
        assertElementIsVisible(ratePackageManagementLocators.RatePackageManagementForm,
                testProps().getProperty("RatePackageManagementPage.verification"));
    }

    public void enterPackageName(String packageName) {
        waitForVisible(ratePackageManagementLocators.packageNameTextbox);
        typeEditBox(ratePackageManagementLocators.packageNameTextbox, packageName);
    }

    public void pressEnterFromInsidePackageName() {
        waitForVisible(ratePackageManagementLocators.packageNameTextbox);
        pressKey(ratePackageManagementLocators.packageNameTextbox, Keys.ENTER);
    }

    public void verifyAllRatePackageNamesStartWith(String text) {
        Boolean containsTheText = true;
        for (final WebElement element : ratePackageManagementLocators.packageListLinks) {
            if (!element.getText().contains(text)) {
                containsTheText = false;
            }
        }
        assertTrue(containsTheText);
    }

    public void verifyNoRecordsMatchedYourCriteriaMessageDisplayed(){
        assertElementIsVisible(ratePackageManagementLocators.RatePackageManagementForm,
        testProps().getProperty("verifyNoRecordsMatchedYourCriteriaMessageDisplayed.verification"));
    }
}