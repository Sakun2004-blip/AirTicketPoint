package lk.ijse.cmjd112.AirTicketPoint.service.impl;

// cSpell:ignore ijse cmjd cmjd112

import jakarta.transaction.Transactional;
import lk.ijse.cmjd112.AirTicketPoint.Dao.AirportDao;
import lk.ijse.cmjd112.AirTicketPoint.dto.AirportDTO;
import lk.ijse.cmjd112.AirTicketPoint.exception.DataNotFoundException;
import lk.ijse.cmjd112.AirTicketPoint.service.AirportService;
import lk.ijse.cmjd112.AirTicketPoint.util.IDGenerator;
import lk.ijse.cmjd112.AirTicketPoint.util.MappingDTOEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AirportServiceMPL implements AirportService {
    private final AirportDao airportDao;
    private final MappingDTOEntity mappingDTOEntity;
    @Override
    public AirportDTO saveAirport(AirportDTO airportDTO) {

        airportDTO.setAirportID(IDGenerator.airportIDGen());
        var airportEntity=mappingDTOEntity.toAirportEntity(airportDTO);
        var savedAirport=airportDao.save(airportEntity);
       var savedAirportDTO=mappingDTOEntity.toAirportDTO(savedAirport);
       return savedAirportDTO;
    }

    @Override
    public AirportDTO getSelectedAirport(String airportId) {
          //Find the record exist
          var foundAirport=airportDao.findById(airportId).orElseThrow(()->new RuntimeException("Data Not Found"));
          return mappingDTOEntity.toAirportDTO(foundAirport);
}
    @Override
    public List<AirportDTO> getAllAirports() {
       return mappingDTOEntity.getAirportDTO(airportDao.findAll());
    }

    @Override
    public void deleteAirport(String airportId) {
        System.out.println("Attempting to delete airport with ID: " + airportId);
        var airport = airportDao.findById(airportId)
                .orElseThrow(() -> {
                    System.out.println("Airport not found with ID: " + airportId);
                    return new DataNotFoundException("Airport with ID: " + airportId + " not found");
                });
        try {
            airportDao.delete(airport);
            System.out.println("Airport deleted successfully: " + airportId);
        } catch (Exception e) {
            System.out.println("Error deleting airport: " + e.getMessage());
            throw new DataNotFoundException("Cannot delete airport. It may be referenced by other records.", e);
        }
    }

    @Override
    public void updateAirport(String airportId, AirportDTO airportDTO) {
        System.out.println("Attempting to update airport with ID: " + airportId);
        airportDao.findById(airportId)
                .orElseThrow(() -> new RuntimeException("Airport with ID: " + airportId + " not found"));
        
        airportDTO.setAirportID(airportId);
        var updatedAirport = mappingDTOEntity.toAirportEntity(airportDTO);
        airportDao.save(updatedAirport);
        System.out.println("Airport updated successfully: " + airportId);
    }
}
