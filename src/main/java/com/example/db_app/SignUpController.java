package com.example.db_app;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;


    @FXML
    private Button signUpBtn;

    @FXML
    private TextField login_field;

    @FXML
    private TextField password_field;

    @FXML
    private TextField signUpCountry;
    @FXML
    private CheckBox signUpCheckBoxFemale;

    @FXML
    private CheckBox signUpCheckBoxMale;

    @FXML
    private TextField signUpLastName;

    @FXML
    private TextField signUpName;

    @FXML
    void initialize() {
        signUpBtn.setOnAction(event -> {
            signUpNewUser();
        });
    }

    private void signUpNewUser() {
        DataBaseHandler dbHandler = new DataBaseHandler();
        String firstName = signUpName.getText();
        String lastName = signUpLastName.getText();
        String userName = login_field.getText();
        String password = password_field.getText();
        String location = signUpCountry.getText();
        String gender = "";
        if (signUpCheckBoxMale.isSelected())
            gender = "Мужской";
        else
            gender = "Женский";

        User user = new User(firstName, lastName, userName, password, location, gender);

        dbHandler.signUpUser(user);
        signUpBtn.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("main.fxml"));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
