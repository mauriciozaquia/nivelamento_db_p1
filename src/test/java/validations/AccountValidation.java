package validations;

import Framework.Browser.Waits;
import Framework.Report.Report;
import Framework.Report.Screenshot;
import pageobjects.AccountPage;
import pageobjects.WidgetAlert;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class AccountValidation {


    private WebDriver driver;
    private AccountPage accountPage;
    private Waits waits;
    private WidgetAlert widgetAlert;
    public AccountValidation(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(this.driver);
        accountPage = new AccountPage(this.driver);
        widgetAlert = new WidgetAlert(driver);
    }

    public void validationRedirectPageHome() {
        try {
            waits.loadElement(accountPage.getNomeInput());
            Assertions.assertTrue(accountPage.getNomeInput().isDisplayed());
            Report.log(Status.PASS, " Acessou a pagina Adicionar Conta com sucesso", Screenshot.captureBase64(driver));
        } catch (Error | Exception e) {
            Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
        }
    }

    public void validationRegisterAddAccountSucess() {
        try {
            waits.loadElement(widgetAlert.getAlert());
            String alert = widgetAlert.getAlert().getText();
            Assertions.assertEquals(alert, "Conta adicionada com sucesso!");
            Report.log(Status.PASS, "Cadastrou a conta com sucesso", Screenshot.captureBase64(driver));
        } catch (Error | Exception e) {
            Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
        }
    }

    public void validationRegisterAddAccountDuplicate() {
        try {
            waits.loadElement(widgetAlert.getAlert());
            String alert = widgetAlert.getAlert().getText();
            Assertions.assertEquals(alert, "Já existe uma conta com esse nome!");
            Report.log(Status.PASS, "Verificou que já existe uma conta com esse nome inserida!", Screenshot.captureBase64(driver));
        } catch (Error | Exception e) {
            Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
        }
    }

    public void validationFields() {
        try {
            Assertions.assertFalse(accountPage.getNomeInput().getAttribute("value").equalsIgnoreCase(" "));
            Report.log(Status.PASS, "Dados do form preenchidos corretamente!", Screenshot.captureBase64(this.driver));
        } catch (Error | Exception e) {
            Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(this.driver));
        }
    }
}
