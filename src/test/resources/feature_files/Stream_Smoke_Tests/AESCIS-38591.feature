Feature: E2E for AESCIS-38579 - (CreditAndAccountValidation.aspx missing error message for SEP validation)
    Background:
        Given Generic logout
        And user navigates to URL : "${streamStagingWebsiteTwo.url}" application

    @SmokeSuite
    Scenario: User is able to see the error when trying to search invalid account details on "CreditAndAccountValidation" page of "Stream Billing" application - [C25735216]
        Given Login page loaded
        When Login to CSR with userName : "${stagingCsr.userName}" and password : "${stagingCsr.password}"
        Then CSR main page displayed
        When user navigate to credit and account validation "${streamStagingWebsiteTwo.url}" url
        Then verify account validation page is displayed
        When user enter invalid values for account number
        And click on validate SEP in account validation page
        Then verify error message account number could not found
