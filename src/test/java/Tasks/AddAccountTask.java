package Tasks;

import PageObjects.AddAccountPage;
import PageObjects.HomePage;
import PageObjects.WidgetNavBar;
import Validations.AddAccountValidation;
import org.openqa.selenium.WebDriver;

public class AddAccountTask {
    private WebDriver driver;
    private AddAccountPage addAccountPage;
    private AddAccountValidation addAccountValidation;
    public AddAccountTask(WebDriver driver) {
        this.driver = driver;
        addAccountPage = new AddAccountPage(this.driver);
        addAccountValidation = new AddAccountValidation(this.driver);
    }

    public void preencherCampos(String conta) {
        addAccountPage.getNomeInput().sendKeys(conta);
    }

    public void salvarConta() {
        addAccountPage.getSalvarButton().click();
        addAccountValidation.validationRegisterAddAccountSucess();
    }
}
