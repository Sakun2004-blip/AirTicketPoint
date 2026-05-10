package lk.ijse.cmjd112.AirTicketPoint.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.cmjd112.AirTicketPoint.Dao.AirportDao;
import lk.ijse.cmjd112.AirTicketPoint.dto.AirportDTO;
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
        System.out.println("Deleted Airport:"+airportId);
    }

    @Override
    public void updateAirport(String airportId, AirportDTO airportDTO) {
        airportDTO.setAirportID(airportId);
        System.out.println("Update Airport ID:"+airportId);
        System.out.println("Updated Airport details:"+airportDTO);
    }
}
