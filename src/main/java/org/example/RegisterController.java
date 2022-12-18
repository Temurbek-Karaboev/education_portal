package org.example;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    public Button backLogin;

    @FXML
    public TextField fullname;

    @FXML
    public TextField username;

    @FXML
    public TextField password;

    @FXML
    public void toLoginPage(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        URL xmlUrl = getClass().getResource("/xml/login.fxml");
        loader.setLocation(xmlUrl);
        Parent root = loader.load();

        Scene scene = new Scene(root);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    }

    @FXML
    public void registerUser(MouseEvent event) throws SQLException {
        Queries queries = new Queries();
        if (!queries.checkDuplicate(username.getText())){
            queries.addUsers(fullname.getText(), username.getText(), password.getText());
        }
        System.out.println("Prover!");
    }

}
