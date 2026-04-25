package lk.ijse.cmjd112.AirTicketPoint.controller;

import lk.ijse.cmjd112.AirTicketPoint.dto.AirportDTO;
import lk.ijse.cmjd112.AirTicketPoint.util.IDGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Airport")
public class AirportController {
     //Create an Airport

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AirportDTO> saveAirport(@RequestBody AirportDTO airportDTO){
        airportDTO.setAirportID(IDGenerator.airportIDGen());
        System.out.println("Airport is :"+airportDTO);
        return new ResponseEntity<>(airportDTO, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{airportId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AirportDTO>getAirport(@PathVariable("airportId") String airportIdentifier){
        System.out.println("Airport ID is"+airportIdentifier);
        var airport=new AirportDTO("API.9d59723c-efc5-448a-bc81-cf31e2fcf83c",
                "CMB","Bandaranayaka International Airport","Katunayaka","Sri Lanka");

        return new ResponseEntity<>(airport,HttpStatus.OK);


    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AirportDTO>>getAllAirports(){
        List<AirportDTO>airportList=List.of(new AirportDTO("API.9d59723c-efc5-448a-bc81-cf31e2fcf83c","CMB","Bandaranayaka International Airport","Katunayaka","Sri Lanka"),
        new AirportDTO("KLH","CMB","Koggala National Airport","Koggala","Sri Lanka"),
        new AirportDTO("MLH","CMB","Mattala International Airport","Hambantota","Sri Lanka"),
        new AirportDTO("RLH","CMB","Rathmalana National Airport","Rathmalana","Sri Lanka"));
        return new ResponseEntity<>(airportList,HttpStatus.OK);
    }

    @DeleteMapping("/{airportID}")
    public ResponseEntity<Void>deleteAirportData(@PathVariable("airportID") String airportIdentifier){
        System.out.println("Deleted Airport:"+airportIdentifier);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping(value = "/{airportID}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateAirportData(@PathVariable ("airportID") String airportIdentifier,@RequestBody AirportDTO updatedairport){
        updatedairport.setAirportID(airportIdentifier);
        System.out.println("Update Airport ID:"+airportIdentifier);
        System.out.println("Updated Airport details:"+updatedairport);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
