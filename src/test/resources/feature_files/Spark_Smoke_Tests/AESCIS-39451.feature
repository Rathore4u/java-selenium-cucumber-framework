Feature: E2E for Feature Story AESCIS-39451 - ChangeLog.aspx (Spark)

  Background: 
    Given Generic logout
    And user navigates to URL : "${sparkStagingWebsiteV3.url}" application

  @SmokeSuite
  Scenario: Make sure the Change Log is loading for specified customer(s). Change log must return logs for customer(s). (Spark) - [C25722582]
    Given Login page loaded
    When Login to CSR with userName : "${stagingCsr.userName}" and password : "${stagingCsr.password}"
    Then CSR main page displayed
    When Navigate to URL-> "${sparkStagingWebsiteV3.url}" /csr/changelog.aspx
    Then Change Log page is loaded
    When In Customer No put "002532166" and click to Get Customer
    Then "ELLA MAE CALDWELL" Change logs loaded
    When In Customer No put "000050737" and click to Get Customer
    Then "JANIE LOPEZ" Change logs loaded
