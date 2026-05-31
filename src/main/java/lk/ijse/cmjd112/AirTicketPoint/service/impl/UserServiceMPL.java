package lk.ijse.cmjd112.AirTicketPoint.service.impl;
// cSpell:ignore ijse cmjd cmjd112

import jakarta.transaction.Transactional;
import lk.ijse.cmjd112.AirTicketPoint.Dao.UserDao;
import lk.ijse.cmjd112.AirTicketPoint.dto.UserDTO;
import lk.ijse.cmjd112.AirTicketPoint.exception.DataNotFoundException;
import lk.ijse.cmjd112.AirTicketPoint.service.UserService;
import lk.ijse.cmjd112.AirTicketPoint.util.IDGenerator;
import lk.ijse.cmjd112.AirTicketPoint.util.MappingDTOEntity;
import lombok.RequiredArgsConstructor;
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
        userDTO.setUserId(IDGenerator.userIDGen());
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
        var foundUser = userDao.findById(userId).orElseThrow(()->new DataNotFoundException("Data Not Found"));

        foundUser.setEmail(userDTO.getEmail());
        foundUser.setRole(userDTO.getRole());
        foundUser.setFirstName(userDTO.getFirstName());
        foundUser.setLastName(userDTO.getLastName());
        
        userDao.save(foundUser);
    }
}
