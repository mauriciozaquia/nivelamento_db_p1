package Framework.Utils;

import java.io.IOException;

public class PropertiesSaver {
    public static void setValuesPropertiesUser(String nome, String email, String senha) throws IOException {
        FilesOperation.setProperties("user", "nome", nome);
        FilesOperation.setProperties("user", "email", email);
        FilesOperation.setProperties("user", "senha", senha);
    }

}
