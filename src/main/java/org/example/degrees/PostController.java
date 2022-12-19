package org.example.degrees;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.example.entity.DataSingleton;
import org.example.entity.Faculties;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PostController implements Initializable {
    DataSingleton data = DataSingleton.getInstance();

    @FXML
    public Button apply1;
    @FXML
    public Button apply2;
    @FXML
    public Button apply3;
    @FXML
    public Button apply4;

    @FXML
    public Button news1;
    @FXML
    public Button news2;
    @FXML
    public Button news3;
    @FXML
    public Button news4;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @FXML
    public void goToApply1(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        data.setUniversityFaculties(Faculties.TSUE_p);
        URL xmlUrl = getClass().getResource("/xml/application.fxml");
        loader.setLocation(xmlUrl);
        Parent root = loader.load();

        Scene scene = new Scene(root);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    };
    @FXML
    public void goToApply2(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        data.setUniversityFaculties(Faculties.USAACI_p);
        URL xmlUrl = getClass().getResource("/xml/application.fxml");
        loader.setLocation(xmlUrl);
        Parent root = loader.load();

        Scene scene = new Scene(root);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    };
    @FXML
    public void goToApply3(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        data.setUniversityFaculties(Faculties.TMA_p);
        URL xmlUrl = getClass().getResource("/xml/application.fxml");
        loader.setLocation(xmlUrl);
        Parent root = loader.load();

        Scene scene = new Scene(root);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    };
    @FXML
    public void goToApply4(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        data.setUniversityFaculties(Faculties.USUWL_p);
        URL xmlUrl = getClass().getResource("/xml/application.fxml");
        loader.setLocation(xmlUrl);
        Parent root = loader.load();

        Scene scene = new Scene(root);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    };

    @FXML
    public void goToBack(MouseEvent event) throws IOException {
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
    public void news11(MouseEvent event){
        System.out.println("CLICKED");
    }
    @FXML
    public void news21(MouseEvent event){
        System.out.println("CLICKED");
    }
    @FXML
    public void news31(MouseEvent event){
        System.out.println("CLICKED");
    }
    @FXML
    public void news41(MouseEvent event){
        System.out.println("CLICKED");
    }
}
