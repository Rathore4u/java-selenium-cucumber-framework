package com.aescis.stepdefinition.TaskToasterStagingCSR;

import com.aescis.lib.WebDriverActions;
import com.aescis.lib.helper.ScumberException;
import com.aescis.page.functions.taskToaster.TaskSettingsObject;
import com.aescis.page.functions.taskToaster.TasksDashboardObject;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TaskPageSD {
    private static final Logger logger = Logger.getLogger(TaskPageSD.class.getName());

    private WebDriver itsDriver;
    private TasksDashboardObject itsTaskPage;
    private TaskSettingsObject itsTaskSettings;
    private static final String taskSettings = "/Task/Settings/447";
    private static final String wrongDayDataMigrationTask = "/Task/Settings/446";
    private static final String taskDetails = "/Task/Settings/430";
    private static final String preInvoiceValidationMap = "/Task/Settings/425";

    public TaskPageSD() {
        logger.info("Constructor: StreamStagingLoginSD");
    }

    @Before
    public void before(final Scenario scenario)
            throws ScumberException {
        itsDriver = WebDriverActions.openBrowser(scenario);
        itsTaskPage = PageFactory.initElements(itsDriver, TasksDashboardObject.class);
        itsTaskSettings = PageFactory.initElements(itsDriver, TaskSettingsObject.class);
    }

    @When("^Navigate to Task url on \"([^\"]*)\"$")
    public void navigateToTaskPage(String baseUrl) {
        final String pageUrl = "/Task";
        String url = baseUrl.concat(pageUrl);
        itsDriver.get(url);
    }

    @Then("^Tasks Dashboard page is loaded$")
    public void verifyTasksDashboardPageLoaded() {
        itsTaskPage.verifyTasksDashboardPageDisplayed();
    }

    @When("^User enters text \"([^\"]*)\" in search box$")
    public void enterSearchText(String text) {
        itsTaskPage.enterSearchText(text);
    }

    @Then("^(\\d+) records are displayed$")
    public void recordsAreDisplayed(int count) {
        itsTaskPage.verifyCountOfTaskRecords(count);
    }

    @When("^Login to \"([^\"]*)\" with userName : \"([^\"]*)\" and password : \"([^\"]*)\"$")
    public void loginToTaskToasterWithUserNameAndPassword(String baseUrl, String userName, String password) {
        String url = baseUrl.replaceFirst("http://", "");
        String urlWithCredentials = "http://".concat(userName).concat(":").concat(password).concat("@").concat(url);
        itsDriver.get(urlWithCredentials);
    }

    @Then("^Task toaster app is logged in$")
    public void verifyUserLoggedIn() {
        itsTaskPage.verifyUserLoggedIn();
    }

    @When("^Navigate to URL \"([^\"]*)\" /Task/Settings/447$")
    public void navigateToDashboardPaymentsDataMigrationTask(String appUrl) {
        String url = appUrl.concat(taskSettings);
        itsDriver.get(url);
    }

    @When("^Navigate to URL \"([^\"]*)\" /Task/Settings/446$")
    public void navigateToDashboardWrongDayDataMigrationTask(String appUrl) {
        String url = appUrl.concat(wrongDayDataMigrationTask);
        itsDriver.get(url);
    }

    @When("^Navigate to URL \"([^\"]*)\" /Task/Settings/430$")
    public void navigateToQueueClientInvoicesTask(String appUrl) {
        String url = appUrl.concat(taskDetails);
        itsDriver.get(url);
    }

    @When("^Navigate to URL \"([^\"]*)\" /Task/Settings/425$")
    public void navigateToPreInvoiceValidationMap(String appUrl) {
        String url = appUrl.concat(preInvoiceValidationMap);
        itsDriver.get(url);
    }

    @When("^Execute Task for Aep Client$")
    public void executeAEPTask() {
        itsTaskSettings.executeAEPTask();
    }

    @Then("^Check for Task Started$")
    public void verifyTaskRunning() {
        itsTaskSettings.verifyTaskRunning();
    }

    @When("^Wait task to be finished$")
    public void waitTaskFinish() {
        itsTaskSettings.waitTaskFinish();
    }

    @Then("^Verify task to finished$")
    public void verifyTaskFinish() {
        itsTaskSettings.verifyTaskFinish();
    }

    @When("^Click to Aep tab$")
    public void clickLogTabAEP() {
        itsTaskSettings.clickLogTabAEP();
    }

    @Then("^Verify Log Items loaded$")
    public void verifyLogItems() {
        itsTaskSettings.verifyLogItems();
    }

    @When("^Click To Search Button To Refresh Logs$")
    public void clickRefreshLogs() {
        itsTaskSettings.clickRefreshLogs();
    }

    @Then("^Verify Log Items for Started$")
    public void verifyTaskStart() {
        itsTaskSettings.verifyTaskStart();
    }

    @Then("^Verify Log Items for Complete$")
    public void verifyTaskComplete() {
        itsTaskSettings.verifyTaskComplete();
    }

    @When("^Execute Task for Green Mountain Client$")
    public void executeGreenMountainTask() {
        itsTaskSettings.executeGreenMountainTask();
    }

    @When("^Click to Green Mountain tab$")
    public void clickLogTabGreenMountain() {
        itsTaskSettings.clickLogTabGreenMountain();
    }

    @When("^Execute Task for Accent Client$")
    public void executeAccentTask() {
        itsTaskSettings.executeAccentTask();
    }

    @When("^Click to Accent tab$")
    public void clickLogTabAccent() {
        itsTaskSettings.clickLogTabAccent();
    }

    @When("^Execute Task for Spark Client$")
    public void executeSparkTask() {
        itsTaskSettings.executeSparkTask();
    }

    @When("^Click to Spark tab$")
    public void clickLogTabSpark() {
        itsTaskSettings.clickLogTabSpark();
    }

    @When("^Execute Task for Stream Energy Client$")
    public void executeStreamEnergyTask() {
        itsTaskSettings.executeStreamEnergyTask();
    }

    @When("^Click to Stream Energy tab$")
    public void clickLogTabStreamEnergy() {
        itsTaskSettings.clickLogTabStreamEnergy();
    }

    @When("^Execute Task for Startex Power Client$")
    public void executeStartexPowerTask() {
        itsTaskSettings.executeStartexPowerTask();
    }

    @When("^Click to Startex Power tab$")
    public void clickLogTabStartexPower() {
        itsTaskSettings.clickLogTabStartexPower();
    }
}
