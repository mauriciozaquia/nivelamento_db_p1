package pageobjects;

import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GenericPage {

    private WebDriver driver;
    private Waits waits;

    public GenericPage(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement getHomeLabelText() {
        return driver.findElement(By.cssSelector(".navbar .navbar-header a"));
    }

}
