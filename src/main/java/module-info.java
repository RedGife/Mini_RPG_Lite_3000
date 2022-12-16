module com.isep.jfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.isep.jfx to javafx.fxml;
    exports com.isep.jfx;
}