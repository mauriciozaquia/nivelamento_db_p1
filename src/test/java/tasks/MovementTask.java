package tasks;

import Framework.Utils.Formatter;
import Framework.Utils.PropertiesSaver;
import Model.Movement;
import pageobjects.MovementPage;
import validations.MovementValidation;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class MovementTask {

    private WebDriver driver;
    private MovementPage movementPage;
    private MovementValidation movementValidation;

    public MovementTask(WebDriver driver) {
        this.driver = driver;
        movementPage = new MovementPage(driver);
        movementValidation = new MovementValidation(driver);
    }

    public void add(Movement m) throws IOException {
        PropertiesSaver.setValuesPropertiesMovement(m);
        movementPage.selectTipoDaMovimentacao(m.getTipoDaMovimentacao());
        movementPage.getDataMovimentacaoInput().sendKeys(Formatter.formatteDate(m.getDataDaMovimentacao()));
        movementPage.getDataDoPagamentoInput().sendKeys(Formatter.formatteDate(m.getDataDoPagamento()));
        movementPage.getDescricaoInput().sendKeys(m.getDescricao());
        movementPage.getInteressadoInput().sendKeys(m.getInteressado());
        movementPage.getValorInput().sendKeys(Double.toString(m.getValor()));
        movementPage.selectConta(m.getConta());
        movementPage.getSituacaoPagoRadio().click();
        movementValidation.validationFields();
        movementPage.getSalvarButton().click();
        movementValidation.validationMovementSucess();
        PropertiesSaver.setValuePropertiesBalanceAtualizaSaldo(m);
    }
}
