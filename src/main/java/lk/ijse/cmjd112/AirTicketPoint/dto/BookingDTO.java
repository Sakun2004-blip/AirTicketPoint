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
    private String bookingID;
    private String bookingRef;
    private LocalDateTime bookingDate;
    private int seatcount;
    private double totalAmt;
    private String status;
    private String User_Id;
    private String flightID;
}
