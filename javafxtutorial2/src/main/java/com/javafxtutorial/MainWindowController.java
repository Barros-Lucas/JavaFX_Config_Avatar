package com.javafxtutorial;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author AdminEtu
 */
public class MainWindowController implements Initializable {
    
    ContexteIdentification contexte;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    void setContexte(ContexteIdentification contexte) {
        this.contexte = contexte;
    }
    
}
