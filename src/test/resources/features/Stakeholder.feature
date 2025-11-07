Feature: Stakeholder
  As a logged in user
  I want to add a new stakeholder
  So that I can manage stakeholder data in the system

  Background:
    Given I am on the login pages
    When I enter Email "riska.dnuraini@solusimakmur.com"
    And I enter Password "Sosio@2025"
    And I click Login button
    Then I am on the dashboard page

  @AddStakeholder
  Scenario: make a submission to add stakeholders
    When I click the menu stakeholder
    And I click the tambah stakeholder button
    And I fill nama stakeholder with "aruna"
    And I fill jabatan with "Artist"
    And I select stakeholder with "External"
    And I select kategori stakeholder "Customers"
    And I select scope area "Ring 2"
    And I select kategori ring "Desa Klekat"
    And I select coverage area "Kabupaten"
    And I click the selanjutnya button
    And I fill pekerjaan with "artist"
    And I fill tempat lahir with "Bandung"
    And I select tanggal lahir with "2000-11-06"
    And I fill alamat with "Bandung raya"
    And I fill no telepon with "0878791218319"
    And I click keluarga tab
    And I fill nama pasangan "sandina"
    And I fill nama anak "medina"
    And I fill nama kerabat yang berpengaruh "sudarsono"
    And I click info pribadi tab
    And I fill agama "islam"
    And I fill suku "jawa"
    And I fill pendidikan "SMA"
    And I fill hobi "kulineran"
    And I fill makanan kesukaan "batagor"
    And I fill topik pembicaraan kesukaan "religius,fashion"
    And I fill penyakit yang diderita "TBC"
    And I click Hub dengan perusahaan tab
    And I fill proyeksi kepentingan "tidak ada"
    And I fill ancaman "tidak ada"
    And I fill Gambaran kekuatan "tidak ada"
    And I fill afiliasi positif "tidak ada"
    And I fill afiliasi negatif "tidak ada"
    And I fill tokoh yang disegani "tidak tau"
    And I fill benerfit yang didapatkan dari perusahaan "tidak bermanfaat"
    And I fill histori konflik
    And I click simpan button add stakeholder
    Then A confirmation popup appears
    And I fill keterangan "Pengajuan penambahan stakeholder baru"
#    And I upload lampiran "C:\Users\Riska\OneDrive\Documents\Sosio-bug"
    And I click simpan button on confirmation popup
    Then I should see success notification "Data Berhasil Disimpan"


