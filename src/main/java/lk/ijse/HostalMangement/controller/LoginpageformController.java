package lk.ijse.HostalMangement.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import lk.ijse.HostalMangement.bo.BoFactory;
import lk.ijse.HostalMangement.bo.custom.LoginBo;
import lk.ijse.HostalMangement.dto.LoginDTO;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class LoginpageformController {
    public Button passwordvisiblebtn;
    public Button passwordhidebtn;
    public JFXTextField usernametxt;
    public JFXPasswordField passwordhidetxt;
    public JFXTextField passwordshowtxt;
    public Button passwordcofirmbtn;

    private static String Username;
    private static String Password;

    private String secretKey = "MySecretKey12345";
    private SecretKey key = new SecretKeySpec(secretKey.getBytes(), "AES");

    private LoginBo loginBo = BoFactory.getBoFactory().getBo(BoFactory.BoType.LOGIN);

    @FXML
    private void passwordvisiblebtnonAction(ActionEvent actionEvent) {
        passwordvisiblebtn.setVisible(false);
        passwordhidebtn.setVisible(true);

        passwordhidetxt.setVisible(false);
        passwordshowtxt.setVisible(true);

        passwordshowtxt.setText(passwordhidetxt.getText());
    }

    @FXML
    private void passwordhidebtnonAction(ActionEvent actionEvent) {
        passwordhidebtn.setVisible(false);
        passwordvisiblebtn.setVisible(true);

        passwordshowtxt.setVisible(false);
        passwordhidetxt.setVisible(true);

        passwordhidetxt.setText(passwordshowtxt.getText());
    }

    @FXML
    private void passwordconfirmbtnonAction(ActionEvent actionEvent) {

    }

    

}
