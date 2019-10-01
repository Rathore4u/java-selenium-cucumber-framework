Feature: CIS - Accent - Edit customer info

    Background:
        Given Generic logout
        And user navigates to URL : "${isgStagingWebsite.url}" application

    @RegressionSuite
    Scenario Outline: CIS - Accent - Edit customer info - [C25752380]
        Given Login page loaded
        When Login to CSR with userName : "${stagingCsr.userName}" and password : "${stagingCsr.password}"
        Then CSR main page displayed
        When From Top Menu Search "9741035002" for "Account No:"
        Then Customer summary page is loaded
        When Click Edit on Customer Info->Contact Information.
        Then Fields become editable.
        When Edit Contact Information: "<CustomerType>", "<DBA>", "<PermitContactName>"
        And Edit Billing Information: "<Contact>", "<AddressLine1>", "<AddressLine2>", "<City>", "<Country>", "<State>", "<Zip>", "<HomePhone>","<otherPhone>", "<Fax>", "<Email>"
        And Edit Correspondence Information: "<AddressLine1>", "<AddressLine2>", "<City>", "<State>", "<Zip>", "<HomePhone>", "<Email>"
        And Edit Power Outage Contact Information: "<HomePhone>","<otherPhone>", "<Email>"
        And Click on Save Button from Contact Information Section in Customer Summary page
        Then Verify Contact Information: "<CustomerType>", "<DBA>", "<PermitContactName>"
        And Verify Billing Information: "<Contact>", "<AddressLine1>", "<AddressLine2>", "<City>", "<Country>", "<State>", "<Zip>", "<HomePhone>","<otherPhone>", "<Fax>", "<Email>"
        And verify Correspondence Information: "<AddressLine1>", "<AddressLine2>", "<City>", "<State>", "<Zip>", "<HomePhone>", "<Email>"
        And verify Power Outage Contact Information: "<HomePhone>","<otherPhone>", "<Email>"

        Examples:
            | CustomerType | DBA    | PermitContactName | Contact | AddressLine1 | AddressLine2 | City   | Country | State | Zip   | HomePhone  | otherPhone | Fax     | Email         |
            | Commercial   | Robert | Mary              | Michael | St one Road  | --           | Berlin | Germany | Ohio  | 21344 | 9999999999 | 3473673647 | 3834675 | test@test.com |


