Feature: login

  Scenario: As user I have be able to success login
    Given I am on the login pages
    When I enter Email "riska.dnuraini@solusimakmur.com"
    And I enter Password "Sosio@123"
    And I click Login button
    Then I am on the dashboard page

    Scenario: As user I have be able to failed login with invalid password
      Given I am on the login pages
      When I enter Email "riska.dnuraini@solusimakmur.com"
      And I enter Password "admin80"
      And I click Login button
      And I can see error message "Email atau kata sandi salah"

      Scenario: As user I have be able to failed login with password not filled
        Given I am on the login pages
        When I enter Email "riska.dnuraini@solusimakmur.com"
        And I enter Password ""
        And I click Login button
        Then the system should display a warning message

        Scenario: As user I have be able to failed login with email not filled
          Given I am on the login pages
          When I enter Email ""
          And I enter Password "Sosio@123"
          And I click Login button
          Then the system should display a warning message

          Scenario:  As user I have be able to failed login with email and password not filled
            Given I am on the login pages
            When I enter Email ""
            And I enter Password ""
            And I click Login button
            Then the system should display a warning message