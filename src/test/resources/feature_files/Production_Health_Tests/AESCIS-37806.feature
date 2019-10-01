Feature: E2E - Task Toaster Dashboard.WrongDayDataMigrationTask- Green Mountain [1]

    // Auto generated by aurea-automation - util on Fri, 20 Sep 2019 13:17:57 GMT
    @HealthCheckSuite
    Scenario: [Green Mountain] User is able to execute "Dashboard.WrongDayDataMigrationTask" task in Task Toaster website - [C25735141]
        Given Login to "${taskToasterStaging.url}" with userName : "${stagingCsr.userName}" and password : "${stagingCsr.password}"
        Then Task toaster app is logged in

        When Navigate to URL "${taskToasterStaging.url}" /Task/Settings/446
        Then Tasks Dashboard page is loaded

        When Execute Task for Green Mountain Client
        Then Check for Task Started

        When Wait task to be finished
        And Click to Green Mountain tab
        Then Verify Log Items loaded

        When Click To Search Button To Refresh Logs
        Then Verify Log Items loaded

        And Verify Log Items for Started
        And Verify Log Items for Complete
