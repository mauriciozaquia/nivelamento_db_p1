package tasks;

import pageobjects.HomePage;
import pageobjects.WidgetNavBar;
import validations.AccountValidation;
import validations.HomeValidation;
import validations.MontlySummaryValidation;
import validations.MovementValidation;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class HomeTask {
    private WebDriver driver;
    private HomePage homePage;
    private WidgetNavBar widgetNavBar;
    private AccountValidation accountValidation;
    private MovementValidation movementValidation;
    private MontlySummaryValidation montlySummaryValidation;
    private HomeValidation homeValidation;
    public HomeTask(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(this.driver);
        widgetNavBar = new WidgetNavBar(this.driver);
        accountValidation = new AccountValidation(this.driver);
        movementValidation = new MovementValidation(this.driver);
        montlySummaryValidation = new MontlySummaryValidation(this.driver);
        homeValidation = new HomeValidation(this.driver);
    }

    public void selectCreateMovimentation() {
        widgetNavBar.getNavBarItemPorTexto("Criar Movimentação").click();
        movementValidation.validationRedirectMovementPage();
    }

    public void selectCreateAccount() {
        widgetNavBar.getNavBarItemPorTexto("Contas").click();
        widgetNavBar.getNavBarSubItemPorTexto("/addConta").click();
        accountValidation.validationRedirectPageHome();
    }

    public void selectMonthlySummary() {
        widgetNavBar.getNavBarItemPorTexto("Resumo Mensal").click();
        montlySummaryValidation.validationRedirectPageMontlySummary();
    }

    public void balance() throws IOException {
        homeValidation.validateBalance();
    }

    public void selectHome() {
        widgetNavBar.getNavBarItemPorTexto("Home").click();
    }
}
