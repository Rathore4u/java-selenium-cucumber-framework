# About Common Test Automation Framework

This framework is basically developed and designed to automate application product test suites 

# Work Flow

1. Create a branch
2. Do your work
3. Prepare feature / bug fix branch
 * Make sure commit history is clean 
4. Raise pull request to merge your branch into the main repo branches


# Tools , Approaches and Technologies Used

* Gherkin
* Core Java
* Selenium WebDriver API 3.3.1
* geckodriver 15
* Cucumber
* Page Object Model Design pattern
* Junit
* Maven
* Firefox 52 or lesser 
* Chrome extension to auto-generate PO classes

#Chrome Extension to auto-generate PO files
* Go to URL - https://chrome.google.com/webstore/detail/epgmnmcjdhapiojbohkkemlfkegmbebb
* Install the extension "Page Object Generator"
* While automating, use the extension to auto-generate PO files
* Auto-generated PO files has following advantages and disadvantages
    ** Advantages:
    1. It generates ALL elements locator dump
    2. It prefers css/name/id to generate element locators
    3. It provides the full syntax of writing it in java, hence saves a lot of typing ( such as @FindBy, WebElement etc)
    4. It provides PO interaction methods for all possible elements, such as clicks, sendKeys
    5. It provides verifyPageLoaded and verifyPageUrl methods in each PO
    
    ** Disadvantages / Points about to be careful while using.
    1. Though it dumps intelligent locator strategy, but there is still human intervention needed to modify and correct in many cases
    2. It provides css with href having indexed urls for locator strategy, at times those need to be tailored to the part unique.
    
Note: overall it's quite helpful in dumping locators and po methods in a formatted way, while still it's not compelte solution for exact ALL unique locators or PO methods



# How to Setup & Configure

  1. Install and IDE such as VScode/IntelliJ/Eclipse ( any latest version will do )
  2. Install Maven plugin in IDE if it is not present/enabled
  3. Use git lfs clone to download the automation framework to your local system , GIT URL 
	https://github.com/Rathore4u/java-selenium-cucumber-framework.git


  4. Locate pom.XML and right click and choose Run As -> Maven Build
   ( Alternatively skipping step 6,7,8, you can run from console of IDE or system console as "mvn clean install" to give a trial run )
  6. In the run configurations provide below values and click apply and run.

		Goals : generate-resources
		Profiles: <profile-to-be-used>

  6. Check whether the build is successful
  7. Now , locate MasterTest.java, right click on the java file and choose Run As -> Junit Test
  This step would launch the browser and launch the application and runs the scenarios written in <modulename>.feature files under resources/feature_files/ path.

  8. From command prompt go to project level and execute following command(it is advised to use command line option to run) :
	
	mvn -P local clean install -Dtest=GenericTest

# How to run feature specific tests : Only for development purpose.

To run feature specific tests , either create and add your own Test file similar to LoginTest.java OR please edit test runner class MasterTest.java and update the tags = "@<feature-name>".

	Examples :
		tags = "@Login"
		tags = "@Home"

To run whole Smoke suite, please edit the test runner class MasterTest.java and update the tags = "@SmokeReady"


# IQB for This Framework
1. Cucumber feature file should be auto-generated from the aurea automation utils tool i.e. chrome plugin for the same which provides a "copy cucumber code" button on TestRail of each test case
2. Each Unique statement should have mapped to a stepDefinition method
3. Stepdefinition file name should end with "SD" as suffix
4. Page Object files should be under "lib/page/functions" folder and locators should be added under "lib/page/locators" folder with appropriate name similar to PO files as mappping
5. All global properties such as credentials, baseUrl, connection names, hostings etc should be in properties file under "profiles" folder
6. Statements should follow cucumber best practices mentioned here https://www.engineyard.com/blog/15-expert-tips-for-using-cucumber
7. Reusability of already existing statements should be made sure. ( avoid writing same statement or a slight variation in different SD files)
8. Make sure to run all affected feature files while refactoring any existing stepdefinition method
9. Any method used across multiple pages or used for multiple Stepdefinition methods, should b abstracted to files under "lib/helper" to make it available to all users,
 Also create new helper file in case there is none related
10. All properties other than credentials, urls and such global properties, should be under "resources" folder as similar to "message.properties" or "testrail.properties" and likewise,
this is primarily to extract commonly used properties across multiple files, but same time not good enough to be considered as global properties.
   
  
