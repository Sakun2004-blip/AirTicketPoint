package lk.ijse.cmjd112.AirTicketPoint.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO implements Serializable {
    private String userId;
    private String firstName;
    private String lastname;
    private String email;
    private String password;
    private Role role;


    public void setuserId(String s) {
        this.userId=s;
    }
}
