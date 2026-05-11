package lk.ijse.cmjd112.AirTicketPoint.entities;

import jakarta.persistence.*;
import lk.ijse.cmjd112.AirTicketPoint.dto.FlightStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="flights")
public class Flight {
    @Id
    private String flightId;
    private String flightNO;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private int totalSeats;
    private int avaliableSeats;
    private double basefare;
    @Enumerated(EnumType.ORDINAL)
    private FlightStatus status;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dep_airport") // Foreign key column name in the 'flights' table
    private Airport departureAirport; // Reference to the Airport entity
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="arr_airport") // Foreign key column name in the 'flights' table
    private Airport arrivalAirport; // Reference to the Airport entity
}
