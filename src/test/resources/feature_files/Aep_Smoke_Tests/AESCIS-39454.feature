Feature: E2E for Feature Story AESCIS-39454 - ChangeLog.aspx (Aep)

  Background: 
    Given Generic logout
    And user navigates to URL : "${aepcsrv3StagingWebsite.url}" application

  @SmokeSuite
  Scenario: Make sure the Change Log is loading for specified customer(s). Change log must return logs for customer(s). (Aep) - [C25735411]
    Given Login page loaded
    When Login to CSR with userName : "${stagingCsr.userName}" and password : "${stagingCsr.password}"
    Then CSR main page displayed
    When Navigate to URL-> "${aepcsrv3StagingWebsite.url}" /csr/changelog.aspx
    Then Change Log page is loaded
    When In Customer No put "4095566" and click to Get Customer
    Then "Sarah Wenger" Change logs loaded
    When In Customer No put "4274923" and click to Get Customer
    Then "Alice Owens" Change logs loaded
