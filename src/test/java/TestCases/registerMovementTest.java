package TestCases;

import Framework.Report.Report;
import Framework.Report.ReportType;
import Framework.Report.Screenshot;
import Framework.TestBase;
import Model.Movement;
import Tasks.*;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;

public class registerMovementTest extends TestBase {
    private WebDriver driver = this.getDriver();
    LoginTask login = new LoginTask(driver);
    RegisterTask register = new RegisterTask(driver);
    HomeTask home = new HomeTask(driver);
    MovementTask movement = new MovementTask(driver);
    AddAccountTask addAccount = new AddAccountTask(driver);
    MontlySummaryTask montlySummary = new MontlySummaryTask(driver);
    private Movement movementReceita;
    private Movement movementDespesa;

    @BeforeEach
    public void configura() {
        movementReceita = new Movement();
        movementReceita.setTipoDaMovimentacao("Receita");
        movementReceita.setDataDaMovimentacao("10/09/2022");
        movementReceita.setDataDoPagamento("10/09/2022");
        movementReceita.setDescricao("Teste de movimentação");
        movementReceita.setInteressado("Fulano de tal");
        movementReceita.setValor(10.00);
        movementReceita.setConta("Receita");
        movementReceita.setSituaca("Pago");

        movementDespesa = new Movement();
        movementDespesa.setTipoDaMovimentacao("Despesa");
        movementDespesa.setDataDaMovimentacao("10/09/2022");
        movementDespesa.setDataDoPagamento("10/09/2022");
        movementDespesa.setDescricao("Teste de movimentação");
        movementDespesa.setInteressado("Fulano de tal");
        movementDespesa.setValor(5.00);
        movementDespesa.setConta("Despesa");
        movementDespesa.setSituaca("Pago");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/CSV/login.csv", numLinesToSkip = 1)
    public void realizarMovimentacao(String user, String email, String password) {
        try {
            Report.creatTest("Realizar registro de movimentação", ReportType.GROUP);
            Report.createStep("Realizar cadastro com sucesso");
            login.selectNewUser();
            register.registerUser(user, email, password);
            Report.createStep("Realizar login com sucesso");
            login.entrar(email, password);
            Report.createStep("Cadastrar contas com sucesso");
            home.selectCreateAccount();
            addAccount.fillData("Receita");
            addAccount.save();
            home.selectCreateAccount();
            addAccount.fillData("Despesa");
            addAccount.save();
            Report.createStep("Realizar movimentação com sucesso");
            home.selectMonthlySummary();
            montlySummary.cleanMovimentation();
            home.selectCreateMovimentation();
            movement.preencherCampos(movementReceita);
            movement.save();
            home.selectCreateMovimentation();
            movement.preencherCampos(movementDespesa);
            movement.save();
            Report.createStep("Validar saldo com sucesso");
            home.selectMonthlySummary();
            montlySummary.searchMovimentation(movementReceita);
            montlySummary.searchMovimentation(movementDespesa);
        } catch (Exception e) {
            Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
        }
    }

}
