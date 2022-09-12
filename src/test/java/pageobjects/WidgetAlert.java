package pageobjects;

import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WidgetAlert {
    private WebDriver driver;
    private Waits waits;

    public WidgetAlert(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement getAlert() {
        return waits.visibilityOfElement(By.cssSelector(".alert"));
    }


}
