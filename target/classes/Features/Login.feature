# This is the first feature file
  Feature: Login to the facebook
    @smoke
    Scenario: login
      Given I launch the facebook page
      When I enter username and password
      And I click on the login
      Then I am on the home page
      And I close the browser


