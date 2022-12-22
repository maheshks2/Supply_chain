package com.example.supplychain17dec;

import javafx.beans.Observable;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class ProductDetails {
    public TableView<Product> productTable;
    public Pane getAllProducts(){
        TableColumn id=new TableColumn("id");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn name=new TableColumn("name");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn price=new TableColumn("price");
        price.setCellValueFactory(new PropertyValueFactory<>("price"));

//        ObservableList<Product> data= FXCollections.observableArrayList();
//        data.add(new Product(1,"Lenovo",8439));
//        data.add(new Product(1,"HP",85439));
        ObservableList<Product> products=Product.getAllProducts();
        productTable=new TableView<>();
        productTable.setItems(products);
        productTable.getColumns().addAll(id,name,price);
        productTable.setMinSize(Supplychain.width,Supplychain.height);
        productTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        Pane tablePane=new Pane();
        tablePane.setStyle("-fx-background-color: #C0C0C0");
        tablePane.setMinSize(Supplychain.width,Supplychain.height);
        tablePane.getChildren().add(productTable);
        return tablePane;
    }

    public Pane getProductsByName(String productName){
        TableColumn id=new TableColumn("id");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn name=new TableColumn("name");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn price=new TableColumn("price");
        price.setCellValueFactory(new PropertyValueFactory<>("price"));

//        ObservableList<Product> data= FXCollections.observableArrayList();
//        data.add(new Product(1,"Lenovo",8439));
//        data.add(new Product(1,"HP",85439));
        ObservableList<Product> products=Product.getProductsByName(productName);
        productTable=new TableView<>();
        productTable.setItems(products);
        productTable.getColumns().addAll(id,name,price);
        productTable.setMinSize(Supplychain.width,Supplychain.height);
        productTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        Pane tablePane=new Pane();
        tablePane.setStyle("-fx-background-color: #C0C0C0");
        tablePane.setMinSize(Supplychain.width,Supplychain.height);
        tablePane.getChildren().add(productTable);
        return tablePane;
    }
    public Product getSelectedProduct(){
        try {
            Product selectProduct=productTable.getSelectionModel().getSelectedItem();
            return selectProduct;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
