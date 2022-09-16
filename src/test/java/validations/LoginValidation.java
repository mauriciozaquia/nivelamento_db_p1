package validations;

import Framework.Browser.Waits;
import Framework.Report.Report;
import Framework.Report.Screenshot;
import pageobjects.GenericPage;
import pageobjects.LoginPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class LoginValidation {
    private WebDriver driver;
    private LoginPage loginPage;
    private GenericPage genericPage;
    private Waits waits;

    public LoginValidation(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(this.driver);
        genericPage = new GenericPage(this.driver);
        waits = new Waits(this.driver);
    }

    public void validationLoginPage() {
        try {
            waits.loadElement(loginPage.getLoginInput());
            Assertions.assertTrue(loginPage.getLoginInput().isDisplayed());
            Report.log(Status.PASS, "Acessou a pagina de Login com sucesso", Screenshot.captureBase64(driver));
        } catch (Error | Exception e) {
            Report.log(Status.FAIL, "Problema ao acessar a pagina Login " + e.getMessage(), Screenshot.captureBase64(driver));
        }
    }

    public void validationFields() {
        try {
            Assertions.assertFalse(loginPage.getLoginInput().getAttribute("value").equalsIgnoreCase(" "));
            Assertions.assertFalse(loginPage.getPasswordInput().getAttribute("value").equalsIgnoreCase(" "));
            Report.log(Status.PASS, "Dados do form preenchidos corretamente!", Screenshot.captureBase64(this.driver));
        } catch (Error | Exception e) {
            Report.log(Status.FAIL, "Problema ao verificar os dados do form " + e.getMessage(), Screenshot.captureBase64(this.driver));
        }
    }
}
