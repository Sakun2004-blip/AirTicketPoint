package lk.ijse.cmjd112.AirTicketPoint.Dao;


import lk.ijse.cmjd112.AirTicketPoint.entities.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportDao extends JpaRepository<Airport, String> {


}
