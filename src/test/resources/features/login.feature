Feature: Login features


  Background:
    Given I am on swaglabs login page
  Scenario: Login with valid data should be successful
    Given I enter 'standard_user' in username field
    And I enter 'secret_sauce' in password field
    When I click on login button
    Then I see 'PRODUCTS' page