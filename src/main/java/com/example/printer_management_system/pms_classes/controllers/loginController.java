package com.example.printer_management_system.pms_classes.controllers;

import com.example.printer_management_system.loginPage;
import com.example.printer_management_system.pms_classes.Deltech_printer_database;
import com.example.printer_management_system.pms_classes.Login;
import com.example.printer_management_system.pms_classes.Login_database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class loginController {

    boolean login_Varify;

    @FXML
    public Pane open_Pane;
    public TextField email_Input;
    public TextField password_Input;
    public Label error_Message;
    public ImageView imageBox;

    @FXML
    private void initialize() throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("src/main/java/com/example/printer_management_system/photos/printerphoto.jpg");
        imageBox.setImage(new Image(fileInputStream));
    }

    @FXML
    void onSigninButtonClicked(InputEvent e) throws IOException {

        Login_database db = new Login_database();
        Login userLogin = new Login();
        login_Varify = userLogin.verifyLogin(email_Input.getText(), password_Input.getText());
        if (login_Varify) {
            Stage page = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(loginPage.class.getResource("printer_Menu.fxml"));

            //Passes information from the loginController to the printer_MenuController
            Parent root = (Parent) fxmlLoader.load();
            printer_MenuController menuController = fxmlLoader.getController();
            //will disable feature depending on account type

            if(db.getAdminPermission(email_Input.getText()) == false) {
                menuController.baseAccount(1);
            }

            //create scene with the root
            Scene newbie = new Scene(root, 600, 400);
            page.setTitle("Printer Management System");
            page.setScene(newbie);
            page.show();

            //end the old scene
            final Node source = (Node) e.getSource();
            final Stage stage = (Stage) source.getScene().getWindow();
            stage.close();
        }
        else{
            error_Message.setText("Invalid email or password, please try again.");
        }
    }
    @FXML
    void onCancelClicked(InputEvent e) {
        final Node source = (Node) e.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}