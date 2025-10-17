package starter.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.Sosio.Dashboard;
import starter.Sosio.Login;

public class AuthSteps {
    @Steps
    Login login;
    @Steps
    Dashboard dashboard;

    @Given("I am on the login pages")
    public void iAmOnTheLoginPages() {
        login.openUrl("https://demo.sosioapps.co.id/");
        login.validateOnLoginPage();
    }

    @When("I enter Email {string}")
    public void iEnterEmail(String email) { login.inputEmail(email);

    }

    @And("I enter Password {string}")
    public void iEnterPassword(String password) { login.inputPassword(password);

    }

    @And("I click Login button")
    public void iClickLoginButton() { login.clickLoginButton();

    }
    @Then("I am on the dashboard page")
    public void iAmOnTheDashboardPage() { dashboard.openUrl("https://demo.sosioapps.co.id/dashboard");
    }

    @Then("I can see error message {string}")
    public void iCanSeeErrorMessage(String expectedMessage) { login.validateErrorMessage(expectedMessage); }
    @Then("the system should display a warning message")
    public void theSystemShouldDisplayAWarningMessage() {

    }

}
