package starter.Sosio;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class Dashboard extends PageObject {
    private By dashboardTitle(){
        return By.xpath("(//div[@class='container-fluid'])[2]");
    }
    @Step
    public void validateOnTheHomePage(){
        $(dashboardTitle()).isDisplayed();
    }
}
