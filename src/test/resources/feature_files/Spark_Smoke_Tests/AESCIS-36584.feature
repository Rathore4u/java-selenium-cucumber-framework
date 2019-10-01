Feature: Login to Spark and basic navigation

  Background:
    Given user navigates to URL : "${sparkStagingWebsite.url}" application

  @SmokeSuite
  Scenario: Verify a CIS user is able to login to CSR web site and search for customer and change his phone for spark client [C25751277]
    Given StreamStagingCSR login page is open
    When Login to CSR with userName : "${stagingCsr.userName}" and password : "${stagingCsr.password}"
    Then CSR main page displayed
    When From Top Menu Search "000233965" for "Account No:"
    Then "BELISA WALLACE" customer summary page is loaded
    When Click Edit on Customer Info->Contact Information.
    Then Fields become editable.
    When Change the Home Phone field value to "1234567"
    And Click on Save Button from Contact Information Section in Customer Summary page
    Then Home Phone field value "1234567" should be Saved.