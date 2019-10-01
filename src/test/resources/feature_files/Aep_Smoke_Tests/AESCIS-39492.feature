Feature: E2E for Feature Story AESCIS-37492 - ratelist.aspx (Aep)

  Background: 
    Given Generic logout
    And user navigates to URL : "${aepcsrv3StagingWebsite.url}" application

  @SmokeSuite
  Scenario: E2E for Feature Story AESCIS-37847 - ratelist.aspx (Aep) - [C25735441]
    Given Login page loaded
    When fill userName : "${stagingCsr.userName}"
    And fill password : "${stagingCsr.password}"
    And hit login button at StreamStaginCSR login page
    Then home page of StreamStagingCSR should open
    When Navigate to URL-> "${aepcsrv3StagingWebsite.url}" /callcenter/includes/ratelist.aspx
    Then rating page is loaded
    And Text area for Rate Code visible
    When Rate Code field is filled with : "${invalid.rateCode}" value
    And click search button on rate list page
    Then no result should be returned in results
    When Rate Code field is filled with "Te" value
    And click search button on rate list page
    Then search results should have rows starting with "Te"
