package starter.Sosio;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.junit.Assert;

public class Logout extends PageObject {

    private By profileIcon() {
        return By.xpath("/html/body/div[2]/div[2]/div[1]/div/div[2]/ul/li[4]/a");
    }

    private By logoutMenu() {
        return By.xpath("/html/body/div[2]/div[2]/div[1]/div/div[2]/ul/li[4]/div/a[4]");
    }

    private By loginButton() {
        return By.xpath("//button[normalize-space(text())='Masuk']");
    }

    @Step("Click profile icon")
    public void clickProfileIcon() {
        $(profileIcon()).waitUntilClickable().click();
    }

    @Step("Click logout menu")
    public void clickLogoutMenu() {
        $(logoutMenu()).waitUntilClickable().click();
    }

    @Step("Validate user is redirected to the login page")
    public void validateRedirectedToLoginPage() {
        boolean isDisplayed = $(loginButton()).waitUntilVisible().isDisplayed();
        Assert.assertTrue("User is not redirected to the login page!", isDisplayed);
    }
}
