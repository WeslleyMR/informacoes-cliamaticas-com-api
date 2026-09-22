module com.example.demo2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires org.json;


    opens com.example.demo2 to javafx.fxml;
    exports com.example.demo2;

    opens com.example.demo2.controller to javafx.fxml;
    exports com.example.demo2.controller;
}