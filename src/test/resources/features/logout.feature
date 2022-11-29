Feature: logout features

  Background:
    Given I am on swaglabs login page

  Scenario: Logout should be successful
    Given I log in the page first
    And I click on burger menu
    When I click on logout button
    Then I see 'LOGIN' page
