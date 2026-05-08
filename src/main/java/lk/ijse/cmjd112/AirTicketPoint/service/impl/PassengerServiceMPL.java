package lk.ijse.cmjd112.AirTicketPoint.service.impl;

import lk.ijse.cmjd112.AirTicketPoint.dto.PassengerDTO;
import lk.ijse.cmjd112.AirTicketPoint.service.PassengerService;
import lk.ijse.cmjd112.AirTicketPoint.util.IDGenerator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerServiceMPL implements PassengerService {
    @Override
    public PassengerDTO savePassenger(PassengerDTO passengerDTO) {
        passengerDTO.setPassengerId(IDGenerator.passengerIDGen());
        System.out.println("Passenger is: " + passengerDTO);
        return passengerDTO;
    }

    @Override
    public PassengerDTO getSelectedPassenger(String passengerId) {
        System.out.println("Passenger Id is: " + passengerId);
        return new PassengerDTO(passengerId,
                "Nimal",
                "Perera",
                30,
                "Male",
                "0711234567",
                "12A",
                "BKG001");
    }

    @Override
    public List<PassengerDTO> getAllPassengers() {
        return List.of(
                new PassengerDTO("PSG001", "Amal", "Perera", 28, "Male", "0719876543", "1A", "BKG001"),
                new PassengerDTO("PSG002", "Saman", "Fernando", 35, "Male", "0717654321", "2B", "BKG002"),
                new PassengerDTO("PSG003", "Kumari", "Silva", 24, "Female", "0715551234", "3C", "BKG003")
        );
    }

    @Override
    public void deletePassenger(String passengerId) {
        System.out.println("Deleted Passenger Id is: " + passengerId);
    }

    @Override
    public void updatePassenger(String passengerId, PassengerDTO passengerDTO) {
        passengerDTO.setPassengerId(passengerId);
        System.out.println("Passenger Id is: " + passengerId);
        System.out.println("Updated passenger is: " + passengerDTO);
    }
}
