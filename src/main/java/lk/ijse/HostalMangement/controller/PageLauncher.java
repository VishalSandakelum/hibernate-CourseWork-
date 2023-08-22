package lk.ijse.HostalMangement.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class PageLauncher {

    private PageLauncher() {
    }

    private PageLauncher(String path , Button btn){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(path));
        Parent root1 = null;
        try {
            root1 = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();

        Stage currentStage = (Stage) btn.getScene().getWindow();
        currentStage.close();
    }

    public static void LauncherPage(String path , Button btn){
        new PageLauncher(path,btn);
    }

}
