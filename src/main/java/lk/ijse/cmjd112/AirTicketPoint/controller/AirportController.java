package lk.ijse.cmjd112.AirTicketPoint.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Airport")
public class AirportController {
    @GetMapping
    public String Airport(){
        return "Airport Controller";
    }
}
