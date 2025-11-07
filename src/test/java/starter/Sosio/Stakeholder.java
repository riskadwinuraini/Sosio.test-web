package starter.Sosio;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;


public class Stakeholder extends PageObject {

    // ========== LOCATORS ==========
    private By menuStakeholder = By.xpath("//span[normalize-space()='Stakeholder']");
    private By btnTambahStakeholder = By.xpath("//button[contains(.,'Tambah Stakeholder')]");
    private By fieldNamaStakeholder = By.name("nama");
    private By fieldJabatan = By.name("jabatan");
    private By stakeholderDropdown = By.cssSelector("select.kategori.subKategori.lv1");
    private By fieldKategoriStakeholder = By.cssSelector("select.kategori.subKategori[data-level='2']");
    private By fieldScopeArea = By.xpath("//*[@id=\"wizard3-p-0\"]/div[4]/div[2]/div/select");
    private By fieldKategoriRing = By.cssSelector("select.kategori.subKategori[data-level='\" + level + \"']");
    private By fieldCoverageArea = By.xpath("//*[@id=\"wizard3-p-0\"]/div[4]/div[3]/div/select");
    private By btnSelanjutnya = By.xpath("//*[@id=\"wizard3\"]/div[3]/ul/li[2]");
    private By btnSimpan = By.xpath("//button[contains(.,'Simpan')]");

    // Tabs
    private By tabKeluarga = By.xpath("//a[contains(.,'Keluarga')]");
    private By tabInfoPribadi = By.xpath("//a[contains(.,'Info Pribadi')]");
    private By tabHubunganPerusahaan = By.xpath("//a[contains(.,'Hub. Dengan Perusahaan')]");

    // Identitas
    private By fieldPekerjaan = By.xpath("//*[@id=\"wizard3-p-1\"]/div[1]/input");
    private By fieldTempatLahir = By.xpath("//*[@id=\"wizard3-p-1\"]/div[2]/input");
    private By fieldTanggalLahir = By.name("birth_of_date");
    private By fieldAlamat = By.xpath("//*[@id=\"wizard3-p-1\"]/div[4]/input");
    private By fieldNoTelepon = By.xpath("//*[@id=\"wizard3-p-1\"]/div[5]/input");

    // Keluarga
    private By fieldNamaPasangan = By.name("partner_name");
    private By fieldNamaAnak = By.name("children_name");
    private By fieldNamaKerabatBerpengaruh = By.name("relative_name");

    // Info pribadi
    private By fieldReligion = By.name("religion");
    private By fieldSuku = By.name("ethnic");
    private By fieldPendidikan = By.name("qualification");
    private By fieldHobi = By.name("hoby");
    private By fieldMakananKesukaan = By.name("favorite_food");
    private By fieldTopikPembicaraan = By.name("favorite_conversation");
    private By fieldPenyakitYangDiderita = By.name("illness");

    // Hubungan perusahaan
    private By fieldProyeksiKepentingan = By.name("projected_interest");
    private By fieldAncaman = By.name("threat");
    private By fieldGambaranKekuatan = By.name("images_of_strengths");
    private By fieldAfiliasiPositif = By.name("positive_affiliation");
    private By fieldAfiliasiNegatif = By.name("negative_affiliation");
    private By fieldTokohDisegani = By.name("respected_figure");
    private By fieldBenefitPerusahaan = By.name("benefit_obtained");
    private By fieldHistoriKonflik = By.name("conflict_history");

    // Popup
    private By popupKonfirmasi = By.xpath("//*[@id='modal']//div[contains(@class,'modal-content')]");

    // Field Keterangan
    private By fieldKeterangan = By.xpath("//*[@id='modal']//textarea[@name='keterangan']");

    // Upload Lampiran
    private By inputLampiran = By.name("lampiran");

    // Tombol Simpan di Popup
    private By tombolSimpanKonfirmasi = By.xpath("//*[@id='submit_button']");

    // Notifikasi Sukses
    private By notifikasiSukses = By.xpath("//div[contains(@class,'toast') or contains(@class,'alert')][contains(.,'Data Berhasil Disimpan')]");

    // ========== STEPS ==========
    @Step
    public void clickMenuStakeholder() {
        $(menuStakeholder).waitUntilVisible().click();
    }

    @Step
    public void clickTambahStakeholder() {
        $(btnTambahStakeholder).waitUntilVisible().click();
        $(fieldNamaStakeholder).waitUntilVisible();
    }

    @Step
    public void fillNamaStakeholder(String nama) {
        $(fieldNamaStakeholder).waitUntilVisible().type(nama);
    }

    @Step
    public void fillJabatan(String jabatan) {
        $(fieldJabatan).waitUntilVisible().type(jabatan);
    }

    @Step
    public void selectStakeholder(String stakeholderType) {
        waitForCondition()
                .withTimeout(Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(stakeholderDropdown));

        org.openqa.selenium.support.ui.Select dropdown =
                new org.openqa.selenium.support.ui.Select($(stakeholderDropdown));
        dropdown.selectByVisibleText(stakeholderType);

    }

