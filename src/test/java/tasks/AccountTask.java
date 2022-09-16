package tasks;

import pageobjects.AccountPage;
import pageobjects.WidgetAlert;
import validations.AccountValidation;
import org.openqa.selenium.WebDriver;

public class AccountTask {
    private WebDriver driver;
    private AccountPage accountPage;
    private validations.AccountValidation accountValidation;
    private WidgetAlert widgetAlert;
    public AccountTask(WebDriver driver) {
        this.driver = driver;
        accountPage = new AccountPage(this.driver);
        accountValidation = new AccountValidation(this.driver);
        widgetAlert = new WidgetAlert((this.driver));
    }

    public void add(String conta) {
        accountPage.getNomeInput().sendKeys(conta);
        accountValidation.validationFields();
        accountPage.getSalvarButton().click();
        if(widgetAlert.getAlert().getText().equals("Já existe uma conta com esse nome!")){
            accountValidation.validationRegisterAddAccountDuplicate();
        } else {
            accountValidation.validationRegisterAddAccountSucess();
        }
    }
}
