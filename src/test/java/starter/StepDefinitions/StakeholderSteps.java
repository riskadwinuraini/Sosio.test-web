package starter.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import starter.Sosio.Stakeholder;

public class StakeholderSteps {

    @Steps
    Stakeholder stakeholder;

    // ===== Menu & Button =====
    @When("I click the menu stakeholder")
    public void clickMenuStakeholder() {
        stakeholder.clickMenuStakeholder();
    }

    @And("I click the tambah stakeholder button")
    public void clickTambahStakeholderButton() {
        stakeholder.clickTambahStakeholder();
    }

    @And("I click the selanjutnya button")
    public void clickSelanjutnyaButton() {
        stakeholder.clickSelanjutnya();
    }

    @And("I click simpan button add stakeholder")
    public void clickSimpanButton() {
        stakeholder.clickSimpanButton();
    }

    // ===== Form Basic Info =====
    @And("I fill nama stakeholder with {string}")
    public void fillNamaStakeholder(String nama) {
        stakeholder.fillNamaStakeholder(nama);
    }

    @And("I fill jabatan with {string}")
    public void fillJabatan(String jabatan) {
        stakeholder.fillJabatan(jabatan);
    }

    @And("I select stakeholder with {string}")
    public void selectStakeholder(String type) {
        stakeholder.selectStakeholder(type);
    }

    @And("I select kategori stakeholder {string}")
    public void selectKategoriStakeholder(String kategori) {
        stakeholder.selectKategoriStakeholder(kategori);
    }

    @And("I select scope area {string}")
    public void selectScopeArea(String scope) {
        stakeholder.selectScopeArea(scope);
    }

    @And("I select kategori ring {string}")
    public void selectKategoriRing(String kategoriRing) {
        stakeholder.selectKategoriRing(kategoriRing);
    }

    @And("I select coverage area {string}")
    public void selectCoverageArea(String coverage) {
        stakeholder.selectCoverageArea(coverage);
    }

    // ===== Identitas =====
    @And("I fill pekerjaan with {string}")
    public void fillPekerjaan(String pekerjaan) {
        stakeholder.fillPekerjaan(pekerjaan);
    }

    @And("I fill tempat lahir with {string}")
    public void fillTempatLahir(String tempat) {
        stakeholder.fillTempatLahir(tempat);
    }

    @And("I select tanggal lahir with {string}")
    public void selectTanggalLahir(String tanggalLahir) {
        stakeholder.selectTanggalLahir(tanggalLahir);
    }

    @And("I fill alamat with {string}")
    public void fillAlamat(String alamat) {
        stakeholder.fillAlamat(alamat);
    }

    @And("I fill no telepon with {string}")
    public void fillNoTelepon(String phone) {
        stakeholder.fillNoTelepon(phone);
    }

    // ===== Tab Keluarga =====
    @And("I click keluarga tab")
    public void clickKeluargaTab() {
        stakeholder.clickKeluargaTab();
    }

    @And("I fill nama pasangan {string}")
    public void fillNamaPasangan(String pasangan) {
        stakeholder.fillNamaPasangan(pasangan);
    }

    @And("I fill nama anak {string}")
    public void fillNamaAnak(String anak) {
        stakeholder.fillNamaAnak(anak);
    }

    @And("I fill nama kerabat yang berpengaruh {string}")
    public void fillNamaKerabat(String kerabat) {
        stakeholder.fillNamaKerabatBerpengaruh(kerabat);
    }

    // ===== Tab Info Pribadi =====
    @And("I click info pribadi tab")
    public void clickInfoPribadiTab() {
        stakeholder.clickInfoPribadiTab();
    }

    @And("I fill agama {string}")
    public void fillReligion(String agama) {
        stakeholder.fillReligion(agama);
    }

    @And("I fill suku {string}")
    public void fillSuku(String suku) {
        stakeholder.fillSuku(suku);
    }

    @And("I fill pendidikan {string}")
    public void fillPendidikan(String pendidikan) {
        stakeholder.fillPendidikan(pendidikan);
    }

    @And("I fill hobi {string}")
    public void fillHobi(String hobi) {
        stakeholder.fillHobi(hobi);
    }

    @And("I fill makanan kesukaan {string}")
    public void fillMakananKesukaan(String makanan) {
        stakeholder.fillMakananKesukaan(makanan);
    }

    @And("I fill topik pembicaraan kesukaan {string}")
    public void fillTopikPembicaraan(String topik) {
        stakeholder.fillTopikPembicaraan(topik);
    }

    @And("I fill penyakit yang diderita {string}")
    public void fillPenyakitYangDiderita(String penyakit) {
        stakeholder.fillPenyakitYangDiderita(penyakit);
    }

    // ===== Tab Hubungan Perusahaan =====
    @And("I click Hub dengan perusahaan tab")
    public void clickHubunganPerusahaanTab() {
        stakeholder.clickHubunganPerusahaanTab();
    }

    @And("I fill proyeksi kepentingan {string}")
    public void fillProyeksiKepentingan(String proyeksi) {
        stakeholder.fillProyeksiKepentingan(proyeksi);
    }

    @And("I fill ancaman {string}")
    public void fillAncaman(String ancaman) {
        stakeholder.fillAncaman(ancaman);
    }

    @And("I fill Gambaran kekuatan {string}")
    public void fillGambaranKekuatan(String kekuatan) {
        stakeholder.fillGambaranKekuatan(kekuatan);
    }

    @And("I fill afiliasi positif {string}")
    public void fillAfiliasiPositif(String positif) {
        stakeholder.fillAfiliasiPositif(positif);
    }

    @And("I fill afiliasi negatif {string}")
    public void fillAfiliasiNegatif(String negatif) {
        stakeholder.fillAfiliasiNegatif(negatif);
    }

    @And("I fill tokoh yang disegani {string}")
    public void fillTokohDisegani(String tokoh) {
        stakeholder.fillTokohDisegani(tokoh);
    }

    @And("I fill benerfit yang didapatkan dari perusahaan {string}")
    public void fillBenefitPerusahaan(String benefit) {
        stakeholder.fillBenefitPerusahaan(benefit);
    }

    @And("I fill histori konflik")
    public void fillHistoriKonflik() {
        stakeholder.fillHistoriKonflik("Tidak ada konflik");
    }
    @Then("A confirmation popup appears")
    public void aConfirmationPopupAppears() {
        stakeholder.waitForConfirmationPopup();
    }

    @And("I fill keterangan {string}")
    public void iFillKeterangan(String keterangan) {
        stakeholder.fillKeterangan(keterangan);
    }

    @And("I upload lampiran {string}")
    public void iUploadLampiran(String filePath) {
        stakeholder.uploadLampiran(filePath);
    }

    @And("I click simpan button on confirmation popup")
    public void iClickSimpanButtonOnConfirmationPopup() {
        stakeholder.clickSimpanKonfirmasi();
    }

    @Then("I should see success notification {string}")
    public void iShouldSeeSuccessNotification(String message) {
        stakeholder.verifySuccessNotification(message);
    }

}
