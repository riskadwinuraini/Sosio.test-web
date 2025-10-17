package starter.Sosio;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.junit.Assert;

public class Profile extends PageObject {

    // ========== SELECTOR PROFIL ==========
    private By profileIcon() {
        return By.xpath("/html/body/div[2]/div[2]/div[1]/div/div[2]/ul/li[4]/a");
    }

    private By profileMenu() {
        return By.xpath("/html/body/div[2]/div[2]/div[1]/div/div[2]/ul/li[4]/div/a[1]");
    }

    private By nameField() {
        return By.name("nama");
    }

    private By saveButton() {
        return By.xpath("/html/body/div[2]/div[2]/div[3]/div[3]/div[2]/div/form/div[2]/button");
    }

    private By successAlert() {
        return By.xpath("//div[contains(@class,'alert') or contains(text(),'Berhasil') or contains(text(),'sukses')]");
    }

    private By profileHeader() {
        return By.xpath("//h1[contains(text(),'Profil')]");
    }

    // ========== SELECTOR UBAH EMAIL ==========
    private By changeEmailMenu() {
        return By.xpath("/html/body/div[2]/div[2]/div[1]/div/div[2]/ul/li[4]/div/a[2]");
    }

    private By emailField() {
        return By.name("new_email");
    }

    private By saveButtonChangeEmail() {
        return By.cssSelector(".card-footer button[type='submit']");
    }
    private By otpHeader() {
        return By.xpath("/html/body/div[2]/div[2]/div[3]");
    }

    public void clickVerifyButton() {
        $(By.cssSelector(".card-footer button.btn.btn-primary")).waitUntilClickable().click();
    }
    private By successAlertChangeEmail() {
        return By.xpath("//div[contains(text(),'Berhasil') or contains(text(),'Email berhasil') or contains(text(),'sukses')]");
    }
    // ========== SELECTOR UBAH PASSWORD ==========
    private By ubahKataSandiMenu() {
        return By.xpath("/html/body/div[2]/div[2]/div[1]/div/div[2]/ul/li[4]/div/a[3]");
    }

    private By emailActiveField() {
        return By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div/div/form/div[1]/div[2]/div/div[2]/input");
    }

    private By kirimButton() {
        return By.cssSelector(".card-footer button.btn.btn-primary.waves-effect.waves-light");
    }

    private By otpFieldPassword() {
        return By.name("otp");
    }

    private By verifyButtonPassword() {
        return By.cssSelector(".card-footer button.btn-primary");
    }

    private By successAlertPassword() {
        return By.xpath("//div[contains(text(),'Kata sandi berhasil') or contains(text(),'Password updated') or contains(text(),'berhasil')]");
    }


    // ========== STEPS ==========
    @Step("Click profile icon")
    public void clickProfileIcon() {
        $(profileIcon()).waitUntilVisible().waitUntilClickable().click();
    }

    @Step("Click Profil menu")
    public void clickProfileMenu() {
        $(profileMenu()).waitUntilVisible().waitUntilClickable().click();
    }

    @Step("Validate on profile page")
    public void validateOnProfilePage() {
        $(profileHeader()).waitUntilVisible();
        Assert.assertTrue("Profile page header is not visible", $(profileHeader()).isDisplayed());
    }

    @Step("Input random name")
    public void inputRandomName() {
        String randomName = "Riskaya_" + (System.currentTimeMillis() % 10000);
        $(nameField()).waitUntilVisible().clear();
        $(nameField()).type(randomName);
        System.out.println("Nama baru: " + randomName);
    }

    @Step("Click Save button")
    public void clickSaveButton() {
        $(saveButton()).waitUntilVisible().waitUntilClickable().click();
    }

    @Step("Validate success message")
    public void validateSuccessMessage() {
        $(successAlert()).waitUntilVisible();
        String txt = $(successAlert()).getText().toLowerCase();
        Assert.assertTrue(
                "Success message didn't contain expected words. Actual: " + txt,
                txt.contains("berhasil") || txt.contains("sukses") || txt.contains("disimpan")
        );
    }

    // ====== EMAIL CHANGE STEPS ======
    @Step("Click Ubah Email menu")
    public void clickUbahEmailMenu() {
        $(changeEmailMenu()).waitUntilVisible().waitUntilClickable().click();
    }

    @Step("Change email to {0}")
    public void changeEmailTo(String newEmail) {
        $(emailField()).waitUntilVisible().clear();
        $(emailField()).type(newEmail);
        System.out.println("Email baru: " + newEmail);
    }

    public void clickSaveButtonChangeEmail() {
        waitABit(1000);
        $(saveButtonChangeEmail()).waitUntilVisible().waitUntilClickable().click();
    }
    @Step("Validate on OTP verification page")
    public void validateOnOtpPage() {
        $(otpHeader()).waitUntilVisible();
        Assert.assertTrue("OTP page not visible", $(otpHeader()).isDisplayed());
    }

    @Step("Validate success message after email change")
    public void validateSuccessMessageAfterEmailChange() {
        $(successAlertChangeEmail()).waitUntilVisible();
        String txt = $(successAlertChangeEmail()).getText().toLowerCase();
        Assert.assertTrue(
                "Email change success message not found. Actual: " + txt,
                txt.contains("berhasil") || txt.contains("sukses") || txt.contains("disimpan")
        );
    }
    // ====== PASSWORD CHANGE STEPS ======
    @Step("Click Ubah Kata Sandi menu")
    public void clickUbahKataSandiMenu() {
        $(ubahKataSandiMenu()).waitUntilVisible().waitUntilClickable().click();
    }

    @Step("Verify on Ubah Kata Sandi page")
    public void verifyOnUbahKataSandiPage() {
        $(emailActiveField()).waitUntilVisible();
        Assert.assertTrue("Email field not visible!", $(emailActiveField()).isDisplayed());
    }

    @Step("Verify email field is active and prefilled")
    public void verifyEmailFieldActiveAndPrefilled() {
        Assert.assertTrue("Email field is not active!", $(emailActiveField()).isEnabled());
        String emailValue = $(emailActiveField()).getValue();
        Assert.assertFalse("Email field is empty!", emailValue.isEmpty());
    }

    @Step("Click Kirim button")
    public void clickKirimButton() {
        $(kirimButton()).waitUntilVisible().waitUntilClickable().click();
    }

    @Step("Verify redirected to OTP verification page for new password")
    public void verifyOnOTPPagePassword() {
        $(otpFieldPassword()).waitUntilVisible();
        Assert.assertTrue("OTP field is not visible!", $(otpFieldPassword()).isDisplayed());
    }

    @Step("Input OTP code manually: {0}")
    public void inputOTPCodeManually(String otp) {
        $(otpFieldPassword()).type(otp);
    }

    @Step("Click verification button of new password")
    public void clickVerificationButtonOfNewPassword() {
        $(verifyButtonPassword()).waitUntilVisible().waitUntilClickable().click();
    }

    @Step("Validate success message after password update")
    public void validateSuccessMessageAfterPasswordUpdate() {
        $(successAlertPassword()).waitUntilVisible();
        String txt = $(successAlertPassword()).getText().toLowerCase();
        Assert.assertTrue("Password update success message not found: " + txt,
                txt.contains("berhasil") || txt.contains("sukses"));
    }
}



