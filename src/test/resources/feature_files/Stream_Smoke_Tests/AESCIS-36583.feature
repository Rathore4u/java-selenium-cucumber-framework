Feature: Login to Stream and basic navigation
    Background:
        Given Generic logout
        And user navigates to URL : "${streamStagingWebsiteTwo.url}" application

    @RegressionSuite
    Scenario: Login to Stream and basic navigation - [C25752393]
        Given Login page loaded
        When Login to CSR with userName : "${stagingCsr.userName}" and password : "${stagingCsr.password}"
        Then CSR main page displayed
        When From Top Menu Search "3001487363" for "Account No:"
        Then "Josephine Jones" customer summary page is loaded
        When Click Edit on Customer Info->Contact Information.
        Then Fields become editable.
        When Change the Home Phone field value to "1234567"
        And Click on Save Button from Contact Information Section in Customer Summary page
        Then Home Phone field value "1234567" should be Saved.