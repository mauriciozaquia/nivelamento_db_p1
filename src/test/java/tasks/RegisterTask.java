package tasks;

import Framework.Utils.FakersGeneration;
import Framework.Utils.PropertiesSaver;
import pageobjects.RegistrationPage;
import org.openqa.selenium.WebDriver;
import validations.RegisterValidation;

import java.io.IOException;

public class RegisterTask {
    private WebDriver driver;
    private RegistrationPage registrationPage;
    private FakersGeneration fakersGeneration;
    private RegisterValidation registerValidation;

    public RegisterTask(WebDriver driver) {
        this.driver = driver;
        registrationPage = new RegistrationPage(this.driver);
        fakersGeneration = new FakersGeneration(this.driver);
        registerValidation = new RegisterValidation(this.driver);
    }

    public void registerUser(String email, String user, String password) throws IOException {
        registrationPage.getNameInput().sendKeys("teste");
        registrationPage.getLoginInput().sendKeys("a@a.com.br");
        registrationPage.getPasswordInput().sendKeys("123123");
        registrationPage.getRegisterButton().click();
        PropertiesSaver.setValuesPropertiesUser(user, email, password);
        registerValidation.validationRegisterExistingUserSucess();
    }

    public void registerUserFakersGeneration() throws IOException {
        String nome = fakersGeneration.getFirstName();
        String email = fakersGeneration.getEmailRandomico(nome, 20);
        String password = "123123";

        registrationPage.getNameInput().sendKeys(nome);
        registrationPage.getLoginInput().sendKeys(email);
        registrationPage.getPasswordInput().sendKeys(password);
        registrationPage.getRegisterButton().click();
        PropertiesSaver.setValuesPropertiesUser(nome, email, password);
        registerValidation.validationRegisterSucess();
    }
}
