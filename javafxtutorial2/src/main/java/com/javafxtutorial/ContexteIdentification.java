/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javafxtutorial;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author AdminEtu
 */
public class ContexteIdentification {
    private final Personnes personnes;
    private final StringProperty usernameUserConnected;
    private final StringProperty passwordUserConnected;
    
    public ContexteIdentification(Personnes personnes) {
        this.personnes = personnes;
        usernameUserConnected = new SimpleStringProperty();
        passwordUserConnected = new SimpleStringProperty();
    }
    
    public Personnes getPersonnes() {
        return personnes;
    }
    
    public String getUsernameUserConnected() {
        return usernameUserConnected.getValue();
    }
    
    public String getPasswordUserConnected() {
        return passwordUserConnected.getValue();
    }
    
    public StringProperty usernameUserConnectedProperty() {
        return usernameUserConnected;
    }
    
    public StringProperty passwordUserConnectedProperty() {
        return passwordUserConnected;
    }
    
    public Personne identification() {
        return personnes.identification(usernameUserConnected.getValue(), passwordUserConnected.getValue());
    }

}
