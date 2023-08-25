package com.example.printer_management_system.pms_classes;

import java.io.IOException;
import java.util.HashMap;

public class AdminAccount extends BaseAccount{

    //return true if the barcode does exist and the printer has been deleted from the databse
    public boolean delete_printer(String barcode) throws IOException {

        //creating the instance of the db based on barcode
        CSVparser r = new CSVparser();
        HashMap<String,String> singleprinter = r.getSinglePrinterData(barcode,r.printers());
        Deltech_printer_database database = new Deltech_printer_database(singleprinter);

        //if the barcode exists
        if(database.getBar_code() != null ) {
            CSVparser reader = new CSVparser();
            reader.deleteFromDB(database);
            return true;
        }
        //barcode doesnt exist
        else {
            System.out.println("Barcode does not exist");
            return false;
        }
    }

//    public boolean delete_printer_String(String barcode) throws IOException {
//
//        CSVparser r = new CSVparser();
//        r.deletetoDB(barcode);
//        return true;
//    }

    //return true if the barcode and serial number dont exist already and have been added to the database
    public boolean add_printer(String barcode,
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

            //if the barcode doesnt exist
            if(database.getBar_code() == null ) {
                //set fields to be added
                database.setBar_code(barcode);
                database.setDescription(description);
                database.setCategory(category);
                database.setLocation(location);
                database.setSerial_num(serialNumber);
                database.setManufacturer(manufacturerName);
                database.setDivision(division);
                database.setDepartment(department);
                database.setCampus(campus);
                database.setStatus(status);

                //add the fields inside database
                CSVparser reader = new CSVparser();
                if (reader.addtoDB(database)){
                    return true;
                }
                else {return false;}

            }
            //barcode doesnt exist
            else {
                System.out.println("Barcode already in database");
                return false;
            }
    }
}
