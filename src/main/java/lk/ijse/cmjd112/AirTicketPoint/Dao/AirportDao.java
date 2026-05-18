package lk.ijse.cmjd112.AirTicketPoint.Dao;


import lk.ijse.cmjd112.AirTicketPoint.entities.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AirportDao extends JpaRepository<Airport, String> {
    Optional<Airport> findAirportByAirportCode(String airportCode);
}
