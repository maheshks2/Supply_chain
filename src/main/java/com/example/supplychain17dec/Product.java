package com.example.supplychain17dec;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

import java.sql.ResultSet;

public class Product {
    private SimpleIntegerProperty id;
    private SimpleStringProperty name;
    private SimpleDoubleProperty price;

    public int getId() {
        return id.get();
    }



    public String getName() {
        return name.get();
    }



    public double getPrice() {
        return price.get();
    }
    public Product(int id,String name, double price){
        this.id=new SimpleIntegerProperty(id);
        this.name=new SimpleStringProperty(name);
        this.price=new SimpleDoubleProperty(price);
    }

    public static ObservableList<Product> getAllProducts(){
        Database_Connection databaseConnection =new Database_Connection();
        ObservableList<Product> ProductList= FXCollections.observableArrayList();
        String selectproducts ="select * from product";
        try {
            ResultSet rs=databaseConnection.getQueryTable(selectproducts);
            while (rs.next()){
                ProductList.add(new Product(rs.getInt("product_id"),
                        rs.getString("name"),
                        rs.getDouble("price")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ProductList;
    }
    public static ObservableList<Product> getProductsByName(String productName){
        Database_Connection databaseConnection =new Database_Connection();
        ObservableList<Product> ProductList= FXCollections.observableArrayList();
        String selectproducts =String.format("select * from product where lower(name) like '%%%s%%'",productName.toLowerCase());
        try {
            ResultSet rs=databaseConnection.getQueryTable(selectproducts);
            while (rs.next()){
                ProductList.add(new Product(rs.getInt("product_id"),
                        rs.getString("name"),
                        rs.getDouble("price")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ProductList;
    }
}
