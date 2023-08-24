package lk.ijse.HostalMangement.controller;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;

public class ManagestudentdetailtableformController {
    public Button tableclosebtn;

    public void tableclosebtnonAction(ActionEvent actionEvent) {
        Stage currentStage = (Stage) tableclosebtn.getScene().getWindow();

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1.20), currentStage.getScene().getRoot());
        translateTransition.setToX(-currentStage.getWidth());

        translateTransition.setOnFinished(event -> currentStage.close());

        translateTransition.play();
    }
}
