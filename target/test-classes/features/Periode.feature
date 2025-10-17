Feature: Periode Management
  As a logged in user
  I want to add a new periode
  So that I can manage periode data in the system

  Background:
    Given I am on the login pages
    When I enter Email "riskadwi583@gmail.com"
    And I enter Password "Sosio@123"
    And I click Login button
    Then I am on the dashboard page

  @AddPeriode
  Scenario: Add period with start and end dates already in use
    When I click the menu "Periode"
    And I click the Tambah Periode button
    And I fill Nama Periode with "Periode Uji Coba 2025"
    And I fill Tanggal Mulai with "2025-01-01"
    And I fill Tanggal Selesai with "2025-06-30"
    And I click the Simpan button
    Then I should see a error message "Tanggal mulai atau tanggal selesai sudah ada di sistem"


  @AddPeriode
  Scenario: Successfully add new periode
    When I click the menu "Periode"
    And I click the Tambah Periode button
    And I fill Nama Periode with "Periode Uji Coba 2025"
    And I fill Tanggal Mulai with "2029-01-01"
    And I fill Tanggal Selesai with "2029-06-30"
    And I click the Simpan button
    Then I should see a success message "Periode berhasil ditambahkan"
    And the new periode "Periode Uji Coba 2029" should appear in the periode list

    @AddPeriode
    Scenario: Add periode with empty data
      When I click the menu "Periode"
      And I click the Tambah Periode button
      And I click the Simpan button
      Then I should see a error message "Nama Periode, Tanggal Mulai, dan Tanggal Selesai wajib diisi"

      @AddPeriode
      Scenario: Add a period with an end date earlier than the start date.
        When I click the menu "Periode"
        And I click the Tambah Periode button
        And I fill Nama Periode with "Periode Uji Coba 2025"
        And I fill Tanggal Mulai with "2032-06-01"
        And I fill Tanggal Selesai with "2032-01-30"
        And I click the Simpan button
        Then I should see a success message "Tanggal selesai harus berisi tanggal setelah tanggal mulai"

        @CompletePeriode
        Scenario: Edit/ delete button disabled for completed period
          When I click the menu "Periode"
          Then the Edit button in row 7 should be disabled

          @InProgressPeriode
          Scenario: Change/delete a period that is in progress
            When I click the menu "Periode"
            Then the action buttons in row 6 should be enabled

#  @PausedPeriode
#  Scenario: Pause a period that is currently in progress
#    When I click the menu "Periode"
#    Then I click button jeda
#    Then I see pop up and click button jeda periode
#    Then I should see a success message "Berhasil mengubah status pengisian"

  @ContinuePeriode
  Scenario: Continue a period that is paused
    When I click the menu "Periode"
    Then I click button lanjutkan periode
    Then I see pop up and click button lanjutkan periode
    Then I should see a success message "Berhasil mengubah status pengisian"

  @AutoStatusChange
  Scenario: Automatically handle pause or continue based on current status
    When I click the menu "Periode"
    Then I click button jeda or continue based on status
    Then I should see a success message "Berhasil mengubah status pengisian"

    @deletePeriode
    Scenario: Delete periods that have not started status
      When I click the menu "Periode"
      Then I click delete button
      Then I see pop up and click delete button
      Then I should see a success message "Periode berhasil dihapus"










