package Framework.Utils;

import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Formatter {

    public static String accentRemove(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }

    public static String lowerCase(String texto) {
        return texto.toLowerCase();
    }

    public static  String formatteDate(Date data) {
        SimpleDateFormat formatteDate = new SimpleDateFormat("dd/MM/yyyy");
        return formatteDate.format(data);
    }
}
