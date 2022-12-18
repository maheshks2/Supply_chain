package com.example.supplychain17dec;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    public static final int width=700, height=600,header=50;
    Pane bodyPane=new Pane();
    private GridPane HeaderBar(){
        TextField SearchText=new TextField();
        Button SearchButton=new Button("Search");
        GridPane gridPane=new GridPane();
        gridPane.add(SearchText,0,0);
        gridPane.add(SearchButton,1,0);
        return gridPane;
    }
   private GridPane loginPage(){
       Label emaillabel=new Label("Email");
       Label paddwordlabel=new Label("Password");
        TextField emailText=new TextField();
       PasswordField passwordfield=new PasswordField();
       GridPane gridpain=new GridPane();
       gridpain.add(emaillabel,0,0);
       gridpain.add(emailText,1,0);
       gridpain.add(paddwordlabel,0,1);
       gridpain.add(passwordfield,1,1);

       return gridpain;

    }
    private Pane createContant(){
        Pane root= new Pane();
        root.setPrefSize(width,height+header);
        bodyPane.setMinSize(width,height);
        bodyPane.setTranslateY(header);
        bodyPane.getChildren().addAll(loginPage());
        root.getChildren().addAll(HeaderBar(),bodyPane);
        return root;
    }
    @Override
    public void start(Stage stage) throws IOException {
       // FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(createContant());
        stage.setTitle("Login Page");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}