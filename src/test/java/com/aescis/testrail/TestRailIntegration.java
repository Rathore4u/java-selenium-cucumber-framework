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

package com.aescis.testrail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import javax.xml.bind.DatatypeConverter;

import com.codepine.api.testrail.TestRail;
import com.codepine.api.testrail.TestRail.Projects;
import com.codepine.api.testrail.model.Case;
import com.codepine.api.testrail.model.CaseField;
import com.codepine.api.testrail.model.Plan;
import com.codepine.api.testrail.model.Plan.Entry;
import com.codepine.api.testrail.model.Project;
import com.codepine.api.testrail.model.Run;
import com.codepine.api.testrail.model.Suite;
import com.aescis.lib.helper.PropertiesLoader;

/***
 * <!-- ========================================================================================================== -->
 * This Class is to Interact with TestRail API. Credentials are stored in a properties file namely testrail.properties
 *
 * @author Rathore Mahipal
 *
 * @lastrev fixXXXXX - new class
 * @since 27-07-2017
 * <!-- -------------------------------------------------------------------------------------------------------- -->
 */
public class TestRailIntegration
{
	private static final Logger	Log		= Logger.getLogger(TestRailIntegration.class.getName());
	TestRail			testRail	= null;
	private final String		endPointUrl	= getProps().getProperty("endPointUrl");
	private final String		userName	= getProps().getProperty("userName");
	private final String		password	= new String(DatatypeConverter.parseBase64Binary(getProps()
			.getProperty("password")));
	List<Integer>			caseIds		= new ArrayList<Integer>();
	private Run			run;
	private int			runId;

	public TestRail createTestRailInstance()
	{
		if (testRail == null)
		{
			testRail = TestRail.builder(endPointUrl, userName, password).build();
		}
		return testRail;
	}

	public void addTestCaseId(final Integer caseId)
	{
		caseIds.add(caseId);
	}

	public List<CaseField> getCaseFields()
	{
		return testRail.caseFields().list().execute();
	}

	public Case getTestCase(final int caseId, final List<CaseField> caseFields)
	{
		return testRail.cases().get(caseId, caseFields).execute();
	}

	public int getProjectIdByName(final String projectName)
	{
		final Projects projects = testRail.projects();
		final List<Project> projectList = projects.list().execute();
		int pid = 0;
		for (final Project project : projectList)
		{
			if (project.getName().equals(projectName))
			{
				pid = project.getId();
				break;
			}
		}
		return pid;
	}

	public List<Suite> getProjectSuites(final int pId)
	{
		return testRail.suites().list(pId).execute();
	}

	public Run createRun(final int projectId, final int suiteId)
		throws ParseException
	{
		final SimpleDateFormat format = new SimpleDateFormat("dd MMM yyy kk mm s");
		final Date date = new Date();
		final String dateString = format.format(date);
		final String runName = "Automation " + dateString;
		try
		{
			run = new Run();
			run = testRail.runs().add(projectId, run.setSuiteId(suiteId).setName(runName).setIncludeAll(
					false)).execute();
			setRun(run);
			setRunId(run.getId());
			return run;
		}
		catch (final Exception e)
		{
			Log.info("TESTRAIL:: Exception while creating RUN");
			e.printStackTrace();
			return null;
		}
	}

	public Plan createPlan(final int projectId, final Plan plan)
	{
		return testRail.plans().add(projectId, plan).execute();
	}

	private void setRunId(final int id)
	{
		runId = id;
	}

	private int getRunId()
	{
		return runId;
	}

	public void setRun(final Run localRun)
	{
		run = localRun;
	}

	public Properties getProps()
	{
		try
		{
			return PropertiesLoader.getInstance().load("testrail.properties");
		}
		catch (final Exception e)
		{
			Log.info("TESTRAIL:: Properties file for testrail is not found or exception reading it");
			e.printStackTrace();
			return null;
		}
	}

	public List<Integer> getCaseIds()
	{
		return caseIds;
	}

	public boolean resetCaseIds()
	{
		caseIds.clear();
		if (caseIds.isEmpty())
		{
			return true;
		}
		else
			return false;
	}

	public Entry addCaseIdsToEntry(final Entry entry)
	{
		return entry.setCaseIds(caseIds);
	}

	public Run getMatchingRun(final int projectId, final int suiteId, final List<Run> listOfRuns)
	{
		Run localRun = new Run();
		for (final Run run : listOfRuns)
		{

			if (run.getSuiteId() == suiteId)
			{
				localRun = run;
				break;
			}
		}
		return localRun;
	}

	public Suite getSuiteById(final int projectId, final int suiteId)
	{
		Suite matchingSuite = new Suite();
		final List<Suite> suites = testRail.suites().list(projectId).execute();
		for (final Suite suite : suites)
		{
			if (suite.getId() == suiteId)
			{
				matchingSuite = suite;
				break;
			}
		}
		return matchingSuite;
	}
}