package Tasks;

import Model.Movement;
import PageObjects.MovementPage;
import Validations.MovementValidation;
import org.openqa.selenium.WebDriver;

public class MovementTask {

    private WebDriver driver;
    private MovementPage movementPage;
    private MovementValidation movementValidation;


    public MovementTask(WebDriver driver) {
        this.driver = driver;
        movementPage = new MovementPage(driver);
        movementValidation = new MovementValidation(driver);
    }

    public void preencherCampos(Movement m) {
        movementPage.selectTipoDaMovimentacao(m.getTipoDaMovimentacao());
        movementPage.getDataMovimentacaoInput().sendKeys(m.getDataDaMovimentacao());
        movementPage.getDataDoPagamentoInput().sendKeys(m.getDataDoPagamento());
        movementPage.getDescricaoInput().sendKeys(m.getDescricao());
        movementPage.getInteressadoInput().sendKeys(m.getInteressado());
        movementPage.getValorInput().sendKeys(Double.toString(m.getValor()));
        //movementPage.getContaInput().click();
        movementPage.getSituacaoPagoRadio().click();
    }
    public void save() {
        movementPage.getSalvarButton().click();
        movementValidation.validationMovementSucess();
    }
}
