package starter.StepDefinitions;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import starter.Sosio.Periode;

public class PeriodeSteps {

    @Steps
    Periode periode;

    @When("I click the menu {string}")
    public void clickMenu(String menu) {
        if (menu.equalsIgnoreCase("Periode")) {
            periode.clickMenuPeriode();
        }
    }

    @When("I click the Tambah Periode button")
    public void clickTambahPeriodeButton() {
        periode.clickTambahPeriode();
    }

    @When("I fill Nama Periode with {string}")
    public void fillNamaPeriode(String namaPeriode) {
        periode.fillNamaPeriode(namaPeriode);
    }

    @When("I fill Tanggal Mulai with {string}")
    public void fillTanggalMulai(String tanggalMulai) {
        periode.fillTanggalMulai(tanggalMulai);
    }

    @When("I fill Tanggal Selesai with {string}")
    public void fillTanggalSelesai(String tanggalSelesai) {
        periode.fillTanggalSelesai(tanggalSelesai);
    }

    @When("I click the Simpan button")
    public void clickSimpanButton() {
        periode.clickSimpan();
    }

    @Then("I should see a error message {string}")
    public void verifyErrorMessage(String message) {
        periode.verifyErrorMessage();
    }

    @Then("I should see a success message {string}")
    public void verifySuccessMessage(String message) {
        periode.verifySuccessMessage();
    }

    @Then("the new periode {string} should appear in the periode list")
    public void verifyPeriodeInList(String namaPeriode) {
        periode.verifyNewPeriodeInList();
    }

    @Then("the Edit button in row {int} should be disabled")
    public void verifyEditButtonDisabled(int rowIndex) {
        periode.verifyEditButtonDisabledByRow(rowIndex);
    }

    @Then("the action buttons in row {int} should be enabled")
    public void verifyActionButtonsEnabledInRow(int row) {
        periode.verifyActionButtonsEnabledInRow(row);
    }

    @Then("I click button jeda")
    public void clickButtonJeda() {
        periode.clickButtonJeda();
    }

    @Then("I see pop up and click button jeda periode")
    public void confirmJedaPopup() {
        periode.confirmJedaPopup();
    }

    @Then("I click button lanjutkan periode")
    public void clickButtonLanjutkan() {
        periode.clickButtonLanjutkan();
    }

    @Then("I see pop up and click button lanjutkan periode")
    public void confirmLanjutkanPopup() {
        periode.confirmLanjutkanPopup();
    }

    //  Tambahan otomatis pilih jeda/lanjutkan
    @Then("I click button jeda or continue based on status")
    public void clickButtonJedaOrContinueBasedOnStatus() {
        periode.clickJedaOrLanjutkan();
    }
    @Then("I click delete button")
    public void clickButtonDelete() {
        periode.clickButtonDelete();
    }

    @Then("I see pop up and click delete button")
    public void confirmDeletePopup() {
        periode.confirmDeletePopup();
    }

}
