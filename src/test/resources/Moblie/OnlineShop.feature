@test
Feature: Login and Product scenarios

  Scenario Outline: Login with valid user name and password on App "SwagLabsMobileApp"
    When I enter username as "<username>"
    And I enter password as "<password>"
    And I login
    Then I should see Products page with title "<title>"
    Examples:
      | username      | password     | title    |
      | standard_user | secret_sauce | PRODUCTS |

  Scenario Outline: Login with invalid password on App "SwagLabsMobileApp"
    When I enter username as "<username>"
    And I enter password as "<password>"
    And I login
    Then login should fail with an error "<err>"
    Examples:
      | username      | password        | err                                                          |
      | standard_user | invalidPassword | Username and password do not match any user in this service. |

  Scenario Outline: Validate product info on Products page on App "SwagLabsMobileApp"
    Given I'm logged in
    Then the product is listed with title "<title>" and price "<price>"
    Examples:
      | title               | price  |
      | Sauce Labs Backpack | $29.99 |
