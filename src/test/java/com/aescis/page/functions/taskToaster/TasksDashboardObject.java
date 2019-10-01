package com.aescis.page.functions.taskToaster;

import com.aescis.lib.helper.PropertiesLoader;
import com.aescis.lib.utils.AbstractBasePage;
import com.aescis.lib.utils.WebElementHelperMethods;
import com.aescis.page.locators.taskToaster.TasksDashboardLocators;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

public class TasksDashboardObject extends AbstractBasePage {

    private final TasksDashboardLocators tasksDashboardLocators;

    @Autowired
    public TasksDashboardObject(final WebDriver driver) {
        super(driver);
        tasksDashboardLocators = PageFactory.initElements(driver, TasksDashboardLocators.class);
    }

    static private Properties testProps()
    {
        return PropertiesLoader.getInstance().load("message.properties");
    }

    public void verifyTasksDashboardPageDisplayed() {
        assertElementIsVisible(tasksDashboardLocators.loadedPage, testProps().getProperty("tasksDashboardPage.verification"));
    }

    public void enterSearchText(final String text) {
        waitForVisible(tasksDashboardLocators.searchBox);
        typeEditBox(tasksDashboardLocators.searchBox, text);
    }

    public void verifyUserLoggedIn() {
        assertElementIsVisible(tasksDashboardLocators.taskLink,
                testProps().getProperty("tasksToastLogin.verification"));
    }

    public void verifyCountOfTaskRecords(final int count) {
        assertCountOfElements(tasksDashboardLocators.taskRecords,
                testProps().getProperty("TaskRecordCount.verification"),
                count);
    }
}
