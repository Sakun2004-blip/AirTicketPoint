package lk.ijse.cmjd112.AirTicketPoint.service.impl;

import lk.ijse.cmjd112.AirTicketPoint.Dao.AirportDao;
import lk.ijse.cmjd112.AirTicketPoint.Dao.FlightDao;
import lk.ijse.cmjd112.AirTicketPoint.dto.FlightDTO;
import lk.ijse.cmjd112.AirTicketPoint.dto.FlightStatus;
import lk.ijse.cmjd112.AirTicketPoint.exception.DataNotFoundException;
import lk.ijse.cmjd112.AirTicketPoint.service.FlightService;
import lk.ijse.cmjd112.AirTicketPoint.util.IDGenerator;
import lk.ijse.cmjd112.AirTicketPoint.util.MappingDTOEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {
    private final FlightDao flightDao;
    private final MappingDTOEntity mappingDTOEntity;
    private final AirportDao airportDao;

    @Override
    public FlightDTO saveFlight(FlightDTO flightDTO) {
        var arrAirport = airportDao.findAirportByAirportCode(flightDTO.getArrivalAirportId())
                .orElseThrow(() -> new DataNotFoundException("Arrival Airport not Found"));

        var depAirport = airportDao.findAirportByAirportCode(flightDTO.getDepartureAirportId())
                .orElseThrow(() -> new DataNotFoundException("Departure Airport Not Found"));

        var flight=mappingDTOEntity.toflight(flightDTO);
        flightDTO.setFlightId(IDGenerator.flightIDGen());
        flight.setFlightId(flightDTO.getFlightId());
        flight.setArrivalAirport(arrAirport);
        flight.setDepartureAirport(depAirport);
        flightDao.save(flight);
        return flightDTO;
    }

    @Override
    public FlightDTO getSelectedFlight(String flightId) {
      var foundflight= flightDao.findById(flightId).orElseThrow(()->new DataNotFoundException("Flight Not Found"));

      return mappingDTOEntity.toflightDTO(foundflight);
    }

    @Override
    public List<FlightDTO> getAllFlights() {
              return mappingDTOEntity.getflightDTOList(flightDao.findAll());
    }

    @Override
    public void deleteFlight(String flightId) {
        flightDao.findById(flightId).orElseThrow(()->new DataNotFoundException("Flight Not Found"));

    }

    @Override
    public void updateFlight(String flightId, FlightDTO flightDTO) {

        var foundflight= flightDao.findById(flightId).orElseThrow(()->new DataNotFoundException("Flight Not Found"));

        foundflight.setFlightId(FlightDTO.getflightId());
        foundflight.setArrivalTime(FlightDTO.getArrivalTime());
        foundflight.setDepartureTime(FlightDTO.getDeapartureTime());
        foundflight.setTotalSeats(flightDTO.getTotalSeats());
        foundflight.setAvaliableSeats(flightDTO.getAvaliableSeats());
        foundflight.setBaseFare(flightDTO.getBaseFare());
        foundflight.setStatus(flightDTO.getStatus());

    }

}
