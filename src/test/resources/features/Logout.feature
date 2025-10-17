Feature: Logout

  Scenario: As a user I am able to successfully logout
    Given I am already logged in and on the dashboard page
    When I click on the profile icon
    And I select the "Keluar" menu
    Then I am redirected to the login page
