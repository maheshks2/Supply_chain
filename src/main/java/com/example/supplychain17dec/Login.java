package com.example.supplychain17dec;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.ResultSet;

public class Login {

    private static byte[] getSHA(String input) {
        try {
            MessageDigest messagedigest = MessageDigest.getInstance("SHA-256");
            return messagedigest.digest(input.getBytes(StandardCharsets.UTF_8));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    private String getEncryptedPassword(String password){
        String encryptedMessage="";
        try {
            BigInteger number=new BigInteger(1,getSHA(password));
            StringBuilder hexString=new StringBuilder(number.toString(16));
            return hexString.toString();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
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
//    public static void main(String[] args) {
//        Login login=new Login();
//        System.out.println(login.customerlogin("ks.mahesh2@gmail.com","abc@123"));
//    }
//    public static void main(String[] args){
//        Login login=new Login();
//        System.out.println(login.getEncryptedPassword("abdc123"));
//    }
    }
