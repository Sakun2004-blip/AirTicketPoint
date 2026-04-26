package lk.ijse.cmjd112.AirTicketPoint.controller;

import lk.ijse.cmjd112.AirTicketPoint.dto.Role;
import lk.ijse.cmjd112.AirTicketPoint.dto.UserDTO;
import lk.ijse.cmjd112.AirTicketPoint.service.UserService;
import lk.ijse.cmjd112.AirTicketPoint.util.IDGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> getSelectedUser(@PathVariable("id") String User_Id) {
        return new ResponseEntity<>(userService.getSelectedUser(User_Id), HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") String userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void>updateUser(@PathVariable ("id")String userId,@RequestBody UserDTO UpdateUser){
        userService.updateUser(userId,UpdateUser);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);


    }

}

