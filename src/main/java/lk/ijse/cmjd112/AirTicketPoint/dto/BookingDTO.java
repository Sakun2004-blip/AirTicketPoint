package lk.ijse.cmjd112.AirTicketPoint.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingDTO implements Serializable {
    private String bookingId;
    private String reference;
    private LocalDateTime bookingDateTime;
    private int seatCount;
    private double totalAmount;
    private BookingStatus bookingStatus;
    private String userId;
    private String flightId;
}
