package lk.ijse.cmjd112.AirTicketPoint.controller;

import lk.ijse.cmjd112.AirTicketPoint.dto.PlayGroundObjDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/PlayGround")
public class PlayGroundController {
    @PostMapping("/{path}")
    public void getPathVariable( @PathVariable("path")String pathvariable){
        System.out.println("Path Variable is "+pathvariable);
    }
    @PostMapping
    public void getQueryParams(@RequestParam String name, @RequestParam String city){
        System.out.println("ParamOne : "+name);
        System.out.println("ParamTwo : "+city);
    }

    @PostMapping("/Headers")
    public void getCustomerHeaderData(@RequestHeader("X-Province") String HeaderOne,@RequestHeader ("X-MainCity") String HeaderTwo){
        System.out.println("HeaderOne : "+HeaderOne);
        System.out.println("HeaderTwo : "+HeaderTwo);
    }

    @PostMapping("/RequestBody")
    public void getRequestBodyData(@RequestBody String Level){
        System.out.println("Level is "+Level);

    }

    @PostMapping(value = "/Play",consumes = "application/json",produces = MediaType.APPLICATION_JSON_VALUE)
    public PlayGroundObjDTO handlePlayGround(@RequestBody PlayGroundObjDTO playGroundObj){
            System.out.println("PlayGround is :"+playGroundObj);
            return playGroundObj;
    }

    @PostMapping(value = "/formal",consumes = "application/json",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlayGroundObjDTO>handlePlayGroundFormal(@RequestBody PlayGroundObjDTO playGroundObj){
        System.out.println("PlayGround is :"+playGroundObj);
        return new ResponseEntity<>(playGroundObj, HttpStatus.CREATED);
    }

}
