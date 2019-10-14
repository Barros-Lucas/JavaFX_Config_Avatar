/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javafxtutorial;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;

import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
/**
 * FXML Controller class
 *
 * @author AdminEtu
 */
public class UI_Avatar_configController implements Initializable {

    @FXML
    private TextField Nom;
    @FXML
    private TextField Prenom;
    @FXML
    private RadioButton Sexe_Homme;
    @FXML
    private RadioButton Sexe_Femme;
    @FXML
    private RadioButton Sexe_Autre;
    @FXML
    private ColorPicker eyes_color;
    @FXML
    private ColorPicker skinColor;
    @FXML
    private Slider hair_width;
    @FXML
    private Canvas avatarCanvas;
    @FXML
    private Button cancel;
    @FXML
    private Button save;
    @FXML
    private MenuButton age;
    @FXML
    private ComboBox<String> hairColor;
    @FXML
    private ListView<String> headStyle;
    
    // Graphic attributes
    GraphicsContext gc;
    Color hair = Color.BLACK;
    Color eye = Color.BLACK;
    Color skin = Color.WHITE;
    String head = "cercle";
    
    // Personne p concerned
    AvatarContexte avatarContexte;
    Personne p;

    
    void setContexte(AvatarContexte avatarContexte) {
        this.avatarContexte = avatarContexte;
        this.p = avatarContexte.pConnectee;

        // Binding and listeners
        this.p.idProperty().bind(
            Prenom.textProperty().concat(".").concat(Nom.textProperty())
        );
        this.p.fullnameProperty().bind(
            Prenom.textProperty().concat(" ").concat(Nom.textProperty())
        );
        hairColor.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> ov, String old_val, String new_val) -> {
            this.resetCanvas();
            hair = Color.web(new_val);
            this.p.setHairColor(new_val);
            this.setHairs(Color.web(new_val), this.p.getHairLength());
            this.setHead(skin, head);
            this.setBody();
            this.setEyes(eye);
            this.setSmile();

        });
        headStyle.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends String> ov, String old_val, String new_val) -> {
            this.resetCanvas();
            this.setHairs(hair, this.p.getHairLength());
            head = new_val;
            this.p.setHeadStyle(head);
            this.setHead(skin, new_val);
            this.setBody();
            this.setEyes(eye);
            this.setSmile();

        });
        hair_width.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            this.resetCanvas();
            this.p.setHairLength(new_val);
            this.setHairs(hair, new_val.doubleValue());
            this.setHead(skin, head);
            this.setBody();
            this.setEyes(eye);
            this.setSmile();
        });
        skinColor.valueProperty().addListener((ObservableValue<? extends Color> ov, Color old_value, Color new_val) -> {
            this.resetCanvas();
            this.p.setSkinColor(new_val.toString());
            skin = new_val;
            this.setHairs(hair, this.p.getHairLength());
            this.setHead(new_val, head);
            this.setBody();
            this.setEyes(eye);
            this.setSmile();
        });
        eyes_color.valueProperty().addListener((ObservableValue<? extends Color> ov, Color old_value, Color new_val) -> {
            this.resetCanvas();
            eye = new_val;
            this.setHairs(hair, this.p.getHairLength());
            this.setHead(skin, head);
            this.setBody();
            p.setEyesColor(new_val.toString());
            this.setEyes(eye);
            this.setSmile();
        });
        
    }

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // Set graphic context
        gc = avatarCanvas.getGraphicsContext2D();
        
        // Initiate canvas
        this.resetCanvas();

        // Initiate avatar geometries
        this.resetAvatar();
        
        // Initiate hair color
        this.resetHairColorBox();

        // Initiate slider
        this.resetSliderHairLength();
        
        // Initiate head style
        this.resetHeadStyle();
        
    }

    private void resetCanvas() {
        gc.clearRect(0, 0, 200, 327);
        gc.setStroke(Color.BLACK);
        gc.strokeRect(0, 0, avatarCanvas.getWidth(), avatarCanvas.getHeight());
    }
    
    private void resetAvatar() {
        this.setHairs(Color.BLACK, 0);
        this.setHead(Color.WHITE, head);
        this.setBody();
        this.setEyes(Color.BLACK);
        this.setSmile();
    }
    
    private void resetHeadStyle() {
        headStyle.getItems().addAll(
            "cercle",
            "étoile"
        );
        headStyle.getSelectionModel().selectFirst();
    }
    
    private void resetSkinColorBox() {
        skinColor.setValue(Color.WHITE);
    }
    
    private void resetHairColorBox() {
        hairColor.getItems().addAll(
            "black",
            "yellow",
            "brown",
            "orange",
            "blue",
            "red",
            "green"
        );
        hairColor.getSelectionModel().selectFirst();
    }

    private void resetSliderHairLength() {
        hair_width.setMin(0);
        hair_width.setMax(3);
        hair_width.setValue(0);
        hair_width.setShowTickLabels(true);
        hair_width.setShowTickMarks(true);
        hair_width.setBlockIncrement(1);
    }

    private void resetEyesColorBox() {
        eyes_color.setValue(Color.BLACK);
    }

    private void setSmile() {
        gc.setStroke(Color.BLACK);
        gc.strokeArc(75, 160, 50, 25, 180, 180, ArcType.OPEN);
    }
    
    private void setEyes(Color color) {
        gc.setFill(color);
        gc.fillOval(120, 140, 5, 10);
        gc.fillOval(75, 140, 5, 10);
    }
    
    private void setHairs(Color color, Number addOn) {
        gc.setFill(color);
        gc.fillArc(
            45 - addOn.doubleValue() * 10,
            90 - addOn.doubleValue() * 10,
            110 + addOn.doubleValue() * 20,
            110 + addOn.doubleValue() * 20,
            0,
            180,
            ArcType.CHORD
        );
    }
    
    private void setBody() {
        gc.setFill(Color.RED);
        gc.strokeArc(25, 200, 150, 150, 0, 180, ArcType.CHORD);
        gc.fillArc(25, 200, 150, 150, 0, 180, ArcType.CHORD);
    }
    
    private void setHead(Color color, String style) {
        gc.setFill(color);
        if ("cercle".equals(style)) {
            gc.strokeOval(50, 95, 100, 100);
            gc.fillOval(50, 95, 100, 100);
        }
        else if ("étoile".equals(style)) {
            double xpoints[] = {0, 75, 100, 125, 200, 150,
                160, 100, 40, 50};
            double ypoints[] = {135, 125, 60, 125, 135, 175,
                240, 200, 240, 175};
            gc.strokePolygon(xpoints, ypoints, xpoints.length);
            gc.fillPolygon(xpoints, ypoints, xpoints.length);
        }
    }
    
    @FXML
    private void onReset(MouseEvent event) {
        head = "cercle";
        this.resetHeadStyle();
        this.resetSkinColorBox();
        this.resetHairColorBox();
        this.resetEyesColorBox();
        this.resetSliderHairLength();
        this.resetCanvas();
        this.resetAvatar();
    }

    @FXML
    private void onSave(MouseEvent event) {
        System.out.println("FULLNAME : " + this.p.getFullname());
        System.out.println("ID : " + this.p.getId());
        System.out.println("Hair LENGTH : " + this.p.getHairLength());
        System.out.println("Hair COLOR : " + this.p.getHairColor());
        System.out.println("Skin COLOR : " + this.p.getSkinColor());
        System.out.println("Head STYLE : " + this.p.getHeadStyle());
    }

}
