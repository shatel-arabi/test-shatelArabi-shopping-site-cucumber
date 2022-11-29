Feature: Products features


  Background:
    Given I am on swaglabs login page

  Scenario: Product's add to cart should be successful
    Given I log in the page first
    And I click on Add to cart button
    When I click on shopping cart sign
    Then I see 'YOUR CART' page
