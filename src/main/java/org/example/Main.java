package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

import java.net.URL;


/**
 * JavaFX App
 */
public class Main extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception {
            primaryStage.setTitle("UZBEKISTAN UNIVERSITY EDUCATION PORTAL");
//            primaryStage.setWidth(500);
//            primaryStage.setHeight(600);
//
//
//            InputStream iconStream = getClass().getResourceAsStream("/img/img.png");
//            Image image = new Image(iconStream);
//            primaryStage.getIcons().add(image);
//
//
//            Label helloWorldLabel = new Label("Hello world!");
//            helloWorldLabel.setAlignment(Pos.CENTER);
//            Scene primaryScene = new Scene(helloWorldLabel);
//            primaryStage.setScene(primaryScene);
//
//            primaryStage.show();

            FXMLLoader loader = new FXMLLoader();
            URL xmlUrl = getClass().getResource("/xml/login.fxml");
            loader.setLocation(xmlUrl);
            Parent root = loader.load();

            primaryStage.setScene(new Scene(root));
            primaryStage.show();

        }

    public static void main(String[] args) {
        Application.launch();
    }
    }