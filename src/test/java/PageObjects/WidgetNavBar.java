package PageObjects;

import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WidgetNavBar {
    private WebDriver driver;
    private Waits waits;

    public WidgetNavBar(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement getHomeLabelText() {
        return driver.findElement(By.cssSelector(".navbar .navbar-header a"));
    }

    public WebElement getNavBarItemPorTexto(String texto) {
        return waits.visibilityOfElement(By.xpath("//a[contains(text(),'" + texto + "')]"));
    }

    public WebElement getNavBarSubItemPorTexto(String texto) {
        return waits.visibilityOfElement(By.cssSelector(".dropdown-menu a[href='" + texto + "']"));
    }
}
