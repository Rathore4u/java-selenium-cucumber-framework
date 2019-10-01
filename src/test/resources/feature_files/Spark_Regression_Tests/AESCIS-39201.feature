Feature: e2e for AESCIS-39097 (Budget Bill Account True Up - Spark)   [.5]

    Background:
        Given Generic logout
        And user navigates to URL : "${sparkStagingWebsite.url}" application

    @RegressionSuite
    Scenario: Verify a CIS user is able to make sure that no Automatic True Up invoice is generated after 1/1/2019 for customers with True Up Type:Adjust Budget Billing Amount for Stream Client - [C25751101]
        Given Login page loaded
        When Login to CSR with userName : "${stagingCsr.userName}" and password : "${stagingCsr.password}"
        Then CSR main page displayed
        When Navigate to "${sparkStagingBudgetBillingEdi.url}" url
        Then "BELISA WALLACE" budget billing plan page is loaded
        And True Up Type is "Adjust Budget Billing Amount"
        When Click on 'Budget Billing Plan History' tab
        Then History page is loaded