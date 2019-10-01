Feature: E2E for AESCIS-38896 (Letter Batch Print Administration parse error) - Accent [.5]

    Background:
        Given user navigates to IGS Energy application using this url "${isgStagingWebsite.url}"

    @RegressionSuite 
    Scenario: TC01 - User is able to access the "Letter Batch Print Administration" page without any errors on "Accent" Application - [C25735165]
        Given ISG login page is open
        When fill userName : "${stagingCsr.userName}"
        And fill password : "${stagingCsr.password}"
        And I click Login button
        Then Then the main page is open
        When I navigate to Batch Print url "${isgStagingInvoiceBatchPrint.url}"
        Then Then INVOICE BATCH PRINT ADMINISTRATION Screen Loaded.
        When Click to Letter Batch Print Administration
        Then Letter Batch Print Administration screen is loaded