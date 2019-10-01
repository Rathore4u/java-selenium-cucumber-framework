Feature: E2E for Feature Story AESCIS-37847 - User is able to verify the exceptiontypeconfiguration.aspx page in Stream Energy Application

  Background:
    Given Generic logout
    And user navigates to URL : "${streamStagingWebsiteV3.url}" application

  @SmokeSuite
  Scenario: User is able to verify the exceptiontypeconfiguration.aspx page in Stream Energy Application [C25726542]
    Given Login page loaded
    When Login to CSR with userName : "${stagingCsr.userName}" and password : "${stagingCsr.password}"
    Then home page of StreamStagingCSR should open
    When Navigate to URL-> "${streamStagingWebsiteV3.url}" /administration/correspondence/exceptiontypeconfiguration.aspx
    Then INVOICE ADMINISTRATION page loaded
    When Click Add validation type button in INVOICE ADMINISTRATION page
    Then VALIDATION RULE EDITOR pop up is displayed
    When Click Cancel on VALIDATION RULE EDITOR pop up
    Then VALIDATION RULE EDITOR pop up is not displayed
    When Click Add validation type button in INVOICE ADMINISTRATION page
    And Select VALIDATION RULE TYPE as "Rate plan"
    And Select RATE PLAN as "Fixed"
    And Click Ok on VALIDATION RULE EDITOR pop up
    Then VALIDATION RULE EDITOR pop up is not displayed
    And Validation Rule "Has Rate Plan 'Fixed'" is added
    When Click edit button on newly added validation rule
    Then VALIDATION RULE EDITOR pop up is displayed
    When Select RATE PLAN as "Variable"
    And Click Ok on VALIDATION RULE EDITOR pop up
    Then VALIDATION RULE EDITOR pop up is not displayed
    And Validation Rule "Has Rate Plan 'Variable'" is added
    When Click delete button on newly added validation rule
    And Exception Type Testing pop up is displayed
    And Click yes on Exception Type Testing pop up
    Then Validation Rule "Has Rate Plan 'Variable'" is deleted
    When Click Test all validations button in INVOICE ADMINISTRATION page
    Then VALIDATION RULE TESTER pop up is displayed
    When Enter invoice id "1" in VALIDATION RULE TESTER pop up
    And Click Start tests button in VALIDATION RULE TESTER pop up
    Then Passed test results populated on VALIDATION RULE TESTER pop up
