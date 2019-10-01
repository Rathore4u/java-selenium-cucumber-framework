package com.aescis.page.locators.stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AutoInvoiceConfigurationPageLocators {

    @Autowired
    public AutoInvoiceConfigurationPageLocators(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[contains(text(), 'Auto Invoice Configuration')]")
    public WebElement autoInvoiceConfigHeading;

    @FindBys(@FindBy(css = "#DefaultsGridView input[type=image]"))
    public List<WebElement> editConfigurationIcon;

    @FindBy(css = "[id*=RunHoursTextBox]")
    public WebElement runHoursTextBox;

    @FindBy(css = "input[src*='save']")
    public WebElement saveIconInConfigPage;

    @FindBy(css = "[id*='RunOnWeekendYesButton']")
    public WebElement yesRunOnWeekend;

    @FindBy(css = "[id*='RunOnWeekendNoButton']")
    public WebElement noRunOnWeekend;

    public WebElement defaultRunHoursValue(WebDriver itsDriver, String hoursValue) {
        String xpath = String.format("//*[@id='DefaultsGridView']//td[contains(text(),\"%s\")]", hoursValue);
        return itsDriver.findElement(By.xpath(xpath));
    }
}