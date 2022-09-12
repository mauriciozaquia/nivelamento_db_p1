package testcases;

import Framework.Report.Report;
import Framework.Report.ReportType;
import Framework.Report.Screenshot;
import Framework.TestBase;
import Framework.Utils.FilesOperation;
import Model.Movement;
import com.aventstack.extentreports.Status;
import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import tasks.*;

public class RegisterMovementFakeGenerationTest extends TestBase {
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
    public void configuracaoInicial() {
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

    @Test
    @Tag("Regressao")
    @Description("Validar inserir movimentações com sucesso - Fake Generation")
    public void realizarMovimentacaoDinamica() {
        try {
            Report.creatTest("Realizar registro de movimentação - Fakers Generation", ReportType.GROUP);
            Report.createStep("Realizar cadastro com sucesso");
            login.selectNewUser();
            register.registerUserFakersGeneration();
            Report.createStep("Realizar login com sucesso");

            String email = FilesOperation.getProperties("user").getProperty("email");
            String password = FilesOperation.getProperties("user").getProperty("senha");
            login.entrar(email,password);

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
