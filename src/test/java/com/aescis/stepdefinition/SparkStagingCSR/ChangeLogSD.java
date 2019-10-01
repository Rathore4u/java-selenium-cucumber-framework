package com.aescis.stepdefinition.SparkStagingCSR;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aescis.lib.WebDriverActions;
import com.aescis.lib.helper.ScumberException;
import com.aescis.page.functions.spark.ChangeLogPageObjects;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ChangeLogSD {
	private final static Logger Log = Logger.getLogger(ChangeLogSD.class.getName());
	private final String pageUrl = "/csr/changelog.aspx";
	
	
	private WebDriver itsDriver;
	private ChangeLogPageObjects itsChangeLog;

	public ChangeLogSD() {
		Log.info("Constructor: ChangeLogSD");
	}

	@Before
	public void before(final Scenario scenario) throws ScumberException {
		itsDriver = WebDriverActions.openBrowser(scenario);
		itsChangeLog = PageFactory.initElements(itsDriver, ChangeLogPageObjects.class);
	}

	@When("^Navigate to URL-> \"([^\"]*)\" /csr/changelog\\.aspx$")
	public void navigateToUrlCsrChangelogAspx(String appUrl) throws Throwable {
		String url = appUrl.concat(pageUrl);
		itsDriver.get(url);
	}

	@Then("^Change Log page is loaded$")
	public void changeLogPageIsLoaded() throws Throwable {
		itsChangeLog.verifyPageLoaded();
	}

	@When("^In Customer No put \"([^\"]*)\" and click to Get Customer$")
	public void inCustomerNoPutAndClickToGetCustomer(String number) throws Throwable {
		itsChangeLog.enterCustomerNumber(number);
		itsChangeLog.clickGetCustomerButton();
	}

	@Then("^\"([^\"]*)\" Change logs loaded$")
	public void changeLogsLoaded(String name) throws Throwable {
		itsChangeLog.verifyCustomerDetails(name);
	}
}
