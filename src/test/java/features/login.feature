Feature: Login in Sauce Labs Mobile App
  Scenario: Successful login
    Given I launch the app
    When I enter username "standard_user" and password "secret_sauce"
    And I tap the login button
    Then I should see the products screen
    Then I quit the app

  Scenario: Failed login
    Given I launch the app
    When I enter username "invalid_user" and password "invalid_pass"
    And I tap the login button
    Then I should see an error message "Username and password do not match any user in this service."
    Then I quit the app