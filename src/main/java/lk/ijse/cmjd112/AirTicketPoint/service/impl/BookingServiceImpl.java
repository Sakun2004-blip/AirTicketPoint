package lk.ijse.cmjd112.AirTicketPoint.service.impl;

import lk.ijse.cmjd112.AirTicketPoint.dto.BookingDTO;
import lk.ijse.cmjd112.AirTicketPoint.dto.BookingStatus;
import lk.ijse.cmjd112.AirTicketPoint.service.BookingService;
import lk.ijse.cmjd112.AirTicketPoint.util.DateTimeUtil;
import lk.ijse.cmjd112.AirTicketPoint.util.IDGenerator;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    @Override
    public BookingDTO saveBooking(BookingDTO bookingDTO) {
        bookingDTO.setBookingId(IDGenerator.bookingIDGen());
        bookingDTO.setBookingDateTime(
                bookingDTO.getBookingDateTime() == null ? DateTimeUtil.currentTime() : bookingDTO.getBookingDateTime());
        System.out.println("Booking is: " + bookingDTO);
        return bookingDTO;
    }

    @Override
    public BookingDTO getSelectedBooking(String bookingID) {
        System.out.println("Booking ID is: " + bookingID);
        var bookingDTO = new BookingDTO(bookingID, "REF123", LocalDateTime.now(), 2, 150.0, BookingStatus.CONFIRMED, "USR123", "FLT123");
        return bookingDTO;
    }

    @Override
    public List<BookingDTO> getAllBookings() {
        return List.of(
                new BookingDTO("BKG1", "REF001", LocalDateTime.now().minusDays(1), 1, 75.0, BookingStatus.CONFIRMED, "USR001", "FLT001"),
                new BookingDTO("BKG2", "REF002", LocalDateTime.now().minusDays(2), 2, 150.0, BookingStatus.PENDING, "USR002", "FLT002"),
                new BookingDTO("BKG3", "REF003", LocalDateTime.now().minusDays(3), 3, 225.0, BookingStatus.CANCELLED, "USR003", "FLT003")
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
