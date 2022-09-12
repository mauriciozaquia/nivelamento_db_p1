package validations;

import Framework.Browser.Waits;
import Framework.Report.Report;
import Framework.Report.Screenshot;
import pageobjects.AddAccountPage;
import pageobjects.WidgetAlert;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class AddAccountValidation {


    private WebDriver driver;
    private AddAccountPage addAccountPage;
    private Waits waits;
    private WidgetAlert widgetAlert;
    public AddAccountValidation(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(this.driver);
        addAccountPage = new AddAccountPage(this.driver);
        widgetAlert = new WidgetAlert(driver);
    }

    public void validationRedirectPageHome() {
        try {
            waits.loadElement(addAccountPage.getNomeInput());
            Assertions.assertTrue(addAccountPage.getNomeInput().isDisplayed());
            Report.log(Status.PASS, " Acessou a pagina Adicionar Conta com sucesso", Screenshot.captureBase64(driver));
        } catch (Exception e) {
            Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
        }
    }

    public void validationRegisterAddAccountSucess() {
        try {
            waits.loadElement(widgetAlert.getAlert());
            String alert = widgetAlert.getAlert().getText();
            Assertions.assertEquals(alert, "Conta adicionada com sucesso!");
            Report.log(Status.PASS, "Cadastrou a conta com sucesso", Screenshot.captureBase64(driver));
        } catch (Exception e) {
            Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
        }
    }

    public void validationRegisterAddAccountDuplicate() {
        try {
            waits.loadElement(widgetAlert.getAlert());
            String alert = widgetAlert.getAlert().getText();
            Assertions.assertEquals(alert, "Já existe uma conta com esse nome!");
            Report.log(Status.PASS, "Verificou que já existe uma conta com esse nome inserida!", Screenshot.captureBase64(driver));
        } catch (Exception e) {
            Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
        }
    }
}
