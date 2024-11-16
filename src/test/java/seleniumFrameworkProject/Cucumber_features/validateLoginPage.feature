@tag
Feature: Vefiry order is palced successfully.

  Background: 
    Given user should be landed on the Login page.

  @tag2
  Scenario Outline: Verify if the order is successfully placed.
    Given Login with <userName> and <password>
    When I added <productName> to cart
    And Click on cart and checkout the <productName> order.
    Then Check if the success massage is displayed.

    Examples: 
      | userName                | password | productName |
      | test.user7981@gmail.com |Demo@123| ZARA COAT 3 |
