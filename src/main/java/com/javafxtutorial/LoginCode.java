/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javafxtutorial;

// import java.awt.Insets;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

/**
 *
 * @author AdminEtu
 */
public class LoginCode extends BorderPane {
    
    Label titre; TextField username; PasswordField password;
    LoginControllerCode controller;

    public LoginCode() {
        // Title
        titre = new Label("Identification");
        titre.setId("title");
        BorderPane.setAlignment(titre, Pos.CENTER);
        this.setTop(titre);
        
        // Instance of grid
        GridPane centerPane = new GridPane();
        
        // Username
        Label labelUsername = new Label("Username : ");
        labelUsername.setPrefWidth(100);
        labelUsername.setId("labeluser");
        centerPane.add(labelUsername, 0, 0);
        username = new TextField("antoine.dupuy");
        username.setId("username");
        username.setPrefWidth(300);
        username.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                username.setStyle("-fx-background-color: red;");
            }
        });
        username.setOnMouseExited((MouseEvent event) -> {
            username.setStyle("-fx-background-color: white;");
        });
        centerPane.add(username, 1, 0);
        
        // Password
        Label labelPassword = new Label("Password : ");
        labelPassword.setPrefWidth(100);
        labelPassword.setId("labelpass");
        centerPane.add(labelPassword, 0, 1);
        password = new PasswordField();
        password.setId("password");
        password.setPrefWidth(300);
        centerPane.add(password, 1, 1);
        
        // Center pane
        this.setCenter(centerPane);
        
        // Buttons
        ButtonBar buttonBar = new ButtonBar();
        Button okButton = new Button("OK");
        okButton.setDefaultButton(true);
        okButton.setOnAction(e -> {controller.onProcess(e);});

        Button cancelButton = new Button("Cancel");
        cancelButton.setCancelButton(true);
        cancelButton.setOnAction(e -> {controller.onCancel(e);});
        
        // Add buttons to button bar
        buttonBar.getButtons().addAll(okButton, cancelButton);
        BorderPane.setMargin(buttonBar, new Insets(0, 10, 0, 10));
        this.setBottom(buttonBar);

        // Root size and padding
        this.setPrefSize(437, 187);
        this.setPadding(new Insets(10, 0, 10, 0));
    }

    void setController(LoginControllerCode controller) {
        this.controller = controller;
    }
}
