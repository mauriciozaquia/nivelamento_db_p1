package Tasks;

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
    }

    public void searchMovimentation() {
        montlySummaryPage.selectMes("Setembro");
        montlySummaryPage.selectYear("2022");
        montlySummaryPage.getBuscarButton().click();
        montlySummaryValidation.validationBalance();
    }

    public void cleanMovimentation(){
        montlySummaryPage.selectMes("Setembro");
        montlySummaryPage.selectYear("2022");
        montlySummaryPage.cleanTableMovement();
    }
}
