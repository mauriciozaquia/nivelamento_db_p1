package testcases;

import Framework.Report.Report;
import Framework.Report.ReportType;
import Framework.Report.Screenshot;
import Framework.TestBase;
import Framework.Utils.DateTime;
import Framework.Utils.FakersGeneration;
import Framework.Utils.PropertiesSaver;
import Model.Movement;
import Model.User;
import jdk.jfr.Description;
import models.MovementType;
import models.MovementSituation;
import org.junit.jupiter.api.Tag;
import tasks.*;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class RegisterMovementTest extends TestBase {
    private WebDriver driver = this.getDriver();
    LoginTask login = new LoginTask(driver);
    RegisterTask register = new RegisterTask(driver);
    HomeTask home = new HomeTask(driver);
    MovementTask movement = new MovementTask(driver);
    AccountTask addAccount = new AccountTask(driver);
    MontlySummaryTask montlySummary = new MontlySummaryTask(driver);
    FakersGeneration fakers = new FakersGeneration(this.driver);
    private Movement movementReceita;
    private Movement movementDespesa;
    private User user;

    @BeforeEach
    public void initialSetting() throws IOException {
        movementReceita = new Movement();
        movementReceita.setTipoDaMovimentacao(MovementType.RECEITA.toString());
        movementReceita.setDataDaMovimentacao(DateTime.getActuaDateTime());
        movementReceita.setDataDoPagamento(DateTime.getActuaDateTime());
        movementReceita.setDescricao(fakers.getCreditCardNumber());
        movementReceita.setInteressado(fakers.getArtist());
        //movementReceita.setValor(fakers.getValue());
        movementReceita.setValor(5.0);
        movementReceita.setConta(MovementType.RECEITA.toString());
        movementReceita.setSituacao(MovementSituation.PAGO.toString());

        movementDespesa = new Movement();
        movementDespesa.setTipoDaMovimentacao(MovementType.DESPESA.toString());
        movementDespesa.setDataDaMovimentacao(DateTime.getActuaDateTime());
        movementDespesa.setDataDoPagamento(DateTime.getActuaDateTime());
        movementDespesa.setDescricao(fakers.getCreditCardNumber());
        movementDespesa.setInteressado(fakers.getArtist());
        //movementDespesa.setValor(fakers.getValue());
        movementDespesa.setValor(10.0);
        movementDespesa.setConta(MovementType.DESPESA.toString());
        movementDespesa.setSituacao(MovementSituation.PAGO.toString());

        PropertiesSaver.zeraSaldo();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/CSV/login.csv", numLinesToSkip = 1)
    @Tag("Regressao")
    @Description("Validar inserir movimentações com sucesso - Email Fixo")
    public void validateRealizeMovement(String nome, String email, String password) {
        try {
            user = new User();
            user.setNome(nome);
            user.setLogin(email);
            user.setPassword(password);

            Report.creatTest("Realizar registro de movimentação - Email Fixo", ReportType.GROUP);
            Report.createStep("Realizar cadastro com sucesso");
            login.selectNewUser();
            register.registerUser(user);
            Report.createStep("Realizar login com sucesso");
            login.signin(user);
            Report.createStep("Cadastrar contas com sucesso");
            home.selectCreateAccount();
            addAccount.add("Receita");
            home.selectCreateAccount();
            addAccount.add("Despesa");
            Report.createStep("Realizar movimentação com sucesso");
            home.selectMonthlySummary();
            montlySummary.cleanMovimentation(DateTime.getActuaDateTime());
            home.selectCreateMovimentation();
            movement.add(movementReceita);
            home.selectMonthlySummary();
            montlySummary.searchMovimentation(movementReceita);
            home.selectCreateMovimentation();
            movement.add(movementDespesa);
            home.selectMonthlySummary();
            montlySummary.searchMovimentation(movementDespesa);
            Report.createStep("Validar saldo com sucesso");
            montlySummary.balance(DateTime.getActuaDateTime());
        } catch (Exception e) {
            Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
        }
    }

}
