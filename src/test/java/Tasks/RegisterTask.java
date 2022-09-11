package Tasks;

import PageObjects.RegistrationPage;
import org.openqa.selenium.WebDriver;

public class RegisterTask {

    private WebDriver driver;
    private RegistrationPage registrationPage;

    public RegisterTask(WebDriver driver) {
        this.driver = driver;
        registrationPage = new RegistrationPage(this.driver);
    }

    public void registerUser(String email, String user, String password) {
        registrationPage.getNameInput().sendKeys("teste");
        registrationPage.getLoginInput().sendKeys("a@a.com.br");
        registrationPage.getPasswordInput().sendKeys("123123");
        registrationPage.getRegisterButton().click();
    }
}
