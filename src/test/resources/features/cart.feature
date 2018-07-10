Feature: To test the cart functionality

  @cart
  Scenario: To test whether items getting added to the cart or not

    Given User is in boulder home page
    When he clicks on Accessories
    Then he should go to accesories page
    And  he clicks on Juice S2 item
    And  he clicks on Add to cart
    Then he should see the juice S2 item added to the cart


