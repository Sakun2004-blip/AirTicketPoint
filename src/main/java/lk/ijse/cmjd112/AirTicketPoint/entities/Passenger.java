package lk.ijse.cmjd112.AirTicketPoint.entities;
// cSpell:ignore ijse cmjd cmjd112

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "passenger")
public class Passenger implements Serializable {
    @Id
    private String passengerId;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String contactNumber;
    private String seatNumber;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id") // Foreign key column name in the 'passenger' table
    private Bookings booking; // Reference to the Bookings entity
}
