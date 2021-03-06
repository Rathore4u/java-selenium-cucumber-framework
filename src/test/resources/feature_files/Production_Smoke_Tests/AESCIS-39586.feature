Feature: E2E for Feature Story AESCIS-37827 - search.aspx(Aep)
    // Auto generated by aurea-automation - util on Thu, 19 Sep 2019 16:29:11 GMT

    Background:
        Given Generic logout
        And user navigates to URL : "${aepcsrv3StagingWebsite.url}" application

    @SmokeSuite
    Scenario: TC01 - User is able to search accounts using "Account No", "Last Name" and "First Name" fields for AEP client - [25717431]
        Given Login page loaded
        When fill userName : "${stagingCsr.userName}"
        And fill password : "${stagingCsr.password}"
        And hit login button at StreamStaginCSR login page
        Then home page of StreamStagingCSR should open

        When Click to Customer Search
        Then home page of StreamStagingCSR should open

        When Enter AccountNo as "4001"
        And Click Search Button
        Then Check Show Results
        And Verify Results for "4001"

        When Enter Last Name as "A"
        And Click Search Button
        Then Check Show Results
        And Verify Results for "4001"
        And Verify Results for "A"

        When Enter First Name as "F"
        And Click Search Button
        Then Check Show Results
        And Verify Results for "4001"
        And Verify Results for "A"
        And Verify Results for "F"