    @Step
    public void selectKategoriStakeholder(String kategori) {
        By fieldKategoriStakeholder = By.cssSelector("select.kategori.subKategori[data-level='2']");

        // 🔹 Pastikan dropdown Stakeholder (lv1) sudah dipilih dulu
        System.out.println("Menunggu dropdown kategori stakeholder muncul di DOM...");

        // 🔹 Coba tunggu maksimal 20 detik, sambil cek tiap 1 detik apakah elemen lv2 sudah ada
        boolean isFound = false;
        for (int i = 0; i < 20; i++) {
            if (getDriver().findElements(fieldKategoriStakeholder).size() > 0) {
                isFound = true;
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 🔹 Kalau setelah 20 detik elemen masih belum muncul, log detail halaman
        if (!isFound) {
            System.out.println("❌ Dropdown kategori stakeholder belum muncul!");
            System.out.println("🔍 Cek DOM: " + getDriver().getPageSource().contains("kategori subKategori"));
            throw new RuntimeException("Dropdown kategori stakeholder (lv2) tidak ditemukan di halaman!");
        }

        // 🔹 Tunggu sampai dropdown benar-benar bisa diklik
        waitForCondition()
                .withTimeout(Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(fieldKategoriStakeholder));

        // 🔹 Pilih opsi berdasarkan teks yang terlihat
        org.openqa.selenium.support.ui.Select selectKategori =
                new org.openqa.selenium.support.ui.Select($(fieldKategoriStakeholder));
        selectKategori.selectByVisibleText(kategori);

        System.out.println("✅ Kategori stakeholder '" + kategori + "' berhasil dipilih!");
    }

    @Step
    public void selectScopeArea(String scope) {
        waitForCondition()
                .withTimeout(Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(fieldScopeArea));

        org.openqa.selenium.support.ui.Select dropdown =
                new org.openqa.selenium.support.ui.Select($(fieldScopeArea));
        dropdown.selectByVisibleText(scope);
    }

    @Step
    public void selectKategoriRing(String kategoriRing) {
        // 🔹 Selector dropdown Kategori Scope Area (level 2)
        By fieldKategoriScope = By.xpath("//*[@id=\"wizard3-p-0\"]/div[4]/div[2]/div[2]/select");

        // 🔹 Pastikan dropdown Scope Area (lv1) sudah dipilih dulu
        System.out.println("Menunggu dropdown kategori Scope Area muncul di DOM...");

        // 🔹 Coba tunggu maksimal 20 detik, cek tiap 1 detik apakah dropdown lv2 sudah muncul
        boolean isFound = false;
        for (int i = 0; i < 20; i++) {
            if (getDriver().findElements(fieldKategoriScope).size() > 0) {
                isFound = true;
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 🔹 Kalau setelah 20 detik belum muncul, cetak log DOM
        if (!isFound) {
            System.out.println("❌ Dropdown kategori Scope Area belum muncul!");
            System.out.println("🔍 Cek DOM: " + getDriver().getPageSource().contains("kategori subKategori"));
            throw new RuntimeException("Dropdown kategori Scope Area (lv2) tidak ditemukan di halaman!");
        }

        // 🔹 Tunggu sampai dropdown benar-benar bisa diklik
        waitForCondition()
                .withTimeout(Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(fieldKategoriScope));

        // 🔹 Pilih opsi berdasarkan teks yang terlihat
        org.openqa.selenium.support.ui.Select selectKategori =
                new org.openqa.selenium.support.ui.Select($(fieldKategoriScope));
        selectKategori.selectByVisibleText(kategoriRing);

        System.out.println("✅ Kategori Scope Area '" + kategoriRing + "' berhasil dipilih!");
    }

    @Step
    public void selectCoverageArea(String coverage) {
        waitForCondition()
                .withTimeout(Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(fieldCoverageArea));

        org.openqa.selenium.support.ui.Select dropdown =
                new org.openqa.selenium.support.ui.Select($(fieldCoverageArea));
        dropdown.selectByVisibleText(coverage);
    }

    @Step
    public void clickSelanjutnya() {
        $(btnSelanjutnya).waitUntilVisible().click();
    }

    @Step
    public void clickSimpanButton() {
        $(btnSimpan).waitUntilVisible().click();
    }

    // ===== Tabs =====
    @Step
    public void clickKeluargaTab() {
        $(tabKeluarga).waitUntilVisible().click();
    }

    @Step
    public void clickInfoPribadiTab() {
        $(tabInfoPribadi).waitUntilVisible().click();
    }

    @Step
    public void clickHubunganPerusahaanTab() {
        $(tabHubunganPerusahaan).waitUntilVisible().click();
    }

    // ===== Identitas =====
    @Step
    public void fillPekerjaan(String pekerjaan) {
        $(fieldPekerjaan).waitUntilVisible().type(pekerjaan);
    }

    @Step
    public void fillTempatLahir(String tempat) {
        $(fieldTempatLahir).waitUntilVisible().type(tempat);
    }

    @Step
    public void selectTanggalLahir(String tanggalLahir) {
        waitForCondition()
                .withTimeout(Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(fieldTanggalLahir));

        String script = "let el = document.querySelector(\"input[name='birth_of_date']\");" +
                "if (el) {" +
                "el.value='" + tanggalLahir + "';" +
                "el.dispatchEvent(new Event('input', { bubbles: true }));" +
                "el.dispatchEvent(new Event('change', { bubbles: true }));" +
                "} else { console.error('❌ Input birth_of_date tidak ditemukan di halaman'); }";

        evaluateJavascript(script);

        System.out.println("✅ Tanggal lahir '" + tanggalLahir + "' berhasil diisi!");
    }

    @Step
    public void fillAlamat(String alamat) {
        $(fieldAlamat).waitUntilVisible().type(alamat);
    }

    @Step
    public void fillNoTelepon(String phone) {
        $(fieldNoTelepon).waitUntilVisible().type(phone);
    }

    // ===== Keluarga =====
    @Step
    public void fillNamaPasangan(String pasangan) {
        $(fieldNamaPasangan).waitUntilVisible().type(pasangan);
    }

    @Step
    public void fillNamaAnak(String anak) {
        $(fieldNamaAnak).waitUntilVisible().type(anak);
    }

    @Step
    public void fillNamaKerabatBerpengaruh(String kerabat) {
        $(fieldNamaKerabatBerpengaruh).waitUntilVisible().type(kerabat);
    }

    // ===== Info Pribadi =====
    @Step
    public void fillReligion(String religion) {
        $(fieldReligion).waitUntilVisible().type(religion);
    }

    @Step
    public void fillSuku(String suku) {
        $(fieldSuku).waitUntilVisible().type(suku);
    }

    @Step
    public void fillPendidikan(String pendidikan) {
        $(fieldPendidikan).waitUntilVisible().type(pendidikan);
    }

    @Step
    public void fillHobi(String hobi) {
        $(fieldHobi).waitUntilVisible().type(hobi);
    }

    @Step
    public void fillMakananKesukaan(String makanan) {
        $(fieldMakananKesukaan).waitUntilVisible().type(makanan);
    }

    @Step
    public void fillTopikPembicaraan(String topik) {
        $(fieldTopikPembicaraan).waitUntilVisible().type(topik);
    }

    @Step
    public void fillPenyakitYangDiderita(String penyakit) {
        $(fieldPenyakitYangDiderita).waitUntilVisible().type(penyakit);
    }

    // ===== Hubungan Perusahaan =====
    @Step
    public void fillProyeksiKepentingan(String proyeksi) {
        $(fieldProyeksiKepentingan).waitUntilVisible().type(proyeksi);
    }

    @Step
    public void fillAncaman(String ancaman) {
        $(fieldAncaman).waitUntilVisible().type(ancaman);
    }

    @Step
    public void fillGambaranKekuatan(String kekuatan) {
        $(fieldGambaranKekuatan).waitUntilVisible().type(kekuatan);
    }

    @Step
    public void fillAfiliasiPositif(String positif) {
        $(fieldAfiliasiPositif).waitUntilVisible().type(positif);
    }

    @Step
    public void fillAfiliasiNegatif(String negatif) {
        $(fieldAfiliasiNegatif).waitUntilVisible().type(negatif);
    }

    @Step
    public void fillTokohDisegani(String tokoh) {
        $(fieldTokohDisegani).waitUntilVisible().type(tokoh);
    }

    @Step
    public void fillBenefitPerusahaan(String benefit) {
        $(fieldBenefitPerusahaan).waitUntilVisible().type(benefit);
    }

    @Step
    public void fillHistoriKonflik(String histori) {
        $(fieldHistoriKonflik).waitUntilVisible().type(histori);
    }
    @Step
    public void waitForConfirmationPopup() {
        $(popupKonfirmasi).waitUntilVisible();
        System.out.println("✅ Popup konfirmasi muncul");
    }

    @Step
    public void fillKeterangan(String keterangan) {
        $(fieldKeterangan).waitUntilVisible().type(keterangan);
    }

    @Step
    public void uploadLampiran(String filePath) {
        $(inputLampiran).waitUntilPresent();
        $(inputLampiran).sendKeys(filePath);
        System.out.println("📎 Lampiran berhasil diupload: " + filePath);
    }

    @Step
    public void clickSimpanKonfirmasi() {
        $(tombolSimpanKonfirmasi).waitUntilClickable().click();
    }

    @Step
    public void verifySuccessNotification(String message) {
        waitForCondition().until(driver -> $(notifikasiSukses).isVisible());
        Assert.assertTrue("Data berhasil disimpan", $(notifikasiSukses).isVisible());
    }
}
