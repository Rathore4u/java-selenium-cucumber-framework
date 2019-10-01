Feature: E2E for AESCIS-38371 (Application fails to show ebillemailtemplateadministration page) - Stream

    Background:
        Given user navigates to URL : "${streamStagingWebsiteTwo.url}" application

    @RegressionSuite
    Scenario: Verify mail template administration page is loading for Stream client. - [C25735139]
        When Login to CSR with userName : "${stagingCsr.userName}" and password : "${stagingCsr.password}"
        Then CSR main page displayed
        When user navigates to URL : "${streamStagingEbillEmailTemplateAdministration.url}" application
        Then Email Template Administration is displayed
        When Click to Add Ebill Configuration button
        Then Add Ebill Configuration Section becomes visible.
        When Click on Cancel button
        Then Add Ebill Configuration Section becomes invisible.