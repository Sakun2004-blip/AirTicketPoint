package lk.ijse.cmjd112.AirTicketPoint.util;

import lk.ijse.cmjd112.AirTicketPoint.dto.AirportDTO;
import lk.ijse.cmjd112.AirTicketPoint.entities.Airport;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MappingDTOEntity {

    private final ModelMapper modelMapper;

    //Airport
    public AirportDTO toAirportDTO(Airport airport){
        return modelMapper.map(airport, AirportDTO.class);
    }
    public Airport toAirportEntity(AirportDTO airportDTO){
        return modelMapper.map(airportDTO, Airport.class);
    }
    public List<AirportDTO> getAirportDTO(List<Airport> airport){
        return modelMapper.map(airport, new TypeToken<List<AirportDTO>>(){}.getType());
    }
}
