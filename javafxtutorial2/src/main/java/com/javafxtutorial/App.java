package com.javafxtutorial;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        LoginCode root = new LoginCode();

        // Reference to controller
        LoginControllerCode controller = new LoginControllerCode();
        ContexteIdentification contexte = new ContexteIdentification(new Personnes());
        controller.setUI(root);
        controller.setContexte(contexte);

        scene = new Scene(root);
        stage.setScene(scene);

        scene.getStylesheets().add(LoginControllerCode.class.getResource("login.css").toExternalForm());

        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}