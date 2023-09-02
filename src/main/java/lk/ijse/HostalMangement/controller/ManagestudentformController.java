package lk.ijse.HostalMangement.controller;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import lk.ijse.HostalMangement.bo.BoFactory;
import lk.ijse.HostalMangement.bo.custom.StudentBo;
import lk.ijse.HostalMangement.dto.StudentDTO;
import lk.ijse.HostalMangement.embedded.Name;

import java.io.IOException;

public class ManagestudentformController {
    public Button tableopenbtn;
    public Button homepagebtn;
    public JFXTextField studentIdtxt;
    public JFXTextField studentFirstNametxt;
    public JFXTextField studentLastNametxt;
    public JFXTextField contactNumbertxt;
    public JFXCheckBox malecheck;
    public JFXCheckBox femelcheck;
    public DatePicker dobtxt;
    public Button savebtn;
    public Button updatebtn;
    public Button deletebtn;
    public JFXTextField adresstxt;

    @FXML
    private void tableopenbtnonAction(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/managestudentdetailtableform.fxml"));
        Parent root1 = null;
        try {
            root1 = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(root1));
        Stage currentStage = (Stage) tableopenbtn.getScene().getWindow();
        //System.out.println(currentStage.getY());
        stage.setY(currentStage.getY()+80);
        stage.setX(currentStage.getX()+80);

        stage.show();


        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1.20), root1);
        translateTransition.setToX(10);

        translateTransition.play();
    }

    @FXML
    private void homepagebtnonAction(ActionEvent actionEvent) {

        Stage currentStage = (Stage) homepagebtn.getScene().getWindow();
        double yaxics = currentStage.getY()+50;
        double xaxics = currentStage.getX()+50;

        double middleY = currentStage.getY() + currentStage.getHeight() / 2;
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1.2), currentStage.getScene().getRoot());
        translateTransition.setToY(middleY);
        translateTransition.setOnFinished(event -> currentStage.close());
        translateTransition.play();

        new Thread() {
            public void run() {
                try {
                    Thread.sleep(1150);
                    Platform.runLater(() -> {
                        try {
                            PageLauncher.OpenPageWithLocation("/view/homepageform.fxml",yaxics,xaxics);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
                } catch (Exception e) {
                }
            }
        }.start();

    }

    @FXML
    private void malecheckBoxonAction(ActionEvent actionEvent) {

    }

    @FXML
    private void femekcheckBoxonAction(ActionEvent actionEvent) {

    }

    @FXML
    private void savebtnonaction(ActionEvent actionEvent) {
        StudentDTO student = new StudentDTO();
        Name fullname = new Name();

        fullname.setFirstName(studentFirstNametxt.getText());
        fullname.setLastName(studentLastNametxt.getText());

        java.time.LocalDate selectedDate = dobtxt.getValue();

        student.setStudentId(studentIdtxt.getText());
        student.setFullName(fullname);
        student.setAddress(adresstxt.getText());
        student.setContactNumber(contactNumbertxt.getText());
        student.setDateOfBirth(selectedDate.toString());
        student.setGender("Male");

        StudentBo studentBo = BoFactory.getBoFactory().getBo(BoFactory.BoType.STUDENT);
        String saveId = studentBo.SaveStudent(student);
    }

    @FXML
    private void updatebtnonAction(ActionEvent actionEvent) {

    }

    @FXML
    private void deletebtnonAction(ActionEvent actionEvent) {

    }
}
