Feature: shoppingCart features

  Background: I am on swaglabs login page

  Scenario: verifying product shopping cart
  Given I login to the page first
    Given I click on product's Add to cart button
   When I click on the shopping cart sign
    Then I see item in cart page
    And I see continue shopping button
   And I see  added product quantity