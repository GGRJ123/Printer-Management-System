package com.example.printer_management_system.pms_classes.controllers;

import com.example.printer_management_system.loginPage;
import com.example.printer_management_system.pms_classes.CSVparser;
import com.example.printer_management_system.pms_classes.Deltech_printer_database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.time.format.TextStyle;
import java.util.*;

public class search_PageController implements Initializable {
    @FXML
    private TableColumn<Deltech_printer_database, String> Manufacturer;
    @FXML
    private TableColumn<Deltech_printer_database, String> Category;
    @FXML
    private TableColumn<Deltech_printer_database, String> Description;
    @FXML
    private TableColumn<Deltech_printer_database, String> Campus;
    @FXML
    private TableColumn<Deltech_printer_database, String> Location;
    @FXML
    private TableView<Deltech_printer_database> printer_Table;
    @FXML
    private TextField searchField;
    @FXML
    private TableColumn<Deltech_printer_database, String> Status;
    @FXML
    private TableColumn<Deltech_printer_database, String> Barcode;
    @FXML
    private TableColumn<Deltech_printer_database, String> Department;
    @FXML
    private TableColumn<Deltech_printer_database, String> serialNumber;
    @FXML
    private TableColumn<Deltech_printer_database, String> Division;

    ObservableList<Deltech_printer_database> testList = null;

    @FXML
    void onGenerateButtonClicked() throws IOException {
        Stage page = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(loginPage.class.getResource("generate_Page.fxml"));
        Scene newbie = new Scene(fxmlLoader.load(), 600, 400);
        page.setTitle("Printer Management System");
        page.setScene(newbie);
        page.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Manufacturer.setCellValueFactory(new PropertyValueFactory<Deltech_printer_database, String>("Manufacturer"));
        Category.setCellValueFactory(new PropertyValueFactory<Deltech_printer_database, String>("Category"));
        Description.setCellValueFactory(new PropertyValueFactory<Deltech_printer_database, String>("Description"));
        Campus.setCellValueFactory(new PropertyValueFactory<Deltech_printer_database, String>("Campus"));
        Location.setCellValueFactory(new PropertyValueFactory<Deltech_printer_database, String>("Location"));
        Status.setCellValueFactory(new PropertyValueFactory<Deltech_printer_database, String>("Status"));
        Barcode.setCellValueFactory(new PropertyValueFactory<Deltech_printer_database, String>("Bar_code"));
        Department.setCellValueFactory(new PropertyValueFactory<Deltech_printer_database, String>("Department"));
        serialNumber.setCellValueFactory(new PropertyValueFactory<Deltech_printer_database, String>("Serial_num"));
        Division.setCellValueFactory(new PropertyValueFactory<Deltech_printer_database, String>("Division"));


        try {
            Deltech_printer_database Tester = new Deltech_printer_database();

            for (int i = 1; i < Tester.getFileSize(); i++) {
                Deltech_printer_database Tester2 = new Deltech_printer_database(i);

                Tester2.readPrinterFile();
                testList = printer_Table.getItems();
                testList.add(Tester2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        FilteredList<Deltech_printer_database> filteredData = new FilteredList<>(testList, p -> true);

        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(person -> {
                if (newValue == null || newValue.isEmpty()){
                 return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if(person.getManufacturer().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }
                if(person.getBar_code().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }
                if(person.getSerial_num().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }
                if(person.getCampus().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }
                if(person.getCategory().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }
                if(person.getDepartment().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }
                if(person.getCategory().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }
                if(person.getSerial_num().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }
                if(person.getLocation().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }
                if(person.getStatus().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }

                return false;
            });

        });

        SortedList<Deltech_printer_database> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(printer_Table.comparatorProperty());

        printer_Table.setItems(sortedData);

    }
}