package starter.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import starter.Sosio.Login;
import starter.Sosio.Logout;
import starter.Sosio.Dashboard;

public class LogoutSteps {

    @Steps
    Login login;

    @Steps
    Dashboard dashboard;

    @Steps
    Logout logout;

    @Given("I am already logged in and on the dashboard page")
    public void iAmAlreadyLoggedInAndOnTheDashboardPage() {
        login.openUrl("https://demo.sosioapps.co.id/");
        login.inputEmail("riska.dnuraini@solusimakmur.com");
        login.inputPassword("Sosio@123");
        login.clickLoginButton();
        dashboard.validateOnTheHomePage();
    }

    @When("I click on the profile icon")
    public void iClickOnTheProfileIcon() {
        logout.clickProfileIcon();
    }

    @And("I select the {string} menu")
    public void iSelectTheMenu(String menuName) {
        if (menuName.equalsIgnoreCase("Keluar")) {
            logout.clickLogoutMenu();
        }
        // bisa ditambah else if untuk menu lain nanti (Akun, Ubah Email, Ubah Kata Sandi)
    }

    @Then("I am redirected to the login page")
    public void iAmRedirectedToTheLoginPage() {
        logout.validateRedirectedToLoginPage();
    }
}
