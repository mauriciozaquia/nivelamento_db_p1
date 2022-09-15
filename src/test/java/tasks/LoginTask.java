package tasks;

import Framework.Utils.FakersGeneration;
import pageobjects.LoginPage;
import pageobjects.WidgetNavBar;
import validations.GenericValidation;
import validations.LoginValidation;
import org.openqa.selenium.WebDriver;
import validations.RegisterValidation;

public class LoginTask {
    private WebDriver driver;
    private LoginPage loginPage;
    private LoginValidation loginValidation;
    private GenericValidation genericValidation;
    private FakersGeneration fakersGeneration;
    private WidgetNavBar widgetNavBar;
    private RegisterValidation registerValidation;

    public LoginTask(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(this.driver);
        loginValidation = new LoginValidation(this.driver);
        genericValidation = new GenericValidation(this.driver);
        fakersGeneration = new FakersGeneration(this.driver);
        widgetNavBar = new WidgetNavBar(this.driver);
        registerValidation = new RegisterValidation(this.driver);
    }

    public void entrar(String email, String password) {
        widgetNavBar.getNavBarItemPorTexto("Login").click();
        loginValidation.validationLoginPage();
        loginPage.getLoginInput().sendKeys(email);
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getLoginButton().click();
        genericValidation.validationPageHome();
    }

    public void selectNewUser() {
        widgetNavBar.getNavBarItemPorTexto("Novo usuário?").click();
        registerValidation.validationRedirectRegisterPage();
    }
}
