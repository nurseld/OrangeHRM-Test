Feature: Search and Navigate to Pages in OrangeHRM

  @search1
  Scenario: Navigate to Admin page through search
    Given User is logged in and on the Dashboard page
    When User clicks on the search box
    And User enters 'Admin' in the search box
    And User clicks on the "Admin" search result
    Then User should be navigated to the 'Admin' page

  Scenario: Navigate to PIM page through search
    Given User is logged in and on the Dashboard page
    When User clicks on the search box
    And User enters 'PIM' in the search box
    And User clicks on the "PIM" search result
    Then User should be navigated to the 'PIM' page

  Scenario: Navigate to Leave page through search
    Given User is logged in and on the Dashboard page
    When User clicks on the search box
    And User enters 'Leave' in the search box
    And User clicks on the "Leave" search result
    Then User should be navigated to the 'Leave' page

  Scenario: Navigate to Time page through search
    Given User is logged in and on the Dashboard page
    When User clicks on the search box
    And User enters 'Time' in the search box
    And User clicks on the "Time" search result
    Then User should be navigated to the 'Time' page

  Scenario: Navigate to Recruitment page through search
    Given User is logged in and on the Dashboard page
    When User clicks on the search box
    And User enters 'Recruitment' in the search box
    And User clicks on the "Recruitment" search result
    Then User should be navigated to the 'Recruitment' page

  Scenario: Navigate to Performance page through search
    Given User is logged in and on the Dashboard page
    When User clicks on the search box
    And User enters 'Performance' in the search box
    And User clicks on the "Performance" search result
    Then User should be navigated to the 'Performance' page