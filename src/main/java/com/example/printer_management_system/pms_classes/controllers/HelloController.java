package com.example.printer_management_system.pms_classes.controllers;

import com.example.printer_management_system.HelloApplication;
import com.example.printer_management_system.loginPage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    public Pane open_Pane;

    @FXML
    void onLoginButtonClicked() throws IOException {
        Stage page = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(loginPage.class.getResource("login.fxml"));
        Scene newbie = new Scene(fxmlLoader.load(), 530, 248);
        page.setTitle("Printer Management System");
        page.setScene(newbie);
        page.show();

    }

    @FXML
    void onSignUpButtonClicked() throws IOException{
        Stage page = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(loginPage.class.getResource("signUp.fxml"));
        Scene newbie = new Scene(fxmlLoader.load(), 600, 400);
        page.setTitle("Printer Management System");
        page.setScene(newbie);
        page.show();
    }



}