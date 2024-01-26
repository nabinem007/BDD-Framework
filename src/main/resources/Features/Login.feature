# This is the first feature file
  Feature: Login to the facebook

    Background:
      Given I launch the facebook page


    Scenario: login
      And I click on the login
      Then I am on the home page
      And I close the browser

    @smoke
    Scenario Outline: login with credentials
      And I enter username as "<username>" and password as "<password>"
      And I click on the login tab
      Then I am on the home page
      And I close the browser
      Examples:
      | username                     | password   |
      | 510-316-6706                 | Deepa2014  |
      | achut.bdrchhetri@gmail.com   | Deepa2014  |


    Scenario: login using DataTable
      When user enter credentials using DataTable
        | 510-316-6706                 | Deepa2014  |
      And I click on the login tab
      Then I am on the home page
      And I close the browser



    Scenario: Create new account
        When I click Create new account
       Then enter the details on the page
      | First name          |    Last name   | Mobile number| New Password |BirthMonth| Birthday| Birthyear|
      |  Nabin               | Chhetri       | 510-316-6706 | Deepa2014    |   Apr     |   14      | 1985      |
      Then I am on the home page
      And I close the browser




