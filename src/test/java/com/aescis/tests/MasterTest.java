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

package com.aescis.tests;

import com.cucumber.listener.ExtentCucumberFormatter;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;

import java.util.HashMap;
import java.util.Map;

/** <!-- ========================================================================================================== -->
 *
 *
 * @lastrev fixXXXXX - new class
 * <!-- -------------------------------------------------------------------------------------------------------- --> */

@RunWith(Cucumber.class)
@CucumberOptions(
		monochrome = true,
		features = { "classpath:feature_files/" },
		glue = {"com.aescis.stepdefinition", },
		tags = {"~@ignore"},
		plugin = { "pretty", "json:target/cucumber" })
public class MasterTest
{
	@SuppressWarnings("unchecked")
	@BeforeClass
	public static void setup()
	{
		// Initiates the extent report and generates the output in the
		// output/Run_<unique timestamp>/report.html file by default.
		ExtentCucumberFormatter.initiateExtentCucumberFormatter();

		// User can add the system information as follows
		ExtentCucumberFormatter.addSystemInfo("Selenium version", "v2.53.0");

		// Also you can add system information using a hash map
		final Map systemInfo = new HashMap();
		systemInfo.put("Cucumber version", "v1.2.4");
		systemInfo.put("Extent Cucumber Reporter version", "v1.1.1");
		ExtentCucumberFormatter.addSystemInfo(systemInfo);
	}
}