package lk.ijse.cmjd112.AirTicketPoint.service.impl;

import lk.ijse.cmjd112.AirTicketPoint.dto.Role;
import lk.ijse.cmjd112.AirTicketPoint.dto.UserDTO;
import lk.ijse.cmjd112.AirTicketPoint.service.UserService;
import lk.ijse.cmjd112.AirTicketPoint.util.IDGenerator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceMPL implements UserService {
    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        userDTO.setuserId(IDGenerator.userIDGen());
        System.out.println("User is:" + userDTO);
        return userDTO;
    }

    public UserDTO getSelectedUser(String userId){
        System.out.println("User Id is:" + userId);
        var userDTO = new UserDTO(userId, "Kamal", "Silva", "kamal@gmail.com", "kamal55", Role.ADMIN);

        return userDTO;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return  List.of(
                new UserDTO("KLH.9d59723c-efc5-448a-bc81-cf31e2fcf83c", "Amal", "Perera", "amalperera@gamil.com", "Amal555", Role.ADMIN),
                new UserDTO("MLH.9d59723c-efc5-448a-bc81-cf31e2fcf83c", "Nimal", "Perera", "nimalperera@gamil.com", "Nimal555", Role.ADMIN),
                new UserDTO("GLH.9d59723c-efc5-448a-bc81-cf31e2fcf83c", "Sunimal", "Perera", "sunimalperera@gamil.com", "Sunimal555", Role.USER),
                new UserDTO("KLH.9d59723c-efc5-448a-bc81-cf31e2fcf83c", "Bimal", "Perera", "bimalperera@gamil.com", "bimal555", Role.USER)

        );

    }

    @Override
    public void deleteUser(String userId) {
        System.out.println("Deleted User Id is:" + userId);

    }

    @Override
    public void updateUser(String userId, UserDTO userDTO) {
        userDTO.setuserId(userId);
        System.out.println("User Id is: " + userId);
        System.out.println("Updated user is: " + userDTO);

    }
}
