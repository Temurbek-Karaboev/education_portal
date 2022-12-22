package org.example;

import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.example.entity.DataSingleton;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URL;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private Stage stage;
    private Scene scene;



    @FXML
    public Button login_button;

    @FXML
    public Button registerButton;

    @FXML
    public TextField login;

    @FXML
    public PasswordField password;

    DataSingleton data = DataSingleton.getInstance();


    @FXML
    public void loginSubmitClick(MouseEvent event) throws SQLException, IOException {
        Queries queries = new Queries();
        String result = queries.checkUser(login.getText(), password.getText());
        if(result.equals("admin")){
            stage.setUserData(login.getText());
            data.setUsername(login.getText());
            FXMLLoader loader = new FXMLLoader();
            URL xmlUrl = getClass().getResource("/xml/chat.fxml");
            loader.setLocation(xmlUrl);
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.show();
        } else if (result.equals("user")) {
            data.setUsername(login.getText());
            FXMLLoader loader = new FXMLLoader();
            URL xmlUrl = getClass().getResource("/xml/menu.fxml");
            loader.setLocation(xmlUrl);
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(scene);
            appStage.show();
        }
        else {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setContentText("Username or Password is incorrect");
            errorAlert.showAndWait();
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



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)  {

    };

    @FXML
    public void toRegisterPage(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        URL xmlUrl = getClass().getResource("/xml/register.fxml");
        loader.setLocation(xmlUrl);
        Parent root = loader.load();

        Scene scene = new Scene(root);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();

    }
}
