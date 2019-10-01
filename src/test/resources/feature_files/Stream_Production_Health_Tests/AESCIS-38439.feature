Feature: E2E for AESCIS-37735 (Email field is mandatory on changing Service State)

    Background:
        Given user navigates to URL : "${streamStagingWebsiteTwo.url}" application

    @HealthSuite
    Scenario: Verify email field is not updated to required if corresponding check box is unchecked - [C25733930]
        When Login to CSR with userName : "${stagingCsr.userName}" and password : "${stagingCsr.password}"
        Then CSR main page displayed
        When user navigate to create new request service "${streamStagingWebsiteTwo.url}" url
        Then customer Enrollment screen should be displayed
        And verify service state field is selected as "DC" by default
        And verify preferences checkbox options are unchecked by default
        And verify asterik sign is not displayed next to Email field
        When service state value is changed to "Georgia"
        Then verify asterik sign is not displayed next to Email field