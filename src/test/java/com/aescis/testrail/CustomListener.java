package com.aescis.testrail;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.RunListener;

import com.codepine.api.testrail.TestRail;
import com.codepine.api.testrail.model.Case;
import com.codepine.api.testrail.model.CaseField;
import com.codepine.api.testrail.model.Project;
import com.codepine.api.testrail.model.ResultField;
import com.codepine.api.testrail.model.Run;
import com.codepine.api.testrail.model.Suite;

/***
 * <!-- ========================================================================================================== -->
 * This class is an extension to RunListener and is basically to interact with TestRail API using method testRunFinished
 *
 * @author Rathore Mahipal
 * @lastrev fixXXXXX - new class
 * @since - 27-07-2017
 * <!-- -------------------------------------------------------------------------------------------------------- -->
 */
public class CustomListener extends RunListener
{
	private static final Logger					Log			= Logger.getLogger(
			RunListener.class.getName());
	TestRail							testRail		= null;
	TestRailIntegration						testRailIntegration	= new TestRailIntegration();
	Project								project			= null;
	List<Run>							listOfRuns		= new ArrayList<Run>();
	Map<Integer, List<Integer>>					mapOfAllSuitesCases	= new HashMap<Integer, List<Integer>>();
	List<HashMap<Integer, Integer>>					listCasesWithResults	= new ArrayList<HashMap<Integer, Integer>>();
	List<CaseField>							caseFields		= new ArrayList<CaseField>();
	Case								testCase;
	List<Integer>							testCaseIds		= new ArrayList<Integer>();
	int								projectId;
	String								projectName		= testRailIntegration
			.getProps().getProperty("projectName");
	int								suiteId;
	Suite								suite;
	CaseResultCollector						customCaseCollector	= new CaseResultCollector();
	List<ResultField>						resultFields;

	Map<Integer, List<com.codepine.api.testrail.model.Result>>	mapOfResults		= new HashMap<Integer, List<com.codepine.api.testrail.model.Result>>();

	@Override
	public void testStarted(final Description description)
		throws Exception
	{
		if (testRail == null)
		{
			testRail = testRailIntegration.createTestRailInstance();
		}
		super.testStarted(description);
	}

	@Override
	public void testRunFinished(final Result result)
	{
		try

		{

			if (result.getRunCount() > 0)
			{
				projectId = testRailIntegration.getProjectIdByName(projectName);
				caseFields = testRailIntegration.getCaseFields();
				final CaseField template = new CaseField();
				template.setName("template_id");
				template.setLabel("˘template_id");
				caseFields.add(template);

				final List<Suite> suiteList = new ArrayList<Suite>();

				/***
				 *  This while gets SuiteList of a given project and
				 *  Creates run for only those exist in current automation script run using resultcollector
				 */
				final Iterator it = customCaseCollector.caseIdResultMap.entrySet().iterator();
				while (it.hasNext())
				{
					final Map.Entry caseResult = (Map.Entry) it.next();
					final int caseID = Integer.parseInt(caseResult.getKey().toString());
					final int statusCode = Integer.parseInt(caseResult.getValue().toString());
					Log.info("TESTRAIL:: Entering runFinish method of Listener and case id is: "
							+ caseResult.getKey());
					if (testRail == null)
					{
						testRail = testRailIntegration.createTestRailInstance();
					}

					testCase = testRailIntegration.getTestCase(Integer.parseInt(caseResult.getKey()
							.toString()), caseFields);
					suiteId = testCase.getSuiteId();
					final Suite suiteById = testRail.suites().get(suiteId).execute();
					final int projId = suiteById.getProjectId();
					if (projId == projectId)
					{
						suite = testRailIntegration.getSuiteById(projectId, suiteId);

						if (!suiteList.contains(suite))
						{
							suiteList.add(suite);

							final Run run = new Run();
							run.setName(suite.getName() + getCurrentTimeInGMT());
							run.setDescription(
									"This is a run reported by Automation Script run By userName "
											+ System.getProperty(
													"user.name")
											+ " of Machine executing it ");
							run.setProjectId(projectId);
							run.setSuiteId(suite.getId());
							run.setIncludeAll(false);
							if (!listOfRuns.contains(run))
							{

								listOfRuns.add(testRail.runs().add(projectId, run)
										.execute());
							}
							Log.info("TESTRAIL:: case ID from result is: " + caseID
									+ " and from case is: " + testCase.getId());
						}
						else
						{
							Log.warning("TESTRAIL:: Current Suite belonging to this testCase is not under current Project ");
						}

					}
					else
					{
						Log.info("TESTRAIL:: suite does not belong to current Project");
					}
				}

				addCasesToSuites(projectId, suiteList);
				addCasesToRuns(mapOfAllSuitesCases, listOfRuns);
				/***
				 *  This while is for adding result fields to each Case belonging to corresponding testcase in a run/suite
				 */
				final Iterator iter = customCaseCollector.caseIdResultMap.entrySet().iterator();
				while (iter.hasNext())
				{
					final Map.Entry caseResult = (Map.Entry) iter.next();
					final int caseID = Integer.parseInt(caseResult.getKey().toString());
					final int statusCode = Integer.parseInt(caseResult.getValue().toString());
					testCase = testRailIntegration.getTestCase(caseID, caseFields);
					suiteId = testCase.getSuiteId();
					final Run run = testRailIntegration.getMatchingRun(projectId, suiteId,
							listOfRuns);
					resultFields = testRail.resultFields().list().execute();

					final com.codepine.api.testrail.model.Result currentResult = new com.codepine.api.testrail.model.Result();
					currentResult.setCaseId(caseID);
					currentResult.setStatusId(statusCode);
					if (!mapOfResults.containsKey(run.getId()))
					{
						mapOfResults.put(run.getId(),
								new ArrayList<com.codepine.api.testrail.model.Result>());
						mapOfResults.get(run.getId()).add(currentResult);
						Log.info("TESTRAIL:: Preparing Result for CaseID: " + currentResult
								.getCaseId() + " To RunID: " + run.getId());
					}
					else
					{
						mapOfResults.get(run.getId()).add(currentResult);
						Log.info("TESTRAIL:: Preparing Result for CaseID: " + currentResult
								.getCaseId() + " To RunID: " + run.getId());
					}

				}
				Log.info("TESTRAIL:: Adding final results to runs: ");
				for (final Run resultRun : listOfRuns)
				{
					Log.info("TESTRAIL:: For Run ID: " + resultRun.getId());
					testRail.results().addForCases(resultRun.getId(), mapOfResults.get(resultRun
							.getId()), resultFields).execute();
				}
			}
			super.testRunFinished(result);
		}
		catch (

		final Exception e)
		{
			Log.info("TESTRAIL::Error in TestRun Finish");
			e.printStackTrace();
		}
	}

