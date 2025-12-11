module GUIProject {
    requires javafx.controls;
    requires javafx.fxml;

    opens hust.soict.dsai.javafx to javafx.fxml, javafx.graphics;

    exports hust.soict.dsai.javafx;
}