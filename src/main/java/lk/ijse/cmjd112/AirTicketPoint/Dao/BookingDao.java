package lk.ijse.cmjd112.AirTicketPoint.Dao;

import lk.ijse.cmjd112.AirTicketPoint.entities.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingDao extends JpaRepository<Bookings, String> {

}
