//=====================================================================================================================
// Copyright (c) 2017. Aurea Software, Inc. All Rights Reserved.
//
// You are hereby placed on notice that the software, its related technology and services may be covered by one or
// more United States ("US") and non-US patents. A listing that associates patented and patent-pending products
// included in the software, software updates, their related technology and services with one or more patent numbers
// is available for you and the general public's access at www.aurea.com/legal/ (the "Patent Notice") without charge.
// The association of products-to-patent numbers at the Patent Notice may not be an exclusive listing of associations,
// and other unlisted patents or pending patents may also be associated with the products. Likewise, the patents or
// pending patents may also be associated with unlisted products. You agree to regularly review the products-to-patent
// number(s) association at the Patent Notice to check for updates.
//=====================================================================================================================

package com.aescis.stepdefinition;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;

import com.aescis.lib.WebDriverActions;
import com.aescis.lib.helper.ScumberException;
import com.aescis.testrail.CaseResultCollector;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/** <!-- ========================================================================================================== -->
 * Hook class to ensure that we create a single browser per scenario and clean up the browser instance.
 *
 * After Hook also has case result collection for TestRail reporting purpose
 *
 * @lastrev fixXXXXX - updated on 27-07-2017 by mrathore
 * <!-- -------------------------------------------------------------------------------------------------------- --> */

public class Hooks
{
	private static final Logger	Log		= Logger.getLogger(Hooks.class.getName());

	private WebDriver		itsDriver;
	int				caseId;
	CaseResultCollector		caseCollector	= new CaseResultCollector();

	public Hooks()
	{
		Log.info("Constructor: Hooks");
	}

	@Before
	public void before(final Scenario scenario)
		throws ScumberException
	{
		Log.info("TESTRAIL: Inside Before Hook of a Scenario And Scenario Name is:  " + scenario.getName());
		itsDriver = WebDriverActions.openBrowser(scenario);
	}

	@After
	public void after(final Scenario scenario)
	{
		try
		{
			caseId = Integer.parseInt(getTestIdFromScenario(scenario.getName()));
			Log.info("TESTRAIL:: Inside After hook- Case Id is: " + caseId);
			final int result = getScenarioResultInteger(scenario.getStatus());
			caseCollector.caseIdResultMap.put(caseId, result);
			Log.info("TESTRAIL: Inside After hook Case Status is: " + scenario.getStatus());
			WebDriverActions.closeBrowser(scenario, itsDriver);
			itsDriver = null;
		}
		catch (final Exception e)
		{
			e.printStackTrace();
		}
	}

	private int getScenarioResultInteger(final String result)
	{
		switch (result)
		{
			case "passed":
				return 1;
			case "undefined":
				return 2;
			case "pending":
				return 3;
			case "skipped":
				return 4;
			case "failed":
				return 5;
			default:
				return -1;
		}
	}

	private String getTestIdFromScenario(final String testHeader)
	{
		final Pattern pattern = Pattern.compile("C\\d+");
		final Matcher matcher = pattern.matcher(testHeader);
		if (matcher.find())
		{
			final String testCaseIdFromFeatureFile = matcher.group(0).trim();
			return testCaseIdFromFeatureFile.substring(1, testCaseIdFromFeatureFile.length());
		}
		else
			return "TESTRAIL:: scenario id not found";
	}
}
