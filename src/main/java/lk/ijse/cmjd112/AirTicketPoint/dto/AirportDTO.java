package lk.ijse.cmjd112.AirTicketPoint.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@NoArgsConstructor
@Data
public class AirportDTO implements Serializable {
    private String airportID;
    private String airportCode;
    private String airportName;
    private String City;
    private String Country;

    public AirportDTO(String airportID, String airportCode, String airportName, String city, String country) {
        this.airportID = airportID;
        this.airportCode = airportCode;
        this.airportName = airportName;
        this.City = city;
        this.Country = country;
    }

    public void setAirportID(String s) {
        this.airportID=s;
    }
}


