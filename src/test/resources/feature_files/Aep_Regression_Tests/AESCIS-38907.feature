Feature: User is able to clone an existing customer on the "AEP Energy" application

  Background:
    Given user navigates to URL : "${aepStagingWebsite.url}" application

  @RegressionSuite
  Scenario: TC01 - User is able to clone an existing customer on the "AEP Energy" application [C25735166]
    Given StreamStagingCSR login page is open
    When fill userName : "${stagingCsr.userName}"
    And fill password : "${stagingCsr.password}"
    And hit login button at StreamStaginCSR login page
    Then home page of StreamStagingCSR should open
    When Navigate to URL -> "${aepStagingWebsite.url}" customer clone utility
    Then customer clone utility page should open
    When user enters no. of clones as "1"
    And user clicks clone customer button
    Then customer is cloned successfully
