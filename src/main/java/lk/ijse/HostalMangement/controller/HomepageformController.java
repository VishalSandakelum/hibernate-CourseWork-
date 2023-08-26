package lk.ijse.HostalMangement.controller;

import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class HomepageformController {
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

    public void addstudentbtnonAction(ActionEvent actionEvent) {

    }

    public void addstudentonMouseenterd(MouseEvent mouseEvent) {
        studentpane.setVisible(true);
        new Thread() {
            public void run() {
                try {
                    Thread.sleep(2000);
                    studentpane.setVisible(false);
                } catch (Exception e) {
                }
            }
        }.start();

        BtnAnimatioStart(addstudentbtn);
    }

    public void addroombtnonaction(ActionEvent actionEvent) {

    }

    public void addroomonMouseenterd(MouseEvent mouseEvent) {
        roompane.setVisible(true);
        new Thread() {
            public void run() {
                try {
                    Thread.sleep(2000);
                    roompane.setVisible(false);
                } catch (Exception e) {
                }
            }
        }.start();

        BtnAnimatioStart(addroombtn);
    }

    public void managereservationbtnonAction(ActionEvent actionEvent) {

    }

    public void managereservationonMouseenterd(MouseEvent mouseEvent) {
        reservationpane.setVisible(true);
        new Thread() {
            public void run() {
                try {
                    Thread.sleep(2000);
                    reservationpane.setVisible(false);
                } catch (Exception e) {
                }
            }
        }.start();

        BtnAnimatioStart(managereservationbtn);
    }

    public void addstudentMouseexited(MouseEvent mouseEvent) {
        BtnAnimationStop(addstudentbtn);
    }

    public void addroomMouseexited(MouseEvent mouseEvent) {
        BtnAnimationStop(addroombtn);
    }

    public void managereservationMouseexited(MouseEvent mouseEvent) {
        BtnAnimationStop(managereservationbtn);
    }

    public void paneopenbtnAction(ActionEvent actionEvent) {
        optionpane.setVisible(true);
    }

    public void backbtnonAction(ActionEvent actionEvent) {
        optionpane.setVisible(false);
    }

    public void notificationbtnonAction(ActionEvent actionEvent) {

    }

    public void notificationbtnonMouseenterd(MouseEvent mouseEvent) {
        BtnAnimatioStart(notificationbtn);
    }

    public void availablebtnonAction(ActionEvent actionEvent) {

    }

    public void notificationbtnonMouseexited(MouseEvent mouseEvent) {
        BtnAnimationStop(notificationbtn);
    }

    public void availablebtnonMouseenterd(MouseEvent mouseEvent) {
        BtnAnimatioStart(availablebtn);
    }

    public void availablebtnonMouseexited(MouseEvent mouseEvent) {
        BtnAnimationStop(availablebtn);
    }

    public void seettingbtnonAction(ActionEvent actionEvent) {

    }

    public void settingMouseenterd(MouseEvent mouseEvent) {
        BtnAnimatioStart(seettingbtn);
    }

    public void settingbtnonMouse(MouseEvent mouseEvent) {
        BtnAnimationStop(seettingbtn);
    }

    private void BtnAnimatioStart(Button btn){
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(200), btn);
        scaleTransition.setToX(1.2);
        scaleTransition.setToY(1.2);
        scaleTransition.playFromStart();
    }

    private void BtnAnimationStop(Button btn){
        ScaleTransition reverseScaleTransition = new ScaleTransition(Duration.millis(200), btn);
        reverseScaleTransition.setToX(1.0);
        reverseScaleTransition.setToY(1.0);
        reverseScaleTransition.playFromStart();
    }

}
