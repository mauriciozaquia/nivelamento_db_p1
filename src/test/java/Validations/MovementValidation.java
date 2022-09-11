package Validations;

import Framework.Browser.Waits;
import Framework.Report.Report;
import Framework.Report.Screenshot;
import PageObjects.AddAccountPage;
import PageObjects.MovementPage;
import PageObjects.WidgetAlert;
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
            waits.loadElement(movementPage.getContaInput());
            Assertions.assertTrue(movementPage.getContaInput().isDisplayed());
            Report.log(Status.PASS, " Acessou a pagina Adicionar Movimento com sucesso", Screenshot.captureBase64(driver));
        } catch (Exception e) {
            Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
        }
    }

    public void validationMovementSucess() {
        try {
            waits.loadElement(widgetAlert.getAlert());
            String alert = widgetAlert.getAlert().getText();
            Assertions.assertEquals(alert, "Movimento adicionado com sucesso!");
            Report.log(Status.PASS, "Inseriu o movimento com sucesso", Screenshot.captureBase64(driver));
        } catch (Exception e) {
            Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
        }
    }
}
