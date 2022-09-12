package Validations;

import Framework.Browser.Waits;
import Framework.Report.Report;
import Framework.Report.Screenshot;
import PageObjects.MontlySummaryPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class MontlySummaryValidation {


    private WebDriver driver;
    private Waits waits;
    private MontlySummaryPage montlySummaryPage;

    public MontlySummaryValidation(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(this.driver);
        montlySummaryPage = new MontlySummaryPage(this.driver);
    }

    public void validationRedirectPageMontlySummary() {
        try {
            waits.loadElement(montlySummaryPage.getBuscarButton());
            Assertions.assertTrue(montlySummaryPage.getBuscarButton().isDisplayed());
            Report.log(Status.PASS, "Acessou a pagina Adicionar Movimento com sucesso", Screenshot.captureBase64(driver));
        } catch (Exception e) {
            Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
        }
    }

    public void validationBalance() {
    //TODO fazer validação balanço
    }
}
