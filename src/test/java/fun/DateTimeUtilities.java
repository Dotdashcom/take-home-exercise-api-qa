package fun;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtilities {

    /**
     * @return current date and time as a string
     * Example:
     * Tue, 14 Jul 2020 03:24:53 GMT
     */
    public static String getCurrentDateAndTime(){
        ZonedDateTime nowWithTimeZone = ZonedDateTime.now(ZoneId.of("GMT"));
        return  nowWithTimeZone.format(DateTimeFormatter.ofPattern("E, dd MMM yyyy HH:mm:ss z"));
    }
}