package Framework.Utils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTime {
    public static String getDateTimeFormatReport() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
        Date now = new Date();
        return dateFormat.format(now);
    }

    public static String getDateTimeFormatScreenshot() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MMM-yyy_hh'h'mm'm's's'");
        LocalDateTime localDateTime = LocalDateTime.now();
        return dateTimeFormatter.format(localDateTime);
    }

    //

    public static String getActualDateTimeString() {
        Date data = new Date(System.currentTimeMillis());
        SimpleDateFormat formatarDate = new SimpleDateFormat("dd/MM/yyyy");
        return formatarDate.format(data);
    }

    public static String getActualDateTimeString(String format) {
        Date data = new Date(System.currentTimeMillis());
        SimpleDateFormat formatarDate = new SimpleDateFormat(format);
        return formatarDate.format(data);
    }

    public static Date getActuaDateTime(){
        Date data = new Date(System.currentTimeMillis());
        return data;
    }

}
