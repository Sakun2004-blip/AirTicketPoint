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

    public FlightDTO(String flightId, String flightNO, LocalDateTime departureTime, LocalDateTime arrivalTime, int totalSeats, int avaliableSeats, double basefare, FlightStatus status, String deapartureAirportID, String arrivalAirportId) {
        this.flightId = flightId;
        this.flightNO = flightNO;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.totalSeats = totalSeats;
        this.avaliableSeats = avaliableSeats;
        this.basefare = basefare;
        this.status = status;
        this.deapartureAirportID = deapartureAirportID;
        this.arrivalAirportId = arrivalAirportId;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }
}
