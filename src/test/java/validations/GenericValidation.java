package validations;

import Framework.Browser.Waits;
import Framework.Report.Report;
import Framework.Report.Screenshot;
import pageobjects.GenericPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class GenericValidation {


    private WebDriver driver;
    private GenericPage genericPage;
    private Waits waits;

    public GenericValidation(WebDriver driver) {
        this.driver = driver;
        genericPage = new GenericPage(this.driver);
        waits = new Waits(this.driver);
    }

    public void validationPageHome() {
        try {
            waits.loadElement(genericPage.getHomeLabelText());
            String label = genericPage.getHomeLabelText().getText();
            Assertions.assertEquals(label, "Seu Barriga");
            Report.log(Status.PASS, " Acessou a pagina home com sucesso", Screenshot.captureBase64(driver));
        } catch (Error | Exception e) {
            Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
        }
    }

}
