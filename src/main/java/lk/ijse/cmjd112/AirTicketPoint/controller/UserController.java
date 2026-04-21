package lk.ijse.cmjd112.AirTicketPoint.controller;

import lk.ijse.cmjd112.AirTicketPoint.dto.Role;
import lk.ijse.cmjd112.AirTicketPoint.dto.UserDTO;
import lk.ijse.cmjd112.AirTicketPoint.util.IDGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Users")
public class UserController {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO user) {
        user.setUser_Id(IDGenerator.userIDGen());
        System.out.println("User is:" + user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> getSelectedUser(@PathVariable("id") String User_Id) {
        System.out.println("User Id is:" + User_Id);
        var UserDTO = new UserDTO(User_Id, "Kamal", "Silva", "kamal@gmail.com", "kamal55", Role.ADMIN);
        return new ResponseEntity<>(UserDTO, HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> allUsers = List.of(
                new UserDTO("KLH.9d59723c-efc5-448a-bc81-cf31e2fcf83c", "Amal", "Perera", "amalperera@gamil.com", "Amal555", Role.ADMIN),
                new UserDTO("MLH.9d59723c-efc5-448a-bc81-cf31e2fcf83c", "Nimal", "Perera", "nimalperera@gamil.com", "Nimal555", Role.ADMIN),
                new UserDTO("GLH.9d59723c-efc5-448a-bc81-cf31e2fcf83c", "Sunimal", "Perera", "sunimalperera@gamil.com", "Sunimal555", Role.USER),
                new UserDTO("KLH.9d59723c-efc5-448a-bc81-cf31e2fcf83c", "Bimal", "Perera", "bimalperera@gamil.com", "bimal555", Role.USER)

        );
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") String User_Id) {
        System.out.println("Deleted User Id is:" + User_Id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void>updateUser(@PathVariable ("id")String User_Id,@RequestBody UserDTO UpdateUser){
        System.out.println("User Id is:"+User_Id);
        System.out.println("Updated user is:"+UpdateUser);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);


    }

}

