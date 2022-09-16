package pageobjects;

import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {
    private WebDriver driver;
    private Waits waits;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement getNomeInput() {
        return driver.findElement(By.id("nome"));
    }

    public WebElement getSalvarButton() {
        return driver.findElement(By.cssSelector("button[type='submit']"));
    }

}
