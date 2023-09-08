package lk.ijse.HostalMangement.controller;

import javafx.animation.ScaleTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import lk.ijse.HostalMangement.bo.BoFactory;
import lk.ijse.HostalMangement.bo.custom.ReservationBo;
import lk.ijse.HostalMangement.dto.ReservationDTO;
import lk.ijse.HostalMangement.entity.ReservationEntity;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class HomepageformController implements Initializable {
    public Pane roompane;
    public Pane studentpane;
    public Pane reservationpane;
    public Button addstudentbtn;
    public Button addroombtn;
    public Button managereservationbtn;
    public Button paneopenbtn;
    public Pane optionpane;
    public Button backbtn;
    public Button notificationbtn;
    public Button availablebtn;
    public Button seettingbtn;
    public TableView tableview;
    public TableColumn reservationidrow;
    public TableColumn roomidrow;
    public TableColumn studentidrow;
    public TableColumn studentnamerow;
    public TableColumn statusrow;
    public TableColumn daterow;
    public Button confirmbtn;
    public Button cancelbtn;

    /*All Action On Here.*/

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            setDataForTable();
            setCellValueFactory();
        }catch(Exception e){}
    }

    @FXML
    private void addstudentbtnonAction(ActionEvent actionEvent) {
        PageLauncher.OpenPageWithAnimation(addstudentbtn,"/view/managestudentform.fxml",0, 0);
    }

    @FXML
    private void addroombtnonaction(ActionEvent actionEvent) {
        PageLauncher.OpenPageWithAnimation(addroombtn,"/view/manageroomform.fxml",0, 0);
    }

    @FXML
    private void managereservationbtnonAction(ActionEvent actionEvent) {
        PageLauncher.OpenPageWithAnimation(managereservationbtn,"/view/managereservationform.fxml",0, 0);
    }

    @FXML
    private void paneopenbtnAction(ActionEvent actionEvent) {
        optionpane.setVisible(true);
    }

    @FXML
    private void backbtnonAction(ActionEvent actionEvent) {
        optionpane.setVisible(false);
    }

    @FXML
    private void notificationbtnonAction(ActionEvent actionEvent) {

    }

    @FXML
    private void availablebtnonAction(ActionEvent actionEvent) {

    }

    @FXML
    private void seettingbtnonAction(ActionEvent actionEvent) {

    }

    /*Mouse Entetrd Action In Here.*/

    @FXML
    private void addstudentonMouseenterd(MouseEvent mouseEvent) {
        studentpane.setVisible(true);
        VisiblePane(studentpane);
        BtnAnimatioStart(addstudentbtn);
    }

    @FXML
    private void addroomonMouseenterd(MouseEvent mouseEvent) {
        roompane.setVisible(true);
        VisiblePane(roompane);
        BtnAnimatioStart(addroombtn);
    }

    @FXML
    private void managereservationonMouseenterd(MouseEvent mouseEvent) {
        reservationpane.setVisible(true);
        VisiblePane(reservationpane);
        BtnAnimatioStart(managereservationbtn);
    }

    @FXML
    private void notificationbtnonMouseenterd(MouseEvent mouseEvent) {
        BtnAnimatioStart(notificationbtn);
    }

    @FXML
    private void availablebtnonMouseenterd(MouseEvent mouseEvent) {
        BtnAnimatioStart(availablebtn);
    }

    @FXML
    private void settingMouseenterd(MouseEvent mouseEvent) {
        BtnAnimatioStart(seettingbtn);
    }

    /*Mouse Exited Action On Here.*/

    @FXML
    private void addstudentMouseexited(MouseEvent mouseEvent) {
        BtnAnimationStop(addstudentbtn);
    }

    @FXML
    private void addroomMouseexited(MouseEvent mouseEvent) {
        BtnAnimationStop(addroombtn);
    }

    @FXML
    private void managereservationMouseexited(MouseEvent mouseEvent) {
        BtnAnimationStop(managereservationbtn);
    }

    @FXML
    private void notificationbtnonMouseexited(MouseEvent mouseEvent) {
        BtnAnimationStop(notificationbtn);
    }

    @FXML
    private void availablebtnonMouseexited(MouseEvent mouseEvent) {
        BtnAnimationStop(availablebtn);
    }

    @FXML
    private void settingbtnonMouse(MouseEvent mouseEvent) {
        BtnAnimationStop(seettingbtn);
    }


    /*Animation Start For Button*/
    private void BtnAnimatioStart(Button btn){
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(200), btn);
        scaleTransition.setToX(1.2);
        scaleTransition.setToY(1.2);
        scaleTransition.playFromStart();
    }

    /*Animation Stop For Button*/
    private void BtnAnimationStop(Button btn){
        ScaleTransition reverseScaleTransition = new ScaleTransition(Duration.millis(200), btn);
        reverseScaleTransition.setToX(1.0);
        reverseScaleTransition.setToY(1.0);
        reverseScaleTransition.playFromStart();
    }

    /*Information Pane Visible When Mouse Enterd*/
    private void VisiblePane(Pane pane) {
        new Thread() {
            public void run() {
                try {
                    Thread.sleep(2000);
                    pane.setVisible(false);
                } catch (Exception e) {
                }
            }
        }.start();
    }

    @FXML
    private void confirmbtnonAction(ActionEvent actionEvent) {

    }

    @FXML
    private void cancelbtnonAction(ActionEvent actionEvent) {

    }

    private void setDataForTable(){
        ReservationBo reservationBo = BoFactory.getBoFactory().getBo(BoFactory.BoType.RESERVATION);

        List<ReservationEntity> reservationEntity = reservationBo.getAllPayDetails();
        ObservableList<ReservationDTO> reservationDTO = FXCollections.observableArrayList();

        for(ReservationEntity reservation : reservationEntity){
            reservationDTO.add(new ReservationDTO(
                    reservation.getReservationId(),
                    reservation.getLastDate(),
                    reservation.getOrderDateTime(),
                    reservation.getStudent(),
                    reservation.getStudent().getStudentId(),
                    reservation.getRoom(),
                    reservation.getRoom().getRoomTypeId(),
                    reservation.getStatus(),
                    reservation.getStudentName(),
                    reservation.getKeyMoney()
            ));
        }
        tableview.setItems(reservationDTO);
    }

    private void setCellValueFactory(){
        reservationidrow.setCellValueFactory(new PropertyValueFactory<>("ReservationId"));
        roomidrow.setCellValueFactory(new PropertyValueFactory<>("RoomTypeID"));
        studentidrow.setCellValueFactory(new PropertyValueFactory<>("StudentID"));
        studentnamerow.setCellValueFactory(new PropertyValueFactory<>("StudentName"));
        statusrow.setCellValueFactory(new PropertyValueFactory<>("Status"));
        daterow.setCellValueFactory(new PropertyValueFactory<>("LastDate"));
    }

}
