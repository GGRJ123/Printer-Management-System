package com.example.printer_management_system.pms_classes.controllers;

import com.example.printer_management_system.loginPage;
import com.example.printer_management_system.pms_classes.AdminAccount;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.InputEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class addPageController {
    @FXML
    private TextField barCode;

    @FXML
    private TextField campus;

    @FXML
    private TextField category;

    @FXML
    private TextField department;

    @FXML
    private TextField description;

    @FXML
    private TextField division;

    @FXML
    private TextField locationName;

    @FXML
    private TextField manufacturer;

    @FXML
    private Label messageLabel;

    @FXML
    private TextField serialNum;

    @FXML
    private TextField status;

    @FXML
    void onAddPrinterButtonClicked() throws IOException{
        AdminAccount addingPrinter = new AdminAccount();
        if (barCode.getText().equals("")){
            messageLabel.setText("Please fill in the form!");
        }

        else if (addingPrinter.add_printer(
                barCode.getText(),
                description.getText(),
                category.getText(),
                locationName.getText(),
                serialNum.getText(),
                manufacturer.getText(),
                division.getText(),
                department.getText(),
                campus.getText(),
                status.getText())){

                messageLabel.setText("Printer add to database");
        }
        else{
            messageLabel.setText("Could not add printer to database.");
        }

    }

    @FXML
    void onCancelButtonClicked(InputEvent e) throws IOException{
        final Node source = (Node) e.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }



}