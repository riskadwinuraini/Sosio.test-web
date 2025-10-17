Feature: Profile Management
  As a logged in user
  I want to view and edit my account profile
  So that I can update my personal information

  Background:
    Given I am on the login pages
    When I enter Email "riskadwi583@gmail.com"
    And I enter Password "Sosio@123"
    And I click Login button
    Then I am on the dashboard page

  @profile
  Scenario: Edit account name with random value
    When I click the profile icon
    And I click the Profil menu
    And I change the name to random
    And I click the save button
    Then I can see a success message

  @profile
  Scenario: Edit account email with a new valid email
    When I click the profile icon
    And I click the ubah email menu
    And I change the email to "reynandatrikusumadewi@gmail.com"
    And I click the send button
    Then I am redirected to the OTP verification page
    When  I input the OTP code manually
    And I click the verify button
    Then I can see a success message after updating email

    @profile
    Scenario:  Edit password with a new valid password
      When I click the profile icon
      And I click the Ubah Kata Sandi menu
      When I click the Kirim button
      Then I am redirected to the OTP verification page of new password
      When I add the OTP code manually
      And I click verification button of new password