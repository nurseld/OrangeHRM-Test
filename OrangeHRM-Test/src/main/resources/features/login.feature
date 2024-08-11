Feature: Login
  Scenario: Successful login with valid credentials
    Given User is on the login page
    When User enters valid username and password
    And User clicks on the login button
    Then User should be redirected to the dashboard

  Scenario: User attempts to log in with invalid username
    Given User is on the login page
    When User enters invalid username "InvalidUser" and password "admin123"
    And User clicks on the login button
    Then User should see an error message indicating invalid username

  Scenario: User attempts to log in with invalid password
    Given User is on the login page
    When User enters valid username "Admin" and invalid password "wrongpassword"
    And User clicks on the login button
    Then User should see an error message indicating invalid password

  Scenario: User attempts to log in with blank username
    Given User is on the login page
    When User enters blank username and valid password "admin123"
    And User clicks on the login button
    Then User should see an error message indicating username is required

  Scenario: User attempts to log in with blank password
    Given User is on the login page
    When User enters valid username "Admin" and blank password
    And User clicks on the login button
    Then User should see an error message indicating password is required

  Scenario: User attempts to log in with both username and password blank
    Given User is on the login page
    When User enters blank username and blank password
    And User clicks on the login button
    Then User should see an error message indicating both fields are required