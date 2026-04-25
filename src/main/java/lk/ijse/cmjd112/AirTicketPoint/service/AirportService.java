package lk.ijse.cmjd112.AirTicketPoint.service;

import lk.ijse.cmjd112.AirTicketPoint.dto.AirportDTO;

import java.util.List;

public interface AirportService {
    public AirportDTO saveAirport(AirportDTO airportDTO);
    List<AirportDTO>getAllAirports();
    void deleteAirport(String airportId);
    void updateAirport(String airportId,AirportDTO airportDTO);
}
