package com.aescis.page.locators.stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class NewRequestServicePageLocators {
    @Autowired
    public NewRequestServicePageLocators(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//b[contains(text(),'Enrollment Status:')]")
    public WebElement enrollmentStatusLabel;

    @FindBy(css = "[id*='ddServiceState']")
    public WebElement serviceStateDropDown;

    @FindBy(css = "input[id*='cbxPreference1']")
    public WebElement emailCheckBox;

    @FindBy(css = "input[id*='cbxPreference2']")
    public WebElement mailCheckBox;

    @FindBy(css = "[id*='spnEmail'][disabled='disabled']")
    public WebElement emailMandatorySymbol;

    public WebElement serviceStateSelected(WebDriver itsDriver, String selectedState) {
        String css = String.format("select [selected='selected'][value='%s']", selectedState);
        return itsDriver.findElement(By.cssSelector(css));
    }
}