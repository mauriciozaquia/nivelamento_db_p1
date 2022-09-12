package Tasks;

import Framework.Utils.FakersGeneration;
import PageObjects.LoginPage;
import PageObjects.WidgetNavBar;
import Validations.GenericValidation;
import Validations.LoginValidation;
import org.openqa.selenium.WebDriver;

public class LoginTask {
    private WebDriver driver;
    private LoginPage loginPage;
    private LoginValidation loginValidation;
    private GenericValidation genericValidation;
    private FakersGeneration fakersGeneration;
    private WidgetNavBar widgetNavBar;

    public LoginTask(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(this.driver);
        loginValidation = new LoginValidation(this.driver);
        genericValidation = new GenericValidation(this.driver);
        fakersGeneration = new FakersGeneration(this.driver);
        widgetNavBar = new WidgetNavBar(this.driver);
    }

    public void entrar(String email, String password) {
        widgetNavBar.getNavBarItemPorTexto("Login").click();
        loginValidation.validationLoginPage();
        //homePage.getLoginInput().sendKeys(fakersGeneration.getEmail());
        loginPage.getLoginInput().sendKeys(email);
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getLoginButton().click();
        genericValidation.validationPageHome();
    }

    public void selectNewUser() {
        widgetNavBar.getNavBarItemPorTexto("Novo usuário?").click();
    }
}
