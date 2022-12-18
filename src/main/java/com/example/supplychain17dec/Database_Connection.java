package com.example.supplychain17dec;
import java.sql.*;
public class Database_Connection {
    private static final String databaseurl="jdbc:mysql://localhost:3306/supply_chain_dec";
    private static final String user="root";
    private static final String password="Abcd@1234";

    public Statement getStatement(){
        Statement statement=null;
        Connection con;
        try {
            con=DriverManager.getConnection(databaseurl,user,password);
            statement=con.createStatement();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return statement;
    }
    public ResultSet getQueryTable(String query){
        Statement statement=getStatement();
        try {
            return statement.executeQuery(query);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
//    public static void main(String[] args){
//        Database_Connection dbcon=new Database_Connection();
//        ResultSet rs=dbcon.getQueryTable("SELECT EmailId,first_name FROM CUSTOMER");
//        try {
//            while (rs.next()){
//                System.out.println(rs.getString("EmailId")+" "+ rs.getString("first_name"));
//            }
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//    }
}
