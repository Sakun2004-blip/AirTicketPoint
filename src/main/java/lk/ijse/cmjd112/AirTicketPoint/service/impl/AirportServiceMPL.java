package lk.ijse.cmjd112.AirTicketPoint.service.impl;

import lk.ijse.cmjd112.AirTicketPoint.dto.AirportDTO;
import lk.ijse.cmjd112.AirTicketPoint.service.AirportService;
import lk.ijse.cmjd112.AirTicketPoint.util.IDGenerator;

import java.util.List;

public class AirportServiceMPL implements AirportService {

    @Override
    public AirportDTO saveAirport(AirportDTO airportDTO) {
        airportDTO.setAirportID(IDGenerator.airportIDGen());
        System.out.println("Airport is from service layer:"+airportDTO);
        return airportDTO;
    }

    @Override
    public AirportDTO getSelectedAirport(String airportId) {
           return null;
    }

    @Override
    public List<AirportDTO> getAllAirports() {
       List<AirportDTO>airportList=List.of
                (new AirportDTO("API.9d59723c-efc5-448a-bc81-cf31e2fcf83c","CMB","Bandaranayaka International Airport","Katunayaka","Sri Lanka"),
                new AirportDTO("KLH","CMB","Koggala National Airport","Koggala","Sri Lanka"),
                new AirportDTO("MLH","CMB","Mattala International Airport","Hambantota","Sri Lanka"),
                new AirportDTO("RLH","CMB","Rathmalana National Airport","Rathmalana","Sri Lanka")
        );
        return airportList;
    }

    @Override
    public void deleteAirport(String airportId) {

    }

    @Override
    public void updateAirport(String airportId, AirportDTO airportDTO) {

    }
}
