package com.example.db_app;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class ZakaziController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView imageBtnHome;

    @FXML
    void initialize() {
        assert imageBtnHome != null : "fx:id=\"imageBtnHome\" was not injected: check your FXML file 'zakazi.fxml'.";

    }

}
