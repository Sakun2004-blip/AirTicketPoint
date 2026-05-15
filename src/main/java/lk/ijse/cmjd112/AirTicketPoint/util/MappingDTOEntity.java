package lk.ijse.cmjd112.AirTicketPoint.util;

import lk.ijse.cmjd112.AirTicketPoint.dto.AirportDTO;
import lk.ijse.cmjd112.AirTicketPoint.dto.BookingDTO;
import lk.ijse.cmjd112.AirTicketPoint.dto.FlightDTO;
import lk.ijse.cmjd112.AirTicketPoint.dto.UserDTO;
import lk.ijse.cmjd112.AirTicketPoint.entities.Airport;
import lk.ijse.cmjd112.AirTicketPoint.entities.Bookings;
import lk.ijse.cmjd112.AirTicketPoint.entities.Flight;
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
    public List<UserDTO> getUserDTOList(List<User> users){
        return modelMapper.map(users, new TypeToken<List<UserDTO>>(){}.getType());
    }

    //Bookings
    public BookingDTO tobookingDTO(Bookings bookings){
        return modelMapper.map(bookings, BookingDTO.class);
    }
    public Bookings tobooking(BookingDTO bookingDTO){
        return modelMapper.map(bookingDTO, Bookings.class);
    }
    public List<BookingDTO> getbookingsDTOList(List<Bookings> bookings){
        return modelMapper.map(bookings, new TypeToken<List<BookingDTO>>(){}.getType());
    }

    //Flight
    public FlightDTO toflightDTO(Flight flight){
        return modelMapper.map(flight, FlightDTO.class);
    }
    public Flight toflight(FlightDTO flightDTO){
        return modelMapper.map(flightDTO, Flight.class);
    }
    public List<BookingDTO> getflightDTOList(List<Flight> flight){
        return modelMapper.map(flight, new TypeToken<List<FlightDTO>>(){}.getType());
    }
}
