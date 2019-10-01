package com.aescis.stepdefinition.SparkStagingCSR;

import com.aescis.lib.WebDriverActions;
import com.aescis.lib.helper.ScumberException;
import com.aescis.page.functions.spark.MeterLoadPageObject;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MeterLoadProfileSD {

    private WebDriver itsDriver;
    private MeterLoadPageObject itsPage;

    @Before
    public void before(final Scenario scenario)
            throws ScumberException
    {
        itsDriver = WebDriverActions.openBrowser(scenario);
        itsPage = PageFactory.initElements(itsDriver, MeterLoadPageObject.class);
    }

    @When("^Navigate to meter load page of \"([^\"]*)\" for meter \"([^\"]*)\"$")
    public void navigateToMeterLoadPage(String sparkUrl, String meterID) {
        final String pageUrl = "/csr/meterdetail.aspx?MeterId=";
        String url = sparkUrl.concat(pageUrl.concat(meterID));
        itsDriver.get(url);
    }

    @Then("^Meter load page should display with (\\d+) row$")
    public void meterLoadPageShouldDisplayWithRow(int rowCount) {
        itsPage.verifyPageLoaded();
        itsPage.verifyCountOfRows(rowCount);
    }

    @Then("^Meter load page should display with invalid meter ID$")
    public void meterLoadPageShouldDisplayWithNoRow() {
        itsPage.verifyPageLoaded();
        itsPage.verifyNoRowDisplayedForInvalidMeterId();
    }
}
