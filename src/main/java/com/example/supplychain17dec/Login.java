package com.example.supplychain17dec;

import java.sql.ResultSet;

public class Login {
    public boolean customerlogin(String emailid,String password) {
        String query = String.format("Select * from customer where emailid='%s' and password='%s'", emailid, password);
        try {
            Database_Connection dbcon = new Database_Connection();
            ResultSet rs = dbcon.getQueryTable(query);
            if (rs != null && rs.next())
                return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;

        }
    public static void main(String[] args) {
        Login login=new Login();
        System.out.println(login.customerlogin("ks.mahesh2@gmail.com","abc@123"));
    }
    }
