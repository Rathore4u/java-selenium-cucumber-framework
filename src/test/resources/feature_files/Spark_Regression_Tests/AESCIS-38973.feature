Feature: E2E for Feature Story AESCIS-38973 - (Letter Batch Print Administration parse error) - Spark

  Background: 
    Given Generic logout
    And user navigates to URL : "${sparkStagingWebsite.url}" application

  @RegressionSuite
  Scenario: TC01 - User is able to access the "Letter Batch Print Administration" page without any errors on "Spark Billing" Application - [C25735164]
    Given Login page loaded
    When Login to CSR with userName : "${stagingCsr.userName}" and password : "${stagingCsr.password}"
    Then CSR main page displayed
    When Navigate to URL-> "${sparkStagingWebsite.url}" /administration/print/batchprint.aspx
    Then INVOICE BATCH PRINT ADMINISTRATION Screen Loaded
    When Click to Letter Batch Print Administration
    Then Letter Batch Print Administration screen is loaded
