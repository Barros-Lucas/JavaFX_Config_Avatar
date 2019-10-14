/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javafxtutorial;

import java.time.LocalDateTime;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author AdminEtu
 */
class Personne {

    private final StringProperty id = new SimpleStringProperty();
    private final StringProperty pwd  = new SimpleStringProperty();
    private final StringProperty fullname = new SimpleStringProperty();
    private final StringProperty addr = new SimpleStringProperty();
    private final ObjectProperty<LocalDateTime> lastConnection = new SimpleObjectProperty();
    
    // Parametrable attributes
    private final StringProperty hairColor = new SimpleStringProperty();
    private final StringProperty eyeColor = new SimpleStringProperty();
    private final DoubleProperty hairLength = new SimpleDoubleProperty();
    private final StringProperty skinColor = new SimpleStringProperty();
    private final StringProperty headStyle = new SimpleStringProperty();

    // Constructor
    public Personne(String id, String pwd, String fullname, String addr) {
        this.id.set(id);
        this.pwd.set(pwd);
        this.fullname.set(fullname);
        this.addr.set(addr);
    }

    // Id
    public String getId() {
        return id.getValue();
    }
    
    public StringProperty idProperty() {
        return id;
    }
    
    public void setId(String value) {
        id.set(value);
    }
    
    // Password
    public String getPwd() {
        return pwd.getValue();
    }
    
    public StringProperty pwdProperty() {
        return pwd;
    }
    
    public void setPwd(String value) {
        pwd.set(value);
    }
    
    // Fullname
    public String getFullname() {
        return fullname.getValue();
    }
    
    public StringProperty fullnameProperty() {
        return fullname;
    }
    
    public void setFullname(String value) {
        fullname.set(value);
    }
    
    // Addr
    public String getAddr() {
        return addr.getValue();
    }
    
    public StringProperty addrProperty() {
        return addr;
    }
    
    public void setAddr(String value) {
        addr.set(value);
    }    
    
    // Last connection
    public final LocalDateTime getLastConnection() {
        return lastConnection.getValue();
    }
    
    public final void setLastConnection(LocalDateTime value) {
        lastConnection.set(value);
    }
    
    public ObjectProperty<LocalDateTime> lastConnectionProperty() {
        return lastConnection;
    }

    // Hair
    public final Number getHairLength() {
        return this.hairLength.getValue();
    }

    void setHairLength(Number new_val) {
        this.hairLength.set((double) new_val);
    }
    
    public final String getHairColor() {
        return this.hairColor.getValue();
    }
    
    void setHairColor(String color) {
        this.hairColor.set(color);
    }
    
    // Skin color
    public final String getSkinColor() {
        return this.skinColor.getValue();
    }

    void setSkinColor(String color) {
        this.skinColor.set(color);
    }

    // Eye color
    public void setEyesColor(String color){
        this.eyeColor.set(color);
    }

    public final String getEyesColor() {
        return this.eyeColor.getValue();
    }
    
    // Head style
    public void setHeadStyle(String style) {
        this.headStyle.set(style);
    }
    
    public String getHeadStyle() {
        return this.headStyle.getValue();
    }

    // Password checker
    boolean checkPassword(String username, String password) {
        return this.pwd.getValue().equals(password) && this.id.getValue().equals(username);
    }

    Object headShapeProperty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
