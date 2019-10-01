Feature: E2E for AESCIS-39076 (Error when changing Compatibility Level of IE+ Not working in chrome (Estimates.aspx).)

  Background:
    Given Generic logout
    And user navigates to URL : "${sparkStagingWebsite.url}" application

  @HealthSuite
  Scenario: Error when changing Compatibility Level of IE+ Not working in chrome (Estimates.aspx) - [C25717915]
    Given Login page loaded
    When Login to CSR with userName : "${stagingCsr.userName}" and password : "${stagingCsr.password}"
    Then CSR main page displayed
    When user navigate to invoice estimates "${sparkStagingWebsite.url}" url
    Then verify spark estimate list page is opened
    When update search filter from field as "5/1/2018" and to field as "6/1/2018" and click on list
    Then verify invoice estimates list updated with new rows of results
