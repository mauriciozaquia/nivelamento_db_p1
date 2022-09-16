package validations;

import Framework.Browser.Waits;
import Framework.Report.Report;
import Framework.Report.Screenshot;
import pageobjects.HomePage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class HomeValidation {

    private WebDriver driver;
    private Waits waits;
    private HomePage homePage;


    public HomeValidation(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(this.driver);
    }

    public void validationHomePage() {
        try {
            waits.loadElement(homePage.getSaldoTable());
            Assertions.assertTrue(homePage.getSaldoTable().isDisplayed());
            Report.log(Status.PASS, "Acessou a pagina home com sucesso", Screenshot.capture(driver));
        } catch (Error | Exception e) {
            Report.log(Status.FAIL, e.getMessage(), Screenshot.capture(driver));
        }
    }
}
