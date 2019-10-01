Feature: E2E for Feature Story AESCIS-39455 - ChangeLog.aspx (Accent)

  Background: 
    Given Generic logout
    And user navigates to URL : "${accentStagingWebsiteV3.url}" application

  @SmokeSuite
  Scenario: Make sure the Change Log is loading for specified customer(s). Change log must return logs for customer(s). (Accent) - [C25738571]
    Given Login page loaded
    When Login to CSR with userName : "${stagingCsr.userName}" and password : "${stagingCsr.password}"
    Then CSR main page displayed
    When Navigate to URL-> "${accentStagingWebsiteV3.url}" /csr/changelog.aspx
    Then Change Log page is loaded
    When In Customer No put "8843462008" and click to Get Customer
    Then "Aileen Porter" Change logs loaded
