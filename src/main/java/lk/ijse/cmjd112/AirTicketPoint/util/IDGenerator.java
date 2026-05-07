package lk.ijse.cmjd112.AirTicketPoint.util;

import java.util.UUID;

public class IDGenerator {
    //Airport
    public static String airportIDGen(){
        return "API."+ UUID.randomUUID();
    }
    public static String userIDGen(){
        return "USR"+UUID.randomUUID();
    }
    public static String bookingIDGen(){
        return "BKG"+UUID.randomUUID();
    }
    public static String flightIDGen(){
        return "FLT"+UUID.randomUUID();
    }
}
