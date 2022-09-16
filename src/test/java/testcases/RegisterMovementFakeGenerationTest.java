package testcases;

import Framework.Report.Report;
import Framework.Report.ReportType;
import Framework.Report.Screenshot;
import Framework.TestBase;
import Framework.Utils.DateTime;
import Framework.Utils.FakersGeneration;
import Framework.Utils.Formatter;
import Framework.Utils.PropertiesSaver;
import Model.Movement;
import Model.User;
import com.aventstack.extentreports.Status;
import jdk.jfr.Description;
import models.MovementSituation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import tasks.*;
import models.MovementType;

import java.io.IOException;

public class RegisterMovementFakeGenerationTest extends TestBase {
    private WebDriver driver = this.getDriver();
    LoginTask login = new LoginTask(driver);
    RegisterTask register = new RegisterTask(driver);
    HomeTask home = new HomeTask(driver);
    MovementTask movement = new MovementTask(driver);
    AccountTask account = new AccountTask(driver);
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
        movementReceita.setValor(fakers.getValue());
        movementReceita.setConta(MovementType.RECEITA.toString());
        movementReceita.setSituacao(MovementSituation.PAGO.toString());

        movementDespesa = new Movement();
        movementDespesa.setTipoDaMovimentacao(MovementType.DESPESA.toString());
        movementDespesa.setDataDaMovimentacao(DateTime.getActuaDateTime());
        movementDespesa.setDataDoPagamento(DateTime.getActuaDateTime());
        movementDespesa.setDescricao(fakers.getCreditCardNumber());
        movementDespesa.setInteressado(fakers.getArtist());
        movementDespesa.setValor(fakers.getValue());
        movementDespesa.setConta(MovementType.DESPESA.toString());
        movementDespesa.setSituacao(MovementSituation.PAGO.toString());

        user = new User();
        user.setNome(Formatter.removerAcentos(fakers.getFirstName()));
        user.setLogin(Formatter.lowerCase(fakers.getEmailRandomico(user.getNome(), 20)));
        user.setPassword("123123");

        PropertiesSaver.zeraSaldo();
    }

    @Test
    @Tag("Regressao")
    @Description("Validar inserir movimentações com sucesso - Fake Generation")
    public void validateRealizeMovement() {
        try {
            Report.creatTest("Realizar registro de movimentação - Fakers Generation", ReportType.GROUP);
            Report.createStep("Realizar cadastro de usuário");
            login.selectNewUser();
            register.registerUser(user);
            Report.createStep("Realizar login");
            login.signin(user);
            Report.createStep("Cadastrar contas");
            home.selectCreateAccount();
            account.add(MovementType.RECEITA.toString());
            home.selectCreateAccount();
            account.add(MovementType.DESPESA.toString());
            Report.createStep("Realizar movimentação");
            home.selectCreateMovimentation();
            movement.add(movementReceita);
            home.selectMonthlySummary();
            montlySummary.searchMovimentation(movementReceita);
            home.selectCreateMovimentation();
            movement.add(movementDespesa);
            home.selectMonthlySummary();
            montlySummary.searchMovimentation(movementDespesa);
            Report.createStep("Validar saldo");
            montlySummary.balance(DateTime.getActuaDateTime());
        } catch (Exception e) {
            Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
        }
    }

}
