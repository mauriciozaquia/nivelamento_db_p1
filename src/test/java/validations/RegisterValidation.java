package validations;

import Framework.Browser.Waits;
import Framework.Report.Report;
import Framework.Report.Screenshot;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pageobjects.RegistrationPage;
import pageobjects.WidgetAlert;

public class RegisterValidation {
    private WebDriver driver;
    private Waits waits;
    private RegistrationPage registrationPage;
    private WidgetAlert widgetAlert;

    public RegisterValidation(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(this.driver);
        widgetAlert = new WidgetAlert(driver);
        registrationPage = new RegistrationPage(driver);
    }

    public void validationRedirectRegisterPage() {
        try {
            waits.loadElement(registrationPage.getLoginInput());
            Assertions.assertTrue(registrationPage.getLoginInput().isDisplayed());
            Report.log(Status.PASS, "Acessou a pagina Adicionar Usuário com sucesso", Screenshot.captureBase64(driver));
        } catch (Exception e) {
            Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
        }
    }
    public void validationRegisterSucess() {
        try {
            waits.loadElement(widgetAlert.getAlert());
            String alert = widgetAlert.getAlert().getText();
            Assertions.assertEquals("Usuário inserido com sucesso", alert);
            Report.log(Status.PASS, "Inseriu o usuário com sucesso!", Screenshot.captureBase64(driver));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
        }
    }

    public void validationRegisterExistingUserSucess() {
        try {
            waits.loadElement(widgetAlert.getAlert());
            String alert = widgetAlert.getAlert().getText();
            Assertions.assertEquals("Endereço de email já utilizado", alert);
            Report.log(Status.PASS, "Validou que o endereço de email já está sendo utilizado!", Screenshot.captureBase64(driver));
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
            Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
        }
    }

}
