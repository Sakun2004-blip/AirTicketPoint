package lk.ijse.cmjd112.AirTicketPoint.dto;
// cSpell:ignore ijse cmjd cmjd112

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
    private String lastName;
    private String email;
    private String password;
    private Role role;


    public void setUserId(String s) {
        this.userId = s;
    }
}
