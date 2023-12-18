package com.example.db_app;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button authSignInBtn;

    @FXML
    private Button loginSignUpBtn;

    @FXML
    private TextField login_field;

    @FXML
    private TextField password_field;

    @FXML
    void initialize() {
        authSignInBtn.setOnAction(actionEvent -> {
            String loginText = login_field.getText().trim();
            String loginPassword = password_field.getText().trim();
            
            if (!loginText.equals("") && !loginPassword.equals(""))
                loginUser(loginText, loginPassword);
            else
                System.out.println("Login and password is empty!");
        });
        
        
        loginSignUpBtn.setOnAction(actionEvent ->
        {loginSignUpBtn.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("signUp.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }

    private void loginUser(String loginText, String loginPassword) {
        DataBaseHandler dbHandler = new DataBaseHandler();
        User user = new User();
        user.setUserName(loginText);
        user.setPassword(loginPassword);
        ResultSet result = dbHandler.getUser(user);

        int counter = 0;

        try {
            while(result.next()) {
                counter++;
            }
        } catch (SQLException e ) {
            e.printStackTrace();
        }

        if(counter >= 1) {
            System.out.println("Success!");
            authSignInBtn.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("zakazi.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root  = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        }
    }
}
