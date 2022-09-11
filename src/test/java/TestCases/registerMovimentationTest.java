package TestCases;

import Framework.Report.Report;
import Framework.Report.ReportType;
import Framework.Report.Screenshot;
import Framework.TestBase;
import Framework.Utils.FakersGeneration;
import Model.Movement;
import Tasks.*;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;

public class registerMovimentationTest extends TestBase {
    private WebDriver driver = this.getDriver();
    LoginTask loginTask = new LoginTask(driver);
    RegisterTask registerTask = new RegisterTask(driver);
    HomeTask homeTask = new HomeTask(driver);
    MovementTask movementTask = new MovementTask(driver);
    AddAccountTask addAccountTask = new AddAccountTask(driver);

    @ParameterizedTest
    @CsvFileSource(resources = "/CSV/login.csv", numLinesToSkip = 1)
    public void realizarMovimentacao(String user, String email, String password) {
        try {
            Movement m = new Movement();
            m.setTipoDaMovimentacao("Receita");
            m.setDataDaMovimentacao("10/09/2022");
            m.setDataDoPagamento("10/09/2022");
            m.setDescricao("Teste de movimentação");
            m.setInteressado("Fulano de tal");
            m.setValor(10.50);
            m.setConta("12345678");
            m.setSituaca("Pago");

            Report.creatTest("Realizar registro de movimentação", ReportType.GROUP);
            Report.createStep("Realizar cadastro com sucesso");
            loginTask.selectNewUser();
            registerTask.registerUser(user, email, password);
            Report.createStep("Realizar login com sucesso");
            loginTask.efetuarLogin(email, password);
            Report.createStep("Cadastrar contas com sucesso");
            homeTask.selectCreateAccount();
            addAccountTask.preencherCampos("Receita");
            addAccountTask.salvarConta();
            homeTask.selectCreateAccount();
            addAccountTask.preencherCampos("Despesa");
            addAccountTask.salvarConta();
            Report.createStep("Realizar movimentação com sucesso");
            homeTask.selectCreateMovimentation();
            movementTask.preencherCampos(m);
            movementTask.salvarMovimento();
            Report.createStep("Validar movimentação com sucesso");

        } catch (Exception e) {
            Report.log(Status.FAIL, e.getMessage(), Screenshot.captureBase64(driver));
        }
    }

}
