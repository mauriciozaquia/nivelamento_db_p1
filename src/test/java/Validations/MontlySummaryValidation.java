package Validations;

import Framework.Browser.JavaScriptExecutor;
import Framework.Browser.Waits;
import Framework.Report.Report;
import Framework.Report.Screenshot;
import Model.Movement;
import PageObjects.MontlySummaryPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.text.DecimalFormat;

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
                    //() -> Assertions.assertTrue(valorTela.contains(valorFormatado)),
                    () -> Assertions.assertEquals(valorFormatado, valorTela),
                    () -> Assertions.assertEquals(m.getConta(), montlySummaryPage.getCampoContaTable(m.getConta()).getText())
            );

            Report.log(Status.PASS, "Valor" + m.getValor() + " correspondente encontrado na lista - Conta do tipo " + m.getConta(), Screenshot.captureBase64(driver));
        } catch (Exception e) {
            Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
        }
    }
}
