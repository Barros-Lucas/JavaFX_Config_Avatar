/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javafxtutorial;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author AdminEtu
 */
public class LoginControllerCode {

    private TextField username;
    private PasswordField password;
    LoginCode ui;
    ContexteIdentification contexte;

    void setUI(LoginCode ui) {
        username = ui.username;
        password = ui.password;
        this.ui = ui;
        ui.setController(this);
    }

    void setContexte(ContexteIdentification contexte) {
        this.contexte = contexte;
        contexte.usernameUserConnectedProperty().bind(username.textProperty());
        contexte.passwordUserConnectedProperty().bind(password.textProperty());
    }
    
    public void onProcess(ActionEvent event) {
        Personne personneConnectee = contexte.identification();
        if (personneConnectee != null) {
            try {
                System.out.println("Login : " + contexte.usernameUserConnectedProperty().getValue());
                Stage stage = (Stage)this.username.getScene().getWindow();

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(App.class.getResource("UI_Avatar_config.fxml"));
                AnchorPane rootLayout = (AnchorPane) loader.load();

                // Chargement du second controller
                UI_Avatar_configController controller = loader.getController();

                Scene scene = new Scene(rootLayout, 600, 600);
                stage.setScene(scene);
                stage.centerOnScreen();
            } catch(IOException exc) {
                Logger.getLogger(LoginControllerCode.class.getName()).log(Level.SEVERE, null, exc);
            }
        } else {
            System.out.println("FAIL");
        }
    }
    
    public void onCancel(ActionEvent event) {
        username.setText("");
        password.setText("");
    }

}
