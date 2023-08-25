package com.example.printer_management_system.pms_classes.controllers;

import com.example.printer_management_system.loginPage;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class printer_MenuController implements Initializable {

    @FXML
    private Button add_Button;

    @FXML
    private Button delete_Button;

    @FXML
    private Pane open_Pane;

    @FXML
    private Button search_Button;

    @FXML
    private Button update_Button;


    static int accountType = 0;

    @FXML
    void onSearchButtonClicked() throws  IOException{
        Stage page = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(loginPage.class.getResource("search_Page.fxml"));
        Scene newbie = new Scene(fxmlLoader.load(), 900, 700);
        page.setTitle("Printer Management System");
        page.setScene(newbie);
        page.show();
    }

    @FXML
    void onAddButtonClicked() throws IOException{
        Stage page = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(loginPage.class.getResource("add_Page.fxml"));
        Scene newbie = new Scene(fxmlLoader.load(), 425, 558);
        page.setTitle("Printer Management System");
        page.setScene(newbie);
        page.show();

    }

    @FXML
    void onDeleteButtonClicked() throws IOException{
        Stage page = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(loginPage.class.getResource("delete_Page.fxml"));
        Scene newbie = new Scene(fxmlLoader.load(), 700, 700);
        page.setTitle("Printer Management System");
        page.setScene(newbie);
        page.show();
    }

    @FXML

    void onUpdateButtonClicked() throws IOException{
        Stage page = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(loginPage.class.getResource("update_Page.fxml"));
        Scene newbie = new Scene(fxmlLoader.load(), 1000, 700);
        page.setTitle("Printer Management System");
        page.setScene(newbie);
        page.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        baseAccount(accountType);

    }
    @FXML
    void onExitProgram(MouseEvent event) {
        Platform.exit();
        System.exit(0);
    }

    public void baseAccount(int accountType){

        this.accountType = accountType;
        System.out.println("This is the base account you passed: " + accountType);

        if(this.accountType == 1){
            add_Button.setDisable(true);
            delete_Button.setDisable(true);
        }
    }
}