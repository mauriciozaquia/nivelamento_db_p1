package pageobjects;

import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MontlySummaryPage {
    private WebDriver driver;
    private Waits waits;

    public MontlySummaryPage(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement getMesSelect() {
        return driver.findElement(By.id("mes"));
    }

    public WebElement getAnoSelect() {
        return driver.findElement(By.id("ano"));
    }

    public WebElement getBuscarButton() {
        return waits.visibilityOfElement(By.cssSelector(".btn.btn-primary"));
    }

    public void selectMes(String month) {
        //new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mes option"))).click();
        getMesSelect().click();
        //List<WebElement> myList = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#mes option")));
        List<WebElement> myList = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='mes']/*[@value='" + month + "']")));
        for (WebElement element : myList) {
            if (element.getText().equals(month)) {
                element.click();
            }
        }
    }

    public void selectYear(String year) {
        getAnoSelect().click();
        //List<WebElement> myList = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#ano option")));
        List<WebElement> myList = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='ano']/*[@value='" + year + "']")));
        for (WebElement element : myList) {
            if (element.getText().equals(year)) {
                element.click();
            }
        }
    }

    public WebElement getRemoveIcon() {
        return waits.visibilityOfElement(By.cssSelector(".glyphicon-remove-circle"));
    }

    public void cleanTableMovement(){
        List<WebElement> list = driver.findElements(By.cssSelector("#tabelaExtrato tbody tr"));
        for (WebElement element : list) {
            getRemoveIcon().click();
        }
    }

    public WebElement getFieldContaTable(String texto){
        List<WebElement> list = driver.findElements(By.cssSelector("#tabelaExtrato tbody tr td:nth-child(3)"));
        for (WebElement element : list) {
            if(element.getText().equals(texto)){
                return element;
            }
        }
        return null;
    }
    public WebElement getFieldValorTable(String texto){
        List<WebElement> list = driver.findElements(By.cssSelector("#tabelaExtrato tbody tr td:nth-child(4)"));
        for (WebElement element : list) {
            if(element.getText().contains(texto)){
                return element;
            }
        }
        return null;
    }

    public List<WebElement> getAllFieldsValorTable(){
        List<WebElement> list = driver.findElements(By.cssSelector("#tabelaExtrato tbody tr td:nth-child(4)"));
        return list;
    }
}
