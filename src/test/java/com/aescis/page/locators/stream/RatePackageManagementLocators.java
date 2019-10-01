package com.aescis.page.locators.stream;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class RatePackageManagementLocators {

    @Autowired
    public RatePackageManagementLocators(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "form[action*='RatePackages']")
    public WebElement RatePackageManagementForm;

    @FindBy(css = "input[id*='txtPackageName']")
    public WebElement packageNameTextbox;

    @FindAll({ @FindBy(css = "a[href*='ViewRatePackage']") })
    public List<WebElement> packageListLinks;

    @FindBy(css = "//td[.='No records matched your criteria.']")
    public WebElement NoRecordsMatchedYourCriteriaMessage;
}