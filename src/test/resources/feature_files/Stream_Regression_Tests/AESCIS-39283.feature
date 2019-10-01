Feature: E2E for AESCIS-39279 (Incorrect behavior when searching the rate package management screen) [1]

  Background:
    Given user navigates to URL : "${streamStagingWebsiteTwo.url}" application

  @RegressionSuite
  Scenario: Verify CIS user is able to make sure that when Enter key is hit on Rate Packages screen,system will search rate packages based on Search criteria for Stream Client [C25749680]
    When Login to CSR with userName : "${stagingCsr.userName}" and password : "${stagingCsr.password}"
    Then CSR main page displayed
    When user navigates to URL : "${streamStagingWebsiteRatePackages.url}" application
    Then Rate Package Management screen displayed.
    When Enter "GA" in the package name field
    And Press enter from inside Package Name field
    Then All the rate packages with name starting with name "GA" should be loaded in grid.
    When Enter "Test123456" in the package name field
    And Press enter from inside Package Name field
    Then Grid is cleaned-up and message No records matched your criteria displayed

