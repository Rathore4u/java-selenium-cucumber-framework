Feature: E2E for Feature Story AESCIS-37833 - Invalid meter id should show and should not show exceptions (Spark)

  Background:
    Given user navigates to URL : "${sparkStagingWebsiteV3.url}" application

  @SmokeSuite
  Scenario: Verify Meter Detail Loaded for correct meters and is not throwing exception but returning empty results for invalid meters [C25733811]
    Given StreamStagingCSR login page is open
    When Login to CSR with userName : "${stagingCsr.userName}" and password : "${stagingCsr.password}"
    Then CSR main page displayed
    When Navigate to meter load page of "${sparkStagingWebsiteV3.url}" for meter "1702878"
    Then Meter load page should display with 1 row
    When Navigate to meter load page of "${sparkStagingWebsiteV3.url}" for meter "1773541"
    Then Meter load page should display with 1 row
    When Navigate to meter load page of "${sparkStagingWebsiteV3.url}" for meter "-1"
    Then Meter load page should display with invalid meter ID
