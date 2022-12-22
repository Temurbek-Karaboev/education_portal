package org.example.degrees;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.example.Queries;
import org.example.entity.DataSingleton;
import org.example.entity.User;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CabinetController implements Initializable {
    @FXML
    public Label old_fullname;
    @FXML
    public Label old_username;
    @FXML
    public Label old_password;

    @FXML
    public TextField fullname;
    @FXML
    public TextField username;
    @FXML
    public TextField password;

    User user;

    DataSingleton dataSingleton = DataSingleton.getInstance();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Queries queries = new Queries();
        user = new User();
        System.out.println("HERE _____>>>"+dataSingleton.getUsername());
        try {
             user  = queries.getUser(dataSingleton.getUsername());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        old_fullname.setText("Old FullName is : "+user.getFullname());
        old_username.setText("Old Username is : "+user.getUsername());
        old_password.setText("Old Password is : "+user.getPassword());


    }

    @FXML
    public void goToMenu(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        URL xmlUrl = getClass().getResource("/xml/menu.fxml");
        loader.setLocation(xmlUrl);
        Parent root = loader.load();

        Scene scene = new Scene(root);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    }

    @FXML
    public void changeData(MouseEvent event) throws IOException, SQLException {
        if (fullname.getText().isBlank() || username.getText().isBlank() || password.getText().isBlank()) {
            Queries queries = new Queries();
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Fields are Blank ! Fill out them !");
            alert.showAndWait();

            FXMLLoader loader = new FXMLLoader();
            URL xmlUrl = getClass().getResource("/xml/cabinet.fxml");
            loader.setLocation(xmlUrl);
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.show();
        } else {
            Queries queries = new Queries();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Are you sure?");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                queries.deleteUser(dataSingleton.getUsername());
                dataSingleton.setUsername(username.getText());
                queries.addUsers(fullname.getText(), username.getText(), password.getText());

                FXMLLoader loader = new FXMLLoader();
                URL xmlUrl = getClass().getResource("/xml/menu.fxml");
                loader.setLocation(xmlUrl);
                Parent root = loader.load();

                Scene scene = new Scene(root);
                Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                appStage.setScene(scene);
                appStage.show();
            } else {
                FXMLLoader loader = new FXMLLoader();
                URL xmlUrl = getClass().getResource("/xml/menu.fxml");
                loader.setLocation(xmlUrl);
                Parent root = loader.load();

                Scene scene = new Scene(root);
                Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                appStage.setScene(scene);
                appStage.show();
            }
        }
    }
}
