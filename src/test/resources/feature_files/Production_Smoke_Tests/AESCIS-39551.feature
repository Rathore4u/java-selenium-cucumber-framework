Feature: E2E for Feature Story AESCIS-37847 - exceptiontypeconfiguration.aspx (Aep)
    // Auto generated by aurea-automation - util on Tue, 17 Sep 2019 17:07:13 GMT

    Background:
        Given user navigates to URL : "${aepcsrv3StagingWebsite.url}" application

    @SmokeSuite
    Scenario: User is able to verify the exceptiontypeconfiguration.aspx page in AEPEnergy Application - [C25726263]
        Given Login page loaded
        When Login to CSR with userName : "${stagingCsr.userName}" and password : "${stagingCsr.password}"
        Then CSR main page displayed
        When Navigate to URL "${aepcsrv3StagingWebsite.url}" Exceptiontypeconfiguration
        Then Exceptiontypeconfiguration page loaded

        When Click Add Validation Type
        Then Verify Validation Rule Type display

        When Click Cancel Button
        Then Exceptiontypeconfiguration page loaded

        When Click Add Validation Type
        And Select Validation Type Rule as "Rate plan"
        And Select Rate Plan as "Fixed"
        And Click Ok Button
        Then Validation Rule Entered in grid as "${validationRules.ratePlanFixed}"

        When Remove Rule Entered as "${validationRules.ratePlanFixed}"
        Then Are you sure display

        When Click Yes Button
        Then Rule deleted as "${validationRules.ratePlanFixed}"

        When Click Test All Validations
        Then Verify Invoice Popup

        When Put Invoice Id=1
        And Click Start Tests
        Then Verify Validation Test Results
