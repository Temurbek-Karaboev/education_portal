package org.example;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.example.entity.DataSingleton;
import org.example.entity.Faculties;

import java.net.URL;
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


}
