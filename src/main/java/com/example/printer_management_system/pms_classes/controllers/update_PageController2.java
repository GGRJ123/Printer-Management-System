package com.example.printer_management_system.pms_classes.controllers;

import com.example.printer_management_system.pms_classes.BaseAccount;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class update_PageController2 {
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
    private TextField serialNum;

    @FXML
    private TextField status;

    @FXML
    private Label messageLabel;

    public void initialize(){
        //update_PageController u = new update_PageController();
        barCode.setText(update_PageController.database.getBar_code());
        description.setText(update_PageController.database.getDescription());
        category.setText(update_PageController.database.getCategory());
        locationName.setText(update_PageController.database.getLocation());
        serialNum.setText(update_PageController.database.getSerial_num());
        manufacturer.setText(update_PageController.database.getManufacturer());
        division.setText(update_PageController.database.getDivision());
        department.setText(update_PageController.database.getDepartment());
        campus.setText(update_PageController.database.getCampus());
        status.setText(update_PageController.database.getStatus());

    }

    @FXML
    void updatePrinter(MouseEvent event) throws IOException {
        BaseAccount baseAccount = new BaseAccount();
        baseAccount.update_printer(
                barCode.getText(),
                description.getText(),
                category.getText(),
                locationName.getText(),
                serialNum.getText(),
                manufacturer.getText(),
                division.getText(),
                department.getText(),
                campus.getText(),
                status.getText());
        messageLabel.setText("Printer has been updated!");
    }

    @FXML
    void onCancelButton(InputEvent e) {
        final Node source = (Node) e.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }


}
