package validations;

import Framework.Browser.JavaScriptExecutor;
import Framework.Browser.Waits;
import Framework.Report.Report;
import Framework.Report.Screenshot;
import Framework.Utils.FilesOperation;
import Framework.Utils.PropertiesSaver;
import Model.Movement;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.WebElement;
import pageobjects.MontlySummaryPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Properties;

public class MontlySummaryValidation {


    private WebDriver driver;
    private Waits waits;
    private MontlySummaryPage montlySummaryPage;
    private JavaScriptExecutor js = new JavaScriptExecutor();

    public MontlySummaryValidation(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(this.driver);
        montlySummaryPage = new MontlySummaryPage(this.driver);
    }

    public void validationRedirectPageMontlySummary() {
        try {
            waits.loadElement(montlySummaryPage.getBuscarButton());
            Assertions.assertTrue(montlySummaryPage.getBuscarButton().isDisplayed());
            Report.log(Status.PASS, "Acessou a pagina Resumo Mensal com sucesso", Screenshot.captureBase64(driver));
        } catch (Exception e) {
            Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
        }
    }

    public void validationBalanceReceita(Movement m) {
        try{
            DecimalFormat df = new DecimalFormat("#,###.00");
            String valorFormatado = df.format(m.getValor()).replace(",", ".");
            String valorTela = montlySummaryPage.getCampoValorTable(valorFormatado).getText();

            js.highlight(this.driver, montlySummaryPage.getCampoContaTable(m.getConta()));
            js.highlight(this.driver, montlySummaryPage.getCampoValorTable(valorFormatado));

            Assertions.assertAll(
                    () -> Assertions.assertEquals(valorFormatado, valorTela),
                    () -> Assertions.assertEquals(m.getConta(), montlySummaryPage.getCampoContaTable(m.getConta()).getText())
            );

            Report.log(Status.PASS, "Valor" + m.getValor() + " correspondente encontrado na lista - Conta do tipo " + m.getConta(), Screenshot.captureBase64(driver));
        } catch (Exception e) {
            Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
        }
    }

    public void validationBalanceDespesa(Movement m) {
        try{
            DecimalFormat df = new DecimalFormat("-#,###.00");
            String valorFormatado = df.format(m.getValor()).replace(",", ".");
            String valorTela = montlySummaryPage.getCampoValorTable(valorFormatado).getText();

            js.highlight(this.driver, montlySummaryPage.getCampoContaTable(m.getConta()));
            js.highlight(this.driver, montlySummaryPage.getCampoValorTable(valorFormatado));

            Assertions.assertAll(
                    () -> Assertions.assertEquals(valorFormatado, valorTela),
                    () -> Assertions.assertEquals(m.getConta(), montlySummaryPage.getCampoContaTable(m.getConta()).getText())
            );

            Report.log(Status.PASS, "Valor " + m.getValor() + " correspondente encontrado na lista - Conta do tipo " + m.getConta(), Screenshot.captureBase64(driver));
        } catch (Error | Exception e) {
            Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
        }
    }

    public void validateBalance() throws IOException {
        Double somaTela = 0.0;
        List<WebElement> itens = montlySummaryPage.getAllFieldsValorTable();
        for (WebElement element : itens) {
            somaTela  = somaTela  + Double.parseDouble(element.getText());
        }
        Double somaProperties = Double.parseDouble(FilesOperation.getProperties("balance").getProperty("balance"));
        try{
            double finalSomaTela = somaTela;
            Assertions.assertEquals(finalSomaTela, somaProperties);
            Report.log(Status.PASS, "Saldo inserido nas movimentações: " + somaProperties +  " Saldo na tela: " + somaTela + " são iguais!");
        } catch (Error | Exception e) {
            Report.log(Status.FAIL, "Saldo diferente! " + e.getMessage(), Screenshot.captureBase64(driver));
        }

    }
}
