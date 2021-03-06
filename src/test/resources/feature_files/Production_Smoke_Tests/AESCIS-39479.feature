Feature: E2E for Feature Story AESCIS-37962 - Creation and editing of Customer Account Warnings for AEP Client.

  Background:
    Given Generic logout
    And user navigates to URL : "${aepcsrv3StagingWebsite.url}" application

  @SmokeSuite
  Scenario: Verify Customer Account Warnings page is loading and can be used to create new warnings and edit them for AEP Client. [C25735147]
    Given Login page loaded
    When Login to CSR with userName : "${stagingCsr.userName}" and password : "${stagingCsr.password}"
    Then home page of StreamStagingCSR should open
    When user navigates to URL : "${aepcsrv3StagingWebsite.url}/administration/warning/accountwarningadmin.aspx?custid=32335" application
    Then Account warning administration page is loaded
    When User puts text "Test Warning" and clicks insert button
    Then Row should be created successfully on Account Warning Administration page
    When User clicks on edit button on first row on Account Warning Administration page
    Then Row should become editable on Account Warning Administration page
    When User checks active checkbox, changes text to "Updated Test Warning", updates date and clicks update button
    Then Row should be updated successfully on Account Warning Administration page
    When User click delete button for row on Account Warning Administration page
    Then First row of Account Warning Administration page should be deleted
