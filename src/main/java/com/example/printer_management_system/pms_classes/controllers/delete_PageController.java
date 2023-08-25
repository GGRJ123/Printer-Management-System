package com.example.printer_management_system.pms_classes.controllers;

import com.example.printer_management_system.loginPage;
import com.example.printer_management_system.pms_classes.AdminAccount;
import com.example.printer_management_system.pms_classes.CSVparser;
import com.example.printer_management_system.pms_classes.Deltech_printer_database;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class delete_PageController {

    @FXML
    public Pane open_Pane;

    @FXML
    private TextField enteredBarcode;

    @FXML
    private TableView<Deltech_printer_database> printerTable;

    @FXML
    private TableColumn<Deltech_printer_database, String> serialNumber;

    @FXML
    private Label messageLabel;

    @FXML
    private TableColumn<Deltech_printer_database, String> barCode;

    private int printersLoaded = 20;

    @FXML
    void loadTenMore(ScrollEvent event) throws IOException {
        CSVparser p = new CSVparser();
        int totalPrinters = p.printers().size();

        if(printersLoaded >= totalPrinters){

        }
        //less than 10 printers left
        if ((totalPrinters - printersLoaded) - 10 < 0) {
            for (int i = printersLoaded; i < printersLoaded + (totalPrinters - printersLoaded); i++) {
                printerTable.getItems().add(new Deltech_printer_database(p.printers().get(i)));
            }
            printersLoaded = printersLoaded + (totalPrinters - printersLoaded);

            //more than 10 printers left
        } else {
            for (int i = printersLoaded; i < printersLoaded + 10; i++) {
                printerTable.getItems().add(new Deltech_printer_database(p.printers().get(i)));
            }
            printersLoaded = printersLoaded + 10;
        }
    }

    @FXML
    public void initialize() throws IOException {
        barCode.setCellValueFactory(new PropertyValueFactory<>("bar_code"));
        serialNumber.setCellValueFactory(new PropertyValueFactory<>("serial_num"));

        CSVparser p = new CSVparser();
        for (int i = 1; i < 20; i++) {
            printerTable.getItems().add(new Deltech_printer_database(p.printers().get(i)));
        }
    }

    @FXML
    void onConfirmButtonClicked() throws IOException {

        AdminAccount admin = new AdminAccount();

        if (admin.delete_printer(enteredBarcode.getText())){
            messageLabel.setText("Printer Deleted From the Database");

        }
        else{
            messageLabel.setText("Could not find that Barcode, try again.");
        }
    }

    @FXML
    void onRefreshButtonClicked(MouseEvent event) throws IOException {
        barCode.setCellValueFactory(new PropertyValueFactory<>("bar_code"));
        serialNumber.setCellValueFactory(new PropertyValueFactory<>("serial_num"));
        printerTable.getItems().clear();
        messageLabel.setText("");
        CSVparser p = new CSVparser();
        for (int i = 1; i < 20; i++) {
            printerTable.getItems().add(new Deltech_printer_database(p.printers().get(i)));
        }
    }
    @FXML
    void onCancelButtonClicked(InputEvent e) throws IOException{
        final Node source = (Node) e.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }



}