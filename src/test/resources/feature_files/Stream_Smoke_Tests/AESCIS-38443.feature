Feature: E2E for Communication Log Update Stream
    Background:
        Given Generic logout
        And user navigates to URL : "${streamStagingWebsiteTwo.url}" application

    @SmokeSuite
    Scenario: Verify able to update Priority of Communication log entries to be able to alert them later with higher priority - [C25733885]
        Given Login page loaded
        When Login to CSR with userName : "${stagingCsr.userName}" and password : "${stagingCsr.password}"
        Then CSR main page displayed
        When search for account number "3000000111"
        Then verify account number "3000000111" searched is displayed
        When user click on communication log tab
        And user clicks on edit button on first row of communication log
        Then communication log grid row become editable
        When change the priority field value and save
        Then priority entry should be changed successfully