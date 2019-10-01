package com.aescis.tests;

import com.cucumber.listener.ExtentCucumberFormatter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.Map;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, features = { "classpath:feature_files/" }, glue = {
	"com.aescis.stepdefinition" }, tags = "@SmokeSuite", plugin = { "pretty", "json:target/cucumber",
		"com.cucumber.listener.ExtentCucumberFormatter" })
public class GenericTagTest
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
