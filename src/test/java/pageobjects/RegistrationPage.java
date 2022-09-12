package pageobjects;

import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {

    private WebDriver driver;
    private Waits waits;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement getNameInput() {
        return waits.visibilityOfElement(By.id("nome"));
    }

    public WebElement getLoginInput() {
        return waits.visibilityOfElement(By.id("email"));
    }

    public WebElement getPasswordInput() {
        return waits.visibilityOfElement(By.id("senha"));
    }

    public WebElement getRegisterButton() {
        return waits.visibilityOfElement(By.cssSelector(".btn.btn-primary"));
    }
}
