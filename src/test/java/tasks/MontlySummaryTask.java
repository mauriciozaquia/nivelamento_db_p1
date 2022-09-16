package tasks;

import Framework.Utils.DateTime;
import Model.Movement;
import pageobjects.MontlySummaryPage;
import validations.MontlySummaryValidation;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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
        SimpleDateFormat formatarDate = new SimpleDateFormat("MM");
        String mes = formatarDate.format(m.getDataDaMovimentacao());
        formatarDate = new SimpleDateFormat("yyyy");
        String year = formatarDate.format(m.getDataDaMovimentacao());
        montlySummaryPage.selectMes(mes);
        montlySummaryPage.selectYear(year);
        montlySummaryPage.getBuscarButton().click();
        if(m.getTipoDaMovimentacao().equals("Despesa")){
            montlySummaryValidation.validationBalanceDespesa(m);
        } else {
            montlySummaryValidation.validationBalanceReceita(m);
        }
    }

    public void cleanMovimentation(Date date){
        SimpleDateFormat formatarDate = new SimpleDateFormat("MM");
        String mes = formatarDate.format(date);
        formatarDate = new SimpleDateFormat("yyyy");
        String year = formatarDate.format(date);
        montlySummaryPage.selectMes(mes);
        montlySummaryPage.selectYear(year);
        montlySummaryPage.cleanTableMovement();
    }

    public void balance(Date date) throws IOException {
        SimpleDateFormat formatarDate = new SimpleDateFormat("MM");
        String mes = formatarDate.format(date);
        formatarDate = new SimpleDateFormat("yyyy");
        String year = formatarDate.format(date);
        montlySummaryPage.selectMes(mes);
        montlySummaryPage.selectYear(year);
        montlySummaryPage.getBuscarButton().click();
        montlySummaryValidation.validateBalance();
    }
}
