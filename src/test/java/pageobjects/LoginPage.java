package pageobjects;

import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    private Waits waits;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement getLoginInput() {
        return waits.visibilityOfElement(By.id("email"));
    }

    public WebElement getPasswordInput() {
        return waits.visibilityOfElement(By.id("senha"));
    }

    public WebElement getLoginButton() {
        return waits.visibilityOfElement(By.cssSelector(".btn.btn-primary"));
    }

    public WebElement getLoginNavBarButton() {
        return waits.visibilityOfElement(By.cssSelector(".navbar li:nth-child(1) a"));
    }

    public WebElement getNewUserNavBarButton() {
        return waits.visibilityOfElement(By.cssSelector(".navbar li:nth-child(2) a"));
    }
}
