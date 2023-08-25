package com.example.printer_management_system.pms_classes;

import java.io.*;
import java.util.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CSVparser {

    public static void main(String[] args) throws IOException {
//        CSVparser r = new CSVparser();
//
//        HashMap<String,String> singleprinter = r.getSinglePrinterData("5115511551",r.printers());
//
//        Deltech_printer_database database = new Deltech_printer_database(singleprinter);

//        AdminAccount a = new AdminAccount();
//
//        //a.delete_printer("2003256");


    }
    public ArrayList<HashMap<String,String>> printers() throws IOException {
        File excelFile = new File("src/main/java/com/example/printer_management_system/pms_classes/printers_Data.xlsx");
        FileInputStream fis = new FileInputStream(excelFile);

        // we create an XSSF Workbook object for our XLSX Excel File
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        // we get first sheet
        XSSFSheet sheet = workbook.getSheetAt(0);
        ArrayList<HashMap<String,String>> printerList = new ArrayList<>();

        XSSFRow row = null;


        int i = 0;
        while((row=sheet.getRow(i))!=null) {
            HashMap<String, String> printer = new HashMap<>();
            printer.put("Bar code", String.valueOf(row.getCell(0)).replace(".0",""));
            printer.put("Description", String.valueOf(row.getCell(1)));
            printer.put("Category Name", String.valueOf(row.getCell(2)));
            printer.put("Location Name", String.valueOf(row.getCell(3)));
            printer.put("Serial Number", String.valueOf(row.getCell(4)));
            printer.put("Manufacturer Name", String.valueOf(row.getCell(5)));
            printer.put("Division", String.valueOf(row.getCell(6)));
            printer.put("Department", String.valueOf(row.getCell(7)));
            printer.put("Campus", String.valueOf(row.getCell(8)));
            printer.put("Status", String.valueOf(row.getCell(9)));
            printerList.add(printer);
            i++;
        }
        workbook.close();
        fis.close();

        return printerList;
    }
    public HashMap<String,String> getSinglePrinterData(String barcode, ArrayList<HashMap<String,String>> printerList){
        HashMap<String,String> singlePrinter = new HashMap<>();
        for (int i = 0; i < printerList.size(); i++) {
            if(printerList.get(i).get("Bar code").equals(barcode)){
                singlePrinter = printerList.get(i);
                return singlePrinter;
            }
        }
        //System.out.println(r.printers().get(2).get("Bar code"));
        singlePrinter.put("Could not find","Bar code");
        return singlePrinter;
        }

    public void updateDB(Deltech_printer_database database) throws IOException {
        File excelFile = new File("src/main/java/com/example/printer_management_system/pms_classes/printers_Data.xlsx");
        FileInputStream fis = new FileInputStream(excelFile);

        // we create an XSSF Workbook object for our XLSX Excel File
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        // we get first sheet
        XSSFSheet sheet = workbook.getSheetAt(0);

        XSSFRow row = null;

        int i = 0;
        //while there is still rows in the file
        while((row=sheet.getRow(i))!=null) {
            String fixedCell = String.valueOf(row.getCell(0)).replace(".0","");
            //if we match a barcode of the file to our database instance, update the appropriate fields
            if (fixedCell.equals(database.getBar_code())){

                Cell description = sheet.getRow(i).getCell(1);
                Cell categoryName = sheet.getRow(i).getCell(2);
                Cell locationName = sheet.getRow(i).getCell(3);
                Cell serialNumber = sheet.getRow(i).getCell(4);
                Cell manufacturerName = sheet.getRow(i).getCell(5);
                Cell division = sheet.getRow(i).getCell(6);
                Cell department = sheet.getRow(i).getCell(7);
                Cell campus = sheet.getRow(i).getCell(8);
                Cell status = sheet.getRow(i).getCell(9);

                description.setCellValue(database.getDescription());
                categoryName.setCellValue(database.getCategory());
                locationName.setCellValue(database.getLocation());
                serialNumber.setCellValue(database.getSerial_num());
                manufacturerName.setCellValue(database.getManufacturer());
                division.setCellValue(database.getDivision());
                department.setCellValue(database.getDepartment());
                campus.setCellValue(database.getCampus());
                status.setCellValue(database.getStatus());

                FileOutputStream outFile =new FileOutputStream(new File("src/main/java/com/example/printer_management_system/pms_classes/printers_Data.xlsx"));
                workbook.write(outFile);
                outFile.close();
            }
            i++;
        }
        workbook.close();
        fis.close();
    }
    public boolean addtoDB(Deltech_printer_database database) throws IOException {
        File excelFile = new File("src/main/java/com/example/printer_management_system/pms_classes/printers_Data.xlsx");
        FileInputStream fis = new FileInputStream(excelFile);

        // we create an XSSF Workbook object for our XLSX Excel File
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        // we get first sheet
        XSSFSheet sheet = workbook.getSheetAt(0);

        XSSFRow row = null;

        int i = 0;
        //while there is still rows in the file
        while((row=sheet.getRow(i))!=null) {
            //if the barcode or serial number exist already
            String fixedCell = String.valueOf(row.getCell(0)).replace(".0","");
            if (fixedCell.equals(database.getBar_code()) || String.valueOf(row.getCell(4)).equals(database.getSerial_num()) ) {
                System.out.println("bar code or serial number already exist in the database");
                break;
            }

            //if the barcode and serial dont exist, add the passed printer object to the database
            if (i == sheet.getLastRowNum() && (!fixedCell.equals(database.getBar_code()) || !String.valueOf(row.getCell(4)).equals(database.getSerial_num()))){
                System.out.println("added to db");
                row = sheet.createRow(i+1);
                row.createCell(0).setCellValue(database.getBar_code());
                row.createCell(1).setCellValue(database.getDescription());
                row.createCell(2).setCellValue(database.getCategory());
                row.createCell(3).setCellValue(database.getLocation());
                row.createCell(4).setCellValue(database.getSerial_num());
                row.createCell(5).setCellValue(database.getManufacturer());
                row.createCell(6).setCellValue(database.getDivision());
                row.createCell(7).setCellValue(database.getDepartment());
                row.createCell(8).setCellValue(database.getCampus());
                row.createCell(9).setCellValue(database.getStatus());
                FileOutputStream outFile =new FileOutputStream(new File("src/main/java/com/example/printer_management_system/pms_classes/printers_Data.xlsx"));
                workbook.write(outFile);
                outFile.close();
                workbook.close();
                fis.close();
                return true;
            }
            i++;
        }
        workbook.close();
        fis.close();
        return false;
    }

    public void deleteFromDB(Deltech_printer_database database) throws IOException {
        File excelFile = new File("src/main/java/com/example/printer_management_system/pms_classes/printers_Data.xlsx");
        FileInputStream fis = new FileInputStream(excelFile);

        // we create an XSSF Workbook object for our XLSX Excel File
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        // we get first sheet
        XSSFSheet sheet = workbook.getSheetAt(0);

        XSSFRow row = null;

        int i = 0;
        //while there is still rows in the file
        while ((row = sheet.getRow(i)) != null) {
            String fixedCell = String.valueOf(row.getCell(0)).replace(".0","");
            //if the barcode exist
            if(fixedCell.equals(database.getBar_code())) {
                //if the printer to be removed is the last printer
                if(i == sheet.getLastRowNum()){
                    sheet.removeRow(row);
                }
                //if the printer to be removed is in the middle
                else {
                    sheet.removeRow(row);
                    sheet.shiftRows(i+1,sheet.getLastRowNum(),-1);
                }

                FileOutputStream outFile =new FileOutputStream(new File("src/main/java/com/example/printer_management_system/pms_classes/printers_Data.xlsx"));
                workbook.write(outFile);
                outFile.close();
                workbook.close();
                fis.close();
                System.out.println("Deleted From Database");
            }
            i++;
        }
        workbook.close();
        fis.close();
    }








}
