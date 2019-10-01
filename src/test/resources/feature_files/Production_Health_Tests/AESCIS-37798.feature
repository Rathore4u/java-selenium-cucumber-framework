Feature: E2E - Task Toaster Dashboard.PaymnentsDataMigrationTask - Spark

    // Auto generated by aurea-automation - util on Fri, 20 Sep 2019 13:17:57 GMT
    @HealthCheckSuite
    Scenario: [Spark] User is able to execute "PaymnentsDataMigration" task in Task Toaster website - [C25733921]
        Given Login to "${taskToasterStaging.url}" with userName : "${stagingCsr.userName}" and password : "${stagingCsr.password}"
        Then Task toaster app is logged in

        When Navigate to URL "${taskToasterStaging.url}" /Task/Settings/447
        Then Tasks Dashboard page is loaded

        When Execute Task for Spark Client
        Then Check for Task Started

        When Wait task to be finished
        Then Verify task to finished

        When Click to Spark tab
        Then Verify Log Items loaded

        When Click To Search Button To Refresh Logs
        Then Verify Log Items loaded

        And Verify Log Items for Started
        And Verify Log Items for Complete