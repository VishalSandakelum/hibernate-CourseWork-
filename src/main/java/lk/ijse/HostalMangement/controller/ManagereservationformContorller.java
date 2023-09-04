package lk.ijse.HostalMangement.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import lk.ijse.HostalMangement.bo.BoFactory;
import lk.ijse.HostalMangement.bo.custom.ReservationBo;
import lk.ijse.HostalMangement.dto.ReservationDTO;
import lk.ijse.HostalMangement.dto.RoomDTO;
import lk.ijse.HostalMangement.dto.StudentDTO;

import java.net.URL;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ManagereservationformContorller implements Initializable {
    public Button tableopenbtn;
    public Button homepagebtn;
    public JFXTextField reservationidtxt;
    public JFXTextField studentidtxt;
    public JFXTextField roomtypeidtxt;
    public DatePicker datetxt;
    public Button savebtn;
    public Button updatebtn;
    public Button deletebtn;
    public JFXComboBox <String>statustxt;

    private List<String> dataList = new ArrayList<>();

    private ReservationBo reservationBo = BoFactory.getBoFactory().getBo(BoFactory.BoType.RESERVATION);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setDataForComboBox();
    }

    @FXML
    private void tableopenbtnonAction(ActionEvent actionEvent) {

    }

    @FXML
    private void homepagebtnonAction(ActionEvent actionEvent) {

    }

    @FXML
    private void savebtnonAction(ActionEvent actionEvent) {
        ReservationDTO reservationDTO = new ReservationDTO();
        StudentDTO studentDTO = new StudentDTO();
        RoomDTO roomDTO = new RoomDTO();

        StudentDTO student = reservationBo.GetStudentName(studentidtxt.getText());
        RoomDTO room = reservationBo.GetKeyMoney(roomtypeidtxt.getText());

        studentDTO.setStudentId(studentidtxt.getText());
        roomDTO.setRoomTypeId(roomtypeidtxt.getText());

        java.time.LocalDate selectedDate = datetxt.getValue();

        reservationDTO.setReservationId(reservationidtxt.getText());
        reservationDTO.setStudent(studentDTO.ToEntity());
        reservationDTO.setRoom(roomDTO.ToEntity());
        reservationDTO.setLastDate(selectedDate.toString());
        reservationDTO.setStatus(statustxt.getValue());
        reservationDTO.setStudentName(student.getFullName().getFirstName());
        reservationDTO.setKeyMoney(room.getKeyMoney());

        String save = reservationBo.SaveReservationDetails(reservationDTO);

        if(save!=("-1")){
            showAlert("Reservation Management"
                    , "Successfully Saved Reservation Details !"
                    , SelectType.INFORMATION);
            setDefault();
        }else{
            setDefault();
            showAlert("Reservation Management"
                    , "Something Wrong !" + "\n" + "Duplicate ID Entry"
                    , SelectType.WARNING);
        }
    }

    @FXML
    private void updatebtnonAction(ActionEvent actionEvent) {
        ReservationDTO reservationDTO = new ReservationDTO();
        StudentDTO studentDTO = new StudentDTO();
        RoomDTO roomDTO = new RoomDTO();

        StudentDTO student = reservationBo.GetStudentName(studentidtxt.getText());
        RoomDTO room = reservationBo.GetKeyMoney(roomtypeidtxt.getText());

        studentDTO.setStudentId(studentidtxt.getText());
        roomDTO.setRoomTypeId(roomtypeidtxt.getText());

        java.time.LocalDate selectedDate = datetxt.getValue();

        reservationDTO.setReservationId(reservationidtxt.getText());
        reservationDTO.setStudent(studentDTO.ToEntity());
        reservationDTO.setRoom(roomDTO.ToEntity());
        reservationDTO.setLastDate(selectedDate.toString());
        reservationDTO.setStatus(statustxt.getValue());
        reservationDTO.setOrderDateTime(Timestamp.valueOf(getCurrentDateTime()));
        reservationDTO.setStudentName(student.getFullName().getFirstName());
        reservationDTO.setKeyMoney(room.getKeyMoney());

        boolean update = reservationBo.UpdateReservationDetails(reservationDTO);

        if(update){
            showAlert("Reservation Management"
                    , "Successfully Updated Reservation Details !"
                    , SelectType.INFORMATION);
            setDefault();
        }else{
            setDefault();
            showAlert("Reservation Management"
                    , "Something Wrong !"
                    , SelectType.ERROR);
        }
        reservationidtxt.setDisable(false);
    }

    @FXML
    private void deletebtnonAction(ActionEvent actionEvent) {
        ReservationDTO reservationDTO = new ReservationDTO();
        StudentDTO studentDTO = new StudentDTO();
        RoomDTO roomDTO = new RoomDTO();

        studentDTO.setStudentId(studentidtxt.getText());
        roomDTO.setRoomTypeId(roomtypeidtxt.getText());

        java.time.LocalDate selectedDate = datetxt.getValue();

        reservationDTO.setReservationId(reservationidtxt.getText());
        reservationDTO.setStudent(studentDTO.ToEntity());
        reservationDTO.setRoom(roomDTO.ToEntity());
        reservationDTO.setLastDate(selectedDate.toString());
        reservationDTO.setStatus(statustxt.getValue());

        boolean update = reservationBo.DeleteReservationDetails(reservationDTO);

        if(update){
            showAlert("Reservation Management"
                    , "Successfully Deleted Reservation Details !"
                    , SelectType.INFORMATION);
            setDefault();
        }else{
            setDefault();
            showAlert("Reservation Management"
                    , "Something Wrong !"
                    , SelectType.ERROR);
        }
        reservationidtxt.setDisable(false);
    }

    @FXML
    private void reservationudtxtonAction(ActionEvent actionEvent) {
        try{
            if(reservationidtxt.getText()!=null&reservationidtxt.getText()!=("")){
                try{
                    ReservationDTO reserversiondetails = reservationBo.getReservationDetails(reservationidtxt.getText());
                    studentidtxt.setText(reserversiondetails.getStudent().getStudentId());
                    roomtypeidtxt.setText(reserversiondetails.getRoom().getRoomTypeId());
                    datetxt.setValue(LocalDate.parse(reserversiondetails.getLastDate()));
                    statustxt.setValue(reserversiondetails.getStatus());

                    reservationidtxt.setDisable(true);
                }catch (Exception e){
                    setDefault();
                    showAlert("Reservation Management"
                            , "Something Wrong !"+"\n"+"Please Check & Enter Valid Reservation ID."
                            , SelectType.ERROR);
                }
            }
        }catch (Exception e){
            throw e;
        }
    }

    private void setDataForComboBox(){
        dataList.add("PEID");
        dataList.add("PENDING");

        ObservableList<String>observableList = FXCollections.observableArrayList(dataList);
        statustxt.setItems(observableList);
        dataList.clear();
    }

    private void setDefault(){
        reservationidtxt.clear();
        studentidtxt.clear();
        datetxt.setValue(null);
        roomtypeidtxt.clear();
        statustxt.setValue(null);
    }

    private void showAlert(String title, String content, SelectType type) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        if(type== SelectType.INFORMATION){
            alert = new Alert(Alert.AlertType.INFORMATION);
        }else if(type== SelectType.WARNING){
            alert = new Alert(Alert.AlertType.WARNING);
        }else if(type== SelectType.ERROR){
            alert = new Alert(Alert.AlertType.ERROR);
        }

        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);

        alert.showAndWait();
    }

    private enum SelectType{
        INFORMATION,WARNING,ERROR
    }

    private String getCurrentDateTime(){
        String formattedTimestamp;

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return (formattedTimestamp = dateFormat.format(timestamp));
    }

}
