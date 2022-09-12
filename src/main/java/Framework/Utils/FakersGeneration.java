package Framework.Utils;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import org.checkerframework.checker.index.qual.PolyUpperBound;
import org.openqa.selenium.WebDriver;

import java.util.Locale;

public class FakersGeneration {
    private Faker faker;
    private String firstName;
    private String lastName;
    private String zipCode;
    private String email;

    public FakersGeneration(WebDriver driver) {
        faker = new Faker(new Locale("pt-BR"));
    }

    public String getFirstName() {
        firstName = faker.name().firstName();
        return firstName;
    }

    public String getLastName() {
        lastName = faker.name().lastName();
        return lastName;
    }

    public String getZipCode() {
        zipCode = faker.address().zipCode();
        return zipCode;
    }

    public String getEmail() {
        return faker.name().firstName() + faker.name().lastName() + "@teste.com.br";
    }
    public static String getEmailRandomico(String prefixo, int length) {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "_-.";
        String email = "";
        String temp = RandomStringUtils.random(length, allowedChars);
        email = prefixo + temp.substring(0, temp.length() - 9) + "@teste.com";
        return email.trim();
    }
}
