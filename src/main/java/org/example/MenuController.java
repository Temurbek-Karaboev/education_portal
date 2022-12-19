package org.example;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void LogOut(MouseEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Are you sure?");
        alert.showAndWait();
        if (alert.getResult() == ButtonType.OK){
            FXMLLoader loader = new FXMLLoader();
            URL xmlUrl = getClass().getResource("/xml/login.fxml");
            loader.setLocation(xmlUrl);
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.show();
        }
    }


@FXML
public void goToList(MouseEvent event) throws IOException{
    FXMLLoader loader = new FXMLLoader();
    URL xmlUrl = getClass().getResource("/xml/degree.fxml");
    loader.setLocation(xmlUrl);
    Parent root = loader.load();

    Scene scene = new Scene(root);
    Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    appStage.setScene(scene);
    appStage.show();
}
@FXML
public void goToChat(MouseEvent event) throws IOException{
    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
    errorAlert.setContentText("Support CHAT IS NOT READY FOR NOW, COME IN 2023 year!");
    errorAlert.showAndWait();


//    FXMLLoader loader = new FXMLLoader();
//    URL xmlUrl = getClass().getResource("/xml/degree.fxml");
//    loader.setLocation(xmlUrl);
//    Parent root = loader.load();
//
//    Scene scene = new Scene(root);
//    Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//    appStage.setScene(scene);
//    appStage.show();
}


@FXML
public void goToCabinet(MouseEvent event) throws IOException{
    FXMLLoader loader = new FXMLLoader();
    URL xmlUrl = getClass().getResource("/xml/cabinet.fxml");
    loader.setLocation(xmlUrl);
    Parent root = loader.load();

    Scene scene = new Scene(root);
    Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    appStage.setScene(scene);
    appStage.show();
}

}
