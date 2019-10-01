Feature: E2E for AESCIS-39205 (CSR Transaction List Window Timeout Error)

  Background:
    Given Generic logout
    And user navigates to URL : "${sparkStagingWebsite.url}" application

  @RegressionSuite
  Scenario: CSR Transaction List Window Timeout Error) - [C25722334]
    Given Login page loaded
    When Login to CSR with userName : "${stagingCsr.userName}" and password : "${stagingCsr.password}"
    Then CSR main page displayed
    When search for account number "002532166"
    Then verify account searched is displayed
    When click on utility accounts tab in accounts section
    Then verify utility accounts tab opened
    When click on transaction history button
    And enter date range from date "1/27/2018" and to date "7/27/2019"
    And click on search button
    Then verify transaction history loaded