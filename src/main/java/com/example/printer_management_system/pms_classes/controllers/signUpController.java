package com.example.printer_management_system.pms_classes.controllers;

import com.example.printer_management_system.loginPage;
import com.example.printer_management_system.pms_classes.Login;
import com.example.printer_management_system.pms_classes.Login_database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class signUpController {

    @FXML
    public Pane open_Pane;
    public TextField user_Email;
    public TextField user_Password;
    @FXML
    private TextField passphraseTB;
    @FXML
    private CheckBox adminCheckbox;
    @FXML
    private Label messageLabel;

    @FXML
    void onSignUpButtonClicked(InputEvent e) throws IOException {
        Login sign_Up = new Login();
        Login_database db = new Login_database();
        boolean correctPassphrase = false;

        if (adminCheckbox.isSelected()) {
            if (passphraseTB.getText().equals("admin123")) {
                correctPassphrase = true;
                //db.setAdminStatus(user_Email.getText());
            }
            else{
                messageLabel.setText("Incorrect passphrase");
                return;
            }
        }


        boolean valid_SignUp = sign_Up.register(user_Email.getText(), user_Password.getText());

        if (valid_SignUp) {
            //messageLabel.setText("Account created!");
          if(correctPassphrase){
              db.setAdminStatus(user_Email.getText(),true);
          }
          else{
              db.setAdminStatus(user_Email.getText(),false);
          }


            Stage page = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(loginPage.class.getResource("printer_Menu.fxml"));
            Scene newbie = new Scene(fxmlLoader.load(), 600, 400);
            page.setTitle("Printer Management System");
            page.setScene(newbie);
            page.show();




            //Parent root = (Parent) fxmlLoader.load();
            printer_MenuController menuController = fxmlLoader.getController();


            //sets admin
            if(db.getAdminPermission(user_Email.getText()) == false) {
                menuController.baseAccount(1);

            }
            else {
                menuController.baseAccount(0);

            }

            final Node source = (Node) e.getSource();
            final Stage stage = (Stage) source.getScene().getWindow();
            stage.close();


        }
        else{
            messageLabel.setText("Account couldn't be created.");
        }
    }
    @FXML
    void onCheckbox(ActionEvent event) {
        if(adminCheckbox.isSelected()){
            passphraseTB.setDisable(false);
        }
        else{
            passphraseTB.setDisable(true);
        }
    }
    @FXML
    void onCancelButtonClicked(InputEvent e) {
        final Node source = (Node) e.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }


}