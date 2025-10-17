package starter.Sosio;

import net.serenitybdd.screenplay.actions.OpenUrl;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class Login extends PageObject {
    private By emailField(){
        return By.xpath("//input[@type='email']");
    }
    private By passwordField(){
        return By.xpath("//input[@placeholder='Kata Sandi']");
    }
    private By loginButton(){
        return By.xpath("//button[normalize-space(text())='Masuk']");
    }
    private By errorMessage() { return By.xpath("//div[@role='alert']"); }


    @Step
    public static OpenUrl url(String targetUrl){
        return new OpenUrl(targetUrl);
    }
    @Step
    public void validateOnLoginPage(){
        $(loginButton()).isDisplayed();
    }
    @Step
    public void inputEmail(String email){
        $(emailField()).type(email);
    }
    @Step
    public void inputPassword(String password){
        $(passwordField()).type(password);
    }
    @Step
    public void clickLoginButton(){
        $(loginButton()).click();
    }
    @Step public void validateErrorMessage(String expectedMessage) {
        String actualMessage = $(errorMessage()).waitUntilVisible().getText(); assert actualMessage.contains(expectedMessage) : "Expected error message to contain: '" + expectedMessage + "', but got: '" + actualMessage + "'"; }


}
