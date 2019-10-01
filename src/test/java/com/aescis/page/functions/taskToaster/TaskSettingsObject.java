package com.aescis.page.functions.taskToaster;

import com.aescis.lib.helper.PropertiesLoader;
import com.aescis.lib.utils.AbstractBasePage;
import com.aescis.page.locators.taskToaster.TaskSettingsLocators;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class TaskSettingsObject extends AbstractBasePage {

    private final TaskSettingsLocators taskSettingsLocators;

    @Autowired
    public TaskSettingsObject(final WebDriver driver) {
        super(driver);
        taskSettingsLocators = PageFactory.initElements(driver, TaskSettingsLocators.class);
    }

    static private Properties testProps() {
        return PropertiesLoader.getInstance().load("message.properties");
    }

    public void executeAEPTask() {
        clickElement(taskSettingsLocators.clientAEPExecute);
    }

    public void verifyTaskRunning() {
        assertElementIsVisible(taskSettingsLocators.runningTask,
            testProps().getProperty("tasksDashboardPage.verification"));
    }

    public void waitTaskFinish() {
        waitForNotVisible(taskSettingsLocators.runningTaskLocator());
    }

    public void verifyTaskFinish() {
        assertElementIsNotVisible(taskSettingsLocators.runningTask,
            taskSettingsLocators.runningTaskLocator(),
            testProps().getProperty("tasksDashboardPage.verification"));
    }

    public void clickLogTabAEP() {
        clickElement(taskSettingsLocators.logTabAEP);
    }

    public void verifyLogItems() {
        assertElementIsVisible(taskSettingsLocators.logItems,
            testProps().getProperty("tasksDashboardPage.verification"));
    }

    public void clickRefreshLogs() {
        clickElement(taskSettingsLocators.refreshLogs);
    }

    public void verifyTaskStart() {
        assertElementIsVisible(taskSettingsLocators.taskStart,
            testProps().getProperty("tasksDashboardPage.verification"));
    }

    public void verifyTaskComplete() {
        assertElementIsVisible(taskSettingsLocators.taskComplete,
            testProps().getProperty("tasksDashboardPage.verification"));
    }

    public void executeGreenMountainTask() {
        clickElement(taskSettingsLocators.clientGreenMountainExecute);
    }

    public void clickLogTabGreenMountain() {
        clickElement(taskSettingsLocators.logTabGreenMountain);
    }

    public void executeAccentTask() {
        clickElement(taskSettingsLocators.clientAccentExecute);
    }

    public void clickLogTabAccent() {
        clickElement(taskSettingsLocators.logTabAccent);
    }

    public void executeSparkTask() {
        clickElement(taskSettingsLocators.clientSparkExecute);
    }

    public void clickLogTabSpark() {
        clickElement(taskSettingsLocators.logTabSpark);
    }

    public void executeStreamEnergyTask() {
        clickElement(taskSettingsLocators.clientStreamEnergyExecute);
    }

    public void clickLogTabStreamEnergy() {
        clickElement(taskSettingsLocators.logTabStreamEnergy);
    }

    public void executeStartexPowerTask() {
        clickElement(taskSettingsLocators.clientStartexPowerExecute);
    }

    public void clickLogTabStartexPower() {
        clickElement(taskSettingsLocators.logTabStartexPower);
    }
}
