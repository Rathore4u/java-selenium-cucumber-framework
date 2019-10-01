package com.aescis.page.locators.taskToaster;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class TaskSettingsLocators {

    @Autowired
    public TaskSettingsLocators(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[div[normalize-space(.)='AEPEnergy']]//a[text()='Execute']")
    public WebElement clientAEPExecute;

    @FindBy(css = "[ng-repeat*='task in runningTasks']")
    public WebElement runningTask;

    public By runningTaskLocator() {
        return By.cssSelector("[ng-repeat*='task in runningTasks']");
    }

    @FindBy(css = "li[heading='AEPEnergy'] a")
    public WebElement logTabAEP;

    @FindBy(css = "li[ng-repeat='logItem in logItems']")
    public WebElement logItems;

    @FindBy(css = "a[ng-click='refreshData()']")
    public WebElement refreshLogs;

    @FindBy(xpath = "//*[contains(text(),' is preparing to start.')]")
    public WebElement taskStart;

    @FindBy(xpath = "//*[contains(text(),' is completed.')]")
    public WebElement taskComplete;

    @FindBy(xpath = "//div[div[normalize-space(.)='Green Mountain Energy']]//a[text()='Execute']")
    public WebElement clientGreenMountainExecute;

    @FindBy(css = "li[heading='Green Mountain Energy'] a")
    public WebElement logTabGreenMountain;

    @FindBy(xpath = "//div[div[normalize-space(.)='Accent']]//a[text()='Execute']")
    public WebElement clientAccentExecute;

    @FindBy(css = "li[heading='Accent'] a")
    public WebElement logTabAccent;

    @FindBy(xpath = "//div[div[normalize-space(.)='Spark']]//a[text()='Execute']")
    public WebElement clientSparkExecute;

    @FindBy(css = "li[heading='Spark'] a")
    public WebElement logTabSpark;

    @FindBy(xpath = "//div[div[normalize-space(.)='Stream Energy']]//a[text()='Execute']")
    public WebElement clientStreamEnergyExecute;

    @FindBy(css = "li[heading='Stream Energy'] a")
    public WebElement logTabStreamEnergy;

    @FindBy(xpath = "//div[div[normalize-space(.)='Startex Power']]//a[text()='Execute']")
    public WebElement clientStartexPowerExecute;

    @FindBy(css = "li[heading='Startex Power'] a")
    public WebElement logTabStartexPower;
}
