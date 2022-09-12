package Tasks;

import Model.Movement;
import PageObjects.HomePage;
import PageObjects.MontlySummaryPage;
import PageObjects.WidgetNavBar;
import Validations.AddAccountValidation;
import Validations.MontlySummaryValidation;
import Validations.MovementValidation;
import org.openqa.selenium.WebDriver;

public class MontlySummaryTask {
    private WebDriver driver;
    private MontlySummaryPage montlySummaryPage;
    private MontlySummaryValidation montlySummaryValidation;
    public MontlySummaryTask(WebDriver driver) {
        this.driver = driver;
        montlySummaryPage = new MontlySummaryPage(this.driver);
        montlySummaryValidation = new MontlySummaryValidation(this.driver);
    }

    public void searchMovimentation(Movement m) {
        montlySummaryPage.selectMes("Setembro");
        montlySummaryPage.selectYear("2022");
        montlySummaryPage.getBuscarButton().click();
        if(m.getTipoDaMovimentacao().equals("Despesa")){
            montlySummaryValidation.validationBalanceDespesa(m);
        } else {
            montlySummaryValidation.validationBalanceReceita(m);
        }

    }

    public void cleanMovimentation(){
        montlySummaryPage.selectMes("Setembro");
        montlySummaryPage.selectYear("2022");
        montlySummaryPage.cleanTableMovement();
    }
}
