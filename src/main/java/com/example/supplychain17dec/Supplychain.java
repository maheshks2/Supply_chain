package com.example.supplychain17dec;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Supplychain extends Application {

    public static final int width=700, height=600,header=50;
    Pane bodyPane=new Pane();
    Login login =new Login();
    private GridPane HeaderBar(){
        TextField SearchText=new TextField();
        Button SearchButton=new Button("Search");
        GridPane gridpane=new GridPane();
        gridpane.setMinSize(bodyPane.getMinWidth(),header-10);
        gridpane.setVgap(5);
        gridpane.setHgap(5);
        gridpane.setStyle("-fx-background-color: #C0C0C0");
        gridpane.setAlignment(Pos.CENTER);
        gridpane.add(SearchText,0,0);
        gridpane.add(SearchButton,1,0);
        return gridpane;
    }
   private GridPane loginPage(){
       Label emaillabel=new Label("Email");
       Label paddwordlabel=new Label("Password");
       Label messageLabel=new Label("Im message");
        TextField emailText=new TextField();
       PasswordField passwordfield=new PasswordField();
       Button loginbutton=new Button("Login");
       loginbutton.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent actionEvent) {
            String email=emailText.getText();
            String password=passwordfield.getText();
//            messageLabel.setText(email + "$$" +password);
            if(login.customerlogin(email,password))
                messageLabel.setText("Login Sucessfull");
            else
                messageLabel.setText("Login Failed");
           }
       });
       GridPane gridpane=new GridPane();
       gridpane.setMinSize(bodyPane.getMinWidth(),bodyPane.getMinHeight());
       gridpane.setVgap(5);
       gridpane.setHgap(5);
       gridpane.setStyle("-fx-background-color: #C0C0C0");
       gridpane.setAlignment(Pos.CENTER);
       gridpane.add(emaillabel,0,0);
       gridpane.add(emailText,1,0);
       gridpane.add(paddwordlabel,0,1);
       gridpane.add(passwordfield,1,1);
        gridpane.add(loginbutton,0,2);
        gridpane.add(messageLabel,1,2);
       return gridpane;


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