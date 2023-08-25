package com.example.printer_management_system.pms_classes.controllers;

import com.example.printer_management_system.loginPage;
import com.example.printer_management_system.pms_classes.Deltech_printer_database;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class generateController {

    @FXML
    private CheckBox barCodeCheckBox;

    @FXML
    private CheckBox campusCheckBox;

    @FXML
    private CheckBox categoryCheckBox;

    @FXML
    private CheckBox departmentCheckBox;

    @FXML
    private CheckBox descriptionCheckBox;

    @FXML
    private CheckBox divisionCheckBox;

    @FXML
    private CheckBox locationCheckBox;

    @FXML
    private CheckBox manufacturerCheckBox;

    @FXML
    private Pane open_Pane;

    @FXML
    private CheckBox selectAllCheckBox;

    @FXML
    private CheckBox serialNumberCheckBox;

    @FXML
    private CheckBox statusCheckBox;


   @FXML
    private TableView<Deltech_printer_database> printer_Table;

    @FXML
    void onGenerateButtonClicked() throws IOException {
        Deltech_printer_database generateReport = new Deltech_printer_database(barCodeCheckBox.isSelected(),
                campusCheckBox.isSelected(), categoryCheckBox.isSelected(),departmentCheckBox.isSelected(),
                descriptionCheckBox.isSelected(), divisionCheckBox.isSelected(), locationCheckBox.isSelected(),
                manufacturerCheckBox.isSelected(), selectAllCheckBox.isSelected(), serialNumberCheckBox.isSelected(),
                statusCheckBox.isSelected());

    }

}