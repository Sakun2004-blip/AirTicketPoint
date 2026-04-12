package lk.ijse.cmjd112.AirTicketPoint.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/healthTest")
public class HealthwithTestAction {

    @GetMapping
    public String healthTest(){
        return "AirTicketPoint is Running";
    }
}

