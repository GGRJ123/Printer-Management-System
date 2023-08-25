package com.example.printer_management_system.pms_classes;

import java.io.IOException;
import java.util.HashMap;

public class BaseAccount {

    //this function returns the database string based off barcode (we could return the object here... might be better than a string)
    public String search_printer(String barcode) throws IOException {
        CSVparser r = new CSVparser();
        HashMap<String, String> singleprinter = r.getSinglePrinterData(barcode, r.printers());
        Deltech_printer_database database = new Deltech_printer_database(singleprinter);

        //if barcode was found
        if (database.getBar_code() != null) {
            return database.toString();
        }
        //if barcode wasnt found
        else return "No barcode found";
    }

    //this function will check if the barcode is valid and if it is, it will update the fields which are passed
    //if the barcode is not correct it will return false
    public boolean update_printer(String barcode,
                          String description,
                          String category,
                          String location,
                          String serialNumber,
                          String manufacturerName,
                          String division,
                          String department,
                          String campus,
                          String status) throws IOException {

        //creating the instance of the db based on barcode
        CSVparser r = new CSVparser();
        HashMap<String,String> singleprinter = r.getSinglePrinterData(barcode,r.printers());
        Deltech_printer_database database = new Deltech_printer_database(singleprinter);

        //if the barcode exists
        if(database.getBar_code() != null ) {
            //set fields that need to be updated
            database.setDescription(description);
            database.setCategory(category);
            database.setLocation(location);
            database.setSerial_num(serialNumber);
            database.setManufacturer(manufacturerName);
            database.setDivision(division);
            database.setDepartment(department);
            database.setCampus(campus);
            database.setStatus(status);

            //update the fields inside database
            CSVparser reader = new CSVparser();
            reader.updateDB(database);
            return true;
        }
        //barcode doesnt exist
        else {
            System.out.println("Barcode does not exist");
            return false;
        }
    }


    //maybe we should return a list of whichever printers objects are chosen via barcode? not all the way sure whats the best option for this.
    public void generate_report(int[] barcode){

    }
    //maybe we should return a list of all the printer objects here?
    public void browse(){

    }

}
