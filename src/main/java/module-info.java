module org.example{
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    requires lombok;
    requires javafx.media;
    requires slf4j.api;


    exports org.example;
    exports org.example.degrees;
    exports org.example.entity;
    exports org.example.client.chatwindow;
    exports org.example.client.util;
    exports org.example.com.exception;
    exports org.example.messages;
    exports org.example.messages.bubble;


}
