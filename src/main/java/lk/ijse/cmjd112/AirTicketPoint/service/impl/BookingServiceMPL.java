package lk.ijse.cmjd112.AirTicketPoint.service.impl;

import lk.ijse.cmjd112.AirTicketPoint.dto.BookingDTO;
import lk.ijse.cmjd112.AirTicketPoint.service.BookingService;
import lk.ijse.cmjd112.AirTicketPoint.util.IDGenerator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceMPL implements BookingService {
    @Override
    public BookingDTO saveBooking(BookingDTO bookingDTO) {
        System.out.println("Booking is: " + bookingDTO);
        return bookingDTO;
    }

    @Override
    public BookingDTO getSelectedBooking(String bookingID) {
        System.out.println("Booking ID is: " + bookingID);
        var bookingDTO = new BookingDTO(bookingID, "John Doe", "john@example.com", "password123");
        return bookingDTO;
    }

    @Override
    public List<BookingDTO> getAllBookings() {
        return List.of(
                new BookingDTO("BKG1", "Alice Smith", "alice@example.com", "pass123"),
                new BookingDTO("BKG2", "Bob Johnson", "bob@example.com", "secure456"),
                new BookingDTO("BKG3", "Charlie Brown", "charlie@example.com", "mypassword")
        );
    }

    @Override
    public void deleteBooking(String bookingID) {
        System.out.println("Deleted Booking ID is: " + bookingID);
    }

    @Override
    public void updateBooking(String bookingID, BookingDTO bookingDTO) {
        System.out.println("Booking ID is: " + bookingID);
        System.out.println("Updated booking is: " + bookingDTO);
    }
}
