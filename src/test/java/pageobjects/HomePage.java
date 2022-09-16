package pageobjects;

import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {

    private WebDriver driver;
    private Waits waits;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement getSaldoTable() {
        return driver.findElement(By.id("tabelaSaldo"));
    }

    public WebElement criarMovimentacaoButton() {
        return  driver.findElement(By.cssSelector(".nav.navbar-nav li:nth-child(3)"));
    }

    public List<WebElement> getAllFieldsValorTable(){
        List<WebElement> list = driver.findElements(By.cssSelector("#tabelaSaldo tbody tr td:nth-child(2)"));
        return list;
    }
}
