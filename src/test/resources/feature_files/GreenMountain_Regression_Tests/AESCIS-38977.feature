Feature: E2E for AESCIS-38896 (Letter Batch Print Administration parse error) - Green Mountain

  Background:
    Given Generic logout
    And user navigates to URL : "${greenMountainBillingWebsite.url}" application

  @RegressionSuite
  Scenario: TC01 - User is able to access the "Letter Batch Print Administration" page on "Green Mountain Energy" Application [C25731663]
    Given greenMountainStaging login page is open
    When fill userName : "${stagingCsr.userName}"
    And fill password : "${stagingCsr.password}"
    And hit login button at StreamStaginCSR login page
    Then home page of StreamStagingCSR should open
    When Navigate to Invoice Batch print URL "${greenMountainBillingWebsite.url}"
    Then verify INVOICE BATCH PRINT ADMIN Screen Loaded
    When Click to Letter Batch Print Administration
    Then Letter Batch Print Administration screen is loaded