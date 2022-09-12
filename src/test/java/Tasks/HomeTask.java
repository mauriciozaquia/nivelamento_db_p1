package Tasks;

import PageObjects.HomePage;
import PageObjects.WidgetNavBar;
import Validations.AddAccountValidation;
import Validations.MontlySummaryValidation;
import Validations.MovementValidation;
import org.openqa.selenium.WebDriver;

public class HomeTask {
    private WebDriver driver;
    private HomePage homePage;
    private WidgetNavBar widgetNavBar;
    private AddAccountValidation addAccountValidation;
    private MovementValidation movementValidation;
    private MontlySummaryValidation montlySummaryValidation;
    public HomeTask(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(this.driver);
        widgetNavBar = new WidgetNavBar(this.driver);
        addAccountValidation = new AddAccountValidation(this.driver);
        movementValidation = new MovementValidation(this.driver);
        montlySummaryValidation = new MontlySummaryValidation(this.driver);
    }

    public void selectCreateMovimentation() {
        widgetNavBar.getNavBarItemPorTexto("Criar Movimentação").click();
        movementValidation.validationRedirectMovementPage();
    }

    public void selectCreateAccount() {
        widgetNavBar.getNavBarItemPorTexto("Contas").click();
        widgetNavBar.getNavBarSubItemPorTexto("/addConta").click();
        addAccountValidation.validationRedirectPageHome();
    }

    public void selectMonthlySummary() {
        widgetNavBar.getNavBarItemPorTexto("Resumo Mensal").click();
        montlySummaryValidation.validationRedirectPageMontlySummary();
    }
}