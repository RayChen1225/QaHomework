@test
Feature: API scenarios

  Scenario: Get user info
    Given I get the user list
    When I call user detail API with id "6129393"
    Then I could get related details

  Scenario: Delete user failed
    When I call user deletion API for user "6129393" without AA
    Then I could delete failed