	/***
	 * <!-- ================================================================================================== -->
	 * This method gets all cases from results and associates them with corresponding run/suite
	 * @param mapOfAllSuitesRunCases
	 * @param listOfRunsForCases
	 *
	 * @lastrev fixXXXXX - New method
	 * <!-- ------------------------------------------------------------------------------------------------ -->
	 */

	private void addCasesToRuns(
			final Map<Integer, List<Integer>> mapOfAllSuitesRunCases,
			final List<Run> listOfRunsForCases)
	{
		Log.info("TESTRAIL:: Adding Cases to Runs: ");
		for (int i = 0; i < listOfRunsForCases.size(); i++)
		{
			Log.info("TESTRAIL:: For Run ID: " + listOfRunsForCases.get(i).getId());
			final int localSuiteId = listOfRunsForCases.get(i).getSuiteId();
			listOfRunsForCases.get(i).setCaseIds(mapOfAllSuitesRunCases.get(localSuiteId));
			testRail.runs().update(listOfRunsForCases.get(i)).execute();
		}
	}

	/***
	 * <!-- ================================================================================================== -->
	 *  This method gets testID from Scenario testHeader if needed (Optional)
	 * @param testHeader
	 * @return
	 *
	 * @lastrev fixXXXXX - New method
	 * <!-- ------------------------------------------------------------------------------------------------ -->
	 */
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
			return "TESTRAIL:: TestID not found in given scenario testheader";
	}

	private String getCurrentTimeInGMT()
	{
		return " Date " + LocalDate.now().toString() + " Time " + LocalTime.now().toString() + " " + TimeZone
				.getDefault().getDisplayName();
	}

	/***
	 * <!-- ================================================================================================== -->
	 * This Method is to add cases to Suites picked up from test results
	 * @param pId
	 * @param listOfSuites
	 *
	 * @lastrev fixXXXXX - New method
	 * <!-- ------------------------------------------------------------------------------------------------ -->
	 */
	private void addCasesToSuites(final int pId, final List<Suite> listOfSuites)
	{
		final Iterator it = customCaseCollector.caseIdResultMap.entrySet().iterator();

		while (it.hasNext())
		{
			final Map.Entry caseResult = (Map.Entry) it.next();
			Log.info("TESTRAIL:: Inside adding case to suites- current case id is: " + caseResult.getKey());
			if (testRail == null)
			{
				testRail = testRailIntegration.createTestRailInstance();
			}

			testCase = testRailIntegration.getTestCase(Integer.parseInt(caseResult.getKey().toString()),
					caseFields);
			suiteId = testCase.getSuiteId();
			suite = testRailIntegration.getSuiteById(pId, suiteId);
			if (!mapOfAllSuitesCases.containsKey(suite.getId()))
			{
				mapOfAllSuitesCases.put(suite.getId(), new ArrayList<Integer>());
				mapOfAllSuitesCases.get(suite.getId()).add(testCase.getId());
			}
			else
			{
				mapOfAllSuitesCases.get(suite.getId()).add(testCase.getId());
			}

		}
	}
}