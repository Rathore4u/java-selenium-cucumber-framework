package com.aescis.page.locators.taskToaster;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class TasksDashboardLocators {

    @Autowired
    public TasksDashboardLocators(final WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".pace-done")
    public WebElement loadedPage;

    @FindBy(css = "[ng-model=\"filter.key\"]")
    public WebElement searchBox;

    @FindBy(css = "[ng-repeat*=\"data.Tasks\"]")
    public List<WebElement> taskRecords;

    @FindBy(css = "a[href=\"/Task\"]")
    public WebElement taskLink;
}
