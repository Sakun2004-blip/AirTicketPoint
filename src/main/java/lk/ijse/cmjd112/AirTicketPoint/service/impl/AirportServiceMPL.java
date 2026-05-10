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
        System.out.println("Airport ID is"+airportId);
        var airport=new AirportDTO("API.9d59723c-efc5-448a-bc81-cf31e2fcf83c",
                "CMB","Bandaranayaka International Airport","Katunayaka","Sri Lanka");
return airport;
}
    @Override
    public List<AirportDTO> getAllAirports() {
       List<AirportDTO>airportList=List.of(
                new AirportDTO("API.9d59723c-efc5-448a-bc81-cf31e2fcf83c","CMB","Bandaranayaka International Airport","Katunayaka","Sri Lanka"),
                new AirportDTO("KLH","CMB","Koggala National Airport","Koggala","Sri Lanka"),
                new AirportDTO("MLH","CMB","Mattala International Airport","Hambantota","Sri Lanka"),
                new AirportDTO("RLH","CMB","Rathmalana National Airport","Rathmalana","Sri Lanka")
        );
        return airportList;
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
