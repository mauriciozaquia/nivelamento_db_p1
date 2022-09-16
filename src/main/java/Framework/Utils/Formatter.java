package Framework.Utils;

import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Formatter {

    public static String removerAcentos(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }

    public static String lowerCase(String texto) {
        return texto.toLowerCase();
    }

    public static  String formataData(Date data) {
        SimpleDateFormat formatarDate = new SimpleDateFormat("dd/MM/yyyy");
        return formatarDate.format(data);
    }
}
