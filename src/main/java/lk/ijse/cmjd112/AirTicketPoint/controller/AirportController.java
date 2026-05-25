package lk.ijse.cmjd112.AirTicketPoint.controller;

import lk.ijse.cmjd112.AirTicketPoint.dto.AirportDTO;
import lk.ijse.cmjd112.AirTicketPoint.service.AirportService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Airport")
@RequiredArgsConstructor
public class AirportController {
    //Field Injection
    //@Autowired
   //private AirportService airportService;

    private final AirportService airportService;
    //Constructor injection=support with lombok=@RequiredArgsConstructor
    //public AirportController(AirportService airportService){
    //   this.airportService=airportService;
    //}

     //Create an Airport

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveAirport(@RequestBody AirportDTO airportDTO){
        airportService.saveAirport(airportDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/{airportId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AirportDTO> getAirport(@PathVariable("airportId") String airportIdentifier){
        return new ResponseEntity<>(airportService.getSelectedAirport(airportIdentifier),HttpStatus.OK);


    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AirportDTO>> getAllAirports(){
        return new ResponseEntity<>(airportService.getAllAirports(),HttpStatus.OK);

    }

    @DeleteMapping(value = "/{airportId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteAirportData(@PathVariable("airportId") String airportIdentifier){
        try {
            airportService.deleteAirport(airportIdentifier);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping(value = "/{airportID}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateAirportData(@PathVariable ("airportID") String airportIdentifier,@RequestBody AirportDTO updatedairport){
        airportService.updateAirport(airportIdentifier,updatedairport);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
