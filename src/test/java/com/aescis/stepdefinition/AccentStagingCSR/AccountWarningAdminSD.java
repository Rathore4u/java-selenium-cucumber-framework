package com.aescis.stepdefinition.AccentStagingCSR;

import com.aescis.lib.WebDriverActions;
import com.aescis.lib.helper.ScumberException;
import com.aescis.page.functions.accent.AccountWarningAdminPageObject;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AccountWarningAdminSD {

    private WebDriver itsDriver;
    private AccountWarningAdminPageObject itsPage;

    @Before
    public void before(final Scenario scenario) throws ScumberException
    {
        itsDriver = WebDriverActions.openBrowser(scenario);
        itsPage = PageFactory.initElements(itsDriver, AccountWarningAdminPageObject.class);
    }

    @Then("^Account warning administration page is loaded$")
    public void verifyPageLoaded() {
        itsPage.verifyPage();
    }

    @When("^User puts text \"([^\"]*)\" and clicks insert button$")
    public void userPutsTextAndClicksInsertButton(String text) {
        itsPage.enterWarningText(text);
        itsPage.clickInsertButton();
    }

    @Then("^Row should be (created|updated) successfully on Account Warning Administration page$")
    public void rowShouldBeCreatedSuccessfully(String created) {
        itsPage.verifyRowSaved();
    }

    @When("^User clicks on edit button on first row on Account Warning Administration page$")
    public void userClicksOnEditButton() {
        itsPage.clickEditButton();
    }

    @Then("^Row should become editable on Account Warning Administration page$")
    public void rowShouldBecomeEditable() {
        itsPage.verifyRowEditable();
    }

    @When("^User checks active checkbox, changes text to \"([^\"]*)\", updates date and clicks update button$")
    public void userUpdatesRow(String text) {
        itsPage.clickActiveCheckbox();
        itsPage.enterWarningTextInEditRow(text);
        itsPage.setCalendarDate();
        itsPage.clickUpdateButton();
    }

    @When("^User click delete button for row on Account Warning Administration page$")
    public void userClickDeleteButtonForRow() {
        itsPage.clickDeleteButton();
    }

    @Then("^First row of Account Warning Administration page should be deleted$")
    public void rowShouldBeDeleted() {
        itsPage.verifyRowDeleted();
    }
}
