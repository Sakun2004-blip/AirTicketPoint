package lk.ijse.cmjd112.AirTicketPoint.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
    private static final DateTimeFormatter formatter=DateTimeFormatter.ofPattern("YYYY-MM-dd 'T' HH:mm:ss");

    //current Time
    public static LocalDateTime currentTime(){
        return LocalDateTime.now();
    }

    //format
    public static String currentDateTimeString(){
        return LocalDateTime.now().format(formatter);
    }
}
