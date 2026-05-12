package lk.ijse.cmjd112.AirTicketPoint.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.cmjd112.AirTicketPoint.Dao.UserDao;
import lk.ijse.cmjd112.AirTicketPoint.dto.Role;
import lk.ijse.cmjd112.AirTicketPoint.dto.UserDTO;
import lk.ijse.cmjd112.AirTicketPoint.exception.DataNotFoundException;
import lk.ijse.cmjd112.AirTicketPoint.service.UserService;
import lk.ijse.cmjd112.AirTicketPoint.util.IDGenerator;
import lk.ijse.cmjd112.AirTicketPoint.util.MappingDTOEntity;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceMPL implements UserService {

    private final UserDao userDao;
    private final MappingDTOEntity mappingDTOEntity;
    @Override
    public void saveUser(UserDTO userDTO) {
        userDTO.setuserId(IDGenerator.userIDGen());
        userDao.save(mappingDTOEntity.touser(userDTO));

    }

    public UserDTO getSelectedUser(String userId){
       var foundUser=userDao.findById(userId).orElseThrow(()->new DataNotFoundException("User Not Found"));
       return mappingDTOEntity.touserDTO(foundUser);

    }
    
    @Override
    public List<UserDTO> getAllUsers() {
       return mappingDTOEntity.getUserDTOList(userDao.findAll());

    }

    @Override
    public void deleteUser(String userId) {
      userDao.findById(userId).orElseThrow(()->new DataNotFoundException("user not Found"));
      userDao.deleteById(userId);

    }

    @Override
    public void updateUser(String userId, UserDTO userDTO) {
        var founduser=userDao.findById(userId).orElseThrow(()->new DataNotFoundException("Data Not Found"));

        founduser.setEmail(userDTO.getEmail());
        founduser.setRole(userDTO.getRole());
        founduser.setFirstName(userDTO.getFirstName());
        founduser.setLastname(userDTO.getLastname());
        
        userDao.save(founduser);
    }
}
