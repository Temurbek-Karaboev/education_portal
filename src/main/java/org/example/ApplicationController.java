package org.example;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.example.entity.DataSingleton;
import org.example.entity.Faculties;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.ResourceBundle;

public class ApplicationController implements Initializable {
    @FXML
    public TextField fullname;
    @FXML
    public TextField passport;
    @FXML
    public TextField address;
    @FXML
    public TextField phone;

    @FXML
    public ChoiceBox gender;
    @FXML
    public ChoiceBox faculty;
    @FXML
    public Button submit;
    @FXML
    public Button backButton;

    DataSingleton data = DataSingleton.getInstance();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String st[] = { "male", "female" };
        gender.setItems(FXCollections.observableArrayList(st));
        faculty.setItems(FXCollections.observableList(Arrays.asList(data.getUniversityFaculties())));
    }

    @FXML
    public void submitApp(MouseEvent event) throws IOException, SQLException {
        Queries queries = new Queries();
        queries.addAssignment(fullname.getText(), gender.getValue().toString(), passport.getText(), address.getText(), phone.getText(), faculty.getValue().toString() );
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
    public void backToList(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        URL xmlUrl = getClass().getResource("/xml/degree.fxml");
        loader.setLocation(xmlUrl);
        Parent root = loader.load();

        Scene scene = new Scene(root);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    }



}
