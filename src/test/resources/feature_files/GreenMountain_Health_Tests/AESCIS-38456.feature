Feature: E2E for Feature Story AESCIS-38456 - ChangeLog.aspx (GME)

  Background: 
    Given Generic logout
    And user navigates to URL : "${greenMountainBillingWebsite.url}" application

  @HealthSuite
  Scenario: Admin user is able to see the ebillemailtemplateadministration page. (GME) - [C25726877]
    Given Login page loaded
    When Login to CSR with userName : "${stagingCsr.userName}" and password : "${stagingCsr.password}"
    Then CSR main page displayed
    When Navigate to URL-> "${greenMountainBillingWebsite.url}" /callcenter/popup/ebillemailtemplateadministration.aspx
    Then EBill Email Template Administration is displayed
    When Click to Add Ebill Configuration button
    Then Add Ebill Configuration Section becomes visible.
    When Click on Cancel button in Add Ebill Configuration Section
    Then Add Ebill Configuration Section becomes invisible.
