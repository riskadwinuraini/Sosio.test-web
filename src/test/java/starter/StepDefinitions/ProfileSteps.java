package starter.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Sosio.Profile;

public class ProfileSteps {

    @Steps
    Profile profile;

    @When("I click the profile icon")
    public void iClickTheProfileIcon() {
        profile.clickProfileIcon();
    }

    @And("I click the Profil menu")
    public void iClickTheProfilMenu() {
        profile.clickProfileMenu();
    }

    @And("I validate that I am on the profile page")
    public void iValidateThatIAmOnTheProfilePage() {
        profile.validateOnProfilePage();
    }

    @And("I change the name to random")
    public void iChangeTheNameToRandom() {
        profile.inputRandomName();
    }

    @And("I click the save button")
    public void iClickTheSaveButton() {
        profile.clickSaveButton();
    }

    @Then("I can see a success message")
    public void iCanSeeASuccessMessage() {
        profile.validateSuccessMessage();
    }

    // ===== EMAIL =====
    @And("I click the ubah email menu")
    public void iClickTheUbahEmailMenu() {
        profile.clickUbahEmailMenu();
    }

    @And("I change the email to {string}")
    public void iChangeTheEmailTo(String newEmail) {
        profile.changeEmailTo(newEmail);
    }

    @And("I click the send button")
    public void iClickTheSendButton() {
        profile.clickSaveButtonChangeEmail();
    }

    @Then("I am redirected to the OTP verification page")
    public void iAmRedirectedToOtpPage() {
        profile.validateOnOtpPage();
    }

    @When("I input the OTP code manually")
    public void iInputTheOtpCodeManually() throws Exception {
        System.out.println("Silakan masukkan OTP secara manual di halaman web dalam waktu 60 detik...");
        Thread.sleep(60000); // waktu tunggu 60 detik (bisa kamu ubah sesuai kebutuhan)
    }

    @And("I click the verify button")
    public void iClickTheVerifyButton() {
        profile.clickVerifyButton();
    }

    @Then("I can see a success message after updating email")
    public void iCanSeeASuccessMessageAfterUpdatingEmail() {
        profile.validateSuccessMessageAfterEmailChange();
    }

    // ===== PASSWORD =====

    @And("I click the Ubah Kata Sandi menu")
    public void iClickTheUbahKataSandiMenu() {
        profile.clickUbahKataSandiMenu();
        profile.verifyOnUbahKataSandiPage();
        profile.verifyEmailFieldActiveAndPrefilled();
    }

    @When("I click the Kirim button")
    public void iClickTheKirimButton() {
        profile.clickKirimButton();
    }

    @Then("I am redirected to the OTP verification page of new password")
    public void iAmRedirectedToTheOTPVerificationPageOfNewPassword() {
        profile.verifyOnOTPPagePassword();
    }

    @When("I add the OTP code manually")
    public void iAddTheOTPCodeManually() {
        // Masukkan OTP manual, bisa dummy
        profile.inputOTPCodeManually("123456");
    }

    @And("I click verification button of new password")
    public void iClickVerificationButtonOfNewPassword() {
        profile.clickVerificationButtonOfNewPassword();
        profile.validateSuccessMessageAfterPasswordUpdate();
    }

}
