Feature: E2E for Feature Story AESCIS-37827 - search.aspx(Stream)
    // Auto generated by aurea-automation - util on Thu, 19 Sep 2019 16:29:11 GMT

    Background:
        Given Generic logout
        And user navigates to URL : "${streamStagingWebsiteV3.url}" application

    @SmokeSuite
    Scenario: E2E for Feature Story AESCIS-37827 - search.aspx(Stream) - [25722472]
        Given Login page loaded
        When fill userName : "${stagingCsr.userName}"
        And fill password : "${stagingCsr.password}"
        And hit login button at StreamStaginCSR login page
        Then home page of StreamStagingCSR should open

        When Click to Customer Search
        Then home page of StreamStagingCSR should open

        When Enter AccountNo as "3000127"
        And Click Search Button
        Then Check Show Results
        And Verify Results for "3000127"

        When Enter Last Name as "A"
        And Click Search Button
        Then Check Show Results
        And Verify Results for "3000127"
        And Verify Results for "A"

        When Enter First Name as "C"
        And Click Search Button
        Then Check Show Results
        And Verify Results for "3000127"
        And Verify Results for "A"
        And Verify Results for "C"
