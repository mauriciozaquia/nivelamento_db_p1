package Framework.Utils;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import java.text.Normalizer;
import java.util.Locale;

public class FakersGeneration {
    private Faker faker;
    private String firstName;
    private String lastName;
    private String zipCode;
    private String email;
    private String password;

    public FakersGeneration(WebDriver driver) {
        faker = new Faker(new Locale("pt-BR"));
    }

    // User
    public String getFirstName() {
        return faker.name().firstName();
    }
    public String getEmail() {
        return faker.name().firstName() + faker.name().lastName() + "@teste.com.br";
    }
    public static String getEmailRandomico(String nome, int length) {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "_-.";
        String email;
        String temp = RandomStringUtils.random(length, allowedChars);
        email = nome + temp.substring(0, temp.length() - 9) + "@teste.com";
        email = email.replaceAll(" ", "");
        return email;
    }

    // Movement
    public String getCreditCardNumber() {
        return faker.business().creditCardNumber();
    }
    public String getArtist() {
        return faker.artist().name();
    }
    public double getValue() {
        return faker.number().randomDouble(2,1,1000);
    }

}
