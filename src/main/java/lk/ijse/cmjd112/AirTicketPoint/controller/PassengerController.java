package lk.ijse.cmjd112.AirTicketPoint.controller;

import lk.ijse.cmjd112.AirTicketPoint.dto.PassengerDTO;
import lk.ijse.cmjd112.AirTicketPoint.service.PassengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passengers")
@RequiredArgsConstructor
public class PassengerController {
    private final PassengerService passengerService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PassengerDTO> savePassenger(@RequestBody PassengerDTO passengerDTO) {
        var savedPassenger = passengerService.savePassenger(passengerDTO);
        return new ResponseEntity<>(savedPassenger, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{passengerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PassengerDTO> getPassenger(@PathVariable("passengerId") String passengerId) {
        return new ResponseEntity<>(passengerService.getSelectedPassenger(passengerId), HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PassengerDTO>> getAllPassengers() {
        return new ResponseEntity<>(passengerService.getAllPassengers(), HttpStatus.OK);
    }

    @DeleteMapping("/{passengerId}")
    public ResponseEntity<Void> deletePassenger(@PathVariable("passengerId") String passengerId) {
        passengerService.deletePassenger(passengerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping(value = "/{passengerId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updatePassenger(@PathVariable("passengerId") String passengerId,
                                                @RequestBody PassengerDTO passengerDTO) {
        passengerService.updatePassenger(passengerId, passengerDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
