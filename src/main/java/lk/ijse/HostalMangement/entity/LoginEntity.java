package lk.ijse.HostalMangement.entity;

import lk.ijse.HostalMangement.dto.LoginDTO;

import javax.persistence.*;

@Entity
@Table(name = "login")
public class LoginEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    @Column(name = "username",length = 50)
    private String UserName;
    @Column(name = "password",nullable = false, length = 50)
    private String Password;

    public LoginEntity() {
    }

    public LoginEntity(int id, String userName, String password) {
        this.id = id;
        UserName = userName;
        Password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public LoginDTO ToDTO() {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUserName(this.UserName);
        loginDTO.setPassword(this.Password);
        return loginDTO;
    }
}
