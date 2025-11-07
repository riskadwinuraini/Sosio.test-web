package starter.Sosio;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import java.util.List;

public class Periode extends PageObject {

    // ========== LOCATORS ==========
    private By menuPeriode = By.xpath("//span[normalize-space()='Periode']");
    private By btnTambahPeriode = By.xpath("//button[contains(.,'Tambah Periode')]");
    private By fieldNamaPeriode = By.id("nama_periode");
    private By fieldTanggalMulai = By.id("tanggal_mulai");
    private By fieldTanggalSelesai = By.id("tanggal_selesai");
    private By btnSimpan = By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div[2]/form/div[5]/div/button");
    private By listPeriode = By.xpath("//*[@id=\"table\"]");
    private By alertSuccess = By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]");
    private By errorMessage = By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]");
    private By btnJeda = By.cssSelector("button.btn-jeda");
    private By popupJeda = By.xpath("//*[@id=\"modal-isLock\"]/div/div/div[2]");
    private By btnConfirmJeda = By.xpath("//*[@id=\"submit_button\"]");
    private By btnLanjutkan = By.cssSelector("button.btn-resume");
    private By popupLanjutkan = By.xpath("//*[@id=\"modal-isLock\"]/div/div/div[2]");
    private By btnConfirmLanjutkan = By.xpath("//*[@id=\"submit_button\"]");
    private By btnDelete = By.cssSelector("button.btn-danger.modal-effect"); //
    private By popupDelete = By.xpath("//*[@id=\"modal-delete\"]/div/div/div[2]");
    private By btnConfirmDelete = By.xpath("//*[@id=\"modal-delete\"]/div/div/div[2]/div/form/button");

    // ========== STEPS ==========
    @Step("Klik menu Periode")
    public void clickMenuPeriode() {
        $(menuPeriode).click();
    }

    @Step("Klik tombol Tambah Periode")
    public void clickTambahPeriode() {
        $(btnTambahPeriode).click();
    }

    @Step("Isi Nama Periode dengan {0}")
    public void fillNamaPeriode(String namaPeriode) {
        $(fieldNamaPeriode).clear();
        $(fieldNamaPeriode).type(namaPeriode);
    }

    @Step("Isi Tanggal Mulai dengan {0}")
    public void fillTanggalMulai(String tanggalMulai) {
        evaluateJavascript("document.getElementById('tanggal_mulai').value='" + tanggalMulai + "'");
    }

    @Step("Isi Tanggal Selesai dengan {0}")
    public void fillTanggalSelesai(String tanggalSelesai) {
        evaluateJavascript("document.getElementById('tanggal_selesai').value='" + tanggalSelesai + "'");
    }

    @Step("Klik tombol Simpan")
    public void clickSimpan() {
        $(btnSimpan).click();
    }

    @Step("Verifikasi pesan gagal")
    public void verifyErrorMessage() {
        waitForCondition().until(driver -> $(errorMessage).isVisible());
        Assert.assertTrue("Pesan gagal tidak muncul!", $(errorMessage).isVisible());
    }

    @Step("Verifikasi pesan sukses")
    public void verifySuccessMessage() {
        waitForCondition().until(driver -> $(alertSuccess).isVisible());
        Assert.assertTrue("Pesan sukses tidak muncul!", $(alertSuccess).isVisible());
    }

    @Step("Verifikasi periode baru muncul di list")
    public void verifyNewPeriodeInList() {
        waitForCondition().until(driver -> $(listPeriode).isVisible());
        Assert.assertTrue("❌ Tabel periode belum muncul!", $(listPeriode).isVisible());
    }

    @Step("Verifikasi tombol Edit di baris ke-{0} disable")
    public void verifyEditButtonDisabledByRow(int rowIndex) {
        By editButton = By.xpath("//*[@id='table']/tbody/tr[" + rowIndex + "]/td[6]/button[1]");
        waitForCondition().until(driver -> $(editButton).isVisible());
        boolean isDisabled = $(editButton).getAttribute("disabled") != null;
        Assert.assertTrue("❌ Tombol Edit di baris ke-" + rowIndex + " seharusnya disable!", isDisabled);
    }

    @Step("Verifikasi tombol aksi pada baris {0} aktif")
    public void verifyActionButtonsEnabledInRow(int row) {
        By actionColumn = By.xpath("//*[@id='table']/tbody/tr[" + row + "]/td[6]");
        WebElementFacade columnElement = $(actionColumn);
        List<WebElement> buttons = columnElement.findElements(By.tagName("button"));
        boolean hasEnabledButton = buttons.stream().anyMatch(WebElement::isEnabled);
        Assert.assertTrue("Tidak ada tombol aktif di kolom aksi baris " + row, hasEnabledButton);
    }

    @Step("Klik tombol jeda periode")
    public void clickButtonJeda() {
        $(btnJeda).waitUntilClickable().click();
    }

    @Step("Klik tombol konfirmasi jeda pada pop up")
    public void confirmJedaPopup() {
        $(popupJeda).waitUntilVisible();
        $(btnConfirmJeda).click();
    }

    @Step("Klik tombol lanjutkan periode")
    public void clickButtonLanjutkan() {
        $(btnLanjutkan).waitUntilClickable().click();
    }

    @Step("Klik tombol konfirmasi lanjutkan pada pop up")
    public void confirmLanjutkanPopup() {
        $(popupLanjutkan).waitUntilVisible();
        $(btnConfirmLanjutkan).click();
    }

    // Tambahan otomatis klik jeda/lanjutkan berdasarkan status
    @Step("Klik tombol jeda atau lanjutkan sesuai status periode")
    public void clickJedaOrLanjutkan() {
        boolean jedaVisible = $(btnJeda).isVisible() && $(btnJeda).isEnabled();
        boolean lanjutVisible = $(btnLanjutkan).isVisible() && $(btnLanjutkan).isEnabled();

        if (jedaVisible) {
            System.out.println("🟡 Status aktif → klik tombol Jeda");
            clickButtonJeda();
            confirmJedaPopup();
        } else if (lanjutVisible) {
            System.out.println("🟢 Status jeda → klik tombol Lanjutkan");
            clickButtonLanjutkan();
            confirmLanjutkanPopup();
        } else {
            Assert.fail("❌ Tidak ada tombol Jeda atau Lanjutkan yang aktif di halaman Periode!");
        }
    }
    @Step("Klik tombol hapus periode")
    public void clickButtonDelete() {
        $(btnDelete).waitUntilClickable().click();
    }

    @Step("Klik tombol konfirmasi hapus pada pop up")
    public void confirmDeletePopup() {
        $(popupDelete).waitUntilVisible();
        $(btnConfirmDelete).click();
    }
}
