Feature: E2E for Feature Story AESCIS-38454 - ChangeLog.aspx (AEP)

  Background: 
    Given Generic logout
    And user navigates to URL : "${aepStagingWebsite.url}" application

  @HealthSuite
  Scenario: Admin user is able to see the ebillemailtemplateadministration page. (AEP) - [C25726889]
    Given Login page loaded
    When Login to CSR with userName : "${stagingCsr.userName}" and password : "${stagingCsr.password}"
    Then CSR main page displayed
    When Navigate to URL-> "${aepStagingWebsite.url}" /callcenter/popup/ebillemailtemplateadministration.aspx
    Then Email Template Administration is displayed
    When Click to Add Ebill Configuration button
    Then Add Ebill Default Configuration Section becomes visible.
    When Click on Cancel button in Add Ebill Configuration Section
    Then Add Ebill Configuration Section becomes invisible.
