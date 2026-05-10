package lk.ijse.cmjd112.AirTicketPoint.controller;

import lk.ijse.cmjd112.AirTicketPoint.dto.ErrorMessage;
import lk.ijse.cmjd112.AirTicketPoint.exception.DataNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static lk.ijse.cmjd112.AirTicketPoint.util.CustomStatus.DATA_NOT_FOUND;

@RestControllerAdvice
public class GlobalExceptionHandler {
    public ResponseEntity<ErrorResponse>handleDataNotFoundException(DataNotFoundException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorMessage(ex.getMessage().DATA_NOT_FOUND));
    }

}
