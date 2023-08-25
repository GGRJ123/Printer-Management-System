package com.example.printer_management_system.pms_classes;


import java.io.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Login_database {
    private String user_email;
    private String password;
    File file = new File("src/main/java/com/example/printer_management_system/pms_classes/login_Database.xlsx");
    FileInputStream fis = new FileInputStream(file);
    XSSFWorkbook wb = new XSSFWorkbook(fis);
    XSSFSheet sheet = wb.getSheetAt(0);
    int Position;




    public Login_database() throws IOException {

    }

    public boolean getUser_email(String user_email) {

            for(int i = 1; i < sheet.getLastRowNum() +1; i++){

                Row row = sheet.getRow(i);
                Cell cell = row.getCell(0);
                String email_Check = cell.getStringCellValue();



                if(email_Check.equals(user_email)){
                    setPosition(i);
                    //System.out.println(Position + "- email is user_email: " + user_email);

                    return true;
                }
            }
            return false;


    }



    public boolean getAdminPermission(String userName) throws IOException {
//        DataFormatter dataFormatter = new DataFormatter();
//        Row row = sheet.getRow(getPosition());
//        String adminPermission = dataFormatter.formatCellValue(row.getCell(2));;
        File excelFile = new File("src/main/java/com/example/printer_management_system/pms_classes/login_Database.xlsx");
        FileInputStream fis = new FileInputStream(excelFile);
        // we create an XSSF Workbook object for our XLSX Excel File
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        // we get first sheet
        XSSFSheet sheet = workbook.getSheetAt(0);

        XSSFRow row = null;
        int i = 0;

        while ((row = sheet.getRow(i)) != null) {


            if(String.valueOf(row.getCell(0)).equals(userName)) {
                if (String.valueOf(row.getCell(2)).equals("TRUE")) {
                    return true;
                }
            }
            i++;
        }

//
//        if(adminPermission == "TRUE"){
//            //System.out.println("User has admin permission");
//
//        }
        return false;
    }




    public boolean getPassword(String password) {
        //System.out.println("Position in pass is: " + getPosition());
            Row row = sheet.getRow(getPosition());
            Cell cell = row.getCell(1);

            String check_Password = cell.getStringCellValue();
            //System.out.println("get password: " + check_Password);
            if(check_Password.equals(password)){
               // System.out.println("Password match");
                return true;
            }

        return false;
    }

    public void setUser_email(String user_email) throws IOException {
        Row row = sheet.getRow(sheet.getLastRowNum());
        //System.out.println("Row created is " + sheet.getLastRowNum());
        Cell cell = row.createCell(0);
        cell.setCellValue(user_email);
        //System.out.println("EMAIl: " + user_email);
        FileOutputStream out = new FileOutputStream(file);
        wb.write(out);
        out.close();
    }

    public void setPassword(String password) throws IOException {
        Row row = sheet.createRow(sheet.getLastRowNum() + 1);
        //System.out.println("Row created is " + sheet.getLastRowNum());
        Cell cell = row.createCell(1);
        cell.setCellValue(password);
        FileOutputStream out = new FileOutputStream(file);
        wb.write(out);
        out.close();
    }

    public boolean setAdminStatus(String userName, Boolean adminStatus) throws IOException {

        File excelFile = new File("src/main/java/com/example/printer_management_system/pms_classes/login_Database.xlsx");
        FileInputStream fis = new FileInputStream(excelFile);
            // we create an XSSF Workbook object for our XLSX Excel File
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
            // we get first sheet
        XSSFSheet sheet = workbook.getSheetAt(0);

        XSSFRow row = null;
        int i = 0;

        while ((row = sheet.getRow(i)) != null) {
            if (userName.equals(String.valueOf(row.getCell(0)))) {
                Cell admin = sheet.getRow(i).createCell(2);

                if(adminStatus == true){
                    admin.setCellValue("TRUE");
                    System.out.println("Admin status granted.");
                }
                else{
                    admin.setCellValue("FALSE");
                }


                //write to the file
                FileOutputStream out = new FileOutputStream("src/main/java/com/example/printer_management_system/pms_classes/login_Database.xlsx");
                workbook.write(out);
                workbook.close();
                out.close();

                return true;
            }
            i++;
        }
        workbook.close();
        System.out.println("couldnt find username");
        return false;
    }

    void setPosition(int Position){
        this.Position = Position;
    }

    int getPosition(){
        return Position;
    }



    void deleteEmptyCell(){

        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                if (sheet.getRow(i) == null || sheet.getRow(i).getCell(0) == null || sheet.getRow(i).getCell(0).toString().equals("")) {
                    sheet.removeRow(sheet.getRow(i));

                    //System.out.println("delete in row: " + (sheet.getLastRowNum() + 1));
                }

        }


    }


    @Override
    public String toString() {
        return "Login_database{" +
                "user_email='" + user_email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
