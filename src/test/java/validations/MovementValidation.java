package validations;

import Framework.Browser.Waits;
import Framework.Report.Report;
import Framework.Report.Screenshot;
import pageobjects.MovementPage;
import pageobjects.WidgetAlert;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class MovementValidation {
    private WebDriver driver;
    private MovementPage movementPage;
    private Waits waits;
    private WidgetAlert widgetAlert;

    public MovementValidation(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(this.driver);
        movementPage = new MovementPage(this.driver);
        widgetAlert = new WidgetAlert(driver);
    }

    public void validationRedirectMovementPage() {
        try {
            waits.loadElement(movementPage.getContaSelect());
            Assertions.assertTrue(movementPage.getContaSelect().isDisplayed());
            Report.log(Status.PASS, "Acessou a pagina Adicionar Movimento com sucesso", Screenshot.captureBase64(driver));
        } catch (Exception e) {
            Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
        }
    }

    public void validationMovementSucess() {
        try {
            waits.loadElement(widgetAlert.getAlert());
            String alert = widgetAlert.getAlert().getText();
            Assertions.assertEquals("Movimentação adicionada com sucesso!", alert);
            Report.log(Status.PASS, "Inseriu o movimento com sucesso", Screenshot.captureBase64(driver));
        } catch (Exception e) {
            Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
        }
    }

    public void validationFields() {
        try {
            Assertions.assertFalse(movementPage.getDataMovimentacaoInput().getAttribute("value").equalsIgnoreCase(" "));
            Assertions.assertFalse(movementPage.getDataDoPagamentoInput().getAttribute("value").equalsIgnoreCase(" "));
            Assertions.assertFalse(movementPage.getDescricaoInput().getAttribute("value").equalsIgnoreCase(" "));
            Assertions.assertFalse(movementPage.getInteressadoInput().getAttribute("value").equalsIgnoreCase(" "));
            Assertions.assertFalse(movementPage.getValorInput().getAttribute("value").equalsIgnoreCase(" "));
            Report.log(Status.PASS, "Dados do form preenchidos corretamente!", Screenshot.captureBase64(this.driver));
        } catch (Error | Exception e) {
            Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(this.driver));
        }

    }
}
