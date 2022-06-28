package com.example.cwiczenia9;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;

public class TestController {
    @FXML
    private FlowPane rightPane;

    @FXML
    protected void addButtons(){
        for (int i = 0; i<100; i++){
            Button button = new Button("Button " + i);
            rightPane.getChildren().add(i,button);
        }
    }
}
