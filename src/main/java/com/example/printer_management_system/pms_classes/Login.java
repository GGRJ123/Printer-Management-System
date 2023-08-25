package com.example.printer_management_system.pms_classes;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Login {
    private String user_email;
    private String password;
    boolean user_Valid, password_Valid, admin_Permission;
    Login_database accounts = new Login_database();

    public Login() throws IOException {

    }

    public boolean verifyLogin(String user_email, String password) throws IOException {
        this.user_email = user_email;
        this.password = password;


        user_Valid = accounts.getUser_email(this.user_email);
        password_Valid = accounts.getPassword(this.password);
        admin_Permission = accounts.getAdminPermission(user_email);

        if (user_Valid == true && password_Valid == true){

            return true;
        }
        else{
            return false;
        }
    }

    public boolean getAdminPermission(){
        return admin_Permission;
    }

    public boolean register(String user_email, String user_Password) throws IOException {
        accounts.deleteEmptyCell();

        if(user_email.contains("@dtcc.edu")){
            System.out.println("@DTCC has been found in email");
            if(accounts.getUser_email(user_email) == true){
                System.out.println("You registered an email that already exist in the file");
                return false;
            }
            else{
                System.out.println("Email is brand new & valid");
            }
        }
        else{

            System.out.println("Email can not be created");
            return false;
        }

        accounts.setPassword(user_Password);
        accounts.setUser_email(user_email);
        return true;
    }
}
