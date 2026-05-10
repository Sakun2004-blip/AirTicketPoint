package lk.ijse.cmjd112.AirTicketPoint.controller;

import lk.ijse.cmjd112.AirTicketPoint.dto.AirportDTO;
import lk.ijse.cmjd112.AirTicketPoint.service.AirportService;
import lk.ijse.cmjd112.AirTicketPoint.service.impl.AirportServiceMPL;
import lk.ijse.cmjd112.AirTicketPoint.util.IDGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<AirportDTO> saveAirport(@RequestBody AirportDTO airportDTO){
      // var airportServiceMPL=new AirportServiceMPL();
       var savedAirport=airportService.saveAirport(airportDTO);
       return new ResponseEntity<>(savedAirport,HttpStatus.CREATED);
    }

    @GetMapping(value = "/{airportId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AirportDTO> getAirport(@PathVariable("airportId") String airportIdentifier){
        return new ResponseEntity<>(airportService.getSelectedAirport(airportIdentifier),HttpStatus.OK);


    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AirportDTO>> getAllAirports(){
        return new ResponseEntity<>(airportService.getAllAirports(),HttpStatus.OK);

    }

    @DeleteMapping("/{airportID}")
    public ResponseEntity<Void>deleteAirportData(@PathVariable("airportID") String airportIdentifier){
        airportService.deleteAirport(airportIdentifier);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping(value = "/{airportID}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateAirportData(@PathVariable ("airportID") String airportIdentifier,@RequestBody AirportDTO updatedairport){
        airportService.updateAirport(airportIdentifier,updatedairport);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
