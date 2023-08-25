package com.example.printer_management_system.pms_classes;

import javafx.collections.ObservableList;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Deltech_printer_database {
    private String bar_code;
    private String Description;
    private String Category;
    private String Location;
    private String serial_num;
    private String Manufacturer;
    private String division;
    private String department;
    private String Campus;
    int Count;
    private String status;

    boolean  barCodeBoolean, campusBoolean,  categoryBoolean, departmentBoolean,  descriptionBoolean,
            divisionBoolean, locationBoolean,  manufacturerBoolean,  selectAllBoolean, serialNumberBoolean,
            statusBoolean;


    File file = new File("src/main/java/com/example/printer_management_system/pms_classes/printers_Data.xlsx");
    FileInputStream fis = new FileInputStream(file);
    XSSFWorkbook wb = new XSSFWorkbook(fis);
    XSSFSheet sheet = wb.getSheetAt(0);

    public Deltech_printer_database(HashMap<String,String> printer) throws IOException{
        this.bar_code = printer.get("Bar code");
        this.Description = printer.get("Description");
        this.Category = printer.get("Category Name");
        this.Location = printer.get("Location Name");
        this.serial_num = printer.get("Serial Number");
        this.Manufacturer = printer.get("Manufacturer Name");
        this.division = printer.get("Division");
        this.department = printer.get("Department");
        this.Campus = printer.get("Campus");
        this.status = printer.get("Status");
    }
    public Deltech_printer_database() throws IOException {

    }

    public Deltech_printer_database(boolean barCodeBoolean, boolean campusBoolean, boolean categoryBoolean,
                                 boolean departmentBoolean, boolean descriptionBoolean, boolean divisionBoolean,
                                 boolean locationBoolean, boolean manufacturerBoolean, boolean selectAllBoolean,
                                 boolean serialNumberBoolean, boolean statusBoolean) throws IOException {
        this.barCodeBoolean = barCodeBoolean;
        this.campusBoolean = campusBoolean;
        this.categoryBoolean = categoryBoolean;
        this.departmentBoolean = departmentBoolean;
        this.descriptionBoolean = descriptionBoolean;
        this.divisionBoolean = divisionBoolean;
        this.locationBoolean = locationBoolean;
        this.manufacturerBoolean = manufacturerBoolean;
        this.selectAllBoolean = selectAllBoolean;
        this.serialNumberBoolean = serialNumberBoolean;
        this.statusBoolean = statusBoolean;

        ArrayList<Integer> checkBoxArray = new ArrayList<Integer>();

        FileOutputStream fileOut = new FileOutputStream("src/main/java/com/example/printer_management_system/pms_classes/test.xlsx");
        XSSFWorkbook wbOut = new XSSFWorkbook();
        XSSFSheet Sheet = wbOut.createSheet();

        /*
        Need to find a way to make cell longer in order to see the words
         */


        int Count = 0;
        Row row = Sheet.createRow(0);
        if(barCodeBoolean == true){
            Cell cell = row.createCell(Count);
            cell.setCellValue("Bar Code");
            checkBoxArray.add(0);
            Count++;
        }
        if (descriptionBoolean == true){
            Cell cell = row.createCell(Count);
            cell.setCellValue("Description");
            checkBoxArray.add(1);
            Count++;
        }
        if(categoryBoolean == true){
            Cell cell = row.createCell(Count);
            cell.setCellValue("Category");
            checkBoxArray.add(2);
            Count++;
        }
        if (locationBoolean == true){
            Cell cell = row.createCell(Count);
            cell.setCellValue("Location");
            checkBoxArray.add(3);
            Count++;
        }
        if(serialNumberBoolean == true){
            Cell cell = row.createCell(Count);
            cell.setCellValue("Serial Number");
            checkBoxArray.add(4);
            Count++;
        }
        if (manufacturerBoolean == true){
            Cell cell = row.createCell(Count);
            cell.setCellValue("Manufacturer");
            checkBoxArray.add(5);
            Count++;
        }
        if (divisionBoolean == true){
            Cell cell = row.createCell(Count);
            cell.setCellValue("Division");
            checkBoxArray.add(6);
            Count++;
        }
        if(departmentBoolean == true){
            Cell cell = row.createCell(Count);
            cell.setCellValue("Department");
            checkBoxArray.add(7);
            Count++;
        }
        if (campusBoolean == true){
            Cell cell = row.createCell(Count);
            cell.setCellValue("Campus");
            checkBoxArray.add(8);
            Count++;
        }
        if (statusBoolean == true){
            Cell cell = row.createCell(Count);
            cell.setCellValue("Status");
            checkBoxArray.add(9);
            Count++;
        }
        DataFormatter dataFormatter = new DataFormatter();

        for (int i = 1; i < sheet.getLastRowNum() + 1; i++){
            row = Sheet.createRow(i);
            Row rowPrinter = sheet.getRow(i);
            for (int j = 0; j < Count; j++){
                        Cell cell = row.createCell(j);
                        String formattedCellStr = dataFormatter.formatCellValue(rowPrinter.getCell(checkBoxArray.get(j)));
                        cell.setCellValue(formattedCellStr);


            }
        }

        wbOut.write(fileOut);

    }

    public Deltech_printer_database(int Count) throws IOException {
        setCount(Count);
    }

    public String getBar_code() {
        return bar_code;
    }

    public void setBar_code(String bar_code) {
        this.bar_code = bar_code;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category_name) {
        this.Category = category_name;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location_name) {
        this.Location = location_name;
    }

    public String getSerial_num() {
        return serial_num;
    }

    public void setSerial_num(String serial_num) {
        this.serial_num = serial_num;
    }

    public String getManufacturer() {
        return Manufacturer;
    }

    public void setManufacturer(String manufacturer_name) {

        this.Manufacturer = manufacturer_name;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCampus() {
        return Campus;
    }

    public void setCampus(String campus) {
        this.Campus = campus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getFileSize(){
        return sheet.getLastRowNum();
    }

    public void setCount(int Count){
        this.Count = Count;
    }

    public void readPrinterFile(){
        DataFormatter dataFormatter = new DataFormatter();

        Row row = sheet.getRow(Count);
        Cell manufacturerCell = row.getCell(5);
        Cell categoryCell = row.getCell(2);
        Cell statusCell = row.getCell(9);
        Cell barcodeCell = row.getCell(0);
        Cell departmentCell = row.getCell(7);
        Cell serialNumberCell = row.getCell(4);
        Cell divisionCell = row.getCell(6);


        Cell descriptionCell = row.getCell(1);
        String formattedCellStr = dataFormatter.formatCellValue(descriptionCell);

        Cell campusCell = row.getCell(8);
        Cell locationCell = row.getCell(3);

        setManufacturer(manufacturerCell.getStringCellValue());
        setCategory(categoryCell.getStringCellValue());
        setDescription(formattedCellStr);
        setCampus(campusCell.getStringCellValue());
        setLocation(locationCell.getStringCellValue());
        setStatus(statusCell.getStringCellValue());

        formattedCellStr = dataFormatter.formatCellValue(barcodeCell);

        setBar_code(formattedCellStr);
        setDepartment(departmentCell.getStringCellValue());

        formattedCellStr = dataFormatter.formatCellValue(serialNumberCell);

        setSerial_num(formattedCellStr);
        setDivision(divisionCell.getStringCellValue());
        //Manufacturer = cell.getStringCellValue();

    }

    @Override
    public String toString() {
        return "Deltech_printer_database{" +
                "bar_code=" + bar_code +
                ", description='" + Description + '\'' +
                ", category_name='" + Category + '\'' +
                ", location_name='" + Location + '\'' +
                ", serial_num='" + serial_num + '\'' +
                ", manufacturer_name='" + Manufacturer + '\'' +
                ", division='" + division + '\'' +
                ", department='" + department + '\'' +
                ", campus='" + Campus + '\'' +
                ", status=" + status +
                '}';
    }
}
