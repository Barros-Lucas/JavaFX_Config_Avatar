/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javafxtutorial;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author AdminEtu
 */
class Personnes {
    
    private final ObservableList<Personne> liste;
    
    public Personnes(List<Personne> liste) {
        this.liste = FXCollections.observableArrayList(liste);
    }
    
    public Personnes() {
        this.liste = FXCollections.observableArrayList();
        this.liste.add(new Personne("antoine.dupuy", "123", "Antoine Dupuy", "17, avenue de Muret"));
    }
    
    public ObservableList<Personne> getListe() {
        return liste;
    }
    
    public Personne identification(String username, String password) {
        for (Personne p : liste) {
            if (p.checkPassword(username, password)) return p;
        }
        return null;
    }
}
