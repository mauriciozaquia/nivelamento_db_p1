package PageObjects;

import Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MovementPage {
    private WebDriver driver;
    private Waits waits;

    public MovementPage(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public WebElement getTipoDaMovimentacaoSelect() {
        return waits.visibilityOfElement(By.id("tipo"));
    }
    public void selectTipoDaMovimentacao(String tipo) {
        getTipoDaMovimentacaoSelect().click();
        List<WebElement> list = driver.findElements(By.cssSelector("#tipo option"));
        for (WebElement element : list) {
            if (element.getText().equals(tipo)) {
                element.click();
            }
        }
    }

    public WebElement getDataMovimentacaoInput() {
        return waits.visibilityOfElement(By.id("data_transacao"));
    }

    public WebElement getDataDoPagamentoInput() {
        return waits.visibilityOfElement(By.id("data_pagamento"));
    }

    public WebElement getDescricaoInput() {
        return waits.visibilityOfElement(By.id("descricao"));
    }

    public WebElement getInteressadoInput() {
        return waits.visibilityOfElement(By.id("interessado"));
    }

    public WebElement getValorInput() {
        return waits.visibilityOfElement(By.id("valor"));
    }

    public WebElement getContaSelect() {
        return waits.visibilityOfElement(By.id("conta"));
    }

    public void selectConta(String conta) {
        getContaSelect().click();
        List<WebElement> list = driver.findElements(By.cssSelector("#conta option"));
        for (WebElement element : list) {
            if (element.getText().equals(conta)) {
                element.click();
            }
        }
    }

    public WebElement getSituacaoPagoRadio() {
        return waits.visibilityOfElement(By.id("status_pago"));
    }

    public WebElement getSituacaoPendenteRadio() {
        return waits.visibilityOfElement(By.id("status_pendente"));
    }

    public WebElement getSalvarButton() {
        return driver.findElement(By.cssSelector("button[type='submit']"));
    }
}
