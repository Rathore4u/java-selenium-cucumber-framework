Feature: E2E for AESCIS-36616 (Spark autopay migration from Fiserv to Paystar)

@HealthSuite
Scenario: TC01 - User is able to find the PayStar task on the TaskToaster application - [C25735218]
    When Login to "${taskToasterStaging.url}" with userName : "${stagingCsr.userName}" and password : "${stagingCsr.password}"
    Then Task toaster app is logged in
    When Navigate to Task url on "${taskToasterStaging.url}"
    Then Tasks Dashboard page is loaded
    When User enters text "paystar" in search box
    Then 3 records are displayed
