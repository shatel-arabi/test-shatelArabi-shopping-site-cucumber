Feature: logout features

  Background:
    Given I am on swaglabs login page

  Scenario: Logout should be successful
  Given I login on the page first
    Given I click on burger menu
    When I click on logout button
   Then I see login button page
