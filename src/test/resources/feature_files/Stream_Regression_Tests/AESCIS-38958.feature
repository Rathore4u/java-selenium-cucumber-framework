Feature: E2E for AESCIS-38935 (Failure when editing Auto Invoice Configuration)

  Background:
    Given Generic logout
    And user navigates to URL : "${streamStagingWebsiteTwo.url}" application

  @RegressionSuite
  Scenario: Failure when editing Auto Invoice Configuration [C25722345]
    When Login to CSR with userName : "${stagingCsr.userName}" and password : "${stagingCsr.password}"
    Then CSR main page displayed
    When user navigates to auto invoice page "${streamStagingWebsiteTwo.url}" url
    Then verify display auto invoice configuration page
    When click on default run hours field edit icon
    And enter value "5" in the default run hours edit box
    And click on save button in invoice configuration page
    Then verify new value "5" is saved without error
    When click on run weekends field edit icon
    And select "Yes" option and save the changes
    Then verify new run weekend option "Yes" is saved without error
    When reset the default run hours and run weekend field to old value
    Then verify default run hours and run weekend field values are reset

