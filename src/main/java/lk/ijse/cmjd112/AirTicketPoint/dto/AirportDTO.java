package lk.ijse.cmjd112.AirTicketPoint.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class AirportDTO implements Serializable {
    private String airportID;
    private String airportCode;
    private String airportName;
    private String city;
    private String country;



    public void setAirportID(String s) {
        this.airportID=s;
    }
}


