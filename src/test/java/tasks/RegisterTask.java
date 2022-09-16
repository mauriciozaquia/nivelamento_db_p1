package tasks;

import Framework.Utils.FakersGeneration;
import Framework.Utils.PropertiesSaver;
import Model.User;
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

    public void registerUser(User user) throws IOException {
        registrationPage.getNameInput().sendKeys(user.getNome());
        registrationPage.getLoginInput().sendKeys(user.getLogin());
        registrationPage.getPasswordInput().sendKeys(user.getPassword());
        registerValidation.validationFields();
        PropertiesSaver.setValuesPropertiesUser(user.getNome(), user.getLogin(), user.getPassword());
        registrationPage.getRegisterButton().click();
        registerValidation.validationRegister();
    }
}
