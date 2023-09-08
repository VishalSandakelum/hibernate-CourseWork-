package lk.ijse.HostalMangement.dto;


import lk.ijse.HostalMangement.entity.LoginEntity;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class LoginDTO {
    private String UserName;
    private String Password;

    public LoginEntity ToEntity(){
        LoginEntity loginEntity = new LoginEntity();
        loginEntity.setUserName(this.UserName);
        loginEntity.setPassword(this.Password);
        return loginEntity;
    }
}
