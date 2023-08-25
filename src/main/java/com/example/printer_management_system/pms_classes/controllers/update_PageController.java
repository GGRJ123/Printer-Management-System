package com.example.printer_management_system.pms_classes.controllers;

import com.example.printer_management_system.loginPage;
import com.example.printer_management_system.pms_classes.AdminAccount;
import com.example.printer_management_system.pms_classes.CSVparser;
import com.example.printer_management_system.pms_classes.Deltech_printer_database;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class update_PageController {


    @FXML
    public Pane open_Pane;

    @FXML
    private TableView<Deltech_printer_database> printerTable;
    @FXML
    private TableColumn<Deltech_printer_database, String> status;

    @FXML
    private TableColumn<Deltech_printer_database, String> campus;

    @FXML
    private TableColumn<Deltech_printer_database, String> categoryName;
//
    @FXML
    private TableColumn<Deltech_printer_database, String> department;

    @FXML
    private TableColumn<Deltech_printer_database, String> description;

    @FXML
    private TableColumn<Deltech_printer_database, String> division;

    @FXML
    private TableColumn<Deltech_printer_database, String> manufacturer;
    @FXML
    private TableColumn<Deltech_printer_database, String> serialNumber;

    @FXML
    private TableColumn<Deltech_printer_database, String> barCode;
    @FXML
    private TableColumn<Deltech_printer_database, String> LocationName;

    private int printersLoaded = 20;
    public static Deltech_printer_database database;

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
        description.setCellValueFactory(new PropertyValueFactory<>("Description"));
        categoryName.setCellValueFactory(new PropertyValueFactory<>("Category"));
        LocationName.setCellValueFactory(new PropertyValueFactory<>("Location"));
        serialNumber.setCellValueFactory(new PropertyValueFactory<>("serial_num"));
        manufacturer.setCellValueFactory(new PropertyValueFactory<>("Manufacturer"));
        division.setCellValueFactory(new PropertyValueFactory<>("division"));
        department.setCellValueFactory(new PropertyValueFactory<>("department"));
        campus.setCellValueFactory(new PropertyValueFactory<>("Campus"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        CSVparser p = new CSVparser();
        for (int i = 1; i < 20; i++) {
            printerTable.getItems().add(new Deltech_printer_database(p.printers().get(i)));
        }

    }


    @FXML
    void onRefreshButtonClicked() throws IOException {
        barCode.setCellValueFactory(new PropertyValueFactory<>("bar_code"));
        serialNumber.setCellValueFactory(new PropertyValueFactory<>("serial_num"));
        printerTable.getItems().clear();
        //messageLabel.setText("");
        CSVparser p = new CSVparser();
        for (int i = 1; i < 20; i++) {
            printerTable.getItems().add(new Deltech_printer_database(p.printers().get(i)));
        }
    }

    @FXML
    public void clickItem(MouseEvent event) throws IOException {
        if (event.getClickCount() == 2)
        {
            CSVparser p = new CSVparser();
            String barcode = printerTable.getSelectionModel().getSelectedItem().getBar_code();
            database = new Deltech_printer_database(p.getSinglePrinterData(barcode,p.printers()));

            Stage page = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(loginPage.class.getResource("update_Page2.fxml"));
            Scene newbie = new Scene(fxmlLoader.load(), 425, 558);
            page.setTitle("Printer Management System");
            page.setScene(newbie);
            page.show();


        }
    }

    @FXML
    void onCancelButtonClicked(InputEvent e) throws IOException{
        final Node source = (Node) e.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

}