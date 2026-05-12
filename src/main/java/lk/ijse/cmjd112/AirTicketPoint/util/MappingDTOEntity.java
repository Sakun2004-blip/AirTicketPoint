package lk.ijse.cmjd112.AirTicketPoint.util;

import lk.ijse.cmjd112.AirTicketPoint.dto.AirportDTO;
import lk.ijse.cmjd112.AirTicketPoint.dto.UserDTO;
import lk.ijse.cmjd112.AirTicketPoint.entities.Airport;
import lk.ijse.cmjd112.AirTicketPoint.entities.User;
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

    //User
    public UserDTO touserDTO(User user){
        return modelMapper.map(user, UserDTO.class);
    }
    public User touser(UserDTO userDTO){
        return modelMapper.map(userDTO, User.class);
    }
    public List<UserDTO> getuserDTO(List<Airport> user){
        return modelMapper.map(user, new TypeToken<List<AirportDTO>>(){}.getType());
    }

}
