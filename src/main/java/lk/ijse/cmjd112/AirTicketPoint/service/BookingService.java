package lk.ijse.cmjd112.AirTicketPoint.service;

import lk.ijse.cmjd112.AirTicketPoint.dto.BookingDTO;

import java.util.List;

public interface BookingService {
    BookingDTO saveBooking(BookingDTO bookingDTO);
    BookingDTO getSelectedBooking(String bookingID);
    List<BookingDTO> getAllBookings();
    void deleteBooking(String bookingID);
    void updateBooking(String bookingID, BookingDTO bookingDTO);
}