package lk.ijse.cmjd112.AirTicketPoint.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FlightDTO implements Serializable {
    private String flightId;
    private String flightNO;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private int totalSeats;
    private int avaliableSeats;
    private double basefare;
    private FlightStatus status;
    private String deapartureAirportID;
    private String arrivalAirportId;

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }
}
