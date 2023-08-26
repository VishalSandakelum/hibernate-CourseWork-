package lk.ijse.HostalMangement.controller;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;

public class ManagestudentformController {
    public Button tableopenbtn;
    public Button homepagebtn;

    public void tableopenbtnonAction(ActionEvent actionEvent) {
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

    public void homepagebtnonAction(ActionEvent actionEvent) {

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
}
