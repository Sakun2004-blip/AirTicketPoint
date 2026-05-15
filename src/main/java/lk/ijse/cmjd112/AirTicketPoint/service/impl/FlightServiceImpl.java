package lk.ijse.cmjd112.AirTicketPoint.service.impl;

import lk.ijse.cmjd112.AirTicketPoint.Dao.AirportDao;
import lk.ijse.cmjd112.AirTicketPoint.Dao.FlightDao;
import lk.ijse.cmjd112.AirTicketPoint.dto.FlightDTO;
import lk.ijse.cmjd112.AirTicketPoint.dto.FlightStatus;
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
        flightDTO.setFlightId(IDGenerator.flightIDGen());

        airportDao.findById(flightDTO.getArrivalAirportId());
        return flightDTO;
    }

    @Override
    public FlightDTO getSelectedFlight(String flightId) {
        System.out.println("Flight ID is: " + flightId);
        var flight = new FlightDTO(
                flightId,
                "FL123",
                LocalDateTime.now(),
                LocalDateTime.now().plusHours(2),
                180,
                150,
                5000.0,
                FlightStatus.AVALIABLE,
                "API.9d59723c-efc5-448a-bc81-cf31e2fcf83c",
                "KLH"
        );
        return flight;
    }

    @Override
    public List<FlightDTO> getAllFlights() {
        List<FlightDTO> flightList = List.of(
                new FlightDTO("FLT001", "FL101", LocalDateTime.now(), LocalDateTime.now().plusHours(2), 180, 150, 5000.0, FlightStatus.AVALIABLE, "API.9d59723c-efc5-448a-bc81-cf31e2fcf83c", "KLH"),
                new FlightDTO("FLT002", "FL102", LocalDateTime.now().plusHours(3), LocalDateTime.now().plusHours(5), 200, 180, 6000.0, FlightStatus.AVALIABLE, "API.9d59723c-efc5-448a-bc81-cf31e2fcf83c", "MLH"),
                new FlightDTO("FLT003", "FL103", LocalDateTime.now().plusHours(6), LocalDateTime.now().plusHours(8), 150, 100, 4500.0, FlightStatus.CANCEL, "KLH", "RLH"),
                new FlightDTO("FLT004", "FL104", LocalDateTime.now().plusHours(9), LocalDateTime.now().plusHours(11), 160, 160, 5500.0, FlightStatus.OUT_OF_SERVICE, "MLH", "API.9d59723c-efc5-448a-bc81-cf31e2fcf83c")
        );
        return flightList;
    }

    @Override
    public void deleteFlight(String flightId) {
        System.out.println("Deleted Flight: " + flightId);
    }

    @Override
    public void updateFlight(String flightId, FlightDTO flightDTO) {
        flightDTO.setFlightId(flightId);
        System.out.println("Update Flight ID: " + flightId);
        System.out.println("Updated Flight details: " + flightDTO);
    }
}
