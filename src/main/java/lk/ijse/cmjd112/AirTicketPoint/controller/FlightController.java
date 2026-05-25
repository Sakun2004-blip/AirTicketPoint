package lk.ijse.cmjd112.AirTicketPoint.controller;

// cSpell:ignore ijse cmjd cmjd112

import lk.ijse.cmjd112.AirTicketPoint.dto.FlightDTO;
import lk.ijse.cmjd112.AirTicketPoint.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
@RequiredArgsConstructor
public class FlightController {
    private final FlightService flightService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FlightDTO> saveFlight(@RequestBody FlightDTO flightDTO) {
        FlightDTO savedFlight = flightService.saveFlight(flightDTO);
        return new ResponseEntity<>(savedFlight, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{flightId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FlightDTO> getFlight(@PathVariable("flightId") String flightId) {
        return new ResponseEntity<>(flightService.getSelectedFlight(flightId), HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FlightDTO>> getAllFlights() {
        return new ResponseEntity<>(flightService.getAllFlights(), HttpStatus.OK);
    }

    @DeleteMapping("/{flightId}")
    public ResponseEntity<Void> deleteFlight(@PathVariable("flightId") String flightId) {
        flightService.deleteFlight(flightId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping(value = "/{flightId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateFlight(@PathVariable("flightId") String flightId, @RequestBody FlightDTO flightDTO) {
        flightService.updateFlight(flightId, flightDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
