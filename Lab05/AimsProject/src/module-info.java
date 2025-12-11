module AimsProject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.swing;
	requires javafx.base;

    opens hust.soict.dsai.aims.screen to javafx.fxml;
    opens hust.soict.dsai.aims.media to javafx.base; // nếu dùng Playable

    exports hust.soict.dsai.aims.screen;
}