module com.example.cwiczenia9 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cwiczenia9 to javafx.fxml;
    exports com.example.cwiczenia9;
}