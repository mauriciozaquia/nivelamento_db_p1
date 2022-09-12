package tasks;

import pageobjects.AddAccountPage;
import pageobjects.WidgetAlert;
import validations.AddAccountValidation;
import org.openqa.selenium.WebDriver;

public class AddAccountTask {
    private WebDriver driver;
    private AddAccountPage addAccountPage;
    private AddAccountValidation addAccountValidation;
    private WidgetAlert widgetAlert;
    public AddAccountTask(WebDriver driver) {
        this.driver = driver;
        addAccountPage = new AddAccountPage(this.driver);
        addAccountValidation = new AddAccountValidation(this.driver);
        widgetAlert = new WidgetAlert((this.driver));
    }

    public void fillData(String conta) {
        addAccountPage.getNomeInput().sendKeys(conta);
    }

    public void save() {
        addAccountPage.getSalvarButton().click();
        if(widgetAlert.getAlert().getText().equals("Já existe uma conta com esse nome!")){
            addAccountValidation.validationRegisterAddAccountDuplicate();
        } else {
            addAccountValidation.validationRegisterAddAccountSucess();
        }
    }
}
