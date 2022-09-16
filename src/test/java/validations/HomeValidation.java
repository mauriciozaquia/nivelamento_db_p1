package validations;

import Framework.Browser.Waits;
import Framework.Report.Report;
import Framework.Report.Screenshot;
import Framework.Utils.FilesOperation;
import org.openqa.selenium.WebElement;
import pageobjects.HomePage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.List;

public class HomeValidation {

    private WebDriver driver;
    private Waits waits;
    private HomePage homePage;


    public HomeValidation(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(this.driver);
        homePage = new HomePage(this.driver);
    }

    public void validationHomePage() {
        try {
            waits.loadElement(homePage.getSaldoTable());
            Assertions.assertTrue(homePage.getSaldoTable().isDisplayed());
            Report.log(Status.PASS, "Acessou a pagina Home com sucesso", Screenshot.captureBase64(driver));
        } catch (Error | Exception e) {
            Report.log(Status.FAIL, "Problema ao acessar a pagina Home" + e.getMessage(), Screenshot.captureBase64(driver));
        }
    }

    public void validateBalance() throws IOException {
        Double somaTela = 0.0;
        List<WebElement> itens = homePage.getAllFieldsValorTable();
        for (WebElement element : itens) {
            somaTela  = somaTela  + Double.parseDouble(element.getText());
        }
        Double somaProperties = Double.parseDouble(FilesOperation.getProperties("balance").getProperty("balance"));
        try{
            double finalSomaTela = somaTela;
            Assertions.assertEquals(finalSomaTela, somaProperties);
            Report.log(Status.PASS, "Saldo inserido nas movimentações: " + somaProperties +  " Saldo na tela: " + somaTela + " são iguais!", Screenshot.captureBase64(driver));
        } catch (Error | Exception e) {
            Report.log(Status.FAIL, "Problema ao validar saldo, saldo diferente! " + e.getMessage(), Screenshot.captureBase64(driver));
        }
    }
}
