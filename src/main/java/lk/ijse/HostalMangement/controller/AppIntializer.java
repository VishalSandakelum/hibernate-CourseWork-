package lk.ijse.HostalMangement.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppIntializer extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent parent =  FXMLLoader.load(getClass().getResource("/view/loginpageform.fxml"));
        stage.setScene(new Scene(parent));
        stage.setTitle("Loginpage");
        stage.centerOnScreen();
        stage.show();
    }
}
