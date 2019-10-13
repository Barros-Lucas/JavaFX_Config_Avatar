module com.javafxtutorial {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.logging;
    requires java.base;

    opens com.javafxtutorial to javafx.fxml;
    exports com.javafxtutorial;
}